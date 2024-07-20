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
    private String data_Nascimento;

    @ManyToMany(mappedBy = "autores", fetch = FetchType.LAZY)
    private List<Livro> livro;


    public Autor(String nome_autor, String sobrenome_autor, String data_nasc) {
        this.nome = nome_autor;
        this.sobrenome = sobrenome_autor;
        this.data_Nascimento = data_nasc;
    }
}
