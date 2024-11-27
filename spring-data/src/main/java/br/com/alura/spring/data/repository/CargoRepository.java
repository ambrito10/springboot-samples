package br.com.alura.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Cargo;

@Repository
//public interface CargoRepository extends CrudRepository<Cargo, Integer> {
public interface CargoRepository extends PagingAndSortingRepository<Cargo, Integer> {
	
	// -- Spring - query creation (derived query) (findBy) - o spring cria a query automaticamente, baseado no parametro inserido e no nome do metodo -- //
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	
	public List<Cargo> findByDescricao(String desc);
	
	public List<Cargo> findByDescricaoLike(String desc);
	
	public List<Cargo> findByDescricaoStartingWith(String desc);
	
	public List<Cargo> findByDescricaoEndingWith(String desc);
	
	public List<Cargo> findByDescricaoIsNull();
	
	public List<Cargo> findByDescricaoIsNotNull();
	
	public List<Cargo> findByDescricaoOrderByDescricaoAsc(String desc);
	
	// -------------------------------------------------------------------------------------------------------------------------------- //
	
	// -- Com JPQL --
	
	@Query("select c from Cargo c")
	public List<Cargo> listAll();

	// -------------------------------------------------------------------------------------------------------------------------------- //
	
	// -- Com Native Query --

	@Query(value = "select * from cargos c", nativeQuery = true)
	public List<Cargo> listAllNative();

}

