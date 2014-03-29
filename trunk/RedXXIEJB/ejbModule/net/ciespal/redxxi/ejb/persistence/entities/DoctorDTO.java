package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


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
	private byte[] docArchivoTesis;

	@Column(name="doc_fecha_nacimiento")
	private Timestamp docFechaNacimiento;

	@Column(name="doc_foto_nombre")
	private String docFotoNombre;

	@Column(name="doc_institucion_titulacion")
	private String docInstitucionTitulacion;

	@Column(name="doc_institucion_trabajo")
	private String docInstitucionTrabajo;

	@Column(name="doc_nombres")
	private String docNombres;

	@Column(name="doc_resumen_tesis")
	private String docResumenTesis;

	@Column(name="doc_titulo_tesis")
	private String docTituloTesis;

	@Column(name="doc_sexo")
	private Integer docSexo;

	@Column(name="doc_ciudad")
	private Integer docCiudad;

	@Column(name="doc_provincia")
	private Integer docProvincia;

	@Column(name="doc_pais")
	private Integer docPais;
	
	@Column(name="doc_foto_byte")
	private byte[] docFotoByte;
	
	@Column(name="doc_archivo_tesis_nombre")
	private String docArchivoTesisNombre;
	
	@Transient
	private String docArchivoTesisPath;
	
	@Transient
	private String docFotoPath;
	
	@Transient
	private Long docCount;
	
	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateDoctor",cascade={CascadeType.ALL,CascadeType.PERSIST},fetch=FetchType.EAGER)
	private List<EntidadDTO> ateEntidads;

	//bi-directional many-to-one association to EspecialidadDTO
	@OneToMany(mappedBy="ateDoctor")
	private List<EspecialidadDTO> ateEspecialidads;

	public DoctorDTO() {
	}

	public DoctorDTO(Long docCount) {
		super();
		this.docCount = docCount;
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

	public byte[] getDocArchivoTesis() {
		return this.docArchivoTesis;
	}

	public void setDocArchivoTesis(byte[] docArchivoTesis) {
		this.docArchivoTesis = docArchivoTesis;
	}

	public Timestamp getDocFechaNacimiento() {
		return this.docFechaNacimiento;
	}

	public void setDocFechaNacimiento(Timestamp docFechaNacimiento) {
		this.docFechaNacimiento = docFechaNacimiento;
	}

	public String getDocFotoNombre() {
		return this.docFotoNombre;
	}

	public void setDocFotoNombre(String docFotoNombre) {
		this.docFotoNombre = docFotoNombre;
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

	public String getDocNombres() {
		return this.docNombres;
	}

	public void setDocNombres(String docNombres) {
		this.docNombres = docNombres;
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

	public Integer getDocSexo() {
		return docSexo;
	}

	public void setDocSexo(Integer docSexo) {
		this.docSexo = docSexo;
	}

	public Integer getDocCiudad() {
		return docCiudad;
	}

	public void setDocCiudad(Integer docCiudad) {
		this.docCiudad = docCiudad;
	}

	public Integer getDocProvincia() {
		return docProvincia;
	}

	public void setDocProvincia(Integer docProvincia) {
		this.docProvincia = docProvincia;
	}

	public Integer getDocPais() {
		return docPais;
	}

	public void setDocPais(Integer docPais) {
		this.docPais = docPais;
	}

	public Long getDocCount() {
		return docCount;
	}

	public void setDocCount(Long docCount) {
		this.docCount = docCount;
	}

	public byte[] getDocFotoByte() {
		return docFotoByte;
	}

	public void setDocFotoByte(byte[] docFotoByte) {
		this.docFotoByte = docFotoByte;
	}

	public String getDocFotoPath() {
		return docFotoPath;
	}

	public void setDocFotoPath(String docFotoPath) {
		this.docFotoPath = docFotoPath;
	}

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public String getDocArchivoTesisNombre() {
		return docArchivoTesisNombre;
	}

	public void setDocArchivoTesisNombre(String docArchivoTesisNombre) {
		this.docArchivoTesisNombre = docArchivoTesisNombre;
	}

	public String getDocArchivoTesisPath() {
		return docArchivoTesisPath;
	}

	public void setDocArchivoTesisPath(String docArchivoTesisPath) {
		this.docArchivoTesisPath = docArchivoTesisPath;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		if(ateEntidad!=null){
			if(getAteEntidads()==null)
				setAteEntidads(new ArrayList<EntidadDTO>());
			getAteEntidads().add(ateEntidad);
			ateEntidad.setAteDoctor(this);
		}
		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAteDoctor(null);

		return ateEntidad;
	}

	public List<EspecialidadDTO> getAteEspecialidads() {
		return this.ateEspecialidads;
	}

	public void setAteEspecialidads(List<EspecialidadDTO> ateEspecialidads) {
		this.ateEspecialidads = ateEspecialidads;
	}

	public EspecialidadDTO addAteEspecialidad(EspecialidadDTO ateEspecialidad) {
		getAteEspecialidads().add(ateEspecialidad);
		ateEspecialidad.setAteDoctor(this);

		return ateEspecialidad;
	}

	public EspecialidadDTO removeAteEspecialidad(EspecialidadDTO ateEspecialidad) {
		getAteEspecialidads().remove(ateEspecialidad);
		ateEspecialidad.setAteDoctor(null);

		return ateEspecialidad;
	}

}