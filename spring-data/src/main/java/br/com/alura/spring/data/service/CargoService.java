package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CargoService {

	private CargoRepository cargoRepository = null;
	
	public CargoService(CargoRepository repository) {
		this.cargoRepository = repository;
	}
	
	public void initial(Scanner scanner) {
		save(scanner);
	}
	
	public void save(Scanner scanner) {
		System.out.println("Digite a descricao: ");
		String desc = "";
		desc += scanner.next();
		Cargo cargo = new Cargo(desc);
		System.out.println(cargo);
		cargoRepository.save(cargo);
		System.out.println("Salvo!!!");
	}
	
	public void update(Scanner scanner) {
		System.out.println("Digite o id: ");
		Integer id = scanner.nextInt();
		System.out.println("\nDigite a descricao: ");
		String desc = scanner.next();
		Cargo cargo = new Cargo(id, desc);
		System.out.println(cargo);
		cargoRepository.save(cargo);
		System.out.println("Atualizado!!!");
	}
	
	public void showAll() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));		
	}

	public void listAll() {
		List<Cargo> cargos = cargoRepository.listAll();
		cargos.forEach(cargo -> System.out.println(cargo));
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("25/10/1979", f);
		System.out.println("Data :: " + date);
	}

	public void listAllNative() {
		List<Cargo> cargos = cargoRepository.listAllNative();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	public void listPaging(Scanner scanner) {
		System.out.println("Digite o numero da pagina: ");
		Integer page = scanner.nextInt() - 1;									// Paginas iniciam em 0 :(
		final int numberRegisterByPage = 5;

		//Pageable pageable = PageRequest.of(page, numberRegisterByPage, Sort.unsorted());
		Pageable pageable = PageRequest.of(page, numberRegisterByPage, Sort.by(Sort.Direction.ASC, "descricao"));
		Page<Cargo> cargos = cargoRepository.findAll(pageable);
		
		System.out.println(cargos);
		System.out.println("Pagina atual ::" + (cargos.getNumber() + 1));
		System.out.println("Registros na pagina :: " + cargos.getNumberOfElements());
		System.out.println("Total registros :: " + cargos.getTotalElements());
		cargos.forEach(System.out::println);
	}
	
	public void delete(Scanner scanner) {
		System.out.println("Digite o id: ");
		Integer id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Removido!!!");
	}
	
	public void listByName(Scanner scanner) {
		System.out.println("Digite o cargo: ");
		String name = scanner.next();
		List<Cargo> list = cargoRepository.findByDescricao(name);
		list.forEach(System.out::println);
	}
	
	public void listByNameLike(Scanner scanner) {
		System.out.println("O cargo inicial com: ");
		String name = scanner.next();
		List<Cargo> list = cargoRepository.findByDescricaoLike(name + "%");
		list.forEach(System.out::println);
	}
	
}
