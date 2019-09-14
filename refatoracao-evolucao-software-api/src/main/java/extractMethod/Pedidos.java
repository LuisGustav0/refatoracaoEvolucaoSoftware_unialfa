package extractMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pedidos {
  private List<Itens> listaPedido;

  public List<Itens> getListaPedido() {
    addItem(new Itens("Sabonete", BigDecimal.ONE));
    addItem(new Itens("Pasta de dente", BigDecimal.TEN));

    return this.listaPedido;
  }

  private void addItem(Itens item) {
    this.listaPedido = Optional.ofNullable(this.listaPedido).orElse(new ArrayList<>());

    item = Optional.ofNullable(item).orElse(new Itens("Item Padrao", BigDecimal.ZERO));

    this.listaPedido.add(item);
  }
}
