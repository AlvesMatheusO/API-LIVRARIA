package com.livraria.app.rest.Repo;

import com.livraria.app.rest.Models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepo extends JpaRepository<Livro, Long> {
}
