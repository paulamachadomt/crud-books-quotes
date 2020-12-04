package br.com.paula.whatdidiread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class QuoteController {
    
    @Autowired
    ILivroRepository livroRepository;

    @Autowired
    IQuoteRepository quoteRepository;


    @GetMapping(value="/cadastrarQuote")
    public ModelAndView getCadastrarQuote() {
        Quote quote = new Quote();
        ModelAndView modelAndView = new ModelAndView("cadastrarQuote");
        modelAndView.addObject("quote", quote);
        return modelAndView;
    }

    @PostMapping(value="/adicionarQuote")
    public String postCadastrarQuote(Quote quote) {
        quoteRepository.save(quote);
        return "redirect:/";        
    
    }

    @GetMapping(value="/detalhesQuote/{idQuote}")
    public ModelAndView getQuoteById(@PathVariable Long idQuote) {
        Quote quote = quoteRepository.findById(idQuote).get();        
        ModelAndView modelAndView = new ModelAndView("detalhesQuote");
        modelAndView.addObject("quote", quote);
        return modelAndView;
    }

    @GetMapping(value="/deletarQuote/{idQuote}")
    public String deletarQuoteById(@PathVariable Long idQuote) {
        quoteRepository.deleteById(idQuote);
        return "redirect:/"; 
    }

    @GetMapping(value="/editarQuote/{idQuote}")
    public ModelAndView getEditarQuote(@PathVariable Long idQuote) {
        Quote quote = quoteRepository.findById(idQuote).get();
        ModelAndView modelAndView = new ModelAndView("cadastrarQuote");
        modelAndView.addObject("quote", quote);
        return modelAndView;
    }

}