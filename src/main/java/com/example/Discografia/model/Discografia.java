package com.example.Discografia.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
public class Discografia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String artista;
    private String disco;
    private String fecha;
    private String discografica;
    private String productores;
    private String estudio;
    private String portada;

    public Discografia(String artista, String disco, String fecha, String discografica, String productores, String estudio, String portada) {
        this.artista = artista;
        this.disco = disco;
        this.fecha = fecha;
        this.discografica = discografica;
        this.productores = productores;
        this.estudio = estudio;
        this.portada = portada;
    }

    public Discografia(Long id, String artista, String disco, String fecha, String discografica, String productores, String estudio, String portada) {
        this.id = id;
        this.artista = artista;
        this.disco = disco;
        this.fecha = fecha;
        this.discografica = discografica;
        this.productores = productores;
        this.estudio = estudio;
        this.portada = portada;
    }

    public Discografia() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    public String getProductores() {
        return productores;
    }

    public void setProductores(String productores) {
        this.productores = productores;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
