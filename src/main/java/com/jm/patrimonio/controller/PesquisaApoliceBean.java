package com.jm.patrimonio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.dao.ApoliceSeguroDAO;
import com.jm.patrimonio.modelo.ApoliceSeguro;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaApoliceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<ApoliceSeguro> apoliceSeguros = new ArrayList<>();
	private ApoliceSeguro apoliceSeguroSelecionada;
	
	@Inject
	private ApoliceSeguroDAO apoliceSeguroDAO;
	
    public void excluir(){
    	try {
			this.apoliceSeguroDAO.Excluir(apoliceSeguroSelecionada);
			this.apoliceSeguros.remove(apoliceSeguroSelecionada);
			FacesUtil.addSuccessMessage("Excluido com sucesso !");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
    }
	
	@PostConstruct
	public void inicar(){
	this.apoliceSeguros = apoliceSeguroDAO.buscarTodos();
	}

	public ApoliceSeguro getApoliceSeguroSelecionada() {
		return apoliceSeguroSelecionada;
	}

	public void setApoliceSeguroSelecionada(ApoliceSeguro apoliceSeguroSelecionada) {
		this.apoliceSeguroSelecionada = apoliceSeguroSelecionada;
	}

	public List<ApoliceSeguro> getApoliceSeguros() {
		return apoliceSeguros;
	}
}
