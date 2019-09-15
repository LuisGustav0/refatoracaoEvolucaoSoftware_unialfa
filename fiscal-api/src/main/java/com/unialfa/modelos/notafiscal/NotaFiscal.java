package com.unialfa.modelos.notafiscal;

import com.unialfa.modelos.notafiscal.enums.TipoImpostoE;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotEmpty(message = "Empresa é obrigatória")
  @Size(max = 60, message = "A empresa não pode conter mais de 60 caracteres")
  private String empresa;
  @NotNull(message = "Imposto é obrigatório")
  @DecimalMin(value = "0.01", message = "Imposto não pode ser menor que 0,01")
  @DecimalMax(value = "9999999.99", message = "Imposto não pode ser maior que 9.999.999,99")
  @NumberFormat(pattern = "#,##0.00")
  private BigDecimal imposto;
  @NotNull(message = "Valor é obrigatório")
  @DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
  @DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
  @NumberFormat(pattern = "#,##0.00")
  private BigDecimal valor;
  @NotNull(message = "Tipo imposto é obrigatório")
  @Enumerated(EnumType.STRING)
  private TipoImpostoE tipoImposto;
  @NumberFormat(pattern = "#,##0.00")
  private BigDecimal valorTotal;

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

  public TipoImpostoE getTipoImposto() {
    return tipoImposto;
  }

  public void setTipoImposto(TipoImpostoE tipoImposto) {
    this.tipoImposto = tipoImposto;
  }

  public boolean isTipoImpostoISS() {
    return TipoImpostoE.ISS.equals(this.tipoImposto);
  }

  public BigDecimal getValorTotal() {
    return Optional.ofNullable(valorTotal).orElse(BigDecimal.ZERO);
  }

  public void setValorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
  }
}
