package com.example.demo.livros.service;

import com.example.demo.livros.entity.Livro;
import com.example.demo.livros.model.RecordLivro;
import com.example.demo.livros.repository.LivroRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;


}
