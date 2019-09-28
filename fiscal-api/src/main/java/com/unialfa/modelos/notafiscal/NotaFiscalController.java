package com.unialfa.modelos.notafiscal;

import com.unialfa.modelos.imposto.enums.TipoImpostoE;
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

  @GetMapping("/novo")
  public ModelAndView novo() {
    ModelAndView modelAndView = new ModelAndView(VIEW_CADASTRO);

    modelAndView.addObject("notaFiscalTO", new NotaFiscalTO());

    return modelAndView;
  }

  @GetMapping
  public ModelAndView findAll() {
    ModelAndView modelAndView = new ModelAndView(VIEW_PESQUISA);

    List<NotaFiscalTO> listaNotaFiscalTO = this.notaFiscalService.findAll();

    modelAndView.addObject("listaNotaFiscal", listaNotaFiscalTO);

    return modelAndView;
  }

  @PostMapping
  public ModelAndView salvar(@Validated NotaFiscalTO notaFiscalTO,
                             Errors errors,
                             RedirectAttributes attributes) {
    if (errors.hasErrors()) {
      return new ModelAndView(VIEW_CADASTRO);
    }

    NotaFiscalTO notaFiscalTOSalvo = this.notaFiscalService.save(notaFiscalTO);

    attributes.addFlashAttribute("mensagem", "Nota fiscal salva com sucesso! " + notaFiscalTOSalvo.getId());

    return new ModelAndView("redirect:/nota-fiscal/novo");
  }

  @GetMapping("{id}")
  public ModelAndView edit(@PathVariable("id") NotaFiscalTO notaFiscalTO) {
    ModelAndView modelAndView = new ModelAndView(VIEW_CADASTRO);

    modelAndView.addObject(notaFiscalTO);

    return modelAndView;
  }

  @DeleteMapping(value = "{id}")
  public ModelAndView excluir(@PathVariable Long id, RedirectAttributes redirectAttributes) {
    this.notaFiscalService.delete(id);

    redirectAttributes.addFlashAttribute("mensagem", "Nota fiscal excluída com sucesso!");

    return new ModelAndView("redirect:/nota-fiscal");
  }
}
