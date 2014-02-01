package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ate_organizacion database table.
 * 
 */
@Entity
@Table(name="ate_organizacion")
@NamedQuery(name="OrganizacionDTO.findAll", query="SELECT o FROM OrganizacionDTO o")
public class OrganizacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_ORGANIZACION_ORGCODIGO_GENERATOR", sequenceName="ATE_ORGANIZACION_ORG_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_ORGANIZACION_ORGCODIGO_GENERATOR")
	@Column(name="org_codigo")
	private Integer orgCodigo;

	@Column(name="org_anio_fundacion")
	private Integer orgAnioFundacion;

	@Column(name="org_datos_institucionales")
	private String orgDatosInstitucionales;

	@Column(name="org_mienbros")
	private Integer orgMienbros;

	@Column(name="org_mision")
	private String orgMision;

	@Column(name="org_nombre")
	private String orgNombre;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="org_entidad")
	private EntidadDTO ateEntidad;

	public OrganizacionDTO() {
	}

	public Integer getOrgCodigo() {
		return this.orgCodigo;
	}

	public void setOrgCodigo(Integer orgCodigo) {
		this.orgCodigo = orgCodigo;
	}

	public Integer getOrgAnioFundacion() {
		return this.orgAnioFundacion;
	}

	public void setOrgAnioFundacion(Integer orgAnioFundacion) {
		this.orgAnioFundacion = orgAnioFundacion;
	}

	public String getOrgDatosInstitucionales() {
		return this.orgDatosInstitucionales;
	}

	public void setOrgDatosInstitucionales(String orgDatosInstitucionales) {
		this.orgDatosInstitucionales = orgDatosInstitucionales;
	}

	public Integer getOrgMienbros() {
		return this.orgMienbros;
	}

	public void setOrgMienbros(Integer orgMienbros) {
		this.orgMienbros = orgMienbros;
	}

	public String getOrgMision() {
		return this.orgMision;
	}

	public void setOrgMision(String orgMision) {
		this.orgMision = orgMision;
	}

	public String getOrgNombre() {
		return this.orgNombre;
	}

	public void setOrgNombre(String orgNombre) {
		this.orgNombre = orgNombre;
	}

	public EntidadDTO getAteEntidad() {
		return this.ateEntidad;
	}

	public void setAteEntidad(EntidadDTO ateEntidad) {
		this.ateEntidad = ateEntidad;
	}

}