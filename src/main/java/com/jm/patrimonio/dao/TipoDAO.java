package com.jm.patrimonio.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jm.patrimonio.modelo.Tipo;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jpa.Transactional;

public class TipoDAO implements Serializable { 
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	
	public void Salvar(Tipo tipo){    
		em.merge(tipo);	
	}

	@SuppressWarnings("unchecked")
	public List<Tipo> buscarTodos() {
		return em.createQuery("from Tipo").getResultList();
	}

	public Tipo buscarPeloCodigo(Long codigo) {
		return em.find(Tipo.class, codigo);
	}
    @Transactional
	public void Excluir(Tipo tipo)  throws NegocioException{
    	Tipo tipoExcluir = em.find(Tipo.class, tipo.getCodigo());
		try {	
			em.remove(tipoExcluir);
			em.flush();
		} catch (Exception e) {
			throw new NegocioException("Não pode ser excluido");
		}	
	}

}
