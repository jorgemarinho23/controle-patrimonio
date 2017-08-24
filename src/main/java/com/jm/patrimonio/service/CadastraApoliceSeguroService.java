package com.jm.patrimonio.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.jm.patrimonio.dao.ApoliceSeguroDAO;
import com.jm.patrimonio.modelo.ApoliceSeguro;
import com.jm.patrimonio.util.jpa.Transactional;

public class CadastraApoliceSeguroService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ApoliceSeguroDAO apoliceSeguroDAO;
	@Transactional
	public void Salvar(ApoliceSeguro apoliceSeguro){
		if (apoliceSeguro.getCodigo() == null) {
	      apoliceSeguro.setDataCalendar(Calendar.getInstance());
		}
		this.apoliceSeguroDAO.Salvar(apoliceSeguro);
	}

}
