package udemy.nelio.cursojavaangular.domain.pedido;

import udemy.nelio.cursojavaangular.domain.cliente.Cliente;
import udemy.nelio.cursojavaangular.domain.cliente.Endereco;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Pedido implements Serializable {
    private static final long serialVerionId = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date instente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name= "endereco_de_entrega_id")
    private Endereco enderecoDeEntrega;


    public Pedido() {
    }

    public Pedido(Integer id, Date instente, Cliente cliente, Endereco enderecoDeEntrega) {
        this.id = id;
        this.instente = instente;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstente() {
        return instente;
    }

    public void setInstente(Date instente) {
        this.instente = instente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
        this.enderecoDeEntrega = enderecoDeEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;

        Pedido pedido = (Pedido) o;

        return getId() != null ? getId().equals(pedido.getId()) : pedido.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
