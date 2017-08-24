package com.jm.patrimonio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.dao.FornecedorDAO;
import com.jm.patrimonio.modelo.Fornecedor;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFornecedorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Fornecedor> fornecedores = new ArrayList<>();
	private Fornecedor fornecedorSelecionado;
	
	@Inject
	private FornecedorDAO fornecedorDAO;
	
	public void excluir(){
		try {
			this.fornecedorDAO.Excluir(fornecedorSelecionado);
			this.fornecedores.remove(fornecedorSelecionado);
			FacesUtil.addSuccessMessage("Excluido com sucesso !");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}
	
	@PostConstruct
	public void iniciar(){
		this.fornecedores = fornecedorDAO.buscarTodos();
	}

	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
}
