package com.unialfa.modelos.imposto;

import java.math.BigDecimal;

public interface ImpostoI {

  BigDecimal calcular(BigDecimal valorBruto);
}
