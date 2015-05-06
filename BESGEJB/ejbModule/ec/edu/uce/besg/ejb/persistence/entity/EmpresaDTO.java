package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;

import javax.persistence.*;

import ec.edu.uce.besg.ejb.persistence.entity.security.UsuarioDTO;

import java.util.List;


/**
 * The persistent class for the bem_empresa database table.
 * 
 */
@Entity
@Table(name="bem_empresa")
@NamedQuery(name="EmpresaDTO.findAll", query="SELECT e FROM EmpresaDTO e")
public class EmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_EMPRESA_EMPCODIGO_GENERATOR", sequenceName="BEM_EMPRESA_EMP_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_EMPRESA_EMPCODIGO_GENERATOR")
	@Column(name="emp_codigo")
	private Integer empCodigo;

	@Column(name="emp_nombre_comercial")
	private String empNombreComercial;

	@Column(name="emp_razon_social")
	private String empRazonSocial;

	@Column(name="emp_ruc")
	private String empRuc;

	@Column(name="emp_sector")
	private Integer empSector;

	@Column(name="emp_ciudad")
	private Integer empCiudad;

	@Column(name="emp_provincia")
	private Integer empProvincia;

	@Column(name="emp_pais")
	private Integer empPais;

	@Column(name="emp_web")
	private String empWeb;

	
	//bi-directional many-to-one association to CandidatoDTO
	@ManyToOne
	@JoinColumn(name="emp_usuario")
	private UsuarioDTO segUsuario;
	
	//bi-directional many-to-one association to AvisoDTO
	@OneToMany(mappedBy="bemEmpresa")
	private List<AvisoDTO> bemAvisos;

	//bi-directional many-to-one association to ContactoDTO
	@OneToMany(mappedBy="bemEmpresa")
	private List<ContactoDTO> bemContactos;

	//bi-directional many-to-one association to ImagenEmpresaDTO
	@OneToMany(mappedBy="bemEmpresa")
	private List<ImagenEmpresaDTO> bemImagenEmpresas;

	public EmpresaDTO() {
	}

	public Integer getEmpCodigo() {
		return this.empCodigo;
	}

	public void setEmpCodigo(Integer empCodigo) {
		this.empCodigo = empCodigo;
	}

	public String getEmpNombreComercial() {
		return this.empNombreComercial;
	}

	public void setEmpNombreComercial(String empNombreComercial) {
		this.empNombreComercial = empNombreComercial;
	}

	public String getEmpRazonSocial() {
		return this.empRazonSocial;
	}

	public void setEmpRazonSocial(String empRazonSocial) {
		this.empRazonSocial = empRazonSocial;
	}

	public String getEmpRuc() {
		return this.empRuc;
	}

	public void setEmpRuc(String empRuc) {
		this.empRuc = empRuc;
	}

	public Integer getEmpSector() {
		return this.empSector;
	}

	public void setEmpSector(Integer empSector) {
		this.empSector = empSector;
	}

	public String getEmpWeb() {
		return this.empWeb;
	}

	public void setEmpWeb(String empWeb) {
		this.empWeb = empWeb;
	}

	public List<AvisoDTO> getBemAvisos() {
		return this.bemAvisos;
	}

	public void setBemAvisos(List<AvisoDTO> bemAvisos) {
		this.bemAvisos = bemAvisos;
	}

	public AvisoDTO addBemAviso(AvisoDTO bemAviso) {
		getBemAvisos().add(bemAviso);
		bemAviso.setBemEmpresa(this);

		return bemAviso;
	}

	public AvisoDTO removeBemAviso(AvisoDTO bemAviso) {
		getBemAvisos().remove(bemAviso);
		bemAviso.setBemEmpresa(null);

		return bemAviso;
	}

	public List<ContactoDTO> getBemContactos() {
		return this.bemContactos;
	}

	public void setBemContactos(List<ContactoDTO> bemContactos) {
		this.bemContactos = bemContactos;
	}

	public UsuarioDTO getSegUsuario() {
		return segUsuario;
	}

	public void setSegUsuario(UsuarioDTO segUsuario) {
		this.segUsuario = segUsuario;
	}
	
	
	public Integer getEmpCiudad() {
		return empCiudad;
	}

	public void setEmpCiudad(Integer empCiudad) {
		this.empCiudad = empCiudad;
	}

	public Integer getEmpProvincia() {
		return empProvincia;
	}

	public void setEmpProvincia(Integer empProvincia) {
		this.empProvincia = empProvincia;
	}

	public Integer getEmpPais() {
		return empPais;
	}

	public void setEmpPais(Integer empPais) {
		this.empPais = empPais;
	}

	public ContactoDTO addBemContacto(ContactoDTO bemContacto) {
		getBemContactos().add(bemContacto);
		bemContacto.setBemEmpresa(this);

		return bemContacto;
	}

	public ContactoDTO removeBemContacto(ContactoDTO bemContacto) {
		getBemContactos().remove(bemContacto);
		bemContacto.setBemEmpresa(null);

		return bemContacto;
	}

	public List<ImagenEmpresaDTO> getBemImagenEmpresas() {
		return this.bemImagenEmpresas;
	}

	public void setBemImagenEmpresas(List<ImagenEmpresaDTO> bemImagenEmpresas) {
		this.bemImagenEmpresas = bemImagenEmpresas;
	}

	public ImagenEmpresaDTO addBemImagenEmpresa(ImagenEmpresaDTO bemImagenEmpresa) {
		getBemImagenEmpresas().add(bemImagenEmpresa);
		bemImagenEmpresa.setBemEmpresa(this);

		return bemImagenEmpresa;
	}

	public ImagenEmpresaDTO removeBemImagenEmpresa(ImagenEmpresaDTO bemImagenEmpresa) {
		getBemImagenEmpresas().remove(bemImagenEmpresa);
		bemImagenEmpresa.setBemEmpresa(null);

		return bemImagenEmpresa;
	}

}