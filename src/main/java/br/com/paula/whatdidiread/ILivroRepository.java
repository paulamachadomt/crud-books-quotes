package br.com.paula.whatdidiread;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ILivroRepository extends CrudRepository<Livro, Long> {
    
    List<Livro> findAll();
    List<Livro> findByAutorContainingIgnoreCase(String autor);
    List<Livro> findByTituloContainingIgnoreCase(String titulo);    
    List<Livro> findByEditoraContainingIgnoreCase(String editora);
    
}
