package com.unialfa.modelos.notafiscal;

import com.unialfa.modelos.imposto.enums.TipoImpostoE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotaFiscalServiceTest {

  @InjectMocks
  private NotaFiscalService notaFiscalService;

  @Mock
  private NotaFiscalRepository notaFiscalRepository;

  @Test
  public void testSalvar() {
    NotaFiscalTO notaFiscalTO = new NotaFiscalTO();
    notaFiscalTO.setEmpresa("Empresa Teste");
    notaFiscalTO.setTipoImposto(TipoImpostoE.ISS);
    notaFiscalTO.setImposto(BigDecimal.valueOf(1000));
    notaFiscalTO.setValor(BigDecimal.valueOf(13850.38));

    when(notaFiscalRepository.save(notaFiscalTO)).thenReturn(notaFiscalTO);

    this.notaFiscalService.save(notaFiscalTO);
  }
}
