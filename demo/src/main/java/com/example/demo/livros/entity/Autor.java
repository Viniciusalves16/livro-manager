package com.example.demo.livros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_AUTOR")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAutor;

    @Column(name = "nome_autor", length = 60, nullable = false)
    private String nome;

    @Column(name = "sobrenome_autor", length = 60, nullable = false)
    private String sobrenome;

    @Column(name = "data_nascimento_autor", length = 60, nullable = false)
    private Date data_Nascimento;

    @ManyToMany(mappedBy = "autores")
    private List<Livro> livro;
}
