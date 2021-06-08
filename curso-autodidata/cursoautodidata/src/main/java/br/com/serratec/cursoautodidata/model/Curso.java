package br.com.serratec.cursoautodidata.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	Long id;
	String descricao;
	ArrayList<Modulo> listaDeModulos;
	ArrayList<Aluno> listaDeAlunos;
	
	
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
	public ArrayList<Modulo> getListaDeModulos() {
		return listaDeModulos;
	}
	public void setListaDeModulos(ArrayList<Modulo> listaDeModulos) {
		this.listaDeModulos = listaDeModulos;
	}
	public ArrayList<Aluno> getListaDeAlunos() {
		return listaDeAlunos;
	}
	public void setListaDeAlunos(ArrayList<Aluno> listaDeAlunos) {
		this.listaDeAlunos = listaDeAlunos;
	}
}
