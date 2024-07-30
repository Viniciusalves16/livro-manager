package com.example.demo.livros.entity;


import com.example.demo.livros.model.RecordLivro;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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
    @NotNull
    @Column(name = "isbn_codigo", length = 50, nullable = false)
    private String isbn;
    @Column(name = "numero_de_pag", length = 50, nullable = false)
    private long numero_de_paginas;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "livro_autor",
            joinColumns = @JoinColumn(name = "idLivro"),
            inverseJoinColumns = @JoinColumn(name = "idAutor")
    )
    private List<Autor> autores;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
    @JoinTable(name = "livro_editora",
            joinColumns = @JoinColumn(name = "idivro"),
            inverseJoinColumns = @JoinColumn(name = "idEditora"))
    private List<Editora> editoras;



    public Livro(RecordLivro recordLivro) {
        this.titulo = recordLivro.titulo();
        this.isbn = recordLivro.isbn();
        this.numero_de_paginas = recordLivro.quantidade_Paginas();

        this.autores = recordLivro.autores().stream()
                .map(dtoAutor -> new Autor(dtoAutor.nome_Autor(), dtoAutor.sobrenome_Autor(),dtoAutor.data_Nascimento()))
                .collect(Collectors.toList());
        this.editoras = recordLivro.editoras().stream()
                .map(dtoEditora -> new Editora(dtoEditora.nome_Editora(),dtoEditora.país()))
                .collect(Collectors.toList());

    }
}