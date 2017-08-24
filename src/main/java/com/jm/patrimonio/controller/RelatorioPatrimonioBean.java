package com.jm.patrimonio.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.dao.PatrimonioDAO;
import com.jm.patrimonio.modelo.Patrimonio;
import com.jm.patrimonio.modelo.Status;

@Named
@ViewScoped
public class RelatorioPatrimonioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Status> status;
	private Status statusSelecionado;
	private List<Patrimonio> Patrimonios;
	
	@Inject
	private PatrimonioDAO patrimonioDAO;
	
	
	public void patrimonioPorStatus(){
	
	this.Patrimonios = this.patrimonioDAO.buscarEquipamentosPorStatus(statusSelecionado);
		
	}
	
	
	@PostConstruct
	public void iniciar(){
		this.status = Arrays.asList(Status.values());
	}
	public Status getStatusSelecionado() {
		return statusSelecionado;
	}
	public void setStatusSelecionado(Status statusSelecionado) {
		this.statusSelecionado = statusSelecionado;
	}
	public List<Status> getStatus() {
		return status;
	}


	public List<Patrimonio> getPatrimonios() {
		return Patrimonios;
	}

	
}
