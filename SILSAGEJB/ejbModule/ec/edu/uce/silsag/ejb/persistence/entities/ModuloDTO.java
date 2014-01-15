package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_modulo database table.
 * 
 */
@Entity
@Table(name="bem_modulo")
public class ModuloDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_MODULO_MODCODIGO_GENERATOR", sequenceName="BEM_MODULO_MOD_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_MODULO_MODCODIGO_GENERATOR")
	@Column(name="mod_codigo")
	private Integer modCodigo;

	@Column(name="mod_descripcion")
	private String modDescripcion;

	//bi-directional many-to-one association to PantallaDTO
	@OneToMany(mappedBy="bemModulo")
	private List<PantallaDTO> bemPantallas;

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

	public List<PantallaDTO> getBemPantallas() {
		return this.bemPantallas;
	}

	public void setBemPantallas(List<PantallaDTO> bemPantallas) {
		this.bemPantallas = bemPantallas;
	}
	
}