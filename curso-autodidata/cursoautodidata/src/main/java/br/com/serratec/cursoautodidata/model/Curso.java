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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cursos")
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	Long id;
	@Column(nullable = false)
	String descricao;
	
	@ManyToMany
    @JoinTable(
        name = "cursos_modulos",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "modulo_id")
    )
	ArrayList<Modulo> listaDeModulos;
	

    @ManyToOne
    @JoinColumn(name = "aluno_id")
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
