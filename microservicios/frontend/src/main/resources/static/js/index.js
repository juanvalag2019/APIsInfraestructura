jQuery(function () {
    principal();
});


function principal() {
    configurarTablaAutores();
}
function configurarTablaAutores() {
    var table = new Tabulator("#autoresTabla", {
        height: 300,
        autoColumns: true,
        ajaxURL: "http://localhost:8080/api/autors/"
    });
}