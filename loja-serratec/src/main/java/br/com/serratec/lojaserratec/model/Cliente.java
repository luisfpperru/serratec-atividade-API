package br.com.serratec.lojaserratec.model;

public class Cliente {
	     private Long id;
	     private String nome;
	     private Integer idade;
	     private String sexo;
	     private String estadoCivil;
	     private String profissao;
	     private String cpfOuCnpj;
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
		public Integer getIdade() {
			return idade;
		}
		public void setIdade(Integer idade) {
			this.idade = idade;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		public String getEstadoCivil() {
			return estadoCivil;
		}
		public void setEstadoCivil(String estadoCivil) {
			this.estadoCivil = estadoCivil;
		}
		public String getProfissao() {
			return profissao;
		}
		public void setProfissao(String profissao) {
			this.profissao = profissao;
		}
		public String getCpfOuCnpj() {
			return cpfOuCnpj;
		}
		public void setCpfOuCnpj(String cpfOuCnpj) {
			this.cpfOuCnpj = cpfOuCnpj;
		}
	     
	}

