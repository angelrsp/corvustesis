package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_modulo database table.
 * 
 */
@Entity
@Table(name="seg_modulo")
@NamedQuery(name="ModuloDTO.findAll", query="SELECT m FROM ModuloDTO m")
public class ModuloDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_MODULO_MODCODIGO_GENERATOR", sequenceName="SEG_MODULO_MOD_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_MODULO_MODCODIGO_GENERATOR")
	@Column(name="mod_codigo")
	private Integer modCodigo;

	@Column(name="mod_descripcion")
	private String modDescripcion;

	//bi-directional many-to-one association to MenuDTO
	@OneToMany(mappedBy="segModulo")
	private List<MenuDTO> segMenus;

	public ModuloDTO() {
	}

	public Integer getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Integer modCodigo) {
		this.modCodigo = modCodigo;
	}

	public String getModDescripcion() {
		return this.modDescripcion;
	}

	public void setModDescripcion(String modDescripcion) {
		this.modDescripcion = modDescripcion;
	}

	public List<MenuDTO> getSegMenus() {
		return this.segMenus;
	}

	public void setSegMenus(List<MenuDTO> segMenus) {
		this.segMenus = segMenus;
	}

	public MenuDTO addSegMenus(MenuDTO segMenus) {
		getSegMenus().add(segMenus);
		segMenus.setSegModulo(this);

		return segMenus;
	}

	public MenuDTO removeSegMenus(MenuDTO segMenus) {
		getSegMenus().remove(segMenus);
		segMenus.setSegModulo(null);

		return segMenus;
	}

}