package br.com.serratec.api.exception;

import java.util.Date;

public class ErrorMessage {
	
	private Date dataAtual;
	private String mensagem;
	
	public ErrorMessage(Date dataAtual, String mensagem) {
		this.setDataAtual(dataAtual);
		this.setMensagem(mensagem);
	}

	public ErrorMessage() {
		
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
