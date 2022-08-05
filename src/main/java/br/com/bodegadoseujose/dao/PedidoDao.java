package br.com.bodegadoseujose.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.bodegadoseujose.model.Pedido;

public class PedidoDao {
	
	
	private EntityManager em;
	
	public PedidoDao(EntityManager em) {
		this.em = em;
	}
	
	
	public void cadastrar(Pedido pedido) {
		em.persist(pedido);
	}
	
	
	public List<Pedido> findByPedido(){
		
		String jpql = "SELECT p FROM Pedido p";
		return em.createQuery(jpql, Pedido.class).getResultList();
		
		
	}
	
	public List<Object[]> buscarIngresso(){
		
		String jpql = "SELECT c,i FROM Categoria c LEFT JOIN c.ingresso i";
		return em.createQuery(jpql, Object[].class).getResultList();
	}
	

}
