package br.com.zup.casadocodigo.validacao;

public class ErroEmCadastroDTO {

	private String campo;
	private String erro;

	public ErroEmCadastroDTO (String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}

}
