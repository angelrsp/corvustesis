/**
 * 
 */
package com.corvustec.facee.files.xml.factura;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author wilmerPC
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder = {"codigo", "codigoPorcentaje", "tarifa", "valor"})
public class RetencionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement(required = true)
	private Integer codigo;
	
	@XmlElement(required = true)
	private Integer codigoPorcentaje;
	
	@XmlElement(required = true)
	private Double tarifa;
	
	@XmlElement(required = true)
	private Double valor;
	
	public RetencionDTO () {}

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
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetencionDTO [codigo=" + codigo + ", codigoPorcentaje="
				+ codigoPorcentaje + ", tarifa=" + tarifa + ", valor=" + valor
				+ "]";
	}
	
}
