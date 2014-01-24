package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ind_catalogo database table.
 * 
 */
@Entity
@Table(name="ind_catalogo")
@NamedQuery(name="CatalogoDTO.findAll", query="SELECT c FROM CatalogoDTO c")
public class CatalogoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_CATALOGO_CATCODIGO_GENERATOR", sequenceName="IND_CATALOGO_CAT_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_CATALOGO_CATCODIGO_GENERATOR")
	@Column(name="cat_codigo")
	private Integer catCodigo;

	@Column(name="cat_descripcion")
	private String catDescripcion;

	//bi-directional many-to-one association to CatalogoDTO
	@ManyToOne
	@JoinColumn(name="cat_predecesor")
	private CatalogoDTO indCatalogo;

	//bi-directional many-to-one association to CatalogoDTO
	@OneToMany(mappedBy="indCatalogo")
	private List<CatalogoDTO> indCatalogos;

	public CatalogoDTO() {
	}

	public Integer getCatCodigo() {
		return this.catCodigo;
	}

	public void setCatCodigo(Integer catCodigo) {
		this.catCodigo = catCodigo;
	}

	public String getCatDescripcion() {
		return this.catDescripcion;
	}

	public void setCatDescripcion(String catDescripcion) {
		this.catDescripcion = catDescripcion;
	}

	public CatalogoDTO getIndCatalogo() {
		return this.indCatalogo;
	}

	public void setIndCatalogo(CatalogoDTO indCatalogo) {
		this.indCatalogo = indCatalogo;
	}

	public List<CatalogoDTO> getIndCatalogos() {
		return this.indCatalogos;
	}

	public void setIndCatalogos(List<CatalogoDTO> indCatalogos) {
		this.indCatalogos = indCatalogos;
	}

	public CatalogoDTO addIndCatalogo(CatalogoDTO indCatalogo) {
		getIndCatalogos().add(indCatalogo);
		indCatalogo.setIndCatalogo(this);

		return indCatalogo;
	}

	public CatalogoDTO removeIndCatalogo(CatalogoDTO indCatalogo) {
		getIndCatalogos().remove(indCatalogo);
		indCatalogo.setIndCatalogo(null);

		return indCatalogo;
	}

}