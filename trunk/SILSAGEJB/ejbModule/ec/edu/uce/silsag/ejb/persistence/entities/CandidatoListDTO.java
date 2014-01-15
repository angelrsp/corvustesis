package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;


/**
 * The persistent class for the vie_candidato database table.
 * 
 */
@Entity
@Table(name="vie_candidato")
@NamedQuery(name="CandidatoListDTO.findAll", query="SELECT c FROM CandidatoListDTO c")
public class CandidatoListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="can_apellido_materno")
	private String canApellidoMaterno;

	@Column(name="can_apellido_paterno")
	private String canApellidoPaterno;

	@Column(name="can_codigo")
	private Integer canCodigo;

	@Column(name="can_estado_civil")
	private Integer canEstadoCivil;

	@Column(name="can_fecha_nacimiento")
	private Timestamp canFechaNacimiento;

	@Column(name="can_foto")
	private byte[] canFoto;

	@Column(name="can_identificacion")
	private String canIdentificacion;

	@Column(name="can_lugar_nacimiento")
	private String canLugarNacimiento;

	@Column(name="can_primer_nombre")
	private String canPrimerNombre;

	@Column(name="can_segundo_nombre")
	private String canSegundoNombre;

	@Column(name="can_tipo_identificacion")
	private Integer canTipoIdentificacion;

	@Column(name="can_usuario")
	private Integer canUsuario;

	@Column(name="cat_estudio_nivel")
	private String catEstudioNivel;

	@Column(name="cat_estudio_pais")
	private String catEstudioPais;

	@Column(name="cat_experiencia_tipo")
	private String catExperienciaTipo;

	@Column(name="cat_idioma_nivel")
	private String catIdiomaNivel;

	@Column(name="cat_programa_nivel")
	private String catProgramaNivel;

	@Column(name="est_anio_fin")
	private Integer estAnioFin;

	@Column(name="est_anio_inicio")
	private Integer estAnioInicio;

	@Column(name="est_candidato")
	private Integer estCandidato;

	@Column(name="est_carrera")
	private String estCarrera;

	@Id
	@Column(name="est_codigo")
	private Integer estCodigo;

	@Column(name="est_establecimiento")
	private String estEstablecimiento;

	@Column(name="est_mes_fin")
	private Integer estMesFin;

	@Column(name="est_mes_inicio")
	private Integer estMesInicio;

	@Column(name="est_nivel")
	private Integer estNivel;

	@Column(name="est_pais")
	private Integer estPais;

	@Column(name="exp_candidato")
	private Integer expCandidato;

	@Column(name="exp_codigo")
	private Integer expCodigo;

	@Column(name="exp_entidad")
	private String expEntidad;

	@Column(name="exp_fecha_fin")
	private Timestamp expFechaFin;

	@Column(name="exp_fecha_inicio")
	private Timestamp expFechaInicio;

	@Column(name="exp_puesto")
	private String expPuesto;

	@Column(name="exp_rubro")
	private BigDecimal expRubro;

	@Column(name="exp_tareas")
	private String expTareas;

	@Column(name="exp_tipo_experiencia")
	private Integer expTipoExperiencia;

	@Column(name="idi_candidato")
	private Integer idiCandidato;

	@Column(name="idi_codigo")
	private Integer idiCodigo;

	@Column(name="idi_idioma")
	private Integer idiIdioma;

	@Column(name="idi_nivel")
	private Integer idiNivel;

	@Column(name="pro_candidato")
	private Integer proCandidato;

	@Column(name="pro_codigo")
	private Integer proCodigo;

	@Column(name="pro_nivel")
	private Integer proNivel;

	@Column(name="pro_programa")
	private String proPrograma;

	@Column(name="ref_candidato")
	private Integer refCandidato;

	@Column(name="ref_codigo")
	private Integer refCodigo;

	@Column(name="ref_mail")
	private String refMail;

	@Column(name="ref_nombre")
	private String refNombre;

	@Column(name="ref_telefono")
	private String refTelefono;

	@Column(name="usu_celular")
	private String usuCelular;

	@Column(name="usu_codigo")
	private Integer usuCodigo;

	@Column(name="usu_direccion")
	private String usuDireccion;

	@Column(name="usu_login")
	private String usuLogin;

	@Column(name="usu_mail")
	private String usuMail;

	@Column(name="usu_password")
	private String usuPassword;

	@Column(name="usu_perfil")
	private Integer usuPerfil;

	@Column(name="usu_telefono")
	private String usuTelefono;

	public CandidatoListDTO() {
	}

	public String getCanApellidoMaterno() {
		return this.canApellidoMaterno;
	}

	public void setCanApellidoMaterno(String canApellidoMaterno) {
		this.canApellidoMaterno = canApellidoMaterno;
	}

	public String getCanApellidoPaterno() {
		return this.canApellidoPaterno;
	}

	public void setCanApellidoPaterno(String canApellidoPaterno) {
		this.canApellidoPaterno = canApellidoPaterno;
	}

	public Integer getCanCodigo() {
		return this.canCodigo;
	}

	public void setCanCodigo(Integer canCodigo) {
		this.canCodigo = canCodigo;
	}

	public Integer getCanEstadoCivil() {
		return this.canEstadoCivil;
	}

	public void setCanEstadoCivil(Integer canEstadoCivil) {
		this.canEstadoCivil = canEstadoCivil;
	}

	public Timestamp getCanFechaNacimiento() {
		return this.canFechaNacimiento;
	}

	public void setCanFechaNacimiento(Timestamp canFechaNacimiento) {
		this.canFechaNacimiento = canFechaNacimiento;
	}

	public byte[] getCanFoto() {
		return this.canFoto;
	}

	public void setCanFoto(byte[] canFoto) {
		this.canFoto = canFoto;
	}

	public String getCanIdentificacion() {
		return this.canIdentificacion;
	}

	public void setCanIdentificacion(String canIdentificacion) {
		this.canIdentificacion = canIdentificacion;
	}

	public String getCanLugarNacimiento() {
		return this.canLugarNacimiento;
	}

	public void setCanLugarNacimiento(String canLugarNacimiento) {
		this.canLugarNacimiento = canLugarNacimiento;
	}

	public String getCanPrimerNombre() {
		return this.canPrimerNombre;
	}

	public void setCanPrimerNombre(String canPrimerNombre) {
		this.canPrimerNombre = canPrimerNombre;
	}

	public String getCanSegundoNombre() {
		return this.canSegundoNombre;
	}

	public void setCanSegundoNombre(String canSegundoNombre) {
		this.canSegundoNombre = canSegundoNombre;
	}

	public Integer getCanTipoIdentificacion() {
		return this.canTipoIdentificacion;
	}

	public void setCanTipoIdentificacion(Integer canTipoIdentificacion) {
		this.canTipoIdentificacion = canTipoIdentificacion;
	}

	public Integer getCanUsuario() {
		return this.canUsuario;
	}

	public void setCanUsuario(Integer canUsuario) {
		this.canUsuario = canUsuario;
	}

	public String getCatEstudioNivel() {
		return this.catEstudioNivel;
	}

	public void setCatEstudioNivel(String catEstudioNivel) {
		this.catEstudioNivel = catEstudioNivel;
	}

	public String getCatEstudioPais() {
		return this.catEstudioPais;
	}

	public void setCatEstudioPais(String catEstudioPais) {
		this.catEstudioPais = catEstudioPais;
	}

	public String getCatExperienciaTipo() {
		return this.catExperienciaTipo;
	}

	public void setCatExperienciaTipo(String catExperienciaTipo) {
		this.catExperienciaTipo = catExperienciaTipo;
	}

	public String getCatIdiomaNivel() {
		return this.catIdiomaNivel;
	}

	public void setCatIdiomaNivel(String catIdiomaNivel) {
		this.catIdiomaNivel = catIdiomaNivel;
	}

	public String getCatProgramaNivel() {
		return this.catProgramaNivel;
	}

	public void setCatProgramaNivel(String catProgramaNivel) {
		this.catProgramaNivel = catProgramaNivel;
	}

	public Integer getEstAnioFin() {
		return this.estAnioFin;
	}

	public void setEstAnioFin(Integer estAnioFin) {
		this.estAnioFin = estAnioFin;
	}

	public Integer getEstAnioInicio() {
		return this.estAnioInicio;
	}

	public void setEstAnioInicio(Integer estAnioInicio) {
		this.estAnioInicio = estAnioInicio;
	}

	public Integer getEstCandidato() {
		return this.estCandidato;
	}

	public void setEstCandidato(Integer estCandidato) {
		this.estCandidato = estCandidato;
	}

	public String getEstCarrera() {
		return this.estCarrera;
	}

	public void setEstCarrera(String estCarrera) {
		this.estCarrera = estCarrera;
	}

	public Integer getEstCodigo() {
		return this.estCodigo;
	}

	public void setEstCodigo(Integer estCodigo) {
		this.estCodigo = estCodigo;
	}

	public String getEstEstablecimiento() {
		return this.estEstablecimiento;
	}

	public void setEstEstablecimiento(String estEstablecimiento) {
		this.estEstablecimiento = estEstablecimiento;
	}

	public Integer getEstMesFin() {
		return this.estMesFin;
	}

	public void setEstMesFin(Integer estMesFin) {
		this.estMesFin = estMesFin;
	}

	public Integer getEstMesInicio() {
		return this.estMesInicio;
	}

	public void setEstMesInicio(Integer estMesInicio) {
		this.estMesInicio = estMesInicio;
	}

	public Integer getEstNivel() {
		return this.estNivel;
	}

	public void setEstNivel(Integer estNivel) {
		this.estNivel = estNivel;
	}

	public Integer getEstPais() {
		return this.estPais;
	}

	public void setEstPais(Integer estPais) {
		this.estPais = estPais;
	}

	public Integer getExpCandidato() {
		return this.expCandidato;
	}

	public void setExpCandidato(Integer expCandidato) {
		this.expCandidato = expCandidato;
	}

	public Integer getExpCodigo() {
		return this.expCodigo;
	}

	public void setExpCodigo(Integer expCodigo) {
		this.expCodigo = expCodigo;
	}

	public String getExpEntidad() {
		return this.expEntidad;
	}

	public void setExpEntidad(String expEntidad) {
		this.expEntidad = expEntidad;
	}

	public Timestamp getExpFechaFin() {
		return this.expFechaFin;
	}

	public void setExpFechaFin(Timestamp expFechaFin) {
		this.expFechaFin = expFechaFin;
	}

	public Timestamp getExpFechaInicio() {
		return this.expFechaInicio;
	}

	public void setExpFechaInicio(Timestamp expFechaInicio) {
		this.expFechaInicio = expFechaInicio;
	}

	public String getExpPuesto() {
		return this.expPuesto;
	}

	public void setExpPuesto(String expPuesto) {
		this.expPuesto = expPuesto;
	}

	public BigDecimal getExpRubro() {
		return this.expRubro;
	}

	public void setExpRubro(BigDecimal expRubro) {
		this.expRubro = expRubro;
	}

	public String getExpTareas() {
		return this.expTareas;
	}

	public void setExpTareas(String expTareas) {
		this.expTareas = expTareas;
	}

	public Integer getExpTipoExperiencia() {
		return this.expTipoExperiencia;
	}

	public void setExpTipoExperiencia(Integer expTipoExperiencia) {
		this.expTipoExperiencia = expTipoExperiencia;
	}

	public Integer getIdiCandidato() {
		return this.idiCandidato;
	}

	public void setIdiCandidato(Integer idiCandidato) {
		this.idiCandidato = idiCandidato;
	}

	public Integer getIdiCodigo() {
		return this.idiCodigo;
	}

	public void setIdiCodigo(Integer idiCodigo) {
		this.idiCodigo = idiCodigo;
	}

	public Integer getIdiIdioma() {
		return this.idiIdioma;
	}

	public void setIdiIdioma(Integer idiIdioma) {
		this.idiIdioma = idiIdioma;
	}

	public Integer getIdiNivel() {
		return this.idiNivel;
	}

	public void setIdiNivel(Integer idiNivel) {
		this.idiNivel = idiNivel;
	}

	public Integer getProCandidato() {
		return this.proCandidato;
	}

	public void setProCandidato(Integer proCandidato) {
		this.proCandidato = proCandidato;
	}

	public Integer getProCodigo() {
		return this.proCodigo;
	}

	public void setProCodigo(Integer proCodigo) {
		this.proCodigo = proCodigo;
	}

	public Integer getProNivel() {
		return this.proNivel;
	}

	public void setProNivel(Integer proNivel) {
		this.proNivel = proNivel;
	}

	public String getProPrograma() {
		return this.proPrograma;
	}

	public void setProPrograma(String proPrograma) {
		this.proPrograma = proPrograma;
	}

	public Integer getRefCandidato() {
		return this.refCandidato;
	}

	public void setRefCandidato(Integer refCandidato) {
		this.refCandidato = refCandidato;
	}

	public Integer getRefCodigo() {
		return this.refCodigo;
	}

	public void setRefCodigo(Integer refCodigo) {
		this.refCodigo = refCodigo;
	}

	public String getRefMail() {
		return this.refMail;
	}

	public void setRefMail(String refMail) {
		this.refMail = refMail;
	}

	public String getRefNombre() {
		return this.refNombre;
	}

	public void setRefNombre(String refNombre) {
		this.refNombre = refNombre;
	}

	public String getRefTelefono() {
		return this.refTelefono;
	}

	public void setRefTelefono(String refTelefono) {
		this.refTelefono = refTelefono;
	}

	public String getUsuCelular() {
		return this.usuCelular;
	}

	public void setUsuCelular(String usuCelular) {
		this.usuCelular = usuCelular;
	}

	public Integer getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public String getUsuDireccion() {
		return this.usuDireccion;
	}

	public void setUsuDireccion(String usuDireccion) {
		this.usuDireccion = usuDireccion;
	}

	public String getUsuLogin() {
		return this.usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	public String getUsuMail() {
		return this.usuMail;
	}

	public void setUsuMail(String usuMail) {
		this.usuMail = usuMail;
	}

	public String getUsuPassword() {
		return this.usuPassword;
	}

	public void setUsuPassword(String usuPassword) {
		this.usuPassword = usuPassword;
	}

	public Integer getUsuPerfil() {
		return this.usuPerfil;
	}

	public void setUsuPerfil(Integer usuPerfil) {
		this.usuPerfil = usuPerfil;
	}

	public String getUsuTelefono() {
		return this.usuTelefono;
	}

	public void setUsuTelefono(String usuTelefono) {
		this.usuTelefono = usuTelefono;
	}

}