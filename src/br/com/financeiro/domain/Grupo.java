package br.com.financeiro.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "Grupo.listar", query = "SELECT grupo FROM Grupo grupo" ),
@NamedQuery(name = "Grupo.buscarPorId", query = "SELECT grupo FROM Grupo grupo WHERE grupo.idgrupo = :idgrupo" ),
@NamedQuery(name = "Grupo.buscarPorNome", query = "SELECT grupo FROM Grupo grupo WHERE grupo.grupo like :grupo" )
})

public class Grupo {

	@Id
    @GeneratedValue
	private int idgrupo;
	private String grupo;
	
	public int getIdgrupo() {
		return idgrupo;
	}
	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
	@Override
	public String toString() {
		String saida = idgrupo + " - " +grupo; 
		return saida;
	}

	
}
