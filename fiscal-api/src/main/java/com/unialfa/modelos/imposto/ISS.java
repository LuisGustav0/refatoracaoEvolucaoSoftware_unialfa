package com.unialfa.modelos.imposto;

import java.math.BigDecimal;

public class ISS implements ImpostoI {
  @Override
  public BigDecimal calcular(BigDecimal valorBruto) {
    return valorBruto.multiply(new BigDecimal(0.10));
  }
}
