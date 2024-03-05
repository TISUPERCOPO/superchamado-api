package com.supercopo.chamado.validation.empresa;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.supercopo.chamado.domain.Empresa;
import com.supercopo.chamado.domain.EmpresaNew;
import com.supercopo.chamado.repository.EmpresaRepository;
import com.supercopo.chamado.resource.exception.FieldMessage;
import com.supercopo.chamado.resource.utils.BR;

public class EmpresaInsertValidator implements ConstraintValidator<EmpresaInsert, EmpresaNew> {
	@Autowired
	private EmpresaRepository repo;
	@Override
	public void initialize(EmpresaInsert ann) {
	}
	@Override
	public boolean isValid(EmpresaNew value, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();      
		
		if (value.getNaturezapessoa().equals("FISICA")){
			Empresa cpf = repo.findByCpfoucnpj(value.getCpfoucnpj());
		if (cpf != null) {
			list.add(new FieldMessage("cpfoucnpj", " CPF já existente "));
		}
		}
		if (value.getNaturezapessoa().equals("FISICA") && !BR.isValidCPF(value.getCpfoucnpj())) {
			list.add(new FieldMessage("cpfoucnpj", "CPF inválido"));			
		}
		
		if (value.getNaturezapessoa().equals("JURIDICA")){
			Empresa cnpj = repo.findByCpfoucnpj(value.getCpfoucnpj());
		if (cnpj != null) {
			list.add(new FieldMessage("cpfoucnpj", " CNPJ já existente  "));
		}
		}
		if (value.getNaturezapessoa().equals("JURIDICA")
				&& !BR.isValidCNPJ(value.getCpfoucnpj())) {
			list.add(new FieldMessage("cpfoucnpj", " CNPJ inválido"));			
		}

		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
