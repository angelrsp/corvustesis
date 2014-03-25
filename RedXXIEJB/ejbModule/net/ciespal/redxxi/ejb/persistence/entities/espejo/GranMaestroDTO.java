package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the esp_gran_maestro database table.
 * 
 */
@Entity
@Table(name="esp_gran_maestro")
@NamedQuery(name="GranMaestroDTO.findAll", query="SELECT g FROM GranMaestroDTO g")
public class GranMaestroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESP_GRAN_MAESTRO_GMACODIGO_GENERATOR", sequenceName="ESP_GRAN_MAESTRO_GMA_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESP_GRAN_MAESTRO_GMACODIGO_GENERATOR")
	@Column(name="gma_codigo")
	private Integer gmaCodigo;

	@Column(name="gma_apellidos")
	private String gmaApellidos;

	@Column(name="gma_estado")
	private Integer gmaEstado;

	@Column(name="gma_fecha_fallecimiento")
	private Timestamp gmaFechaFallecimiento;

	@Column(name="gma_fecha_nacimiento")
	private Timestamp gmaFechaNacimiento;

	@Column(name="gma_foto")
	private byte[] gmaFoto;

	@Column(name="gma_nombres")
	private String gmaNombres;

	@Column(name="gma_pais")
	private Integer gmaPais;

	@Column(name="gma_perfil_biografico")
	private String gmaPerfilBiografico;

	@Column(name="gma_provincia")
	private Integer gmaProvincia;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="gma_entidad")
	private EntidadDTO espEntidad;

	public GranMaestroDTO() {
	}

	public Integer getGmaCodigo() {
		return this.gmaCodigo;
	}

	public void setGmaCodigo(Integer gmaCodigo) {
		this.gmaCodigo = gmaCodigo;
	}

	public String getGmaApellidos() {
		return this.gmaApellidos;
	}

	public void setGmaApellidos(String gmaApellidos) {
		this.gmaApellidos = gmaApellidos;
	}

	public Integer getGmaEstado() {
		return this.gmaEstado;
	}

	public void setGmaEstado(Integer gmaEstado) {
		this.gmaEstado = gmaEstado;
	}

	public Timestamp getGmaFechaFallecimiento() {
		return this.gmaFechaFallecimiento;
	}

	public void setGmaFechaFallecimiento(Timestamp gmaFechaFallecimiento) {
		this.gmaFechaFallecimiento = gmaFechaFallecimiento;
	}

	public Timestamp getGmaFechaNacimiento() {
		return this.gmaFechaNacimiento;
	}

	public void setGmaFechaNacimiento(Timestamp gmaFechaNacimiento) {
		this.gmaFechaNacimiento = gmaFechaNacimiento;
	}

	public byte[] getGmaFoto() {
		return this.gmaFoto;
	}

	public void setGmaFoto(byte[] gmaFoto) {
		this.gmaFoto = gmaFoto;
	}

	public String getGmaNombres() {
		return this.gmaNombres;
	}

	public void setGmaNombres(String gmaNombres) {
		this.gmaNombres = gmaNombres;
	}

	public Integer getGmaPais() {
		return this.gmaPais;
	}

	public void setGmaPais(Integer gmaPais) {
		this.gmaPais = gmaPais;
	}

	public String getGmaPerfilBiografico() {
		return this.gmaPerfilBiografico;
	}

	public void setGmaPerfilBiografico(String gmaPerfilBiografico) {
		this.gmaPerfilBiografico = gmaPerfilBiografico;
	}

	public Integer getGmaProvincia() {
		return this.gmaProvincia;
	}

	public void setGmaProvincia(Integer gmaProvincia) {
		this.gmaProvincia = gmaProvincia;
	}

	public EntidadDTO getEspEntidad() {
		return this.espEntidad;
	}

	public void setEspEntidad(EntidadDTO espEntidad) {
		this.espEntidad = espEntidad;
	}

}