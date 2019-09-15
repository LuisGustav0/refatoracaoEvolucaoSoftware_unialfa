package com.unialfa.modelos.notafiscal.enums;

import com.unialfa.modelos.imposto.ICMS;
import com.unialfa.modelos.imposto.ISS;
import com.unialfa.modelos.imposto.ImpostoI;

public enum TipoImpostoE {
  ICMS(new ICMS()),
  ISS(new ISS());

  private ImpostoI impostoI;

  TipoImpostoE(ImpostoI impostoI) {
    this.impostoI = impostoI;
  }

  public ImpostoI getImposto() {
    return impostoI;
  }
}