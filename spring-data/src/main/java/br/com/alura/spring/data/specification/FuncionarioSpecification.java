package br.com.alura.spring.data.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.alura.spring.data.orm.Funcionario;

public class FuncionarioSpecification {

	public static Specification<Funcionario> nome(String nome) {
		return(root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
	}
	
	public static Specification<Funcionario> salario(Double salario) {
		return(root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("salario"), salario);
	}
}
