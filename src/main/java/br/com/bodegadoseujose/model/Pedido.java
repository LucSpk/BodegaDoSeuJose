package br.com.bodegadoseujose.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;

	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Ingresso> ingressos;
	
	
	public Pedido() {}
	

	public Pedido(String nome) {
		this.nome = nome;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Ingresso> getIngressos() {
		return ingressos;
	}


	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
