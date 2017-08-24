package com.jm.patrimonio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.dao.LocalDAO;
import com.jm.patrimonio.modelo.Local;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaLocalBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Local> locais = new ArrayList<>();
	private Local localSelecinado;
	
	@Inject
	private LocalDAO localDAO;
	
	public void excluir(){
		try {
			this.localDAO.Excluir(localSelecinado);
			this.locais.remove(localSelecinado);
			FacesUtil.addSuccessMessage("Excluido com sucesso !");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void iniciar(){
		this.locais = localDAO.buscarTodos();
	}


	public Local getLocalSelecinado() {
		return localSelecinado;
	}


	public void setLocalSelecinado(Local localSelecinado) {
		this.localSelecinado = localSelecinado;
	}


	public List<Local> getLocais() {
		return locais;
	}
}
