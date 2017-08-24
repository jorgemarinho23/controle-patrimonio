package com.jm.patrimonio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.dao.PatrimonioDAO;
import com.jm.patrimonio.modelo.Patrimonio;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaPatrimonioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Patrimonio> patrimonios = new ArrayList<>();
	private Patrimonio patrimonioSelecionado;
	
	@Inject
	private PatrimonioDAO patrimonioDAO;
	
	public void excluir(){
		try {
			this.patrimonioDAO.Excluir(patrimonioSelecionado);
			this.patrimonios.remove(patrimonioSelecionado);
			FacesUtil.addSuccessMessage("Excluido com sucesso !");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Erro ao excluir");
		}
	}
	
	
	@PostConstruct
	public void iniciar(){
		this.patrimonios = patrimonioDAO.buscarTodos();
	}


	public Patrimonio getPatrimonioSelecionado() {
		return patrimonioSelecionado;
	}


	public void setPatrimonioSelecionado(Patrimonio patrimonioSelecionado) {
		this.patrimonioSelecionado = patrimonioSelecionado;
	}


	public List<Patrimonio> getPatrimonios() {
		return patrimonios;
	}

}
