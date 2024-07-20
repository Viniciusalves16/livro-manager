package com.example.demo.livros.repository;

import com.example.demo.livros.entity.Autor;
import com.example.demo.livros.entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
