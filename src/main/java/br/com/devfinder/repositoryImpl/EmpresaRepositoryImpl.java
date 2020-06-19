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

import br.com.devfinder.model.Empresa;
import br.com.devfinder.repository.EmpresaRepositoryCustom;

public class EmpresaRepositoryImpl implements EmpresaRepositoryCustom{
	 
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Empresa> findEmpresa(String[] texto) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Empresa> query = cb.createQuery(Empresa.class);
        Root<Empresa> user = query.from(Empresa.class);
 
        Path<String> razaoSocialPath = user.get("razaoSocial");
        
        List<Predicate> predicates = new ArrayList<>();
        for (int i = 0; i < texto.length; i++) {
            predicates.add(cb.like(razaoSocialPath, '%'+texto[i]+'%'));
        }
        query.select(user)
            .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
 
        return entityManager.createQuery(query)
            .getResultList();       

	}

}
