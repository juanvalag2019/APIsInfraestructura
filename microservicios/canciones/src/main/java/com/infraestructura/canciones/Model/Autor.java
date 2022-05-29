package com.infraestructura.canciones.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {

    private long id;
    private String name;
    private String lastName;
    private String artistName;

    public Autor() {
    }

    public Autor(long id, String name, String lastName, String artistName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.artistName = artistName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Autor [apellido=" + lastName + ", id=" + id + ", nombre=" + name + ", nombreArtistico="
                + artistName + "]";
    }

}
