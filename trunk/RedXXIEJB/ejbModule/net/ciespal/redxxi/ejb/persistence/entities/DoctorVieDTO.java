package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ate_doctor_vie database table.
 * 
 */
@Entity
@Table(name="ate_doctor_vie")
@NamedQuery(name="DoctorVieDTO.findAll", query="SELECT d FROM DoctorVieDTO d")
public class DoctorVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_ciudad")
	private String catCiudad;

	@Column(name="cat_pais")
	private String catPais;

	@Column(name="cat_provincia")
	private String catProvincia;

	@Column(name="cat_sexo")
	private String catSexo;

	@Column(name="doc_anio_titulacion")
	private Integer docAnioTitulacion;

	@Column(name="doc_apellidos")
	private String docApellidos;

	@Column(name="doc_archivo_tesis")
	private byte[] docArchivoTesis;

	@Column(name="doc_archivo_tesis_nombre")
	private String docArchivoTesisNombre;

	@Column(name="doc_ciudad")
	private Integer docCiudad;

	@Id
	@Column(name="doc_codigo")
	private Integer docCodigo;

	@Column(name="doc_fecha_nacimiento")
	private Timestamp docFechaNacimiento;

	@Column(name="doc_foto")
	private String docFoto;

	@Column(name="doc_foto_byte")
	private byte[] docFotoByte;

	@Column(name="doc_foto_nombre")
	private String docFotoNombre;

	@Column(name="doc_institucion_titulacion")
	private String docInstitucionTitulacion;

	@Column(name="doc_institucion_trabajo")
	private String docInstitucionTrabajo;

	@Column(name="doc_nombres")
	private String docNombres;

	@Column(name="doc_pais")
	private Integer docPais;

	@Column(name="doc_provincia")
	private Integer docProvincia;

	@Column(name="doc_resumen_tesis")
	private String docResumenTesis;

	@Column(name="doc_sexo")
	private Integer docSexo;

	@Column(name="doc_titulo_tesis")
	private String docTituloTesis;

	public DoctorVieDTO() {
	}

	public String getCatCiudad() {
		return this.catCiudad;
	}

	public void setCatCiudad(String catCiudad) {
		this.catCiudad = catCiudad;
	}

	public String getCatPais() {
		return this.catPais;
	}

	public void setCatPais(String catPais) {
		this.catPais = catPais;
	}

	public String getCatProvincia() {
		return this.catProvincia;
	}

	public void setCatProvincia(String catProvincia) {
		this.catProvincia = catProvincia;
	}

	public String getCatSexo() {
		return this.catSexo;
	}

	public void setCatSexo(String catSexo) {
		this.catSexo = catSexo;
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

	public String getDocArchivoTesisNombre() {
		return this.docArchivoTesisNombre;
	}

	public void setDocArchivoTesisNombre(String docArchivoTesisNombre) {
		this.docArchivoTesisNombre = docArchivoTesisNombre;
	}

	public Integer getDocCiudad() {
		return this.docCiudad;
	}

	public void setDocCiudad(Integer docCiudad) {
		this.docCiudad = docCiudad;
	}

	public Integer getDocCodigo() {
		return this.docCodigo;
	}

	public void setDocCodigo(Integer docCodigo) {
		this.docCodigo = docCodigo;
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

	public byte[] getDocFotoByte() {
		return this.docFotoByte;
	}

	public void setDocFotoByte(byte[] docFotoByte) {
		this.docFotoByte = docFotoByte;
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

	public Integer getDocPais() {
		return this.docPais;
	}

	public void setDocPais(Integer docPais) {
		this.docPais = docPais;
	}

	public Integer getDocProvincia() {
		return this.docProvincia;
	}

	public void setDocProvincia(Integer docProvincia) {
		this.docProvincia = docProvincia;
	}

	public String getDocResumenTesis() {
		return this.docResumenTesis;
	}

	public void setDocResumenTesis(String docResumenTesis) {
		this.docResumenTesis = docResumenTesis;
	}

	public Integer getDocSexo() {
		return this.docSexo;
	}

	public void setDocSexo(Integer docSexo) {
		this.docSexo = docSexo;
	}

	public String getDocTituloTesis() {
		return this.docTituloTesis;
	}

	public void setDocTituloTesis(String docTituloTesis) {
		this.docTituloTesis = docTituloTesis;
	}

}