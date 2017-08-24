package com.jm.patrimonio.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.jm.patrimonio.modelo.Fornecedor;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jpa.Transactional;

public class FornecedorDAO implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Inject
	private EntityManager em;
    
    
	public void Salvar(Fornecedor fornecedor){	
		em.merge(fornecedor);	
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> buscarTodos() {
		return em.createQuery("from Fornecedor").getResultList();
	}
    @Transactional
	public void Excluir(Fornecedor fornecedor) throws NegocioException {
		Fornecedor fornecExcluir = em.find(Fornecedor.class, fornecedor.getCodigo());
		try {
			em.remove(fornecExcluir);
			em.flush();
		} catch (PersistenceException e) {
		throw	new NegocioException("Existem equipamentos para esse fornecedor !");
		}

	}

	public Fornecedor buscarPeloCodigo(Long codigo) {
		return em.find(Fornecedor.class, codigo);
	}
}