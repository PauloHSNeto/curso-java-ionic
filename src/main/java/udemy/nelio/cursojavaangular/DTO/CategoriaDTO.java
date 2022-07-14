package udemy.nelio.cursojavaangular.DTO;

import udemy.nelio.cursojavaangular.domain.produto.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVerionId = 1L;

    private Integer id;
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
