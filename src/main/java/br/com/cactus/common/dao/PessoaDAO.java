package br.com.cactus.common.dao;

import java.util.List;

import br.com.cactus.blank.model.Pessoa;

public class PessoaDAO extends GenericDAO<Pessoa, Long> {

	public PessoaDAO() {
		super(Pessoa.class);
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Pessoa> listar(){
		
		return super.listar("Select p from Pessoa p");
	}

	
}
