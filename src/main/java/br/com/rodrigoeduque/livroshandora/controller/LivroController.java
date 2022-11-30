package br.com.rodrigoeduque.livroshandora.controller;

import br.com.rodrigoeduque.livroshandora.model.Livro;
import br.com.rodrigoeduque.livroshandora.model.dto.LivroRequest;
import br.com.rodrigoeduque.livroshandora.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository repository;

    @PostMapping
    public ResponseEntity<Void> novoLivro(@RequestBody @Valid LivroRequest request) {

        Livro novoLivro = request.toLivro();

        repository.save(novoLivro);

        URI uri = UriComponentsBuilder.fromPath("/livros/{id}").buildAndExpand(novoLivro.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
