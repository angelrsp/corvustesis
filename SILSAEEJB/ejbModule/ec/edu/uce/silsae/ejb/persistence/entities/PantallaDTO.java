package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_pantalla database table.
 * 
 */
@Entity
@Table(name="bem_pantalla")
public class PantallaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_PANTALLA_PANCODIGO_GENERATOR", sequenceName="BEM_PANTALLA_PAN_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_PANTALLA_PANCODIGO_GENERATOR")
	@Column(name="pan_codigo")
	private Integer panCodigo;

	@Column(name="pan_descripcion")
	private String panDescripcion;

	@Column(name="pan_on_click")
	private String panOnClick;

	@Column(name="pan_orden")
	private Integer panOrden;

	@Column(name="pan_padre")
	private Integer panPadre;

	@Column(name="pan_url")
	private String panUrl;

	//bi-directional many-to-one association to ModuloDTO
    @ManyToOne
	@JoinColumn(name="pan_modulo")
	private ModuloDTO bemModulo;

	//bi-directional many-to-one association to PerfilPermisoDTO
	@OneToMany(mappedBy="bemPantalla")
	private List<PerfilPermisoDTO> bemPerfilPermisos;

    public PantallaDTO() {
    }

	public Integer getPanCodigo() {
		return this.panCodigo;
	}

	public void setPanCodigo(Integer panCodigo) {
		this.panCodigo = panCodigo;
	}

	public String getPanDescripcion() {
		return this.panDescripcion;
	}

	public void setPanDescripcion(String panDescripcion) {
		this.panDescripcion = panDescripcion;
	}

	public String getPanOnClick() {
		return this.panOnClick;
	}

	public void setPanOnClick(String panOnClick) {
		this.panOnClick = panOnClick;
	}

	public Integer getPanOrden() {
		return this.panOrden;
	}

	public void setPanOrden(Integer panOrden) {
		this.panOrden = panOrden;
	}

	public Integer getPanPadre() {
		return this.panPadre;
	}

	public void setPanPadre(Integer panPadre) {
		this.panPadre = panPadre;
	}

	public String getPanUrl() {
		return this.panUrl;
	}

	public void setPanUrl(String panUrl) {
		this.panUrl = panUrl;
	}

	public ModuloDTO getBemModulo() {
		return this.bemModulo;
	}

	public void setBemModulo(ModuloDTO bemModulo) {
		this.bemModulo = bemModulo;
	}
	
	public List<PerfilPermisoDTO> getBemPerfilPermisos() {
		return this.bemPerfilPermisos;
	}

	public void setBemPerfilPermisos(List<PerfilPermisoDTO> bemPerfilPermisos) {
		this.bemPerfilPermisos = bemPerfilPermisos;
	}
	
}