package com.jm.patrimonio.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jm.patrimonio.modelo.ApoliceSeguro;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jpa.Transactional;

public class ApoliceSeguroDAO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;

	public void Salvar(ApoliceSeguro apoliceSeguro){
		em.merge(apoliceSeguro);
	}

	@SuppressWarnings("unchecked")
	public List<ApoliceSeguro> buscarTodos() {
		return em.createQuery("from ApoliceSeguro").getResultList();
	}

	public ApoliceSeguro buscarPeloCodigo(Long codigo) {
		
		return em.find(ApoliceSeguro.class, codigo);
	}
	
    @Transactional
	public void Excluir(ApoliceSeguro apolice) throws NegocioException {
    	ApoliceSeguro apoliceExcluir = em.find(ApoliceSeguro.class, apolice.getCodigo());
		try {
			em.remove(apoliceExcluir);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Existem patrimonios ultilizando essa apolice !");
		}	
	}

}
