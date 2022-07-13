package udemy.nelio.cursojavaangular.domain.pedido;

import com.fasterxml.jackson.annotation.JsonFormat;
import udemy.nelio.cursojavaangular.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class PagamentoComBoleto extends Pagamento{
    private static final long serialVerionId = 1L;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeVencimento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDePagamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataDeVencimento, Date dataDePagamento) {
        super(id, estado, pedido);
        this.dataDeVencimento = dataDeVencimento;
        this.dataDePagamento = dataDePagamento;
    }

    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(Date dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public Date getDataDePagamento() {
        return dataDePagamento;
    }

    public void setDataDePagamento(Date dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }
}
