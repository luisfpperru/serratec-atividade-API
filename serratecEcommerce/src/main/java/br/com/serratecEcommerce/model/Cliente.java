package br.com.serratec.lojaeletronicos.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import com.sun.istack.NotNull;

@Repository
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String email;
	
	@NotNull
	private String username;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String cpfOuCnpj;
	
	private String telefone;
	
	private Date dataDeNascimento;
	
	private Long enderecoId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public Long getEnderecoId() {
		return enderecoId;
	}
	
	public void setEnderecoId(Long enderecoId) {
		this.enderecoId = enderecoId;
	}	
	
}
