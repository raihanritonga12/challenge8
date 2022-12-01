package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.entity.FilmEntity;
import org.example.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    FilmService filmService;

    @Operation(summary="Memasukkan film baru,mengambil semua film,memperbarui film,menghapus film")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200",
                    description = "Berhasil mengedit film",
                    content = {@Content(mediaType="application/json")}),
            @ApiResponse(responseCode = "404",
                    description = "Gagal mengedit film",
                    content = @Content)
    })

    @PostMapping("/buat")
    @ResponseStatus(HttpStatus.CREATED)
    public FilmEntity create(@RequestBody FilmEntity film){
        return filmService.simpanFilm(film);
    }
    @GetMapping("/ambilSemua")
    public List<FilmEntity> getall(){
        return filmService.cariSemuaFilm();
    }
    @PutMapping("/perbaharui/{id}")
    public FilmEntity update(@PathVariable Long id, @RequestBody FilmEntity film){
        return filmService.updateFilm(id,film);
    }
    @DeleteMapping("/hapus/{id}")
    public String delete(@PathVariable Long id){
        return filmService.deleteFilm(id);
    }


    @GetMapping("/test")
    public String testEndpoint(){
        return "test";
    }


}
