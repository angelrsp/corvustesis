package com.corvustec.tiempofila.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tfi_asesor database table.
 * 
 */
@Entity
@Table(name="tfi_asesor")
@NamedQuery(name="AsesorDTO.findAll", query="SELECT a FROM AsesorDTO a")
public class AsesorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TFI_ASESOR_ASECODIGO_GENERATOR", sequenceName="TFI_ASESOR_ASE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TFI_ASESOR_ASECODIGO_GENERATOR")
	@Column(name="ase_codigo")
	private Integer aseCodigo;

	@Column(name="ase_apellidos")
	private String aseApellidos;

	@Column(name="ase_cargo")
	private Integer aseCargo;

	@Column(name="ase_codigo_referente")
	private String aseCodigoReferente;

	@Column(name="ase_identificacion")
	private String aseIdentificacion;

	@Column(name="ase_mail")
	private String aseMail;

	@Column(name="ase_movil")
	private String aseMovil;

	@Column(name="ase_nombre")
	private String aseNombre;

	//bi-directional many-to-one association to AgenciaDTO
	@ManyToOne
	@JoinColumn(name="ase_agencia")
	private AgenciaDTO tfiAgencia;

	//bi-directional many-to-one association to TiempoDTO
	@OneToMany(mappedBy="tfiAsesor")
	private List<TiempoDTO> tfiTiempos;

	public AsesorDTO() {
	}

	public Integer getAseCodigo() {
		return this.aseCodigo;
	}

	public void setAseCodigo(Integer aseCodigo) {
		this.aseCodigo = aseCodigo;
	}

	public String getAseApellidos() {
		return this.aseApellidos;
	}

	public void setAseApellidos(String aseApellidos) {
		this.aseApellidos = aseApellidos;
	}

	public Integer getAseCargo() {
		return this.aseCargo;
	}

	public void setAseCargo(Integer aseCargo) {
		this.aseCargo = aseCargo;
	}

	public String getAseCodigoReferente() {
		return this.aseCodigoReferente;
	}

	public void setAseCodigoReferente(String aseCodigoReferente) {
		this.aseCodigoReferente = aseCodigoReferente;
	}

	public String getAseIdentificacion() {
		return this.aseIdentificacion;
	}

	public void setAseIdentificacion(String aseIdentificacion) {
		this.aseIdentificacion = aseIdentificacion;
	}

	public String getAseMail() {
		return this.aseMail;
	}

	public void setAseMail(String aseMail) {
		this.aseMail = aseMail;
	}

	public String getAseMovil() {
		return this.aseMovil;
	}

	public void setAseMovil(String aseMovil) {
		this.aseMovil = aseMovil;
	}

	public String getAseNombre() {
		return this.aseNombre;
	}

	public void setAseNombre(String aseNombre) {
		this.aseNombre = aseNombre;
	}

	public AgenciaDTO getTfiAgencia() {
		return this.tfiAgencia;
	}

	public void setTfiAgencia(AgenciaDTO tfiAgencia) {
		this.tfiAgencia = tfiAgencia;
	}

	public List<TiempoDTO> getTfiTiempos() {
		return this.tfiTiempos;
	}

	public void setTfiTiempos(List<TiempoDTO> tfiTiempos) {
		this.tfiTiempos = tfiTiempos;
	}

	public TiempoDTO addTfiTiempo(TiempoDTO tfiTiempo) {
		getTfiTiempos().add(tfiTiempo);
		tfiTiempo.setTfiAsesor(this);

		return tfiTiempo;
	}

	public TiempoDTO removeTfiTiempo(TiempoDTO tfiTiempo) {
		getTfiTiempos().remove(tfiTiempo);
		tfiTiempo.setTfiAsesor(null);

		return tfiTiempo;
	}

}