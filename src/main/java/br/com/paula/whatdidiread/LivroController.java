package br.com.paula.whatdidiread;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class LivroController {

    @Autowired
    ILivroRepository livroRepository;

    @Autowired
    IQuoteRepository quoteRepository;

    

    @GetMapping(value="/")
    public ModelAndView getListaLivrosEQuotes() {
        List<Livro> listaLivros = livroRepository.findAll();
        List<Quote> listaQuotes = quoteRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listaLivros", listaLivros);    
        modelAndView.addObject("listaQuotes", listaQuotes);    
        return modelAndView;
    }

    @GetMapping(value="/detalhesLivro/{idLivro}")
    public ModelAndView getLivroById(@PathVariable Long idLivro) {
        Livro livro = livroRepository.findById(idLivro).get();        
        ModelAndView modelAndView = new ModelAndView("detalhesLivro");
        modelAndView.addObject("livro", livro);
        return modelAndView;
    }
    
    @GetMapping(value="/cadastrarLivro")
    public ModelAndView getCadastrarLivro() {
        Livro livro = new Livro();
        ModelAndView modelAndView = new ModelAndView("cadastrarLivro");
        modelAndView.addObject("livro", livro);
        return modelAndView;
    }
    
    @PostMapping(value="/adicionarLivro")
    public String adicionarLivro(Livro livro) {        
        livroRepository.save(livro);
        return "redirect:/";
    }

    @GetMapping(value="/editarLivro/{idLivro}")
    public ModelAndView getEditarLivro(@PathVariable Long idLivro) {
        Livro livro = livroRepository.findById(idLivro).get();
        ModelAndView modelAndView = new ModelAndView("cadastrarLivro");
        modelAndView.addObject("livro", livro);
        return modelAndView;
    }
    
    @GetMapping(value="/deletarLivro/{idLivro}")
    public String deletarLivroById(@PathVariable Long idLivro) {
        livroRepository.deleteById(idLivro);
        return "redirect:/"; 
    }
    

    @GetMapping(value="/pesquisar")
    public String getPesquisarLivrosEQuotes() {
        return "pesquisar";
    }

    @PostMapping(value="/pesquisar")
    public ModelAndView postPesquisarLivrosEQuotes(@RequestParam String titulo) {
        List<Livro> listaLivros = livroRepository.findByTituloContainingIgnoreCase(titulo);

        ModelAndView modelAndView = new ModelAndView("pesquisar");
        modelAndView.addObject("titulo", titulo);
        modelAndView.addObject("listaLivros", listaLivros);
        return modelAndView;
    }
        
}
