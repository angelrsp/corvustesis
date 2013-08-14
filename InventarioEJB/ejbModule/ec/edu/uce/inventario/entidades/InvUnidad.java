package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inv_unidad database table.
 * 
 */
@Entity
@Table(name="inv_unidad")
@NamedQuery(name="InvUnidad.findAll", query="SELECT i FROM InvUnidad i")
public class InvUnidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INV_UNIDAD_UNICODIGO_GENERATOR", sequenceName="INV_UNIDAD_UNI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INV_UNIDAD_UNICODIGO_GENERATOR")
	@Column(name="uni_codigo")
	private Integer uniCodigo;

	@Column(name="uni_descripcion")
	private String uniDescripcion;

	//bi-directional many-to-one association to InvArticulo
	@OneToMany(mappedBy="invUnidad",fetch=FetchType.EAGER)
	private List<InvArticulo> invArticulos;

	public InvUnidad() {
	}

	public Integer getUniCodigo() {
		return this.uniCodigo;
	}

	public void setUniCodigo(Integer uniCodigo) {
		this.uniCodigo = uniCodigo;
	}

	public String getUniDescripcion() {
		return this.uniDescripcion;
	}

	public void setUniDescripcion(String uniDescripcion) {
		this.uniDescripcion = uniDescripcion;
	}

	public List<InvArticulo> getInvArticulos() {
		return this.invArticulos;
	}

	public void setInvArticulos(List<InvArticulo> invArticulos) {
		this.invArticulos = invArticulos;
	}

	public InvArticulo addInvArticulo(InvArticulo invArticulo) {
		getInvArticulos().add(invArticulo);
		invArticulo.setInvUnidad(this);

		return invArticulo;
	}

	public InvArticulo removeInvArticulo(InvArticulo invArticulo) {
		getInvArticulos().remove(invArticulo);
		invArticulo.setInvUnidad(null);

		return invArticulo;
	}

}