package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CargoService;
import br.com.alura.spring.data.service.FuncionarioService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private CargoService cargoService = null;
	private FuncionarioService funcionarioService = null;
	private RelatorioFuncionarioDinamico relFuncionaroDinamico = null;
	private boolean stop = false;
	
	public SpringDataApplication(CargoService cargoService, FuncionarioService funcService, RelatorioFuncionarioDinamico rel) {
		this.cargoService = cargoService;
		this.funcionarioService = funcService;
		this.relFuncionaroDinamico = rel;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Metodo executado apos o start da aplicacao (pertence a interface CommandLineRunnger)...");
		Scanner scanner = new Scanner(System.in);
		
		while(!stop) {
			System.out.println("Digite a acao desejada:");
			System.out.println("0 - Sair");
			System.out.println("1 - Adicionar cargo");
			System.out.println("2 - Atualizar cargo");
			System.out.println("3 - Mostrar todos cargos");
			System.out.println("4 - Deleter cargo");
			System.out.println("5 - Procurar cargo");
			System.out.println("6 - Procurar cargo (parte)");
			System.out.println("7 - Mostrar cargo paginado");
			System.out.println("8 - Mostrar todos functionaros");
			System.out.println("9 - Mostrar functionaros / salarios");
			System.out.println("10 - Relatorio dinamico de funcionarios");
			System.out.println();
			
			int option = scanner.nextInt();
			
			switch(option) {
				case 1:
					cargoService.initial(scanner);
					break;
					
				case 2:
					cargoService.update(scanner);
					break;
					
				case 3:
					//cargoService.showAll();
					//cargoService.listAll();
					cargoService.listAllNative();
					break;
					
				case 4:
					cargoService.delete(scanner);
					break;

				case 5:
					cargoService.listByName(scanner);
					break;

				case 6:
					cargoService.listByNameLike(scanner);
					break;
					
				case 7:
					cargoService.listPaging(scanner);
					break;

				case 8:
					funcionarioService.showAll();
					break;

				case 9:
					funcionarioService.listFuncionarioSalario();
					break;

				case 10:
					relFuncionaroDinamico.report(scanner);
					break;
					
				default:
					stop = true;
					break;
			}
		}
		
		
	}

}
