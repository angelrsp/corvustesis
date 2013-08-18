package ec.edu.uce.inventario.entidades;

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
	@SequenceGenerator(name="SIS_MODULO_MODCODIGO_GENERATOR", sequenceName="SIS_MODULO_MOD_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_MODULO_MODCODIGO_GENERATOR")
	@Column(name="mod_codigo")
	private Integer modCodigo;

	@Column(name="mod_descripcion")
	private String modDescripcion;

	//bi-directional many-to-one association to SisOpcion
	@OneToMany(mappedBy="sisModulo")
	private List<SisOpcion> sisOpcions;

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

	public List<SisOpcion> getSisOpcions() {
		return this.sisOpcions;
	}

	public void setSisOpcions(List<SisOpcion> sisOpcions) {
		this.sisOpcions = sisOpcions;
	}

	public SisOpcion addSisOpcion(SisOpcion sisOpcion) {
		getSisOpcions().add(sisOpcion);
		sisOpcion.setSisModulo(this);

		return sisOpcion;
	}

	public SisOpcion removeSisOpcion(SisOpcion sisOpcion) {
		getSisOpcions().remove(sisOpcion);
		sisOpcion.setSisModulo(null);

		return sisOpcion;
	}

}