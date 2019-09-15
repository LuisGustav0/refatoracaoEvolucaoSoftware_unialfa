package com.unialfa.modelos.notafiscal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaFiscalService {

  @Autowired
  private NotaFiscalRepository notaFiscalRepository;

  public List<NotaFiscal> findAll() {
    return notaFiscalRepository.findAll();
  }

  private NotaFiscal onAntesSalvar(NotaFiscal notaFiscal) {

    return notaFiscal;
  }

  public NotaFiscal save(NotaFiscal notaFiscal) {
    notaFiscal = onAntesSalvar(notaFiscal);

    return notaFiscalRepository.save(notaFiscal);
  }

  public void delete(Long id) {
    this.notaFiscalRepository.deleteById(id);
  }
}
