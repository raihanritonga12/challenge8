package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name= "Film")

public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kode_film")
    private long kodeFilm;
    @Column(name = "nama_film")
    private String namaFilm;
    @Column(name = "film_status")
    private String statusFilm;
    @Column(name = "lama")
    private String durasi;
    @Column(name = "genre")
    private String genre;

}
