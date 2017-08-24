package com.jm.patrimonio.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.patrimonio.dao.FornecedorDAO;
import com.jm.patrimonio.modelo.Fornecedor;
import com.jm.patrimonio.util.jpa.Transactional;

public class CadastraFornecedorService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private FornecedorDAO fornecedorDAO;
	
	@Transactional
	public void Salvar(Fornecedor fornecedor) throws NegocioException{
		if (fornecedor.getCodigo() == null) {
			fornecedor.setDataCadastro(Calendar.getInstance());	
		}
		
		this.fornecedorDAO.Salvar(fornecedor);
	}
	
}
