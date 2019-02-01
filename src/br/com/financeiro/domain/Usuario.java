package br.com.financeiro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario" ),
@NamedQuery(name = "Usuario.buscarPorId", query = "SELECT usuario FROM Usuario usuario WHERE usuario.idusuario = :idusuario" ),
@NamedQuery(name = "Usuario.buscarPorNome", query = "SELECT usuario FROM Usuario usuario WHERE usuario.nome like :nome" )
})

public class Usuario {

	@Id
    @GeneratedValue
	private int idusuario;
	private String nome;
	private String login;
	private String email;
	private String senha;
	private int ativo;

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nome=" + nome + ", login=" + login + ", email=" + email
				+ ", senha=" + senha + ", ativo=" + ativo + "]";
	}

	
}
