package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_menu database table.
 * 
 */
@Entity
@Table(name="seg_menu")
@NamedQuery(name="MenuDTO.findAll", query="SELECT m FROM MenuDTO m")
public class MenuDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_MENU_MENCODIGO_GENERATOR", sequenceName="SEG_MENU_MEN_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_MENU_MENCODIGO_GENERATOR")
	@Column(name="men_codigo")
	private Integer menCodigo;

	@Column(name="men_descripcion")
	private String menDescripcion;

	@Column(name="men_icono")
	private String menIcono;

	@Column(name="men_nombre")
	private String menNombre;

	@Column(name="men_url")
	private String menUrl;

	//bi-directional many-to-one association to ComponenteMenuDTO
	@OneToMany(mappedBy="segMenu")
	private List<ComponenteMenuDTO> segComponenteMenus;

	public MenuDTO() {
	}

	public Integer getMenCodigo() {
		return this.menCodigo;
	}

	public void setMenCodigo(Integer menCodigo) {
		this.menCodigo = menCodigo;
	}

	public String getMenDescripcion() {
		return this.menDescripcion;
	}

	public void setMenDescripcion(String menDescripcion) {
		this.menDescripcion = menDescripcion;
	}

	public String getMenIcono() {
		return this.menIcono;
	}

	public void setMenIcono(String menIcono) {
		this.menIcono = menIcono;
	}

	public String getMenNombre() {
		return this.menNombre;
	}

	public void setMenNombre(String menNombre) {
		this.menNombre = menNombre;
	}

	public String getMenUrl() {
		return this.menUrl;
	}

	public void setMenUrl(String menUrl) {
		this.menUrl = menUrl;
	}

	public List<ComponenteMenuDTO> getSegComponenteMenus() {
		return this.segComponenteMenus;
	}

	public void setSegComponenteMenus(List<ComponenteMenuDTO> segComponenteMenus) {
		this.segComponenteMenus = segComponenteMenus;
	}

	public ComponenteMenuDTO addSegComponenteMenus(ComponenteMenuDTO segComponenteMenus) {
		getSegComponenteMenus().add(segComponenteMenus);
		segComponenteMenus.setSegMenu(this);

		return segComponenteMenus;
	}

	public ComponenteMenuDTO removeSegComponenteMenus(ComponenteMenuDTO segComponenteMenus) {
		getSegComponenteMenus().remove(segComponenteMenus);
		segComponenteMenus.setSegMenu(null);

		return segComponenteMenus;
	}

}