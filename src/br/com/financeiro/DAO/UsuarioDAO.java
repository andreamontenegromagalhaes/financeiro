package br.com.financeiro.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.financeiro.domain.Usuario;
import br.com.financeiro.util.HibernateUtil;

public class UsuarioDAO {
	
	public void salvar(Usuario usuario){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.save(usuario);
			transacao.commit(); // confirmando a transa��o
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}
			throw ex;
		}
		finally {
			sessao.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Usuario> usuario = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			usuario = consulta.list();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return usuario;
	}

	public Usuario buscarPorId (int idusuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Usuario usuario = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Usuario.buscarPorId");
			consulta.setInteger("idusuario", idusuario);
			usuario = (Usuario) consulta.uniqueResult();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return usuario;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarPorNome(String nome) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Usuario> usuario = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Usuario.buscarPorNome");
			consulta.setString("nome", nome);
			usuario = consulta.list();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return usuario;
	}

	public void excluir(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			sessao.delete(usuario);
			transacao.commit(); // confirmando a transa��o

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}

		}

		finally {
			sessao.close();
		}
	}
	
	public void editar(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transa��o
			
			sessao.update(usuario);
			transacao.commit(); // confirmando a transa��o

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transa��o
			}

		}

		finally {
			sessao.close();
		}

	}	
}
