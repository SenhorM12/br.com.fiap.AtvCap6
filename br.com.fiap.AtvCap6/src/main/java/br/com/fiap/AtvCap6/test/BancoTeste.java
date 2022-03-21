package br.com.fiap.AtvCap6.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.AtvCap6.domain.Cliente;

public class BancoTeste {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("AtvCap6");
		EntityManager em = factory.createEntityManager();
		
		Cliente cliente= new Cliente();
		cliente.setCel(988321521);
		cliente.setNome("Affonso Solano");
		cliente.setTipoCerveja("Pilsen");
		cliente.setValor(50);
		
		
		try {
			em.persist(cliente);
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		factory.close();
	}
	
}