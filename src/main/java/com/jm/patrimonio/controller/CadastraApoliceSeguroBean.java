package com.jm.patrimonio.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.modelo.ApoliceSeguro;
import com.jm.patrimonio.service.CadastraApoliceSeguroService;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraApoliceSeguroBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ApoliceSeguro apoliceSeguro;
	
	@Inject
	private CadastraApoliceSeguroService cadastraApoliceSeguroService;

	
	public void salvar(){
		this.cadastraApoliceSeguroService.Salvar(apoliceSeguro);
		FacesUtil.addSuccessMessage("Salvo com sucesso !");
		this.limpar();
	}
	
	@PostConstruct
	public void iniciar(){
		this.limpar();
	}
	public void limpar(){
		this.apoliceSeguro = new ApoliceSeguro();
	}
	public ApoliceSeguro getApoliceSeguro() {
		return apoliceSeguro;
	}

	public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
		this.apoliceSeguro = apoliceSeguro;
	}
}
