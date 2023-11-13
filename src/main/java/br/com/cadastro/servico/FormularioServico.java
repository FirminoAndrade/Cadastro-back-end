package br.com.cadastro.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dto.FormularioDto;
import br.com.cadastro.entidade.Formulario;
import br.com.cadastro.repositorio.FormularioRepositorio;

@Service
public class FormularioServico {

	@Autowired
	private FormularioRepositorio formularioRepository;

	// buscar por id
	private Formulario findById(Long id) {
		Optional<Formulario> formulario = formularioRepository.findById(id);
		return formulario.get();
	}

	// listar
	public static List<FormularioDto> listarTodosFormularios(List<Formulario> formulario) {
		return formulario.stream().map(FormularioDto::new).collect(Collectors.toList());
	}

	// criar
	public Formulario criarFormulario(Formulario formulario) {
		formulario.setId(null);
		return formularioRepository.save(formulario);
	}

	// atualizar
	public Formulario atualizarFormulario(Long id, Formulario dados) {
		Formulario novoDados = findById(id);
		atualizarDadosDoFormulario(novoDados, dados);
		return formularioRepository.save(novoDados);
	}

	// atualizar dados do Formulario
	private void atualizarDadosDoFormulario(Formulario novoDados, Formulario formulario) {
		novoDados.setNome(formulario.getNome());
		novoDados.setEndereco(formulario.getEndereco());
		novoDados.setBairro(formulario.getBairro());
		novoDados.setCidade(formulario.getCidade());
		novoDados.setTelefone(formulario.getTelefone());
		novoDados.setDataNasc(formulario.getDataNasc());
		novoDados.setGenero(formulario.getGenero());
		novoDados.setIdade(formulario.getIdade());

	}

	// deletar
	public void deleteFormulario(Long id) {
		findById(id);
		formularioRepository.deleteById(id);
	}
}
