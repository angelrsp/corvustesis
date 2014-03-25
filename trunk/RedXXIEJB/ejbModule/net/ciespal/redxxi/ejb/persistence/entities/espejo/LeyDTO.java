package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the esp_ley database table.
 * 
 */
@Entity
@Table(name="esp_ley")
@NamedQuery(name="LeyDTO.findAll", query="SELECT l FROM LeyDTO l")
public class LeyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESP_LEY_LEYCODIGO_GENERATOR", sequenceName="ESP_LEY_LEY_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESP_LEY_LEYCODIGO_GENERATOR")
	@Column(name="ley_codigo")
	private Integer leyCodigo;

	@Column(name="ley_anio")
	private Integer leyAnio;

	@Column(name="ley_archivo")
	private byte[] leyArchivo;

	@Column(name="ley_entidad_emisora")
	private String leyEntidadEmisora;

	@Column(name="ley_estado")
	private Integer leyEstado;

	@Column(name="ley_pais")
	private Integer leyPais;

	@Column(name="ley_provincia")
	private Integer leyProvincia;

	@Column(name="ley_texto")
	private String leyTexto;

	@Column(name="ley_tipo")
	private Integer leyTipo;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="ley_entidad")
	private EntidadDTO espEntidad;

	public LeyDTO() {
	}

	public Integer getLeyCodigo() {
		return this.leyCodigo;
	}

	public void setLeyCodigo(Integer leyCodigo) {
		this.leyCodigo = leyCodigo;
	}

	public Integer getLeyAnio() {
		return this.leyAnio;
	}

	public void setLeyAnio(Integer leyAnio) {
		this.leyAnio = leyAnio;
	}

	public byte[] getLeyArchivo() {
		return this.leyArchivo;
	}

	public void setLeyArchivo(byte[] leyArchivo) {
		this.leyArchivo = leyArchivo;
	}

	public String getLeyEntidadEmisora() {
		return this.leyEntidadEmisora;
	}

	public void setLeyEntidadEmisora(String leyEntidadEmisora) {
		this.leyEntidadEmisora = leyEntidadEmisora;
	}

	public Integer getLeyEstado() {
		return this.leyEstado;
	}

	public void setLeyEstado(Integer leyEstado) {
		this.leyEstado = leyEstado;
	}

	public Integer getLeyPais() {
		return this.leyPais;
	}

	public void setLeyPais(Integer leyPais) {
		this.leyPais = leyPais;
	}

	public Integer getLeyProvincia() {
		return this.leyProvincia;
	}

	public void setLeyProvincia(Integer leyProvincia) {
		this.leyProvincia = leyProvincia;
	}

	public String getLeyTexto() {
		return this.leyTexto;
	}

	public void setLeyTexto(String leyTexto) {
		this.leyTexto = leyTexto;
	}

	public Integer getLeyTipo() {
		return this.leyTipo;
	}

	public void setLeyTipo(Integer leyTipo) {
		this.leyTipo = leyTipo;
	}

	public EntidadDTO getEspEntidad() {
		return this.espEntidad;
	}

	public void setEspEntidad(EntidadDTO espEntidad) {
		this.espEntidad = espEntidad;
	}

}