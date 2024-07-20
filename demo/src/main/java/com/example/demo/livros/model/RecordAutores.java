package com.example.demo.livros.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public record RecordAutores(@NotBlank String nome_Autor,
                            @NotBlank String sobrenome_Autor,
                            @NotBlank String data_Nascimento) {

}
