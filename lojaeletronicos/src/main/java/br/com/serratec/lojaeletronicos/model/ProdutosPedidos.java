package br.com.serratec.lojaeletronicos.model;

public class ProdutosPedidos {
	
	private Long id;
	private Long produtoId;
	private Long pedidosId;
	private Integer quantidade;
	private Double preço;
	
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
	
	public Double getPreço() {
		return preço;
	}
	
	public void setPreço(Double preço) {
		this.preço = preço;
	}
	
}
