package br.com.financeiro.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Cliente {
	
	@Id
    @GeneratedValue
	private int idcliente;
	private String tipo;
	private String cpfcnpj;
	private int ativo;
	private String nome;
	private String razaosocial;
	private String email;
	private String contato;
	private String telefone1;
	private String telefone2;
	private int logradouro_num_cep;
	private String logradouro;
	private String numero;
	private String complemento;
	

}
