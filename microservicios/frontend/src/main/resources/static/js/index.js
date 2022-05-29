jQuery(function () {
    main();
});
var autorsTable;
var autors = [];
var cellToModify = {};
var timeToUpdate = 0;
var timer;
var isNew;
const AUTOR_API_URL = "http://localhost:8080/api/autors/";

function main() {
    loadAutors();
}
function confAutorsTable() {
    autorsTable = new Tabulator("#autoresTabla", {
        height: 300,
        data: autors,
        layout: "fitColumns",
        columns: [ //Define Table Columns
            { title: "Nombre", field: "name", editor: "input" },
            { title: "Apellido", field: "lastName", editor: "input" },
            { title: "Nombre Artistico", field: "artistName", editor: "input" }
        ]
    });
    autorsTable.on("dataChanged", function (_) {
        if (!isNew) {
            if (!timer) {
                startTimer();
            }
            timeToUpdate += 2;
        }
        isNew = false;
    });
    autorsTable.on("cellEdited", (cell) => {
        cellToModify = cell;
    });
}

function loadAutors() {
    $.ajax({
        url: "http://localhost:8080/api/autors/",
        type: "GET",
        dataType: "json",
        success: function (dataAutors) {
            autors = dataAutors;
            let currId = 0;
            autors.forEach(function (autor) {
                currId++;
                autor.id = currId;
                autor.new = false;
            });
            console.log(autors);
            confAutorsTable();
        }
    });
}


function saveAutor() {
    stopTimer();
    let autor = cellToModify.getRow().getData();
    if (autor.new) {
        let newAutor = { ...autor };
        delete newAutor.id;
        delete newAutor.new;
        console.log(newAutor);
        $.ajax({
            url: AUTOR_API_URL,
            type: "POST",
            data: JSON.stringify(newAutor),
            contentType: "application/json",
            dataType: "json",
            success: function (dataAutors) {
                console.log("creado:", dataAutors);
            },
            error: function () {
                cellToModify.restoreOldValue();
            }
        });
    }
}

function añadirAutor() {
    let id = autors.length + 1;
    autorsTable.addData([{
        id: id,
        name: "",
        lastName: "",
        artistName: "",
        new: true
    }]);
    isNew = true;
}

function startTimer() {
    timer = setInterval(function () {
        timeToUpdate--;
        console.log(timeToUpdate);
        if (timeToUpdate == 0) {
            console.log("A actualizar...");
            saveAutor();
        }
    }, 1000);
}

function stopTimer() {
    clearInterval(timer);
    timer = null;
    timeToUpdate = 0;
}