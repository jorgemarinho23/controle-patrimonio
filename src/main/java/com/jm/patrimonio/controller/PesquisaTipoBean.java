package com.jm.patrimonio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.jm.patrimonio.dao.TipoDAO;
import com.jm.patrimonio.modelo.Tipo;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaTipoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Tipo> tipos = new ArrayList<>();
	private Tipo tipoSelecionado;
	@Inject
	private TipoDAO tipoDAO;
	
	public void excluir(){
		try {
			this.tipoDAO.Excluir(tipoSelecionado);
			this.tipos.remove(tipoSelecionado);
			FacesUtil.addSuccessMessage("Excluido com sucesso !");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
	}
	
	@PostConstruct
	public void iniciar(){
		this.tipos =tipoDAO.buscarTodos();
	}
	
	public Tipo getTipoSelecionado() {
		return tipoSelecionado;
	}
	public void setTipoSelecionado(Tipo tipoSelecionado) {
		this.tipoSelecionado = tipoSelecionado;
	}
	public List<Tipo> getTipos() {
		return tipos;
	}
}
