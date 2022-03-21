package br.com.fiap.AtvCap6.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.fiap.AtvCap6.domain.Cliente;

public class BancoTesteBusca {

	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("AtvCap6");
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		 CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
	        Root<Cliente> root = criteriaQuery.from(Cliente.class);

	        criteriaQuery.multiselect(root.get("freq"), 
	        						  root.get("cel"),
	        						  root.get("nome"),
	        						  root.get("dataVisita"),
	        						  root.get("valor"));
	        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("dataVisita")));
	        criteriaQuery.where(criteriaBuilder.equal(root.get("cel"), 988321521));
	        TypedQuery<Object[]> typedQuery = em.createQuery(criteriaQuery);
	        List<Object[]> lista = typedQuery.getResultList();
			lista.forEach(arr -> System.out.println(String.format("Frquência ao mês: "+ arr[0] +
	        												      " Contato: "+ arr[1] +
	        												      "\nNome: "+ arr[2] +
	        												      " Data: "+ arr[3] +	
	        												      " Ticket Médio: \n" )));
			
			
        em.close();
        factory.close();
    }	
	
}     