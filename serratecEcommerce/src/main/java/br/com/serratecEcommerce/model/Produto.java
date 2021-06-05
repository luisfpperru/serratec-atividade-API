package br.com.serratecEcommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column( nullable = false)
	private String nome;
	
	@Column( nullable = false)
	private String descricao;
	
	@Column( nullable = false)
	private Double preco;
	
	@Column( nullable = false)
	private Integer quantidadeEmEstoque;
	
	@Column( nullable = false)
	private Date dataDeCadastroDoProduto;
	
	@Column( nullable = false)
	private String imagem;
	
	@Column( nullable = false)
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
