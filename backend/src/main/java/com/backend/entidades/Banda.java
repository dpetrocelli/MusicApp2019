package com.backend.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "banda")
public class Banda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artista_id", referencedColumnName = "id")
    private Artista artistaLider;

    @NotBlank
    @Column(unique = true)
    private String nombre;

    @NotBlank
    private String generoMusical;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puntuacion")
    private List<PuntuacionArtista> puntuacionesRecibidas;


    public Banda() {

    }

    public Banda(Artista artistaLider, @NotBlank String nombre, @NotBlank String generoMusical) {
        this.artistaLider = artistaLider;
        this.nombre = nombre;
        this.generoMusical = generoMusical;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artista getArtistaLider() {
        return artistaLider;
    }

    public void setArtistaLider(Artista artistaLider) {
        this.artistaLider = artistaLider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public List<PuntuacionArtista> getPuntuacionesRecibidas() {
        return puntuacionesRecibidas;
    }

    public void setPuntuacionesRecibidas(List<PuntuacionArtista> puntuacionesRecibidas) {
        this.puntuacionesRecibidas = puntuacionesRecibidas;
    }
}
