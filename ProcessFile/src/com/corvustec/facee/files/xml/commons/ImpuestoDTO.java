/**
 * 
 */
package com.corvustec.facee.files.xml.commons;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author wilmerPC
 *
 */
@XmlRootElement(name="factura")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder = {"codigo", "codigoPorcentaje", "tarifa", "baseImponible", "valor"})
public class ImpuestoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	private Integer codigo;
	
	@XmlElement(required = true)
	private Integer codigoPorcentaje;
	
	private Double tarifa;
	
	@XmlElement(required = true)
	private BigDecimal baseImponible;
	
	@XmlElement(required = true)
	private BigDecimal valor;
	
	public ImpuestoDTO () {}
	
	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the codigoPorcentaje
	 */
	public Integer getCodigoPorcentaje() {
		return codigoPorcentaje;
	}

	/**
	 * @param codigoPorcentaje the codigoPorcentaje to set
	 */
	public void setCodigoPorcentaje(Integer codigoPorcentaje) {
		this.codigoPorcentaje = codigoPorcentaje;
	}

	/**
	 * @return the tarifa
	 */
	public Double getTarifa() {
		return tarifa;
	}

	/**
	 * @param tarifa the tarifa to set
	 */
	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	/**
	 * @return the baseImponible
	 */
	public BigDecimal getBaseImponible() {
		return baseImponible;
	}

	/**
	 * @param baseImponible the baseImponible to set
	 */
	public void setBaseImponible(BigDecimal baseImponible) {
		this.baseImponible = baseImponible;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImpuestoDTO [codigo=" + codigo + ", codigoPorcentaje="
				+ codigoPorcentaje + ", tarifa=" + tarifa + ", baseImponible="
				+ baseImponible + ", valor=" + valor + "]";
	}
	
}
