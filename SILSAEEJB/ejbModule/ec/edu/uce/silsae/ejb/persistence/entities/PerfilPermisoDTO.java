package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_perfil_permiso database table.
 * 
 */
@Entity
@Table(name="bem_perfil_permiso")
public class PerfilPermisoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_PERFIL_PERMISO_PPECODIGO_GENERATOR", sequenceName="BEM_PERFIL_PERMISO_PPE_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_PERFIL_PERMISO_PPECODIGO_GENERATOR")
	@Column(name="ppe_codigo")
	private Integer ppeCodigo;

	//bi-directional many-to-one association to PantallaDTO
    @ManyToOne
	@JoinColumn(name="ppe_pantalla")
	private PantallaDTO bemPantalla;

	//bi-directional many-to-one association to PerfilDTO
    @ManyToOne
	@JoinColumn(name="ppe_perfil")
	private PerfilDTO bemPerfil;

    public PerfilPermisoDTO() {
    }

	public Integer getPpeCodigo() {
		return this.ppeCodigo;
	}

	public void setPpeCodigo(Integer ppeCodigo) {
		this.ppeCodigo = ppeCodigo;
	}

	public PantallaDTO getBemPantalla() {
		return this.bemPantalla;
	}

	public void setBemPantalla(PantallaDTO bemPantalla) {
		this.bemPantalla = bemPantalla;
	}
	
	public PerfilDTO getBemPerfil() {
		return this.bemPerfil;
	}

	public void setBemPerfil(PerfilDTO bemPerfil) {
		this.bemPerfil = bemPerfil;
	}
	
}