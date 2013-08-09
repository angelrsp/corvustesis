package ec.edu.uce.erpmunicipal.sistema.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_pantalla database table.
 * 
 */
@Entity
@Table(name="sis_pantalla")
public class SisPantalla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_PANTALLA_PANCODIGO_GENERATOR", sequenceName="sis_pantalla_pan_codigo_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_PANTALLA_PANCODIGO_GENERATOR")
	@Column(name="pan_codigo")
	private Integer panCodigo;

	@Column(name="pan_descripcion")
	private String panDescripcion;

	@Column(name="pan_orden")
	private Integer panOrden;

	@Column(name="pan_padre")
	private Integer panPadre;

	@Column(name="pan_url")
	private String panUrl;

	//bi-directional many-to-one association to SisModulo
	@ManyToOne
	@JoinColumn(name="pan_modulo")
	private SisModulo sisModulo;

	//bi-directional many-to-one association to SisRolPermiso
	@OneToMany(mappedBy="sisPantalla")
	private List<SisRolPermiso> sisRolPermisos;

	public SisPantalla() {
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

	public SisModulo getSisModulo() {
		return this.sisModulo;
	}

	public void setSisModulo(SisModulo sisModulo) {
		this.sisModulo = sisModulo;
	}

	public List<SisRolPermiso> getSisRolPermisos() {
		return this.sisRolPermisos;
	}

	public void setSisRolPermisos(List<SisRolPermiso> sisRolPermisos) {
		this.sisRolPermisos = sisRolPermisos;
	}

}