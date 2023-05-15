
package com.livraria.app.rest.Controller;
import com.livraria.app.rest.Models.Livro;
import com.livraria.app.rest.Repo.LivroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private LivroRepo livroRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/livros")
    public List<Livro> getLivros() {
        return livroRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveLivro(@RequestBody Livro livro) {
        livroRepo.save(livro);
        return "livro salvo";
    }

    @PutMapping(value = "/update/{id}")
    public String updatedLivro(@PathVariable long id, @RequestBody Livro livro)  {
        Livro updatedLivro = livroRepo.findById(id).get();
        updatedLivro.setTitulo(livro.getTitulo());
        updatedLivro.setDescricao(livro.getDescricao());
        updatedLivro.setAutor(livro.getAutor());
        livroRepo.save(updatedLivro);
        return "Livro Atualizado";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteLivro(@PathVariable long id){
        Livro deleteLivro = livroRepo.findById(id).get();
        livroRepo.delete(deleteLivro);
        return "Deletado livro com ID: "+id;
    }

}


