package udemy.nelio.cursojavaangular.services.Validation;

import udemy.nelio.cursojavaangular.DTO.ClienteNewDTO;
import udemy.nelio.cursojavaangular.enums.TipoCliente;
import udemy.nelio.cursojavaangular.exception.FieldMessage;
import udemy.nelio.cursojavaangular.services.Validation.ClienteInsert;
import udemy.nelio.cursojavaangular.services.Validation.Utils.BR;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class ClientInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO

> {
    @Override
    public void initialize(ClienteInsert ann) {
    }
    @Override
    public boolean isValid(ClienteNewDTO

 objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj","CPF invalido"));
        }

        if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.add(new FieldMessage("cpfOuCnpj","CNPJ invalido"));
        }


        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}