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
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long idLivro; 

    @Column
    String titulo;

    @Column
    String autor;

    @Column
    String editora;

    @Column
    String anoPublicacao;
    

    // @OneToMany //(mappedBy="livro")
    // public List<Quote> quotes;

    

    // @Column
    // private String linkImagemCapa;    


}
