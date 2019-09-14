package collapseHierarchy;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class VendedorTeste {

  @Test
  public void testeVendedor() {
    Vendedor vendedor = new Vendedor("Luis Gustavo", new BigDecimal(200), new BigDecimal(50));

    assertEquals(new BigDecimal(250), vendedor.calcularSalario());
  }
}
