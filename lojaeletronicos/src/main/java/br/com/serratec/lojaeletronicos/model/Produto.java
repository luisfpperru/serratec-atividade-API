package br.com.serratec.lojaeletronicos.model;

import java.util.Date;

public class Produto {

	private Long id;
	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidadeEmEstoque;
	private Date dataDeCadastroDoProduto;
	private String imagem;
	private Long categoriaId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Integer getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}
	
	public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}
	
	public Date getDataDeCadastroDoProduto() {
		return dataDeCadastroDoProduto;
	}
	
	public void setDataDeCadastroDoProduto(Date dataDeCadastroDoProduto) {
		this.dataDeCadastroDoProduto = dataDeCadastroDoProduto;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public Long getCategoriaId() {
		return categoriaId;
	}
	
	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}
	
}
