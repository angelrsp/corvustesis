package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_clase database table.
 * 
 */
@Entity
@Table(name="inv_clase")
@NamedQuery(name="InvClase.findAll", query="SELECT i FROM InvClase i")
public class InvClase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INV_CLASE_CLACODIGO_GENERATOR", sequenceName="INV_CLASE_CLA_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INV_CLASE_CLACODIGO_GENERATOR")
	@Column(name="cla_codigo")
	private Integer claCodigo;

	@Column(name="cla_descripcion")
	private String claDescripcion;

	//bi-directional many-to-one association to InvKardex
	@OneToMany(mappedBy="invClase")
	private List<InvKardex> invKardexs;

	public InvClase() {
	}

	public Integer getClaCodigo() {
		return this.claCodigo;
	}

	public void setClaCodigo(Integer claCodigo) {
		this.claCodigo = claCodigo;
	}

	public String getClaDescripcion() {
		return this.claDescripcion;
	}

	public void setClaDescripcion(String claDescripcion) {
		this.claDescripcion = claDescripcion;
	}

	public List<InvKardex> getInvKardexs() {
		return this.invKardexs;
	}

	public void setInvKardexs(List<InvKardex> invKardexs) {
		this.invKardexs = invKardexs;
	}

	public InvKardex addInvKardex(InvKardex invKardex) {
		getInvKardexs().add(invKardex);
		invKardex.setInvClase(this);

		return invKardex;
	}

	public InvKardex removeInvKardex(InvKardex invKardex) {
		getInvKardexs().remove(invKardex);
		invKardex.setInvClase(null);

		return invKardex;
	}

}