package entidades;



public class Conta {

	private String nome;
	private String email;
	private String senha;
	private String pais;
	private String cidade;

	public Conta(String nome, String email, String senha, String pais, String cidade) {

		this.nome = nome;
		this.email = email;
		this.pais = pais;
		this.cidade = cidade;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getPais() {
		return pais;
	}

	public String getCidade() {
		return cidade;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + ", Email: " + email + ", País: " + pais + ", Cidade: " + cidade;
	}

	public String getSenha() {
		return senha;
	}

}
