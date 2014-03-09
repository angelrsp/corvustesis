package com.corvustec.tiempofila.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the tfi_tiempo database table.
 * 
 */
@Entity
@Table(name="tfi_tiempo")
@NamedQuery(name="TiempoDTO.findAll", query="SELECT t FROM TiempoDTO t")
public class TiempoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TFI_TIEMPO_TIECODIGO_GENERATOR", sequenceName="TFI_TIEMPO_TIE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TFI_TIEMPO_TIECODIGO_GENERATOR")
	@Column(name="tie_codigo")
	private Integer tieCodigo;

	@Column(name="tie_fin")
	private Timestamp tieFin;

	@Column(name="tie_inicio")
	private Timestamp tieInicio;

	//bi-directional many-to-one association to AsesorDTO
	@ManyToOne
	@JoinColumn(name="tie_asesor")
	private AsesorDTO tfiAsesor;

	//bi-directional many-to-one association to ClienteDTO
	@ManyToOne
	@JoinColumn(name="tie_cliente")
	private ClienteDTO tfiCliente;

	public TiempoDTO() {
	}

	public Integer getTieCodigo() {
		return this.tieCodigo;
	}

	public void setTieCodigo(Integer tieCodigo) {
		this.tieCodigo = tieCodigo;
	}

	public Timestamp getTieFin() {
		return this.tieFin;
	}

	public void setTieFin(Timestamp tieFin) {
		this.tieFin = tieFin;
	}

	public Timestamp getTieInicio() {
		return this.tieInicio;
	}

	public void setTieInicio(Timestamp tieInicio) {
		this.tieInicio = tieInicio;
	}

	public AsesorDTO getTfiAsesor() {
		return this.tfiAsesor;
	}

	public void setTfiAsesor(AsesorDTO tfiAsesor) {
		this.tfiAsesor = tfiAsesor;
	}

	public ClienteDTO getTfiCliente() {
		return this.tfiCliente;
	}

	public void setTfiCliente(ClienteDTO tfiCliente) {
		this.tfiCliente = tfiCliente;
	}

}