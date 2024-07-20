package com.example.demo.livros.model;

import jakarta.validation.constraints.NotBlank;

public record RecordEditoras(@NotBlank String nome_Editora,
                             @NotBlank String país) {
}
