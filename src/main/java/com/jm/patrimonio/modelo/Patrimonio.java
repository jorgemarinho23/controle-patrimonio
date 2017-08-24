package com.jm.patrimonio.modelo;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Patrimonio {
	
	private Long codigo;
	@NotBlank(message="nome obrigatório")
	private String nome;
	@NotNull(message="nota obrigatório")
	private Long notaFiscal;
	@NotNull(message="valor obrigatório")
	private BigDecimal valor;
	@NotNull(message="status obrigatório")
	private Status status;
	private Calendar dataCadastro;
	@NotNull(message="local obrigatório")
	private Local local;
	@NotNull(message="tipo obrigatório")
	private Tipo tipo;
	@NotNull(message="fornecedor obrigatório")
	private Fornecedor fornecedor;
	private ApoliceSeguro apoliceSeguro;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(Long notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro")
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@ManyToOne 
	@JoinColumn(name= "codigo_local")  
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	@ManyToOne
	@JoinColumn(name = "codigo_tipo")
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	@ManyToOne
	@JoinColumn(name ="codigo_fornecedor")
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	@ManyToOne
	@JoinColumn(name="codigo_apolice") 
	public ApoliceSeguro getApoliceSeguro() {
		return apoliceSeguro;
	}
	public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
		this.apoliceSeguro = apoliceSeguro;
	}
	
	

}
