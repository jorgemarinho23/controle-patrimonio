package com.jm.patrimonio.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.jm.patrimonio.modelo.Local;
import com.jm.patrimonio.modelo.Patrimonio;
import com.jm.patrimonio.modelo.Status;
import com.jm.patrimonio.service.NegocioException;
import com.jm.patrimonio.util.jpa.Transactional;

public class PatrimonioDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject EntityManager em;
	
	public void Salvar(Patrimonio patrimonio){
		em.merge(patrimonio);	
	}

	@SuppressWarnings("unchecked")
	public List<Patrimonio> buscarTodos() {  
		
		return em.createQuery("from Patrimonio").getResultList();
	}
    @Transactional
	public void Excluir(Patrimonio patrimonio) throws NegocioException {
		
		Patrimonio equipExcluir = em.find(Patrimonio.class, patrimonio.getCodigo());
		
		em.remove(equipExcluir); 
		
	}

	public Patrimonio buscarPeloCodigo(Long codigo) {
		
		return em.find(Patrimonio.class, codigo); 
	}

	public List<Patrimonio> buscarEquipamentosPorStatus(Status status) {
		
		String jpql = "from Patrimonio where status = '"+status+"'";
		
		List<Patrimonio> patrimonios = em.createQuery(jpql, Patrimonio.class).getResultList();
               
         return patrimonios;
				              
	}

	public List<Patrimonio> buscarPorLocal(Local local) { 
	
		String jpql = "from Patrimonio where local = :local";
		
		List<Patrimonio> patrimonios = em.createQuery(jpql,Patrimonio.class)
				.setParameter("local", local)
				.getResultList();

		return patrimonios;
	}
}
