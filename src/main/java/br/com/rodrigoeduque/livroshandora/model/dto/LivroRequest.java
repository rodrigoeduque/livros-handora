package br.com.rodrigoeduque.livroshandora.model.dto;

import br.com.rodrigoeduque.livroshandora.model.Livro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class LivroRequest {

    @NotBlank
    @Length(min = 200, max = 4000)
    private String titulo;

    @NotBlank
    @Length(min = 200, max = 4000)
    private String descricao;

    @Past
    @NotNull
    private LocalDate dataPublicacao;

    @NotNull
    @ISBN
    private String isbn;

    public LivroRequest(String titulo, String descricao, LocalDate dataPublicacao, String isbn) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = dataPublicacao;
        this.isbn = isbn;
    }

    @Deprecated
    public LivroRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getIsbn() {
        return isbn;
    }

    public Livro toLivro() {
        return new Livro(titulo, descricao, dataPublicacao, isbn);
    }
}
