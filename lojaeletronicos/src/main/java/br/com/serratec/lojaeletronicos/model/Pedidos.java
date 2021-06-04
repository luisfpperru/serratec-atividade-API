package br.com.serratec.lojaeletronicos.model;

import java.util.Date;

public class Pedidos {

	private Long id;
	private Integer numeroDoPedido;
	private Double valorTotalDoPedido;
	private Date dataDoPedido;
	private String status;
	private Long clienteId;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getNumeroDoPedido() {
		return numeroDoPedido;
	}
	
	public void setNumeroDoPedido(Integer numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}
	
	public Double getValorTotalDoPedido() {
		return valorTotalDoPedido;
	}
	
	public void setValorTotalDoPedido(Double valorTotalDoPedido) {
		this.valorTotalDoPedido = valorTotalDoPedido;
	}
	
	public Date getDataDoPedido() {
		return dataDoPedido;
	}
	
	public void setDataDoPedido(Date dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getClienteId() {
		return clienteId;
	}
	
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	
}
