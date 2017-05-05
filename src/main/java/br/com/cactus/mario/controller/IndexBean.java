package br.com.cactus.mario.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.cactus.mario.infra.MessagesHelper;

@Model
public class IndexBean {
	
	@Inject
	private MessagesHelper helper;
	
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
	
	
}
