package com.example.demo.livros.controller;

import com.example.demo.livros.entity.Livro;
import com.example.demo.livros.model.RecordLivro;
import com.example.demo.livros.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LivroResource {

    @Autowired
    LivroRepository livroRepository;

    @PostMapping("/livros")
    @Transactional
    public ResponseEntity createLivro(@RequestBody @Valid RecordLivro recordLivro, Livro livro, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("meu log");
        var livrosTemp = (new Livro(recordLivro));
        livroRepository.save(livrosTemp);

        var uri = uriComponentsBuilder.path("/livros/{id}").buildAndExpand(livro.getIdLivro()).toUri();
        System.out.println("teste");
        return ResponseEntity.created(uri).body(livroRepository.save(livrosTemp));
    }


    @DeleteMapping("/livros/{id}")
    @Transactional
    public ResponseEntity deleteLivro(@PathVariable(value = "id") Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if (livro.isEmpty()) {
            throw new EntityNotFoundException();
        }
        livroRepository.deleteById((livro.get().getIdLivro()));
        return ResponseEntity.status(HttpStatus.OK).body("Livro excluido");
    }


    @GetMapping("livros")
    public ResponseEntity getAllLivro() {
        var livros = livroRepository.findAll();
        return ResponseEntity.ok().body(livros);
    }


}
