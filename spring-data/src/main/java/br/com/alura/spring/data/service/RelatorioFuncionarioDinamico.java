package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.specification.FuncionarioSpecification;

@Service
public class RelatorioFuncionarioDinamico {

	private FuncionarioRepository funcRepository = null;
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository rep) {
		this.funcRepository = rep;
	}
	
	public void report(Scanner scanner) {
		System.out.println("Digite um trecho do nome: ");
		String nome = scanner.next();		
		if(nome.equalsIgnoreCase("NULL")) nome = null;

		System.out.println("Digite um salario inicial: ");
		Double salario = scanner.nextDouble();		

		List<Funcionario> list = funcRepository.findAll(
			Specification.where(FuncionarioSpecification.nome(nome)
				.and(FuncionarioSpecification.salario(salario)))
		);
		
		list.forEach(System.out::println);
	}
}
