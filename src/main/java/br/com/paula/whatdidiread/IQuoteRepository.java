package br.com.paula.whatdidiread;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IQuoteRepository extends CrudRepository<Quote, Long>{

    List<Quote> findAll();
    List<Quote> findByConteudoQuoteContainingIgnoreCase(String conteudoQuote);
    
}
