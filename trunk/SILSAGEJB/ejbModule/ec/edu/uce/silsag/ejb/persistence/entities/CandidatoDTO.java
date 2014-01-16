package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


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

	@Column(name="can_apellido_materno")
	private String canApellidoMaterno;

	@Column(name="can_apellido_paterno")
	private String canApellidoPaterno;

	@Column(name="can_estado_civil")
	private Integer canEstadoCivil;

	@Column(name="can_estado_estudio")
	private Integer canEstadoEstudio;

	@Column(name="can_fecha_nacimiento")
	private Timestamp canFechaNacimiento;

	@Column(name="can_fecha_ultima")
	private Timestamp canFechaUltima;

	@Column(name="can_foto")
	private byte[] canFoto;

	@Column(name="can_identificacion")
	private String canIdentificacion;

	@Column(name="can_lugar_nacimiento")
	private String canLugarNacimiento;

	@Column(name="can_max_estudio")
	private Integer canMaxEstudio;

	@Column(name="can_primer_nombre")
	private String canPrimerNombre;

	@Column(name="can_segundo_nombre")
	private String canSegundoNombre;

	@Column(name="can_sexo")
	private Integer canSexo;

	@Column(name="can_tipo_identificacion")
	private Integer canTipoIdentificacion;

	//bi-directional many-to-one association to AdicionalDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<AdicionalDTO> bemAdicionals;

	//bi-directional many-to-one association to UsuarioDTO
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="can_usuario")
	private UsuarioDTO bemUsuario;

	//bi-directional many-to-one association to CursoDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<CursoDTO> bemCursos;

	//bi-directional many-to-one association to EstudioDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<EstudioDTO> bemEstudios;

	//bi-directional many-to-one association to ExperienciaDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<ExperienciaDTO> bemExperiencias;

	//bi-directional many-to-one association to PostulacionDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<PostulacionDTO> bemPostulacions;

	//bi-directional many-to-one association to ReferenciaDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<ReferenciaDTO> bemReferencias;

	//bi-directional many-to-one association to ResultadoDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<ResultadoDTO> bemResultados;

	public CandidatoDTO() {
	}

	public Integer getCanCodigo() {
		return this.canCodigo;
	}

	public void setCanCodigo(Integer canCodigo) {
		this.canCodigo = canCodigo;
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

	public Timestamp getCanFechaNacimiento() {
		return this.canFechaNacimiento;
	}

	public void setCanFechaNacimiento(Timestamp canFechaNacimiento) {
		this.canFechaNacimiento = canFechaNacimiento;
	}

	public Timestamp getCanFechaUltima() {
		return this.canFechaUltima;
	}

	public void setCanFechaUltima(Timestamp canFechaUltima) {
		this.canFechaUltima = canFechaUltima;
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

	public Integer getCanMaxEstudio() {
		return this.canMaxEstudio;
	}

	public void setCanMaxEstudio(Integer canMaxEstudio) {
		this.canMaxEstudio = canMaxEstudio;
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

	public List<AdicionalDTO> getBemAdicionals() {
		return this.bemAdicionals;
	}

	public void setBemAdicionals(List<AdicionalDTO> bemAdicionals) {
		this.bemAdicionals = bemAdicionals;
	}

	public AdicionalDTO addBemAdicional(AdicionalDTO bemAdicional) {
		getBemAdicionals().add(bemAdicional);
		bemAdicional.setBemCandidato(this);

		return bemAdicional;
	}

	public AdicionalDTO removeBemAdicional(AdicionalDTO bemAdicional) {
		getBemAdicionals().remove(bemAdicional);
		bemAdicional.setBemCandidato(null);

		return bemAdicional;
	}

	public UsuarioDTO getBemUsuario() {
		return this.bemUsuario;
	}

	public void setBemUsuario(UsuarioDTO bemUsuario) {
		this.bemUsuario = bemUsuario;
	}

	public List<CursoDTO> getBemCursos() {
		return this.bemCursos;
	}

	public void setBemCursos(List<CursoDTO> bemCursos) {
		this.bemCursos = bemCursos;
	}

	public CursoDTO addBemCurso(CursoDTO bemCurso) {
		getBemCursos().add(bemCurso);
		bemCurso.setBemCandidato(this);

		return bemCurso;
	}

	public CursoDTO removeBemCurso(CursoDTO bemCurso) {
		getBemCursos().remove(bemCurso);
		bemCurso.setBemCandidato(null);

		return bemCurso;
	}

	public List<EstudioDTO> getBemEstudios() {
		return this.bemEstudios;
	}

	public void setBemEstudios(List<EstudioDTO> bemEstudios) {
		this.bemEstudios = bemEstudios;
	}

	public EstudioDTO addBemEstudio(EstudioDTO bemEstudio) {
		getBemEstudios().add(bemEstudio);
		bemEstudio.setBemCandidato(this);

		return bemEstudio;
	}

	public EstudioDTO removeBemEstudio(EstudioDTO bemEstudio) {
		getBemEstudios().remove(bemEstudio);
		bemEstudio.setBemCandidato(null);

		return bemEstudio;
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

	public List<ResultadoDTO> getBemResultados() {
		return this.bemResultados;
	}

	public void setBemResultados(List<ResultadoDTO> bemResultados) {
		this.bemResultados = bemResultados;
	}

	public ResultadoDTO addBemResultado(ResultadoDTO bemResultado) {
		getBemResultados().add(bemResultado);
		bemResultado.setBemCandidato(this);

		return bemResultado;
	}

	public ResultadoDTO removeBemResultado(ResultadoDTO bemResultado) {
		getBemResultados().remove(bemResultado);
		bemResultado.setBemCandidato(null);

		return bemResultado;
	}

}