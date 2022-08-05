package br.com.bodegadoseujose;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.bodegadoseujose.dao.PedidoDao;
import br.com.bodegadoseujose.model.Categoria;
import br.com.bodegadoseujose.model.Ingresso;
import br.com.bodegadoseujose.model.Pedido;
import br.com.bodegadoseujose.utils.JpaUtils;

public class Application {
	
	public static void main(String[] args) {
		
		EntityManager em = JpaUtils.getEntityManager();
		
		Categoria camarote = new Categoria("Camarote", 100, 150.0);
		Categoria pista = new Categoria("Pista", 300, 80.0);
		Categoria lounge = new Categoria("Lounge", 30, 300.0);
		
		
		
		Ingresso ingresso = new Ingresso("CapFest");
		
		ingresso.setCategorias(Arrays.asList(camarote,pista,lounge));
		
		camarote.setIngresso(ingresso);
		pista.setIngresso(ingresso);
		lounge.setIngresso(ingresso);
		
		
		

		Pedido pedido = new Pedido("Vitor");
		
		pedido.setIngressos(Arrays.asList(ingresso));
		
		
		ingresso.setPedido(pedido);
		
		
		
		PedidoDao dao = new PedidoDao(em);
		
		
		//em.getTransaction().begin();
		
		//dao.cadastrar(pedido);
		
		//em.getTransaction().commit();
		
		
		List<Pedido> lista = dao.findByPedido();

		
		lista.forEach(p -> System.out.println(p.getId() + ", " + p.getNome()));
		
		
	
		
		List<Object[]> listaCategoria = dao.buscarIngresso();
		
		listaCategoria.forEach(arr -> {
			
			String out = ((Categoria)  arr[0]).getNome() + ", " + ((Categoria)  arr[0]).getPreco() + ", " + ((Categoria)  arr[0]).getQuatidade();
			
			if(arr[1] == null) {
				out += ", Null";
			}else {
				
				out += " , " + ((Ingresso) arr[1]).getNome();
				
			}
			
			System.out.println(out);
			
		});
		
		
		em.close();
		JpaUtils.closeEntityManagerFactory();
		
	}

}
