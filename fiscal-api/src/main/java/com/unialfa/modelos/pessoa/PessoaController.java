package com.unialfa.modelos.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

  @Autowired
  private PessoaRepository pessoaRepository;

  @GetMapping
  public List<Pessoa> listar() {
    return pessoaRepository.findAll();
  }

  @PostMapping
  public void save(@RequestBody Pessoa pessoa) {
    this.pessoaRepository.save(pessoa);
  }
}
