package br.com.financeiro.main;

import br.com.financeiro.util.HibernateUtil;

public class GerarTabela {
	
	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}