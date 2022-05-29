package com.infraestructura.canciones.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cancion")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "duracion")
    private String duracion;
    @Column(name = "autor")
    private long autor;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDuracion() {
        return duracion;
    }
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    public long getAutor() {
        return autor;
    }
    public void setAutor(long idAutor) {
        this.autor = idAutor;
    }
    @Override
    public String toString() {
        return "Cancion [duracion=" + duracion + ", id=" + id + ", idAutor=" + autor + ", titulo=" + titulo + "]";
    }
    
}
