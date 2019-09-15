package com.unialfa.modelos.imposto;

import java.math.BigDecimal;

public class ICMS implements ImpostoI {

  @Override
  public BigDecimal calcular(BigDecimal valorBruto) {
    return valorBruto.multiply(new BigDecimal(0.11));
  }
}
