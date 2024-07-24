package com.example.demo.livros.repository;


import com.example.demo.livros.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Método criado para consultar o usuário no banco de dados
    UserDetails findByLogin(String username);
}
