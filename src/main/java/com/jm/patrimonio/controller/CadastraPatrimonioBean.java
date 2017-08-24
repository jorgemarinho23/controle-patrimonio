package com.jm.patrimonio.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List; 

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.dao.ApoliceSeguroDAO;
import com.jm.patrimonio.dao.FornecedorDAO;
import com.jm.patrimonio.dao.LocalDAO;
import com.jm.patrimonio.dao.TipoDAO;
import com.jm.patrimonio.modelo.ApoliceSeguro;
import com.jm.patrimonio.modelo.Fornecedor;
import com.jm.patrimonio.modelo.Patrimonio;
import com.jm.patrimonio.modelo.Local;
import com.jm.patrimonio.modelo.Status;
import com.jm.patrimonio.modelo.Tipo;
import com.jm.patrimonio.service.CadastraPatrimonioService;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraPatrimonioBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
    private Patrimonio patrimonio;
	private List<Status> status;
	private List<Local> locais;   
	private List<Tipo> tipos;
	private List<Fornecedor> fornecedores;
	private List<ApoliceSeguro> apolices;
	
	@Inject
	private CadastraPatrimonioService cadastraPatrimonioService;
	@Inject
	private LocalDAO localDAO;
	@Inject
	private TipoDAO tipoDAO;
	@Inject
	private FornecedorDAO fornecedorDAO;
	@Inject
	private ApoliceSeguroDAO apoliceSeguroDAO;
	public void salvar(){
		try {
			
			this.cadastraPatrimonioService.Salvar(patrimonio);
			FacesUtil.addSuccessMessage("Salvo com sucesso !");
			this.limpar();
			
		} catch (NegocioException e) {
			
			FacesUtil.addErrorMessage(e.getMessage());
			
		}
	}
	
	
	@PostConstruct
	public void iniciar(){
		this.limpar();	
		this.status =  Arrays.asList(Status.values());
		this.locais = localDAO.buscarTodos();
		this.tipos= tipoDAO.buscarTodos();
		this.fornecedores = fornecedorDAO.buscarTodos();
		this.apolices = apoliceSeguroDAO.buscarTodos();
	}
	
	public void limpar(){
		this.patrimonio = new Patrimonio();
	}

	public Patrimonio getEquipamento() {
		return patrimonio;
	}
    


	public Patrimonio getPatrimonio() {
		return patrimonio;
	}


	public void setPatrimonio(Patrimonio patrimonio) {
		this.patrimonio = patrimonio;
	}


	public List<Local> getLocais() {
		return locais;
	}


	public List<Tipo> getTipos() {
		return tipos;
	}


	public List<Status> getStatus() {
		return status;
	}


	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}


	public List<ApoliceSeguro> getApolices() {
		return apolices;
	}
	
	

}
