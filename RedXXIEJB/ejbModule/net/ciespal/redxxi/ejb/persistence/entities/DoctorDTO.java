package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ate_doctor database table.
 * 
 */
@Entity
@Table(name="ate_doctor")
@NamedQuery(name="DoctorDTO.findAll", query="SELECT d FROM DoctorDTO d")
public class DoctorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_DOCTOR_DOCCODIGO_GENERATOR", sequenceName="ATE_DOCTOR_DOC_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_DOCTOR_DOCCODIGO_GENERATOR")
	@Column(name="doc_codigo")
	private Integer docCodigo;

	@Column(name="doc_anio_titulacion")
	private Integer docAnioTitulacion;

	@Column(name="doc_apellidos")
	private String docApellidos;

	@Column(name="doc_archivo_tesis")
	private String docArchivoTesis;

	@Column(name="doc_fecha_nacimiento")
	private Timestamp docFechaNacimiento;

	@Column(name="doc_foto")
	private String docFoto;

	@Column(name="doc_institucion_titulacion")
	private String docInstitucionTitulacion;

	@Column(name="doc_institucion_trabajo")
	private String docInstitucionTrabajo;

	@Column(name="doc_nombre")
	private String docNombre;

	@Column(name="doc_resumen_tesis")
	private String docResumenTesis;

	@Column(name="doc_titulo_tesis")
	private String docTituloTesis;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="doc_entidad")
	private EntidadDTO ateEntidad;

	//bi-directional many-to-one association to EspecalidadDTO
	@OneToMany(mappedBy="ateDoctor")
	private List<EspecalidadDTO> ateEspecalidads;

	//bi-directional many-to-one association to ObraDTO
	@OneToMany(mappedBy="ateDoctor")
	private List<ObraDTO> ateObras;

	public DoctorDTO() {
	}

	public Integer getDocCodigo() {
		return this.docCodigo;
	}

	public void setDocCodigo(Integer docCodigo) {
		this.docCodigo = docCodigo;
	}

	public Integer getDocAnioTitulacion() {
		return this.docAnioTitulacion;
	}

	public void setDocAnioTitulacion(Integer docAnioTitulacion) {
		this.docAnioTitulacion = docAnioTitulacion;
	}

	public String getDocApellidos() {
		return this.docApellidos;
	}

	public void setDocApellidos(String docApellidos) {
		this.docApellidos = docApellidos;
	}

	public String getDocArchivoTesis() {
		return this.docArchivoTesis;
	}

	public void setDocArchivoTesis(String docArchivoTesis) {
		this.docArchivoTesis = docArchivoTesis;
	}

	public Timestamp getDocFechaNacimiento() {
		return this.docFechaNacimiento;
	}

	public void setDocFechaNacimiento(Timestamp docFechaNacimiento) {
		this.docFechaNacimiento = docFechaNacimiento;
	}

	public String getDocFoto() {
		return this.docFoto;
	}

	public void setDocFoto(String docFoto) {
		this.docFoto = docFoto;
	}

	public String getDocInstitucionTitulacion() {
		return this.docInstitucionTitulacion;
	}

	public void setDocInstitucionTitulacion(String docInstitucionTitulacion) {
		this.docInstitucionTitulacion = docInstitucionTitulacion;
	}

	public String getDocInstitucionTrabajo() {
		return this.docInstitucionTrabajo;
	}

	public void setDocInstitucionTrabajo(String docInstitucionTrabajo) {
		this.docInstitucionTrabajo = docInstitucionTrabajo;
	}

	public String getDocNombre() {
		return this.docNombre;
	}

	public void setDocNombre(String docNombre) {
		this.docNombre = docNombre;
	}

	public String getDocResumenTesis() {
		return this.docResumenTesis;
	}

	public void setDocResumenTesis(String docResumenTesis) {
		this.docResumenTesis = docResumenTesis;
	}

	public String getDocTituloTesis() {
		return this.docTituloTesis;
	}

	public void setDocTituloTesis(String docTituloTesis) {
		this.docTituloTesis = docTituloTesis;
	}

	public EntidadDTO getAteEntidad() {
		return this.ateEntidad;
	}

	public void setAteEntidad(EntidadDTO ateEntidad) {
		this.ateEntidad = ateEntidad;
	}

	public List<EspecalidadDTO> getAteEspecalidads() {
		return this.ateEspecalidads;
	}

	public void setAteEspecalidads(List<EspecalidadDTO> ateEspecalidads) {
		this.ateEspecalidads = ateEspecalidads;
	}

	public EspecalidadDTO addAteEspecalidad(EspecalidadDTO ateEspecalidad) {
		getAteEspecalidads().add(ateEspecalidad);
		ateEspecalidad.setAteDoctor(this);

		return ateEspecalidad;
	}

	public EspecalidadDTO removeAteEspecalidad(EspecalidadDTO ateEspecalidad) {
		getAteEspecalidads().remove(ateEspecalidad);
		ateEspecalidad.setAteDoctor(null);

		return ateEspecalidad;
	}

	public List<ObraDTO> getAteObras() {
		return this.ateObras;
	}

	public void setAteObras(List<ObraDTO> ateObras) {
		this.ateObras = ateObras;
	}

	public ObraDTO addAteObra(ObraDTO ateObra) {
		getAteObras().add(ateObra);
		ateObra.setAteDoctor(this);

		return ateObra;
	}

	public ObraDTO removeAteObra(ObraDTO ateObra) {
		getAteObras().remove(ateObra);
		ateObra.setAteDoctor(null);

		return ateObra;
	}

}