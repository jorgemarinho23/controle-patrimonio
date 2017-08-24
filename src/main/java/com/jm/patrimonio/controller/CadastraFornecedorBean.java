package com.jm.patrimonio.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.modelo.Estado;
import com.jm.patrimonio.modelo.Fornecedor;
import com.jm.patrimonio.modelo.TipoPessoa;
import com.jm.patrimonio.service.CadastraFornecedorService;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastraFornecedorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;
	private List<Estado> estados;
	private List<TipoPessoa> tipoPessoas;
	@Inject
	private CadastraFornecedorService cadastraFornecedorService;
	
	public void salvar(){
		try {
			this.cadastraFornecedorService.Salvar(fornecedor);
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
		this.fornecedor = new Fornecedor();
		this.estados = Arrays.asList(Estado.values());
		this.tipoPessoas = Arrays.asList(TipoPessoa.values());
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public List<TipoPessoa> getTipoPessoas() {
		return tipoPessoas;
	}
	
}
