package br.com.financeiro.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.financeiro.DAO.GrupoDAO;
import br.com.financeiro.domain.Grupo;

public class GrupoDAOTeste {

	@Test
	@Ignore
	public void salvar(){
		Grupo g1 = new Grupo();
		
		g1.setGrupo("Teste Salvar Hibernate");
				
		GrupoDAO dao = new GrupoDAO();
		
		dao.salvar(g1);
		
	}

	@Test
	@Ignore
	public void listar() {
		GrupoDAO dao = new GrupoDAO();
		List<Grupo> grupo = dao.listar();
		
		for(Grupo u : grupo){
			System.out.println(u);
		}		
	}
	
	@Test
	@Ignore
	public void buscarPorId(){
	GrupoDAO dao = new GrupoDAO();
	Grupo u = dao.buscarPorId(7);
	
	
		System.out.println(u);
			
	}
	
	
	@Test
	@Ignore
		public void buscarPorNome(){
		GrupoDAO dao = new GrupoDAO();
		List<Grupo> grupo = dao.buscarPorNome("Montenegro");
				
		for(Grupo u : grupo){
			System.out.println(u);
		}		
	}
	
	@Test
	@Ignore
	public void excluir(){
		GrupoDAO dao = new GrupoDAO();
		
		Grupo grupo = dao.buscarPorId(7);
		
		
		dao.excluir(grupo);
	}
	
	@Test
	public void editar(){
		
		GrupoDAO dao = new GrupoDAO();
		Grupo grupo = dao.buscarPorId(14);

		grupo.setGrupo("Teste Update");
				
		dao.editar(grupo);
		
			
	}	
	
}
