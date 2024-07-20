package com.example.demo.livros.repository;

import com.example.demo.livros.entity.Editora;
import com.example.demo.livros.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
}
