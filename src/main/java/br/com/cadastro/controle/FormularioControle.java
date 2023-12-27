package br.com.cadastro.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastro.dto.FormularioDto;
import br.com.cadastro.entidade.Formulario;
import br.com.cadastro.repositorio.FormularioRepositorio;
import br.com.cadastro.servico.FormularioServico;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://cadastro-front.vercel.app",  maxAge = 3600)
@RequestMapping("/api/formulario")
public class FormularioControle {

	@Autowired
	private FormularioRepositorio formularioRepository;

	@Autowired
	private FormularioServico formularioService;

	@GetMapping("/{id}")
	@Operation(summary = "Buscar Formulário")
	public ResponseEntity<Optional<Formulario>> buscarFormulario(@PathVariable Long id) {
		Optional<Formulario> formulario = formularioRepository.findById(id);
		return ResponseEntity.ok().body(formulario);
	}

	@GetMapping("/todos")
	@Operation(summary = "Listar Todos os Formulários")
	public List<FormularioDto> listarConsultas() {
		List<Formulario> formularios = formularioRepository.findAllDesc();
		return FormularioServico.listarTodosFormularios(formularios);
	}

	@PostMapping
	@Operation(summary = "Cadastrar Formulário")
	public ResponseEntity<Formulario> cadastrarFormulario(@Valid @RequestBody Formulario formulario) {
		formulario = formularioService.criarFormulario(formulario);
		return ResponseEntity.ok().body(formulario);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar Formulário")
	public ResponseEntity<Formulario> atualizarFormulario(@PathVariable Long id, @Valid @RequestBody Formulario dados) {
		Formulario novoDados = formularioService.atualizarFormulario(id, dados);
		return ResponseEntity.ok().body(novoDados);
	}

	@PatchMapping("/{id}")
	@Operation(summary = "Atualizar Formulário Patch")
	public ResponseEntity<Formulario> atualizarFormularioPatch(@PathVariable Long id,
			@Valid @RequestBody Formulario dados) {
		Formulario novoDados = formularioService.atualizarFormulario(id, dados);
		return ResponseEntity.ok().body(novoDados);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar Formulário")
	public ResponseEntity<?> deletarFormulario(@PathVariable Long id) {
		formularioService.deleteFormulario(id);
		return ResponseEntity.ok().build();

	}
}
