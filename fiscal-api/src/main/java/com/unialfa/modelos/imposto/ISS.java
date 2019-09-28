package com.unialfa.modelos.imposto;

import java.math.BigDecimal;

public class ISS implements ImpostoI {
  @Override
  public BigDecimal calcular(BigDecimal valorBruto) {
    BigDecimal valorISS = BigDecimal.valueOf(0.10);

    return valorBruto.multiply(valorISS);
  }
}
