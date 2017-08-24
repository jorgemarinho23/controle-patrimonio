package com.jm.patrimonio.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.patrimonio.dao.LocalDAO;
import com.jm.patrimonio.modelo.Local;
import com.jm.patrimonio.util.jpa.Transactional;

public class CadastroLocalService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LocalDAO localDAO;
	@Transactional
	public void Salvar(Local local) throws NegocioException{
		
		if (local.getCodigo() == null) {
			local.setDataCadastro(Calendar.getInstance());	
		}
		
		
		this.localDAO.Salvar(local);	
	}
}
