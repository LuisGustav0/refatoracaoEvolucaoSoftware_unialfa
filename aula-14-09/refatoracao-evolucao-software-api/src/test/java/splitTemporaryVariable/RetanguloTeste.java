package splitTemporaryVariable;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RetanguloTeste {

  @Test
  public void calcularPerimetro() {
    Retangulo retangulo = new Retangulo(20, 3);

    double perimetro = retangulo.getPerimetro();
    assertEquals(46, perimetro, 0);
  }

  @Test
  public void calcularArea() {
    Retangulo retangulo = new Retangulo(35, 3);

    double area = retangulo.getArea();
    assertEquals(105, area, 0.1);
  }
}
