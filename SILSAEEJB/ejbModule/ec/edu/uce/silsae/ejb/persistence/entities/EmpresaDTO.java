package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_empresa database table.
 * 
 */
@Entity
@Table(name="bem_empresa")
public class EmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_EMPRESA_EMPCODIGO_GENERATOR", sequenceName="BEM_EMPRESA_EMP_CODIGO_SEQ", allocationSize=1)
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

	@Column(name="emp_ubicacion")
	private String empUbicacion;

	@Column(name="emp_web")
	private String empWeb;

	@Column(name="emp_activa")
	private Boolean empActiva;

	//bi-directional many-to-one association to AvisoDTO
	@OneToMany(mappedBy="bemEmpresa")
	private List<AvisoDTO> bemAvisos;

	//bi-directional many-to-one association to UsuarioDTO
    @ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="emp_usuario")
	private UsuarioDTO bemUsuario;

	//bi-directional many-to-one association to ContactoDTO
    @OneToMany(mappedBy="bemEmpresa")
	private List<ContactoDTO> bemContactos;

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

	public String getEmpUbicacion() {
		return this.empUbicacion;
	}

	public void setEmpUbicacion(String empUbicacion) {
		this.empUbicacion = empUbicacion;
	}

	public String getEmpWeb() {
		return this.empWeb;
	}

	public void setEmpWeb(String empWeb) {
		this.empWeb = empWeb;
	}

	public Boolean getEmpActiva() {
		return empActiva;
	}

	public void setEmpActiva(Boolean empActiva) {
		this.empActiva = empActiva;
	}

	public List<AvisoDTO> getBemAvisos() {
		return this.bemAvisos;
	}

	public void setBemAvisos(List<AvisoDTO> bemAvisos) {
		this.bemAvisos = bemAvisos;
	}
	
	public UsuarioDTO getBemUsuario() {
		return this.bemUsuario;
	}

	public void setBemUsuario(UsuarioDTO bemUsuario) {
		this.bemUsuario = bemUsuario;
	}
	
	public List<ContactoDTO> getBemContactos() {
		return bemContactos;
	}

	public void setBemContactos(List<ContactoDTO> bemContactos) {
		this.bemContactos = bemContactos;
	}
	
}