package com.example.demo.livros.controller;

import com.example.demo.livros.entity.Livro;
import com.example.demo.livros.model.RecordLivro;
import com.example.demo.livros.repository.LivroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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

}
