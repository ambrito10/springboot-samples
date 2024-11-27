package br.com.alura.spring.data.orm;

// Poderia ser uma classe tambem, porem, teremos que implementar um construtor com os mesmos atributos retornados na query (e na mesma ordem)
public interface FuncionarioProjecao {

	public Integer getId();
	public String getNome();
	public double getSalario();
	
}
