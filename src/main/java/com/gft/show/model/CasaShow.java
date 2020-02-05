package com.gft.show.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CasaShow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	
	
	private String descricao;
	
	
	private BigDecimal valor;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataShow;
	
	
	private StatusEvento status;
	
	
	public String getDescricao() {
		return descricao;
		
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getDataShow() {
		return dataShow;
	}
	public void setDataShow(Date dataShow) {
		this.dataShow = dataShow;
	}
	public StatusEvento getStatus() {
		return status;
	}
	public void setStatus(StatusEvento status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		result = prime * result + ((dataShow == null) ? 0 : dataShow.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		CasaShow other = (CasaShow) obj;
		if (codigo != other.codigo)
			return false;
		if (dataShow == null) {
			if (other.dataShow != null)
				return false;
		} else if (!dataShow.equals(other.dataShow))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (status != other.status)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	
}


