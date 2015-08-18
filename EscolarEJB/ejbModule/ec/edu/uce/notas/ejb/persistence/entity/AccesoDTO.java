package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_acceso database table.
 * 
 */
@Entity
@Table(name="seg_acceso")
@NamedQuery(name="AccesoDTO.findAll", query="SELECT a FROM AccesoDTO a")
public class AccesoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_ACCESO_ACCCODIGO_GENERATOR", sequenceName="SEG_ACCESO_ACC_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_ACCESO_ACCCODIGO_GENERATOR")
	@Column(name="acc_codigo")
	private Integer accCodigo;

	//bi-directional many-to-one association to ComponenteMenuDTO
	@ManyToOne
	@JoinColumn(name="acc_componente_menu")
	private ComponenteMenuDTO segComponenteMenu;

	//bi-directional many-to-one association to PerfilDTO
	@ManyToOne
	@JoinColumn(name="acc_perfil")
	private PerfilDTO segPerfil;

	public AccesoDTO() {
	}

	public Integer getAccCodigo() {
		return this.accCodigo;
	}

	public void setAccCodigo(Integer accCodigo) {
		this.accCodigo = accCodigo;
	}

	public ComponenteMenuDTO getSegComponenteMenu() {
		return this.segComponenteMenu;
	}

	public void setSegComponenteMenu(ComponenteMenuDTO segComponenteMenu) {
		this.segComponenteMenu = segComponenteMenu;
	}

	public PerfilDTO getSegPerfil() {
		return this.segPerfil;
	}

	public void setSegPerfil(PerfilDTO segPerfil) {
		this.segPerfil = segPerfil;
	}

}