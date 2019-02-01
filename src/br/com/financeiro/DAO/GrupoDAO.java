package br.com.financeiro.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.financeiro.domain.Grupo;
import br.com.financeiro.util.HibernateUtil;

public class GrupoDAO {
	
	public void salvar(Grupo grupo){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			sessao.save(grupo);
			transacao.commit(); // confirmando a transação
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}
			throw ex;
		}
		finally {
			sessao.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Grupo> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Grupo> grupo = null;

		try {
			Query consulta = sessao.getNamedQuery("Grupo.listar");
			grupo = consulta.list();

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return grupo;
	}

	public Grupo buscarPorId (int idgrupo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Grupo grupo = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Grupo.buscarPorId");
			consulta.setInteger("idgrupo", idgrupo);
			grupo = (Grupo) consulta.uniqueResult();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return grupo;
	}

	@SuppressWarnings("unchecked")
	public List<Grupo> buscarPorNome(String nome) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Grupo> grupo = null;

		try {
			
			Query consulta = sessao.getNamedQuery("Grupo.buscarPorNome");
			consulta.setString("nome", nome);
			grupo = consulta.list();
			

		} catch (RuntimeException ex) {
			throw ex;
		}

		finally {
			sessao.close();
		}
		
		return grupo;
	}

	public void excluir(Grupo grupo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			sessao.delete(grupo);
			transacao.commit(); // confirmando a transação

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}

		}

		finally {
			sessao.close();
		}
	}
	
	public void editar(Grupo grupo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction(); // abrindo a transação
			
			sessao.update(grupo);
			transacao.commit(); // confirmando a transação

		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação
			}

		}

		finally {
			sessao.close();
		}

	}	
}
