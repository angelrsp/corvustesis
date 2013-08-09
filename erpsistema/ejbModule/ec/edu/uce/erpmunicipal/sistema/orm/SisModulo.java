package ec.edu.uce.erpmunicipal.sistema.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_modulo database table.
 * 
 */
@Entity
@Table(name="sis_modulo")
public class SisModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_MODULO_MODCODIGO_GENERATOR", sequenceName="sis_modulo_mod_codigo_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_MODULO_MODCODIGO_GENERATOR")
	@Column(name="mod_codigo")
	private Integer modCodigo;

	@Column(name="mod_descripcion")
	private String modDescripcion;

	//bi-directional many-to-one association to SisPantalla
	@OneToMany(mappedBy="sisModulo")
	private List<SisPantalla> sisPantallas;

	public SisModulo() {
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

	public List<SisPantalla> getSisPantallas() {
		return this.sisPantallas;
	}

	public void setSisPantallas(List<SisPantalla> sisPantallas) {
		this.sisPantallas = sisPantallas;
	}

}