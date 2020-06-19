package br.com.devfinder.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.repository.DesenvolvedorRepositoryCustom;

public class DesenvolvedorRepositoryImpl implements DesenvolvedorRepositoryCustom{
	 
    @PersistenceContext
    private EntityManager entityManager;
 
   	@Override
	public List<Desenvolvedor> findDesenvolvedor(String[] texto) {
   		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Desenvolvedor> query = cb.createQuery(Desenvolvedor.class);
        Root<Desenvolvedor> user = query.from(Desenvolvedor.class);
 
        Path<String> nomePath = user.get("nome");
        
        List<Predicate> predicates = new ArrayList<>();
        for (int i = 0; i < texto.length; i++) {
            predicates.add(cb.like(nomePath, '%'+texto[i]+'%'));
        }
        query.select(user)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
 
        return entityManager.createQuery(query)
            .getResultList();       
	}
}
