package extractMethod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pedido {
  private List<Item> listaPedido;

  public List<Item> getListaPedido() {
    addItem(new Item("Sabonete", BigDecimal.ONE));
    addItem(new Item("Pasta de dente", BigDecimal.TEN));
    addItem(null);

    return this.listaPedido;
  }

  private void addItem(Item item) {
    this.listaPedido = Optional.ofNullable(this.listaPedido)
                               .orElse(new ArrayList<>());

    item = Optional.ofNullable(item)
                   .orElse(new Item());

    this.listaPedido.add(item);
  }
}
