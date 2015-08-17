package ec.edu.uce.notas.ejb.persistence.entity.view;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_componente_menu_view database table.
 * 
 */
@Entity
@Table(name="seg_componente_menu_view")
@NamedQuery(name="ComponenteMenuViewDTO.findAll", query="SELECT c FROM ComponenteMenuViewDTO c")
public class ComponenteMenuViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public ComponenteMenuViewDTO() {
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