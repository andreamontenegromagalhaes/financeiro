package br.com.financeiro.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.financeiro.DAO.UsuarioDAO;
import br.com.financeiro.domain.Usuario;
import br.com.financeiro.util.JSFUtil;

@ManagedBean(name = "MBUsuario")
@ViewScoped

public class UsuarioBean {
	private Usuario usuario;
			
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private ArrayList<Usuario> itens;
	private ArrayList<Usuario> itensFiltrados;

	public ArrayList<Usuario> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Usuario> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Usuario> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Usuario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			UsuarioDAO udao = new UsuarioDAO();			
			itens = (ArrayList<Usuario>) udao.listar();
		} catch (RuntimeException e) {
			JSFUtil.adicionarMensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	public void prepararNovo(){
		usuario = new Usuario();
	}

	public void novo() {
		try{
			UsuarioDAO udao = new UsuarioDAO();
			udao.salvar(usuario);
			itens = udao.listar();

			JSFUtil.adicionarMensagemSucesso("Usuário salvo com sucesso!");
			
		} catch(SQLException e) {
			JSFUtil.adicionarMensagemErro("e.getMessage()");
			e.printStackTrace();
		}
		
	}
	
	public void excluir() {
		try{
			UsuarioDAO udao = new UsuarioDAO();
			udao.excluir(usuario);
			itens = udao.listar();
			JSFUtil.adicionarMensagemSucesso("Usuário excluído com sucesso!");
			
		} catch(SQLException e) {
			JSFUtil.adicionarMensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}

	public void editar() {
		try{
			UsuarioDAO udao = new UsuarioDAO();
			udao.editar(usuario);
			itens = udao.listar();
			JSFUtil.adicionarMensagemSucesso("Usuário editado com sucesso!");
			
		} catch(SQLException e) {
			JSFUtil.adicionarMensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}



}
