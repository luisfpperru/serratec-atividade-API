package br.com.serratec.cursoautodidata.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="modulos")
public class Modulo {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	Long id;
	@Column(nullable = false)
	String descricao;
	
	@ManyToMany
    @JoinTable(
        name = "modulos_aulas",
        joinColumns = @JoinColumn(name = "modulo_id"),
        inverseJoinColumns = @JoinColumn(name = "aula_id")
    )
	ArrayList<Aula> listaDeAulas;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ArrayList<Aula> getListaDeAulas() {
		return listaDeAulas;
	}
	public void setListaDeAulas(ArrayList<Aula> listaDeAulas) {
		this.listaDeAulas = listaDeAulas;
	}
}
