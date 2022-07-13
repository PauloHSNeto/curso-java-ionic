package udemy.nelio.cursojavaangular.domain.pedido;

import udemy.nelio.cursojavaangular.domain.produto.Jogo;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class ItemPedido implements Serializable {
    private static final long serialVerionId = 1L;
    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;


    public ItemPedido() {
    }

    public ItemPedido(Pedido pedido , Jogo jogo, Double desconto, Integer quantidade, Double preco) {
        id.setPedido(pedido);
        id.setProduto(jogo);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public Pedido getPedido(){

        return id.getPedido();
    }
    public Jogo getProduto(){

        return id.getProduto();

    }
    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemPedido)) return false;

        ItemPedido that = (ItemPedido) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
