package br.com.cadastro.dto;

import br.com.cadastro.entidade.Formulario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormularioDto {

	private Long id;
	private String nome;
	private String endereco;
	private String bairro;
	private String cidade;
	private String telefone;
	private String dataNasc;
	private String genero;
	private String idade;
	private String data;


	public FormularioDto(Formulario formulario) {
		this.id = formulario.getId();
		this.nome = formulario.getNome();
		this.endereco = formulario.getEndereco();
		this.bairro = formulario.getBairro();
		this.cidade = formulario.getCidade();
		this.telefone = formulario.getTelefone();
		this.dataNasc = formulario.getDataNasc();
		this.genero = formulario.getGenero();
		this.idade = formulario.getIdade();
		this.data = formulario.getData();

	}
}
