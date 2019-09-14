package replaceConditionalWithPolymorphism;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ViajanteTeste {

  @Test
  public void testarViajanteAlemao() throws Exception {
    Viajante viajante = new Viajante(new Alemao());
    assertEquals("cerveja", viajante.getBebida());
  }

  @Test
  public void testarViajanteBrasileiro() throws Exception {
    Viajante viajante = new Viajante(new Brasileiro());
    assertEquals("pinga + limao", viajante.getBebida());
  }

  @Test
  public void testarViajanteAmericano() throws Exception {
    Viajante viajante = new Viajante(new Americano());
    assertEquals("coca_cola", viajante.getBebida());
  }

  @Test(expected = Exception.class)
  public void testarViajanteNaoExiste() throws Exception {
    Viajante viajante = new Viajante(null);
    assertEquals("coca_cola", viajante.getBebida());
  }
}
