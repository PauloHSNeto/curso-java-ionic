package udemy.nelio.cursojavaangular.DTO;

import org.hibernate.validator.constraints.Length;
import udemy.nelio.cursojavaangular.services.Validation.ClienteInsert;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
@ClienteInsert
public class ClienteNewDTO implements Serializable {
    private static final long serialVerionId = 1L;
    @NotEmpty(message = "Preechimento obrigatorio")
    @Length(min = 5, max =120, message = "O tamanho deve estar entre 5 e 120 caracteres")
    private String name;
    @NotEmpty(message = "Preechimento obrigatorio")
    @Email(message = "Email Invalido")
    private String email;
    @NotEmpty(message = "Preechimento obrigatorio")
    private String cpfOuCnpj;
    private Integer tipo;
    @NotEmpty(message = "Preechimento obrigatorio")
    private String logradouro;
    @NotEmpty(message = "Preechimento obrigatorio")
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    @NotEmpty(message = "Preechimento obrigatorio")
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private Integer cidadeId;

    @NotEmpty(message = "Preechimento obrigatorio")
    private String senha;

    public ClienteNewDTO() {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public Integer getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Integer cidadeId) {
        this.cidadeId = cidadeId;
    }
}
