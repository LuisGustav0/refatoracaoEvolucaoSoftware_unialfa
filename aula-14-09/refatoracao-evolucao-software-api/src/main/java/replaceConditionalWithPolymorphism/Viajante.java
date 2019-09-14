package replaceConditionalWithPolymorphism;

import java.util.Optional;

public class Viajante {
  private TipoViajante tipoViajante;

  public Viajante(TipoViajante tipoViajante) {
    this.tipoViajante = tipoViajante;
  }

  public String getBebida() throws Exception {
    String simplName = Optional.ofNullable(tipoViajante)
                               .map(TipoViajante::getClass)
                               .map(Class::getSimpleName)
                               .map(Optional::ofNullable)
                               .map(Optional::get)
                               .orElse("ViajanteNaoExiste");

    switch (simplName) {
      case "Alemao":
        return "cerveja";
      case "Brasileiro":
        return "pinga + limao";
      case "Americano":
        return "coca_cola";
    }
    throw new Exception("Tipo desconhecido!");
  }
}
