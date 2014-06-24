package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_acceso_vie database table.
 * 
 */
@Entity
@Table(name="seg_acceso_vie")
@NamedQuery(name="AccesoVieDTO.findAll", query="SELECT a FROM AccesoVieDTO a")
public class AccesoVieDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="acc_codigo")
	private Integer accCodigo;

	@Column(name="acc_componente_menu")
	private Integer accComponenteMenu;

	@Column(name="acc_perfil")
	private Integer accPerfil;

	@Id
	@Column(name="cme_codigo")
	private Integer cmeCodigo;

	@Column(name="cme_componente")
	private Integer cmeComponente;

	@Column(name="cme_menu")
	private Integer cmeMenu;

	@Column(name="com_codigo")
	private Integer comCodigo;

	@Column(name="com_descripcion")
	private String comDescripcion;

	public AccesoVieDTO() {
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

	public Integer getComCodigo() {
		return this.comCodigo;
	}

	public void setComCodigo(Integer comCodigo) {
		this.comCodigo = comCodigo;
	}

	public String getComDescripcion() {
		return this.comDescripcion;
	}

	public void setComDescripcion(String comDescripcion) {
		this.comDescripcion = comDescripcion;
	}

}