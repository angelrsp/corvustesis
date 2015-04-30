package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;


/**
 * The persistent class for the bem_candidato database table.
 * 
 */
@Entity
@Table(name="bem_candidato")
@NamedQuery(name="CandidatoDTO.findAll", query="SELECT c FROM CandidatoDTO c")
public class CandidatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_CANDIDATO_CANCODIGO_GENERATOR", sequenceName="BEM_CANDIDATO_CAN_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_CANDIDATO_CANCODIGO_GENERATOR")
	@Column(name="can_codigo")
	private Integer canCodigo;

	@Column(name="can_apellidos")
	private String canApellidos;

	@Column(name="can_estado_civil")
	private Integer canEstadoCivil;

	@Column(name="can_estado_estudio")
	private Integer canEstadoEstudio;

	@Column(name="can_fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date canFechaNacimiento;

	@Column(name="can_identificacion")
	private String canIdentificacion;

	@Column(name="can_lugar_nacimiento")
	private String canLugarNacimiento;

	@Column(name="can_max_estudio")
	private Integer canMaxEstudio;

	@Column(name="can_nombres")
	private String canNombres;

	@Column(name="can_sexo")
	private Integer canSexo;

	@Column(name="can_tipo_identificacion")
	private Integer canTipoIdentificacion;

	@ManyToOne
	@JoinColumn(name="can_usuario")
	private UsuarioDTO segUsuario;
	
	//bi-directional many-to-one association to ExperienciaDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<ExperienciaDTO> bemExperiencias;

	//bi-directional many-to-one association to HabilidadDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<HabilidadDTO> bemHabilidads;

	//bi-directional many-to-one association to ImagenCandidatoDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<ImagenCandidatoDTO> bemImagenCandidatos;

	//bi-directional many-to-one association to PostulacionDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<PostulacionDTO> bemPostulacions;

	//bi-directional many-to-one association to ReferenciaDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<ReferenciaDTO> bemReferencias;

	//bi-directional many-to-one association to ResultadoDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<ResultadoDTO> cueResultados;

	public CandidatoDTO() {
	}

	public Integer getCanCodigo() {
		return this.canCodigo;
	}

	public void setCanCodigo(Integer canCodigo) {
		this.canCodigo = canCodigo;
	}

	public String getCanApellidos() {
		return this.canApellidos;
	}

	public void setCanApellidos(String canApellidos) {
		this.canApellidos = canApellidos;
	}

	public Integer getCanEstadoCivil() {
		return this.canEstadoCivil;
	}

	public void setCanEstadoCivil(Integer canEstadoCivil) {
		this.canEstadoCivil = canEstadoCivil;
	}

	public Integer getCanEstadoEstudio() {
		return this.canEstadoEstudio;
	}

	public void setCanEstadoEstudio(Integer canEstadoEstudio) {
		this.canEstadoEstudio = canEstadoEstudio;
	}

	public Date getCanFechaNacimiento() {
		return this.canFechaNacimiento;
	}

	public void setCanFechaNacimiento(Date canFechaNacimiento) {
		this.canFechaNacimiento = canFechaNacimiento;
	}

	public String getCanIdentificacion() {
		return this.canIdentificacion;
	}

	public void setCanIdentificacion(String canIdentificacion) {
		this.canIdentificacion = canIdentificacion;
	}

	public UsuarioDTO getSegUsuario() {
		return segUsuario;
	}

	public void setSegUsuario(UsuarioDTO segUsuario) {
		this.segUsuario = segUsuario;
	}

	public String getCanLugarNacimiento() {
		return this.canLugarNacimiento;
	}

	public void setCanLugarNacimiento(String canLugarNacimiento) {
		this.canLugarNacimiento = canLugarNacimiento;
	}

	public Integer getCanMaxEstudio() {
		return this.canMaxEstudio;
	}

	public void setCanMaxEstudio(Integer canMaxEstudio) {
		this.canMaxEstudio = canMaxEstudio;
	}

	public String getCanNombres() {
		return this.canNombres;
	}

	public void setCanNombres(String canNombres) {
		this.canNombres = canNombres;
	}

	public Integer getCanSexo() {
		return this.canSexo;
	}

	public void setCanSexo(Integer canSexo) {
		this.canSexo = canSexo;
	}

	public Integer getCanTipoIdentificacion() {
		return this.canTipoIdentificacion;
	}

	public void setCanTipoIdentificacion(Integer canTipoIdentificacion) {
		this.canTipoIdentificacion = canTipoIdentificacion;
	}

	public List<ExperienciaDTO> getBemExperiencias() {
		return this.bemExperiencias;
	}

	public void setBemExperiencias(List<ExperienciaDTO> bemExperiencias) {
		this.bemExperiencias = bemExperiencias;
	}

	public ExperienciaDTO addBemExperiencia(ExperienciaDTO bemExperiencia) {
		getBemExperiencias().add(bemExperiencia);
		bemExperiencia.setBemCandidato(this);

		return bemExperiencia;
	}

	public ExperienciaDTO removeBemExperiencia(ExperienciaDTO bemExperiencia) {
		getBemExperiencias().remove(bemExperiencia);
		bemExperiencia.setBemCandidato(null);

		return bemExperiencia;
	}

	public List<HabilidadDTO> getBemHabilidads() {
		return this.bemHabilidads;
	}

	public void setBemHabilidads(List<HabilidadDTO> bemHabilidads) {
		this.bemHabilidads = bemHabilidads;
	}

	public HabilidadDTO addBemHabilidad(HabilidadDTO bemHabilidad) {
		getBemHabilidads().add(bemHabilidad);
		bemHabilidad.setBemCandidato(this);

		return bemHabilidad;
	}

	public HabilidadDTO removeBemHabilidad(HabilidadDTO bemHabilidad) {
		getBemHabilidads().remove(bemHabilidad);
		bemHabilidad.setBemCandidato(null);

		return bemHabilidad;
	}

	public List<ImagenCandidatoDTO> getBemImagenCandidatos() {
		return this.bemImagenCandidatos;
	}

	public void setBemImagenCandidatos(List<ImagenCandidatoDTO> bemImagenCandidatos) {
		this.bemImagenCandidatos = bemImagenCandidatos;
	}

	public ImagenCandidatoDTO addBemImagenCandidato(ImagenCandidatoDTO bemImagenCandidato) {
		getBemImagenCandidatos().add(bemImagenCandidato);
		bemImagenCandidato.setBemCandidato(this);

		return bemImagenCandidato;
	}

	public ImagenCandidatoDTO removeBemImagenCandidato(ImagenCandidatoDTO bemImagenCandidato) {
		getBemImagenCandidatos().remove(bemImagenCandidato);
		bemImagenCandidato.setBemCandidato(null);

		return bemImagenCandidato;
	}

	public List<PostulacionDTO> getBemPostulacions() {
		return this.bemPostulacions;
	}

	public void setBemPostulacions(List<PostulacionDTO> bemPostulacions) {
		this.bemPostulacions = bemPostulacions;
	}

	public PostulacionDTO addBemPostulacion(PostulacionDTO bemPostulacion) {
		getBemPostulacions().add(bemPostulacion);
		bemPostulacion.setBemCandidato(this);

		return bemPostulacion;
	}

	public PostulacionDTO removeBemPostulacion(PostulacionDTO bemPostulacion) {
		getBemPostulacions().remove(bemPostulacion);
		bemPostulacion.setBemCandidato(null);

		return bemPostulacion;
	}

	public List<ReferenciaDTO> getBemReferencias() {
		return this.bemReferencias;
	}

	public void setBemReferencias(List<ReferenciaDTO> bemReferencias) {
		this.bemReferencias = bemReferencias;
	}

	public ReferenciaDTO addBemReferencia(ReferenciaDTO bemReferencia) {
		getBemReferencias().add(bemReferencia);
		bemReferencia.setBemCandidato(this);

		return bemReferencia;
	}

	public ReferenciaDTO removeBemReferencia(ReferenciaDTO bemReferencia) {
		getBemReferencias().remove(bemReferencia);
		bemReferencia.setBemCandidato(null);

		return bemReferencia;
	}

	public List<ResultadoDTO> getCueResultados() {
		return this.cueResultados;
	}

	public void setCueResultados(List<ResultadoDTO> cueResultados) {
		this.cueResultados = cueResultados;
	}

	public ResultadoDTO addCueResultado(ResultadoDTO cueResultado) {
		getCueResultados().add(cueResultado);
		cueResultado.setBemCandidato(this);

		return cueResultado;
	}

	public ResultadoDTO removeCueResultado(ResultadoDTO cueResultado) {
		getCueResultados().remove(cueResultado);
		cueResultado.setBemCandidato(null);

		return cueResultado;
	}

}