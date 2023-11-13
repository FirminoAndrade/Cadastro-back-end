package br.com.cadastro.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cadastro.entidade.Formulario;

@Repository
public interface FormularioRepositorio extends JpaRepository<Formulario, Long> {

	@Query(nativeQuery = true, value = "Select * from formulario order by id desc;")
	List<Formulario> findAllDesc();
}
