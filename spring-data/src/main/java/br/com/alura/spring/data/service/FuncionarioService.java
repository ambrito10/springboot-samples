package br.com.alura.spring.data.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private FuncionarioRepository funcionarioRepository;
	
	public FuncionarioService(FuncionarioRepository repository) {
		this.funcionarioRepository = repository;
	}
	
	public void showAll() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(System.out::println);
	}
	
	public void listFuncionarioSalario() {
		List<FuncionarioProjecao> list = funcionarioRepository.listFuncionarioSalario();
		list.forEach(func -> System.out.println(String.format("id :: %d - nome :: %s - salario :: %.02f", func.getId(), func.getNome(), func.getSalario())));
	}
}
