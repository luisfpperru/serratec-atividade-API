package br.com.serratec.cursoautodidata.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modulos")
public class Modulo {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	Long id;
	String descricao;
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
