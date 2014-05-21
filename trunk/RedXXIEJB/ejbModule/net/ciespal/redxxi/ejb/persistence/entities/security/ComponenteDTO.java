package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_componente database table.
 * 
 */
@Entity
@Table(name="seg_componente")
@NamedQuery(name="ComponenteDTO.findAll", query="SELECT c FROM ComponenteDTO c")
public class ComponenteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_COMPONENTE_COMCODIGO_GENERATOR", sequenceName="SEG_COMPONENTE_COM_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_COMPONENTE_COMCODIGO_GENERATOR")
	@Column(name="com_codigo")
	private Integer comCodigo;

	@Column(name="com_descripcion")
	private String comDescripcion;

	//bi-directional many-to-one association to ComponenteMenuDTO
	@OneToMany(mappedBy="segComponente")
	private List<ComponenteMenuDTO> segComponenteMenus;

	public ComponenteDTO() {
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

	public List<ComponenteMenuDTO> getSegComponenteMenus() {
		return this.segComponenteMenus;
	}

	public void setSegComponenteMenus(List<ComponenteMenuDTO> segComponenteMenus) {
		this.segComponenteMenus = segComponenteMenus;
	}

	public ComponenteMenuDTO addSegComponenteMenus(ComponenteMenuDTO segComponenteMenus) {
		getSegComponenteMenus().add(segComponenteMenus);
		segComponenteMenus.setSegComponente(this);

		return segComponenteMenus;
	}

	public ComponenteMenuDTO removeSegComponenteMenus(ComponenteMenuDTO segComponenteMenus) {
		getSegComponenteMenus().remove(segComponenteMenus);
		segComponenteMenus.setSegComponente(null);

		return segComponenteMenus;
	}

}