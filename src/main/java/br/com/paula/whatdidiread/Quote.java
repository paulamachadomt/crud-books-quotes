package br.com.paula.whatdidiread;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idQuote;
    
    @Column
    String conteudoQuote;   

    @Column
    String autorQuote;

    @Column
    String tituloLivro;

    // @ManyToOne
    // //@JoinColumn(name="livro_id", nullable = false)
    // public Livro livro;
    
}


