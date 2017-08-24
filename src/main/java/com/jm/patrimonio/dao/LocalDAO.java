package com.jm.patrimonio.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jm.patrimonio.modelo.Local;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jpa.Transactional;

public class LocalDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public void Salvar(Local local){
		em.merge(local);
	}

	@SuppressWarnings("unchecked")
	public List<Local> buscarTodos() {
		return em.createQuery("from Local").getResultList();
	}

	public Local buscarPeloCodigo(Long codigo) {
		
		return em.find(Local.class, codigo);
	}

	@Transactional
	public void Excluir(Local local) throws NegocioException {
		Local LocalExcluir = em.find(Local.class, local.getCodigo());
		
		try {
			em.remove(LocalExcluir);
			em.flush();
		} catch (PersistenceException e) {
			
			throw new NegocioException("Local não pode ser excluido");
		}

	}
	
}
