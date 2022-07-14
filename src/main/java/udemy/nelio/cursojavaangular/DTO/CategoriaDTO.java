package udemy.nelio.cursojavaangular.DTO;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;
import udemy.nelio.cursojavaangular.domain.produto.Categoria;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVerionId = 1L;
    private Integer id;

    @NotEmpty(message = "Preechimento obrigatorio")
    @Length(min = 2, max =80, message = "O tamanho de estar entre 2 e 80 caracteres")
    private String name;
    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj) {
        id = obj.getId();
        name = obj.getName();

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
