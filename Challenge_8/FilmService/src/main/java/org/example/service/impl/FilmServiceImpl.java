package org.example.service.impl;


import org.example.entity.FilmEntity;
import org.example.repository.FilmRepository;
import org.example.service.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;


    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
    @Override
    public List<FilmEntity> cariSemuaFilm() {
        return filmRepository.findAll();
    }

    @Override
    public Optional<FilmEntity> cariDariID(Long userId) {
        return filmRepository.findById(userId);
    }

    @Override
    public FilmEntity simpanFilm(FilmEntity filmEntity) {
        return filmRepository.save(filmEntity);
    }

    @Override
    public FilmEntity updateFilm(Long id, FilmEntity filmEntity) {
        FilmEntity filmEntityUpdate=filmRepository.findById(id).get();
        filmEntityUpdate.setNamaFilm(filmEntity.getNamaFilm());
        filmEntityUpdate.setStatusFilm(filmEntity.getStatusFilm());
        filmEntityUpdate.setDurasi(filmEntity.getDurasi());
        filmEntityUpdate.setGenre(filmEntity.getGenre());
        return filmRepository.save(filmEntityUpdate);
    }
    public String deleteFilm(Long id) {
        filmRepository.deleteById(id);
        return "Film Has Been Deleted";
    }
}
