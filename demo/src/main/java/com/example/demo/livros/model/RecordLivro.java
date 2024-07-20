package com.example.demo.livros.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RecordLivro(@NotBlank String titulo,
                          @NotBlank String isbn,
                          @NotNull Long quantidade_Paginas,
                          @NotEmpty List<RecordAutores> autores,
                          @NotEmpty List<RecordEditoras> editoras) {

}
