package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_usuario database table.
 * 
 */
@Entity
@Table(name="bem_usuario")
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_USUARIO_USUCODIGO_GENERATOR", sequenceName="BEM_USUARIO_USU_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_USUARIO_USUCODIGO_GENERATOR")
	@Column(name="usu_codigo")
	private Integer usuCodigo;

	@Column(name="usu_celular")
	private String usuCelular;

	@Column(name="usu_direccion")
	private String usuDireccion;

	@Column(name="usu_mail")
	private String usuMail;

	@Column(name="usu_password")
	private String usuPassword;

	@Column(name="usu_telefono")
	private String usuTelefono;

	//bi-directional many-to-one association to CandidatoDTO
	@OneToMany(mappedBy="bemUsuario")
	private List<CandidatoDTO> bemCandidatos;

	//bi-directional many-to-one association to EmpresaDTO
	@OneToMany(mappedBy="bemUsuario")
	private List<EmpresaDTO> bemEmpresas;

	//bi-directional many-to-one association to PerfilDTO
    @ManyToOne
	@JoinColumn(name="usu_perfil")
	private PerfilDTO bemPerfil;
    
    @Transient
    private String npUsuPassword;

    public UsuarioDTO() {
    }

	public Integer getUsuCodigo() {
		return this.usuCodigo;
	}

	public void setUsuCodigo(Integer usuCodigo) {
		this.usuCodigo = usuCodigo;
	}

	public String getUsuCelular() {
		return this.usuCelular;
	}

	public void setUsuCelular(String usuCelular) {
		this.usuCelular = usuCelular;
	}

	public String getUsuDireccion() {
		return this.usuDireccion;
	}

	public void setUsuDireccion(String usuDireccion) {
		this.usuDireccion = usuDireccion;
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

	public String getUsuTelefono() {
		return this.usuTelefono;
	}

	public void setUsuTelefono(String usuTelefono) {
		this.usuTelefono = usuTelefono;
	}

	public List<CandidatoDTO> getBemCandidatos() {
		return this.bemCandidatos;
	}

	public void setBemCandidatos(List<CandidatoDTO> bemCandidatos) {
		this.bemCandidatos = bemCandidatos;
	}
	
	public List<EmpresaDTO> getBemEmpresas() {
		return this.bemEmpresas;
	}

	public void setBemEmpresas(List<EmpresaDTO> bemEmpresas) {
		this.bemEmpresas = bemEmpresas;
	}
	
	public PerfilDTO getBemPerfil() {
		return this.bemPerfil;
	}

	public void setBemPerfil(PerfilDTO bemPerfil) {
		this.bemPerfil = bemPerfil;
	}

	public String getNpUsuPassword() {
		return npUsuPassword;
	}

	public void setNpUsuPassword(String npUsuPassword) {
		this.npUsuPassword = npUsuPassword;
	}
	
}