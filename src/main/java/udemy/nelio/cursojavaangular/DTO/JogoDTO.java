package udemy.nelio.cursojavaangular.DTO;

import org.hibernate.validator.constraints.Length;
import udemy.nelio.cursojavaangular.domain.produto.Jogo;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class JogoDTO implements Serializable {
    private static final long serialVerionId = 1L;
    private Integer id;
    @NotEmpty(message = "Preechimento obrigatorio")
    @Length(min = 2, max =80, message = "O tamanho deve estar entre 2 e 80 caracteres")
    private String name;
    private Double price;
    public JogoDTO() {
    }
    public JogoDTO(Jogo obj) {
        id = obj.getId();
        name = obj.getName();
        price = obj.getPrice();

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
}
