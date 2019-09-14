package extractMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Divida {
  private Pedido pedidoService;
  private String nome;

  public Divida() {
    this.nome = "RAZAO SOCIAL";
    this.pedidoService = new Pedido();
  }

  private void imprimirCabecalho() {
    System.out.println("***************************");
    System.out.println("*** Dívidas do Cliente ****");
    System.out.println("***************************");
  }

  private BigDecimal calcularDivida() {
    BigDecimal divida;

    List<Item> listaItens = Optional.ofNullable(pedidoService)
                                    .map(Pedido::getListaPedido)
                                    .map(Optional::ofNullable)
                                    .map(Optional::get)
                                    .orElse(new ArrayList<>());

    divida = listaItens.stream()
                       .map(this::getValorItem)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);

    return divida;
  }

  private BigDecimal getValorItem(Item item) {
    return Optional.ofNullable(item)
                   .map(Item::getValor)
                   .map(Optional::ofNullable)
                   .map(Optional::get)
                   .orElse(BigDecimal.ZERO);
  }

  private void impirmirDetalhes(BigDecimal divida) {
    System.out.println("Nome: " + nome);
    System.out.println("Divida total: " + divida);
  }

  public void imprimeDivida() {
    imprimirCabecalho();

    BigDecimal divida = calcularDivida();

    impirmirDetalhes(divida);
  }
}
