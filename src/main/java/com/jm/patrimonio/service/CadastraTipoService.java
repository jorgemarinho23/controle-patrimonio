package com.jm.patrimonio.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.patrimonio.dao.TipoDAO;
import com.jm.patrimonio.modelo.Tipo;
import com.jm.patrimonio.util.jpa.Transactional;

public class CadastraTipoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoDAO tipoDAO;
	@Transactional
	public void Salvar(Tipo tipo) throws NegocioException{
		if (tipo.getCodigo() == null) {
			tipo.setDataCadastro(Calendar.getInstance());	
		}
		
		this.tipoDAO.Salvar(tipo);
	}
}
