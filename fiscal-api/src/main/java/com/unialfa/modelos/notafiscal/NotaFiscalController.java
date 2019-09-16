package com.unialfa.modelos.notafiscal;

import com.unialfa.modelos.notafiscal.enums.TipoImpostoE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/nota-fiscal")
public class NotaFiscalController {

  private static final String VIEW_CADASTRO = "cadastro-nota-fiscal";
  private static final String VIEW_PESQUISA = "pesquisa-nota-fiscal";

  @Autowired
  private NotaFiscalService notaFiscalService;

  @ModelAttribute("listaTipoImpostoE")
  public List<TipoImpostoE> getListaTipoImpostoE() {
    return Arrays.asList(TipoImpostoE.values());
  }

  @RequestMapping("/novo")
  public ModelAndView novo() {
    ModelAndView modelAndView = new ModelAndView(VIEW_CADASTRO);

    modelAndView.addObject("notaFiscal", new NotaFiscal());

    return modelAndView;
  }

  @RequestMapping
  public ModelAndView findAll() {
    ModelAndView modelAndView = new ModelAndView(VIEW_PESQUISA);

    List<NotaFiscal> listaNotaFiscal = this.notaFiscalService.findAll();

    modelAndView.addObject("listaNotaFiscal", listaNotaFiscal);

    return modelAndView;
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView salvar(@Validated NotaFiscal notaFiscal,
                             Errors errors,
                             RedirectAttributes attributes) {
    if (errors.hasErrors()) {
      return new ModelAndView(VIEW_CADASTRO);
    }

    this.notaFiscalService.save(notaFiscal);

    attributes.addFlashAttribute("mensagem", "Nota fiscal salva com sucesso!");

    return new ModelAndView("redirect:/nota-fiscal/novo");
  }

  @RequestMapping("{id}")
  public ModelAndView edit(@PathVariable("id") NotaFiscal notaFiscal) {
    ModelAndView modelAndView = new ModelAndView(VIEW_CADASTRO);

    modelAndView.addObject(notaFiscal);

    return modelAndView;
  }

  @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
  public ModelAndView excluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    this.notaFiscalService.delete(id);

    redirectAttributes.addFlashAttribute("mensagem", "Nota fiscal excluída com sucesso!");

    return new ModelAndView("redirect:/nota-fiscal");
  }
}
