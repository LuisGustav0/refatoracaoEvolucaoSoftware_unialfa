package com.unialfa.modelos.notafiscal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class NotaFiscalService {

  @Autowired
  private NotaFiscalRepository notaFiscalRepository;

  public List<NotaFiscal> findAll() {
    return notaFiscalRepository.findAll();
  }

  private void onCalcularImposto(NotaFiscal notaFiscal) {
    BigDecimal valorBruto = notaFiscal.getValor().add(notaFiscal.getImposto());

    BigDecimal valorImposto = notaFiscal.getTipoImposto().getImposto().calcular(valorBruto);
    BigDecimal valorTotal = valorBruto.add(valorImposto);

    notaFiscal.setValorTotal(valorTotal);
  }

  private NotaFiscal onAntesSalvar(NotaFiscal notaFiscal) {
    onCalcularImposto(notaFiscal);

    return notaFiscal;
  }

  public NotaFiscal save(NotaFiscal notaFiscal) {
    onAntesSalvar(notaFiscal);

    return notaFiscalRepository.save(notaFiscal);
  }

  public void delete(Long id) {
    this.notaFiscalRepository.deleteById(id);
  }
}
