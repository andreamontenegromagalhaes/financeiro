package br.com.financeiro.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.financeiro.DAO.GrupoDAO;
import br.com.financeiro.domain.Grupo;
import br.com.financeiro.util.JSFUtil;

@ManagedBean(name = "MBGrupo")
@ViewScoped
public class GrupoBean {

	private Grupo grupo;
	
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	private ArrayList<Grupo> itens;
	private ArrayList<Grupo> itensFiltrados;

	public ArrayList<Grupo> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Grupo> itens) {
		this.itens = itens;
	}
	
	public ArrayList<Grupo> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(ArrayList<Grupo> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}
	
	
	@PostConstruct
	public void prepararPesquisa() {
		try {
			GrupoDAO gdao = new GrupoDAO();			
			itens = gdao.listar();
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}

	public void prepararNovo(){
		grupo = new Grupo();
	}

	public void novo() {
		try{
			GrupoDAO gdao = new GrupoDAO();
			gdao.salvar(grupo);
			itens = gdao.listar();

			JSFUtil.adicionarMensagemSucesso("Grupo salvo com sucesso!");
			
		} catch(SQLException e) {
			JSFUtil.adicionarMensagemErro("e.getMessage()");
			e.printStackTrace();
		}
		
	}
	
	public void excluir() {
		try{
			GrupoDAO gdao = new GrupoDAO();
			gdao.excluir(grupo);
			itens = gdao.listar();
			JSFUtil.adicionarMensagemSucesso("Grupo excluído com sucesso!");
			
		} catch(SQLException e) {
			JSFUtil.adicionarMensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}

	public void editar() {
		try{
			GrupoDAO gdao = new GrupoDAO();
			gdao.editar(grupo);
			itens = gdao.listar();
			JSFUtil.adicionarMensagemSucesso("Grupo editado com sucesso!");
			
		} catch(SQLException e) {
			JSFUtil.adicionarMensagemErro("e.getMessage()");
			e.printStackTrace();
		}
	}
	
}
