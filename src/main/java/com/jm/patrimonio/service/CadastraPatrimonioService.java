package com.jm.patrimonio.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.patrimonio.dao.PatrimonioDAO;
import com.jm.patrimonio.modelo.Patrimonio;
import com.jm.patrimonio.util.jpa.Transactional;

public class CadastraPatrimonioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PatrimonioDAO patrimonioDAO;
	@Transactional
	public void Salvar(Patrimonio patrimonio) throws NegocioException{
		
		if (patrimonio.getCodigo() == null) {
			
			patrimonio.setDataCadastro(Calendar.getInstance());
			
		}
		this.patrimonioDAO.Salvar(patrimonio);
	}
}
