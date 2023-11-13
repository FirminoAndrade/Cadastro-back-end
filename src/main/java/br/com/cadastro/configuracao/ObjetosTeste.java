package br.com.cadastro.configuracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.entidade.Formulario;
import br.com.cadastro.repositorio.FormularioRepositorio;

@Service
public class ObjetosTeste {

	@Autowired
	private FormularioRepositorio formularioRepositorio;
	
	public void instaciaBaseDeDados() {
		
		Formulario formulario = new Formulario(null, "Jose", "Rua1", "centro", "Lagoa do Carro", "81984661549", "13-01-1989", "Masculino", "34","10-11-2023");
		formularioRepositorio.save(formulario);

	}
}
