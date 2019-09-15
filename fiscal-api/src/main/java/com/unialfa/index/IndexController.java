package com.unialfa.index;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

  @RequestMapping("/")
  public ModelAndView paginaPrincipal() {
    return  new ModelAndView("redirect:/nota-fiscal/novo");
  }
}
