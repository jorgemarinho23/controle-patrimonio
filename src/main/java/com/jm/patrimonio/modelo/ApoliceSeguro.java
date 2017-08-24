package com.jm.patrimonio.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="apolice_seguro")
public class ApoliceSeguro {
	
	private Long codigo;
	@NotBlank(message= "descrição obrigatória")
	private String descricao;
	@NotNull(message="valor obrigatório")
	private BigDecimal valorFranquia;
	private boolean protecaoCausasNaturais;
	private boolean protecaoTerceiro;
	private boolean protecaoRoubo;
	private Calendar dataCalendar;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValorFranquia() {
		return valorFranquia;
	}
	public void setValorFranquia(BigDecimal valorFranquia) {
		this.valorFranquia = valorFranquia;
	}
	public boolean isProtecaoCausasNaturais() {
		return protecaoCausasNaturais;
	}
	public void setProtecaoCausasNaturais(boolean protecaoCausasNaturais) {
		this.protecaoCausasNaturais = protecaoCausasNaturais;
	}
	public boolean isProtecaoTerceiro() {
		return protecaoTerceiro;
	}
	public void setProtecaoTerceiro(boolean protecaoTerceiro) {
		this.protecaoTerceiro = protecaoTerceiro;
	}
	public boolean isProtecaoRoubo() {
		return protecaoRoubo;
	}
	public void setProtecaoRoubo(boolean protecaoRoubo) {
		this.protecaoRoubo = protecaoRoubo;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="data_cadastro")
	public Calendar getDataCalendar() { 
		return dataCalendar;
	}
	public void setDataCalendar(Calendar dataCalendar) {
		this.dataCalendar = dataCalendar;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApoliceSeguro other = (ApoliceSeguro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
