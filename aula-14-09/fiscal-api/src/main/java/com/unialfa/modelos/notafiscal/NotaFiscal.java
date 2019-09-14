package com.unialfa.modelos.notafiscal;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String empresa;
  private BigDecimal imposto;
  private BigDecimal valor;

  public NotaFiscal() {
  }

  public NotaFiscal(String empresa,
                    BigDecimal imposto,
                    BigDecimal valor) {
    this.empresa = empresa;
    this.imposto = imposto;
    this.valor = valor;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmpresa() {
    return empresa;
  }

  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }

  public BigDecimal getImposto() {
    return imposto;
  }

  public void setImposto(BigDecimal imposto) {
    this.imposto = imposto;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
}
