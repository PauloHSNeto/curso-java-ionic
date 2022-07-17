package udemy.nelio.cursojavaangular.domain.produto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import udemy.nelio.cursojavaangular.domain.pedido.ItemPedido;
import udemy.nelio.cursojavaangular.domain.pedido.Pedido;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@Entity
public class Jogo  implements Serializable {
        private static final long serialVerionId = 1L;

        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="Jogo_Categoria",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    private Set<ItemPedido> items = new HashSet<>();

    public Jogo() {
    }
    public Jogo(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @JsonIgnore
    public  List<Pedido> getPedidos(){
        List<Pedido> lista = new ArrayList<>();
        for (ItemPedido p : items){
            lista.add(p.getPedido());
        }
        return lista;
    }

    public Set<ItemPedido> getItems() {
        return items;
    }

    public void setItems(Set<ItemPedido> items) {
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogo)) return false;

        Jogo jogo = (Jogo) o;

        return getId() != null ? getId().equals(jogo.getId()) : jogo.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
