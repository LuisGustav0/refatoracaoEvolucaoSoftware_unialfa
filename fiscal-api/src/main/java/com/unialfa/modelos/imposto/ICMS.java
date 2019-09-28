package com.unialfa.modelos.imposto;

import java.math.BigDecimal;

public class ICMS implements ImpostoI {

  @Override
  public BigDecimal calcular(BigDecimal valorBruto) {
    BigDecimal valorICMS = BigDecimal.valueOf(0.11);

    return valorBruto.multiply(valorICMS);
  }
}
