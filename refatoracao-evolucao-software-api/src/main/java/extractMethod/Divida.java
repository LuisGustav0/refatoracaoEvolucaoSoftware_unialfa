package extractMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Divida {
  private Pedidos pedidoService;
  private String nome;

  public Divida() {
    this.nome = "RAZAO SOCIAL";
    this.pedidoService = new Pedidos();
  }

  private void imprimirCabecalho() {
    System.out.println("***************************");
    System.out.println("*** Dívidas do Cliente ****");
    System.out.println("***************************");
  }

  private BigDecimal calcularDivida() {
    BigDecimal divida;

    List<Itens> listaItens = Optional.ofNullable(pedidoService)
                                     .map(Pedidos::getListaPedido)
                                     .map(Optional::ofNullable)
                                     .map(Optional::get)
                                     .orElse(new ArrayList<>());

    divida = listaItens.stream()
                       .map(this::getValorItem)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);

    return divida;
  }

  private BigDecimal getValorItem(Itens item) {
    return Optional.ofNullable(item)
                   .map(Itens::getValor)
                   .map(Optional::ofNullable)
                   .map(Optional::get)
                   .orElse(BigDecimal.ZERO);
  }

  private void impirmirDetalhes(BigDecimal divida) {
    System.out.println("Nome: " + nome);
    System.out.println("Divida total: " + divida);
  }

  private void imprimeDivida() {
    imprimirCabecalho();

    BigDecimal divida = calcularDivida();

    impirmirDetalhes(divida);
  }

  public static void main(String[] args) {
    Divida divida = new Divida();
    divida.imprimeDivida();
  }
}
