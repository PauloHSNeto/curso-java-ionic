package udemy.nelio.cursojavaangular.DTO;

import org.hibernate.validator.constraints.Length;
import udemy.nelio.cursojavaangular.domain.cliente.Cliente;
import udemy.nelio.cursojavaangular.services.Validation.ClienteUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@ClienteUpdate
public class ClienteDTO implements Serializable {
    private static final long serialVerionId = 1L;
    private Integer id;
    @NotEmpty(message = "Preechimento obrigatorio")
    @Length(min = 5, max =120, message = "O tamanho deve estar entre 5 e 120 caracteres")
    private String name;
    @NotEmpty(message = "Preechimento obrigatorio")
    @Email(message = "Email Invalido")
    private String email;

    public ClienteDTO() {
    }
    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        name = obj.getNome();
        email = obj.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
