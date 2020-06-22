package br.com.devfinder.repositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.DesenvolvedorDesafio;
import br.com.devfinder.model.ids.DesenvolvedorDesafioId;
import br.com.devfinder.repository.DesafioRepositoryCustom;

public class DesafioRepositoryImpl implements DesafioRepositoryCustom{
	 
    @PersistenceContext
    private EntityManager entityManager;
 
   	@Override
	public List<Desafio> findDesafio(String[] texto) {
   		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Desafio> query = cb.createQuery(Desafio.class);
        Root<Desafio> user = query.from(Desafio.class);
 
        Path<String> descricaoPath = user.get("descricao");
        Path<String> nomePath = user.get("nome");
        
        List<Predicate> predicatesNome = new ArrayList<>();
        List<Predicate> predicatesDesc = new ArrayList<>();
        for (int i = 0; i < texto.length; i++) {
            predicatesDesc.add(cb.like(descricaoPath, '%'+texto[i]+'%'));
            predicatesNome.add(cb.like(nomePath, '%'+texto[i]+'%'));
        }
        query.select(user)
        .where(cb.or(cb.and(predicatesNome.toArray(new Predicate[predicatesNome.size()])), 
        		cb.or(predicatesDesc.toArray(new Predicate[predicatesDesc.size()]))));

        return entityManager.createQuery(query)
            .getResultList();       
	}

	
}