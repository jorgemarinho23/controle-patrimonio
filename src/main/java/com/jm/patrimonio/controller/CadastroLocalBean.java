package com.jm.patrimonio.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.modelo.Local;
import com.jm.patrimonio.service.CadastroLocalService;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroLocalBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Local local;
	
	@Inject
	private CadastroLocalService cadastroLocalService;
	
	public void salvar(){
		try {
			this.cadastroLocalService.Salvar(local);
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
		this.local = new Local();
	}
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
}
