package com.example.demo.livros.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLivro;

    @Column(name = "titulo_livro", length = 50, nullable = false)
    private String titulo;
    @Column(name = "isbn_codigo", length = 50, nullable = false)
    private String ISBN;
    @Column(name = "numero_de_pag", length = 50, nullable = false)
    private long numero_de_paginas;

    @ManyToMany
    @JoinTable(name = "livro_autor",
            joinColumns = @JoinColumn(name = "idLivro"),
            inverseJoinColumns = @JoinColumn(name = "idAutor")
    )
    private List<Autor> autores;

    @ManyToMany
    @JoinTable(name = "livro_editora",
            joinColumns = @JoinColumn(name = "idivro"),
            inverseJoinColumns = @JoinColumn(name = "idEditora"))
    private List<Editora> editoras;
}