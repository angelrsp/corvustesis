package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the arg_opinion database table.
 * 
 */
@Entity
@Table(name="arg_opinion")
@NamedQuery(name="OpinionDTO.findAll", query="SELECT o FROM OpinionDTO o")
public class OpinionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARG_OPINION_OPICODIGO_GENERATOR", sequenceName="ARG_OPINION_OPI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARG_OPINION_OPICODIGO_GENERATOR")
	@Column(name="opi_codigo")
	private Integer opiCodigo;

	@Column(name="opi_ciudad")
	private Integer opiCiudad;

	@Column(name="opi_comentario")
	private String opiComentario;

	@Column(name="opi_estado")
	private Boolean opiEstado;

	@Column(name="opi_fecha")
	private Timestamp opiFecha;

	@Column(name="opi_fecha_referencia")
	private Timestamp opiFechaRefenrencia;
	
	@Column(name="opi_medio")
	private String opiMedio;

	@Column(name="opi_pais")
	private Integer opiPais;

	@Column(name="opi_provincia")
	private Integer opiProvincia;

	@Column(name="opi_tema_referencia")
	private String opiTemaReferencia;

	@Transient
	private long opiCount;
	
	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="opi_defesor")
	private DefensorDTO argDefensor;

	public OpinionDTO() {
	}

	public OpinionDTO(long opiCount) {
		this.opiCount=opiCount;
	}

	
	public Integer getOpiCodigo() {
		return this.opiCodigo;
	}

	public void setOpiCodigo(Integer opiCodigo) {
		this.opiCodigo = opiCodigo;
	}

	public Integer getOpiCiudad() {
		return this.opiCiudad;
	}

	public void setOpiCiudad(Integer opiCiudad) {
		this.opiCiudad = opiCiudad;
	}

	public String getOpiComentario() {
		return this.opiComentario;
	}

	public void setOpiComentario(String opiComentario) {
		this.opiComentario = opiComentario;
	}

	public Boolean getOpiEstado() {
		return this.opiEstado;
	}

	public void setOpiEstado(Boolean opiEstado) {
		this.opiEstado = opiEstado;
	}

	public Timestamp getOpiFecha() {
		return this.opiFecha;
	}

	public void setOpiFecha(Timestamp opiFecha) {
		this.opiFecha = opiFecha;
	}

	public Timestamp getOpiFechaRefenrencia() {
		return opiFechaRefenrencia;
	}

	public void setOpiFechaRefenrencia(Timestamp opiFechaRefenrencia) {
		this.opiFechaRefenrencia = opiFechaRefenrencia;
	}

	public String getOpiMedio() {
		return this.opiMedio;
	}

	public void setOpiMedio(String opiMedio) {
		this.opiMedio = opiMedio;
	}

	public Integer getOpiPais() {
		return this.opiPais;
	}

	public void setOpiPais(Integer opiPais) {
		this.opiPais = opiPais;
	}

	public Integer getOpiProvincia() {
		return this.opiProvincia;
	}

	public void setOpiProvincia(Integer opiProvincia) {
		this.opiProvincia = opiProvincia;
	}

	public String getOpiTemaReferencia() {
		return this.opiTemaReferencia;
	}

	public void setOpiTemaReferencia(String opiTemaReferencia) {
		this.opiTemaReferencia = opiTemaReferencia;
	}

	public long getOpiCount() {
		return opiCount;
	}

	public void setOpiCount(long opiCount) {
		this.opiCount = opiCount;
	}

	public DefensorDTO getArgDefensor() {
		return argDefensor;
	}

	public void setArgDefensor(DefensorDTO argDefensor) {
		this.argDefensor = argDefensor;
	}

}