package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_componente_menu database table.
 * 
 */
@Entity
@Table(name="seg_componente_menu")
@NamedQuery(name="ComponenteMenuDTO.findAll", query="SELECT c FROM ComponenteMenuDTO c")
public class ComponenteMenuDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_COMPONENTE_MENU_CMECODIGO_GENERATOR", sequenceName="SEG_COMPONENTE_MENU_CME_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_COMPONENTE_MENU_CMECODIGO_GENERATOR")
	@Column(name="cme_codigo")
	private Integer cmeCodigo;

	//bi-directional many-to-one association to AccesoDTO
	@OneToMany(mappedBy="segComponenteMenu")
	private List<AccesoDTO> segAccesos;

	//bi-directional many-to-one association to ComponenteDTO
	@ManyToOne
	@JoinColumn(name="cme_componente")
	private ComponenteDTO segComponente;

	//bi-directional many-to-one association to MenuDTO
	@ManyToOne
	@JoinColumn(name="cme_menu")
	private MenuDTO segMenu;

	public ComponenteMenuDTO() {
	}

	public Integer getCmeCodigo() {
		return this.cmeCodigo;
	}

	public void setCmeCodigo(Integer cmeCodigo) {
		this.cmeCodigo = cmeCodigo;
	}

	public List<AccesoDTO> getSegAccesos() {
		return this.segAccesos;
	}

	public void setSegAccesos(List<AccesoDTO> segAccesos) {
		this.segAccesos = segAccesos;
	}

	public AccesoDTO addSegAcceso(AccesoDTO segAcceso) {
		getSegAccesos().add(segAcceso);
		segAcceso.setSegComponenteMenu(this);

		return segAcceso;
	}

	public AccesoDTO removeSegAcceso(AccesoDTO segAcceso) {
		getSegAccesos().remove(segAcceso);
		segAcceso.setSegComponenteMenu(null);

		return segAcceso;
	}

	public ComponenteDTO getSegComponente() {
		return this.segComponente;
	}

	public void setSegComponente(ComponenteDTO segComponente) {
		this.segComponente = segComponente;
	}

	public MenuDTO getSegMenu() {
		return this.segMenu;
	}

	public void setSegMenu(MenuDTO segMenu) {
		this.segMenu = segMenu;
	}

}