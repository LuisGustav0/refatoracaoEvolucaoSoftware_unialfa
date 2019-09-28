package com.unialfa.modelos.notafiscal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class NotaFiscalService {

  @Autowired
  private NotaFiscalRepository notaFiscalRepository;

  public List<NotaFiscalTO> findAll() {
    return notaFiscalRepository.findAll();
  }

  private void onCalcularImposto(NotaFiscalTO notaFiscalTO) {
    BigDecimal valorBruto = notaFiscalTO.getValor().add(notaFiscalTO.getImposto());

    BigDecimal valorImposto = notaFiscalTO.getTipoImposto().getImposto().calcular(valorBruto);
    BigDecimal valorTotal = valorBruto.add(valorImposto);

    notaFiscalTO.setValorTotal(valorTotal);
  }

  private NotaFiscalTO onAntesSalvar(NotaFiscalTO notaFiscalTO) {
    onCalcularImposto(notaFiscalTO);

    return notaFiscalTO;
  }

  public NotaFiscalTO save(NotaFiscalTO notaFiscalTO) {
    onAntesSalvar(notaFiscalTO);

    return notaFiscalRepository.save(notaFiscalTO);
  }

  public void delete(Long id) {
    this.notaFiscalRepository.deleteById(id);
  }
}
