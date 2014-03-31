package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the ate_obra database table.
 * 
 */
@Entity
@Table(name="ate_obra")
@NamedQuery(name="ObraDTO.findAll", query="SELECT o FROM ObraDTO o")
public class ObraDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_OBRA_OBRCODIGO_GENERATOR", sequenceName="ATE_OBRA_OBR_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_OBRA_OBRCODIGO_GENERATOR")
	@Column(name="obr_codigo")
	private Integer obrCodigo;

	@Column(name="obr_campo_conocimiento")
	private Integer obrCampoConocimiento;

	@Column(name="obr_nombre")
	private String obrNombre;

	@Column(name="obr_tipo")
	private Integer obrTipo;

	@Column(name="obr_pais")
	private Integer obrPais;

	@Column(name="obr_provincia")
	private Integer obrProvincia;

	@Column(name="obr_ciudad")
	private Integer obrCiudad;
	
	@Column(name="obr_titulo")
	private String obrTitulo;
	
	@Column(name="obr_resumen")
	private String obrResumen;

	@Column(name="obr_archivo")
	private byte[] obrArchivo;

	@Column(name="obr_archivo_nombre")
	private String obrArchivoNombre;	
	
	@Transient
	private String obrArchivoPath;
	
	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateObra",cascade=CascadeType.PERSIST)
	private List<EntidadDTO> ateEntidads;

	public ObraDTO() {
	}

	public Integer getObrCodigo() {
		return this.obrCodigo;
	}

	public void setObrCodigo(Integer obrCodigo) {
		this.obrCodigo = obrCodigo;
	}

	public Integer getObrCampoConocimiento() {
		return this.obrCampoConocimiento;
	}

	public void setObrCampoConocimiento(Integer obrCampoConocimiento) {
		this.obrCampoConocimiento = obrCampoConocimiento;
	}

	public String getObrNombre() {
		return this.obrNombre;
	}

	public void setObrNombre(String obrNombre) {
		this.obrNombre = obrNombre;
	}

	public Integer getObrTipo() {
		return this.obrTipo;
	}

	public void setObrTipo(Integer obrTipo) {
		this.obrTipo = obrTipo;
	}

	public Integer getObrPais() {
		return obrPais;
	}

	public void setObrPais(Integer obrPais) {
		this.obrPais = obrPais;
	}

	public Integer getObrProvincia() {
		return obrProvincia;
	}

	public void setObrProvincia(Integer obrProvincia) {
		this.obrProvincia = obrProvincia;
	}

	public Integer getObrCiudad() {
		return obrCiudad;
	}

	public void setObrCiudad(Integer obrCiudad) {
		this.obrCiudad = obrCiudad;
	}

	public String getObrTitulo() {
		return obrTitulo;
	}

	public void setObrTitulo(String obrTitulo) {
		this.obrTitulo = obrTitulo;
	}

	public String getObrResumen() {
		return obrResumen;
	}

	public void setObrResumen(String obrResumen) {
		this.obrResumen = obrResumen;
	}

	public byte[] getObrArchivo() {
		return obrArchivo;
	}

	public void setObrArchivo(byte[] obrArchivo) {
		this.obrArchivo = obrArchivo;
	}

	public String getObrArchivoNombre() {
		return obrArchivoNombre;
	}

	public void setObrArchivoNombre(String obrArchivoNombre) {
		this.obrArchivoNombre = obrArchivoNombre;
	}

	public String getObrArchivoPath() {
		return obrArchivoPath;
	}

	public void setObrArchivoPath(String obrArchivoPath) {
		this.obrArchivoPath = obrArchivoPath;
	}

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		if(ateEntidad!=null)
		{
			if(getAteEntidads()==null)
				setAteEntidads(new ArrayList<EntidadDTO>());
			getAteEntidads().add(ateEntidad);
			ateEntidad.setAteObra(this);
		}
		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAteObra(null);

		return ateEntidad;
	}

}