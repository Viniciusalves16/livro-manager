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
@Table(name = "TB_EDITORA")
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEditora;

    @Column(name = "nome_editora_livro", length = 55, nullable = false)
    private String nome_editora;

    @Column(name = "nome_pais_editora", length = 20, nullable = false)
    private String país;

    @ManyToMany(mappedBy = "editoras", fetch = FetchType.LAZY)
    private List<Livro> livros;


    public Editora(String nome, String país_1) {
        this.nome_editora = nome;
        this.país = país_1;
    }
}
