package udemy.nelio.cursojavaangular.services;

import org.springframework.stereotype.Service;
import udemy.nelio.cursojavaangular.domain.pedido.PagamentoComBoleto;

import java.util.Calendar;
import java.util.Date;

@Service
public class BoletoService {
    public void preencherPagamentoComBoleto(PagamentoComBoleto pgto, Date instanteDoPedido) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(instanteDoPedido);
        cal.add(Calendar.DAY_OF_MONTH,7);
        pgto.setDataVencimento(cal.getTime());
    }
}
