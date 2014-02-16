package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
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

	@Column(name="doc_nombres")
	private String docNombres;

	@Column(name="doc_resumen_tesis")
	private String docResumenTesis;

	@Column(name="doc_titulo_tesis")
	private String docTituloTesis;

	@Column(name="doc_ubicacion")
	private Integer docUbicacion;

	@Column(name="doc_sexo")
	private Integer docSexo;

	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateDoctor",cascade={CascadeType.ALL,CascadeType.PERSIST},fetch=FetchType.EAGER)
	private List<EntidadDTO> ateEntidads;

	//bi-directional many-to-one association to EspecialidadDTO
	@OneToMany(mappedBy="ateDoctor")
	private List<EspecialidadDTO> ateEspecialidads;

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

	public Integer getDocUbicacion() {
		return docUbicacion;
	}

	public void setDocUbicacion(Integer docUbicacion) {
		this.docUbicacion = docUbicacion;
	}

	public Integer getDocSexo() {
		return docSexo;
	}

	public void setDocSexo(Integer docSexo) {
		this.docSexo = docSexo;
	}

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
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