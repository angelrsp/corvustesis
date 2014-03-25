package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the esp_premio database table.
 * 
 */
@Entity
@Table(name="esp_premio")
@NamedQuery(name="PremioDTO.findAll", query="SELECT p FROM PremioDTO p")
public class PremioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESP_PREMIO_PRECODIGO_GENERATOR", sequenceName="ESP_PREMIO_PRE_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESP_PREMIO_PRECODIGO_GENERATOR")
	@Column(name="pre_codigo")
	private Integer preCodigo;

	@Column(name="pre_ciudad")
	private Integer preCiudad;

	@Column(name="pre_descripcion")
	private String preDescripcion;

	@Column(name="pre_institucion")
	private String preInstitucion;

	@Column(name="pre_nivel_geografico")
	private Integer preNivelGeografico;

	@Column(name="pre_pais")
	private Integer prePais;

	@Column(name="pre_periodicidad")
	private String prePeriodicidad;

	@Column(name="pre_provincia")
	private Integer preProvincia;

	@Column(name="pre_tipo_medio")
	private Integer preTipoMedio;

	@Column(name="pre_titulo")
	private String preTitulo;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="pre_entidad")
	private EntidadDTO espEntidad;

	public PremioDTO() {
	}

	public Integer getPreCodigo() {
		return this.preCodigo;
	}

	public void setPreCodigo(Integer preCodigo) {
		this.preCodigo = preCodigo;
	}

	public Integer getPreCiudad() {
		return this.preCiudad;
	}

	public void setPreCiudad(Integer preCiudad) {
		this.preCiudad = preCiudad;
	}

	public String getPreDescripcion() {
		return this.preDescripcion;
	}

	public void setPreDescripcion(String preDescripcion) {
		this.preDescripcion = preDescripcion;
	}

	public String getPreInstitucion() {
		return this.preInstitucion;
	}

	public void setPreInstitucion(String preInstitucion) {
		this.preInstitucion = preInstitucion;
	}

	public Integer getPreNivelGeografico() {
		return this.preNivelGeografico;
	}

	public void setPreNivelGeografico(Integer preNivelGeografico) {
		this.preNivelGeografico = preNivelGeografico;
	}

	public Integer getPrePais() {
		return this.prePais;
	}

	public void setPrePais(Integer prePais) {
		this.prePais = prePais;
	}

	public String getPrePeriodicidad() {
		return this.prePeriodicidad;
	}

	public void setPrePeriodicidad(String prePeriodicidad) {
		this.prePeriodicidad = prePeriodicidad;
	}

	public Integer getPreProvincia() {
		return this.preProvincia;
	}

	public void setPreProvincia(Integer preProvincia) {
		this.preProvincia = preProvincia;
	}

	public Integer getPreTipoMedio() {
		return this.preTipoMedio;
	}

	public void setPreTipoMedio(Integer preTipoMedio) {
		this.preTipoMedio = preTipoMedio;
	}

	public String getPreTitulo() {
		return this.preTitulo;
	}

	public void setPreTitulo(String preTitulo) {
		this.preTitulo = preTitulo;
	}

	public EntidadDTO getEspEntidad() {
		return this.espEntidad;
	}

	public void setEspEntidad(EntidadDTO espEntidad) {
		this.espEntidad = espEntidad;
	}

}