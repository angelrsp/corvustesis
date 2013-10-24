package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_candidato database table.
 * 
 */
@Entity
@Table(name="bem_candidato")
public class CandidatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_CANDIDATO_CANCODIGO_GENERATOR", sequenceName="BEM_CANDIDATO_CAN_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_CANDIDATO_CANCODIGO_GENERATOR")
	@Column(name="can_codigo")
	private Integer canCodigo;

	@Column(name="can_apellidos")
	private String canApellidos;

	@Column(name="can_identificacion")
	private String canIdentificacion;

	@Column(name="can_nombres")
	private String canNombres;

	//bi-directional many-to-one association to UsuarioDTO
    @ManyToOne
	@JoinColumn(name="can_usuario")
	private UsuarioDTO bemUsuario;

	//bi-directional many-to-one association to PostulacionDTO
	@OneToMany(mappedBy="bemCandidato")
	private List<PostulacionDTO> bemPostulacions;

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

	public String getCanIdentificacion() {
		return this.canIdentificacion;
	}

	public void setCanIdentificacion(String canIdentificacion) {
		this.canIdentificacion = canIdentificacion;
	}

	public String getCanNombres() {
		return this.canNombres;
	}

	public void setCanNombres(String canNombres) {
		this.canNombres = canNombres;
	}

	public UsuarioDTO getBemUsuario() {
		return this.bemUsuario;
	}

	public void setBemUsuario(UsuarioDTO bemUsuario) {
		this.bemUsuario = bemUsuario;
	}
	
	public List<PostulacionDTO> getBemPostulacions() {
		return this.bemPostulacions;
	}

	public void setBemPostulacions(List<PostulacionDTO> bemPostulacions) {
		this.bemPostulacions = bemPostulacions;
	}
	
}