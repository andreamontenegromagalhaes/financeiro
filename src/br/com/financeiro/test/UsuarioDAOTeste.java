package br.com.financeiro.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.financeiro.DAO.UsuarioDAO;
import br.com.financeiro.domain.Usuario;

public class UsuarioDAOTeste {
	
	@Test
	@Ignore
	public void salvar(){
		Usuario u1 = new Usuario();
		
		u1.setNome("Teste Salvar Hibernate");
		u1.setLogin("hibernate");
		u1.setSenha("12345");
		u1.setAtivo(1);
				
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.salvar(u1);
		
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuario = dao.listar();
		
		for(Usuario u : usuario){
			System.out.println(u);
		}		
	}
	
	@Test
	@Ignore
	public void buscarPorId(){
	UsuarioDAO dao = new UsuarioDAO();
	Usuario u = dao.buscarPorId(7);
	
	
		System.out.println(u);
			
	}
	
	
	@Test
	@Ignore
		public void buscarPorNome(){
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuario = dao.buscarPorNome("Montenegro");
				
		for(Usuario u : usuario){
			System.out.println(u);
		}		
	}
	
	@Test
	@Ignore
	public void excluir(){
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario usuario = dao.buscarPorId(7);
		
		
		dao.excluir(usuario);
	}
	
	@Test
	public void editar(){
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscarPorId(14);

		usuario.setNome("Teste2 Update");
		usuario.setLogin("Teste2");
		usuario.setEmail("Teste2@gmail.com");
		usuario.setSenha("12345");
				
		dao.editar(usuario);
		
			
	}	
	
}
