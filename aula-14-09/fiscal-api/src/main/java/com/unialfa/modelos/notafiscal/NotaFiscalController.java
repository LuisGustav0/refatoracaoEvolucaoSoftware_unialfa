package com.unialfa.modelos.notafiscal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@RestController
public class NotaFiscalController {

  @Autowired
  private NotaFiscalRepository notaFiscalRepository;

  @RequestMapping("/")
  public ModelAndView index() {
    return new ModelAndView("index");
  }

  @RequestMapping("listanotasfiscais")
  public ModelAndView listaNotasFiscais(Model model) {
    Iterable<NotaFiscal> nf = this.notaFiscalRepository.findAll();

    model.addAttribute("notasfiscais", nf);

    return new ModelAndView("listanotasfiscais");
  }

  @PostMapping("salvar")
  public ModelAndView salvar(@RequestParam("nome") String nome,
                             @RequestParam("valor") BigDecimal valor,
                             Model model) {

    BigDecimal i = new BigDecimal(1.1);
    NotaFiscal nf = new NotaFiscal(nome, i, valor);
    notaFiscalRepository.save(nf);

    Iterable<NotaFiscal> nf_list = notaFiscalRepository.findAll();
    model.addAttribute("notasfiscais", nf_list);

    return new ModelAndView("listanotasfiscais");
  }
}
