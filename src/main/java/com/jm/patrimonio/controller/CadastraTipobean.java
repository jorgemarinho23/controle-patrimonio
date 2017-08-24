package com.jm.patrimonio.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.modelo.Tipo;
import com.jm.patrimonio.service.CadastraTipoService;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraTipobean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Tipo tipo;
	@Inject
	private CadastraTipoService cadastraTipoService;
	
	public void salvar(){
		try {
			this.cadastraTipoService.Salvar(tipo);
		    FacesUtil.addSuccessMessage("Salvo com sucesso !");
		    this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	@PostConstruct
	public void iniciar(){
		this.limpar();
	}
	
	public void limpar(){
		this.tipo = new Tipo();
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}
