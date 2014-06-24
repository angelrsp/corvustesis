package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_menu_vie database table.
 * 
 */
@Entity
@Table(name="seg_menu_vie")
@NamedQuery(name="MenuVieDTO.findAll", query="SELECT m FROM MenuVieDTO m")
public class MenuVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="acc_codigo")
	private Integer accCodigo;

	@Column(name="acc_componente_menu")
	private Integer accComponenteMenu;

	@Column(name="acc_perfil")
	private Integer accPerfil;

	@Column(name="cme_codigo")
	private Integer cmeCodigo;

	@Column(name="cme_componente")
	private Integer cmeComponente;

	@Column(name="cme_menu")
	private Integer cmeMenu;

	@Column(name="men_codigo")
	private Integer menCodigo;

	@Column(name="men_descripcion")
	private String menDescripcion;

	@Column(name="men_icono")
	private String menIcono;

	@Column(name="men_nombre")
	private String menNombre;

	@Column(name="men_orden")
	private Integer menOrden;

	@Column(name="men_predecesor")
	private Integer menPredecesor;

	@Column(name="men_url")
	private String menUrl;

	public MenuVieDTO() {
	}

	public Integer getAccCodigo() {
		return this.accCodigo;
	}

	public void setAccCodigo(Integer accCodigo) {
		this.accCodigo = accCodigo;
	}

	public Integer getAccComponenteMenu() {
		return this.accComponenteMenu;
	}

	public void setAccComponenteMenu(Integer accComponenteMenu) {
		this.accComponenteMenu = accComponenteMenu;
	}

	public Integer getAccPerfil() {
		return this.accPerfil;
	}

	public void setAccPerfil(Integer accPerfil) {
		this.accPerfil = accPerfil;
	}

	public Integer getCmeCodigo() {
		return this.cmeCodigo;
	}

	public void setCmeCodigo(Integer cmeCodigo) {
		this.cmeCodigo = cmeCodigo;
	}

	public Integer getCmeComponente() {
		return this.cmeComponente;
	}

	public void setCmeComponente(Integer cmeComponente) {
		this.cmeComponente = cmeComponente;
	}

	public Integer getCmeMenu() {
		return this.cmeMenu;
	}

	public void setCmeMenu(Integer cmeMenu) {
		this.cmeMenu = cmeMenu;
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

	public Integer getMenOrden() {
		return this.menOrden;
	}

	public void setMenOrden(Integer menOrden) {
		this.menOrden = menOrden;
	}

	public Integer getMenPredecesor() {
		return this.menPredecesor;
	}

	public void setMenPredecesor(Integer menPredecesor) {
		this.menPredecesor = menPredecesor;
	}

	public String getMenUrl() {
		return this.menUrl;
	}

	public void setMenUrl(String menUrl) {
		this.menUrl = menUrl;
	}

}