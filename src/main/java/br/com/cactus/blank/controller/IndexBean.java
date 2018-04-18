package br.com.cactus.blank.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.cactus.common.infra.MessagesHelper;

@Model
public class IndexBean {
	
	@Inject
	private MessagesHelper helper;
	private String nome;
	private String email;
	private String telefone;
	
	private String NEW_PAGE = "/index.xhtml?faces-redirect=true";
	
	@PostConstruct
	public void setup(){
		
	}
	
	public String novo(){
		setup();
		return NEW_PAGE;
	}
	
	public String getText(){
		return "You are on index page";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void salvar(){
		System.out.println(nome);
		System.out.println(email);
		System.out.println(telefone);
	}
}
