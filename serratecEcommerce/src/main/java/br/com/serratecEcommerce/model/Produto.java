package br.com.serratecEcommerce.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	
	@Column( nullable = false)
	private String nome;
	
	@Column( nullable = false)
	private String descricao;
	
	@Column( nullable = false)
	private Double preco;
	
	@Column( nullable = false)
	private Integer quantidadeEmEstoque;
	
	private Date dataDeCadastroDoProduto;
	
	private String imagem;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Pedido> pedidos;
	
	@ManyToOne
	@JoinColumn(name = "categoriaId")
	private Categoria categoria;
	
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
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedido(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
