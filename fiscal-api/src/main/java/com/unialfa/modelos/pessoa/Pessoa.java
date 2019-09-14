package com.unialfa.modelos.pessoa;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {
  @Id
  @GeneratedValue
  private Long id;
  private String nome;
  private boolean isAtivo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public boolean isAtivo() {
    return isAtivo;
  }

  public void setAtivo(boolean ativo) {
    isAtivo = ativo;
  }
}
