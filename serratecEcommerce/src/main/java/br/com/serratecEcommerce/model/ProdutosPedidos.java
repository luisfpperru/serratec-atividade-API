package br.com.serratecEcommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtosPedidos")
public class ProdutosPedidos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column( nullable = false)
	private Long produtoId;
	
	@Column( nullable = false)
	private Long pedidosId;
	
	@Column( nullable = false)
	private Integer quantidade;
	
	@Column( nullable = false)
	private Double preco;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProdutoId() {
		return produtoId;
	}
	
	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}
	
	public Long getPedidosId() {
		return pedidosId;
	}
	
	public void setPedidosId(Long pedidosId) {
		this.pedidosId = pedidosId;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
