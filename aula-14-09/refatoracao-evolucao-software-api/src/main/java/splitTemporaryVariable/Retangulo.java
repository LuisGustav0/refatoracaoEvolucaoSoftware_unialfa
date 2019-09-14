package splitTemporaryVariable;

import java.util.Optional;

public class Retangulo {
  private double altura;
  private double largura;

  public Retangulo(double altura, double largura) {
    this.altura = Optional.ofNullable(altura).orElse(0D);
    this.largura = Optional.ofNullable(largura).orElse(0D);
  }

  public double getPerimetro() {
    return 2 * (this.altura + this.largura);
  }

  public double getArea() {
    return this.altura * this.largura;
  }
}
