package ec.edu.uce.besg.ejb.persistence.entity.security;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_catalogo database table.
 * 
 */
@Entity
@Table(name="seg_catalogo")
@NamedQuery(name="CatalogoDTO.findAll", query="SELECT c FROM CatalogoDTO c")
public class CatalogoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_CATALOGO_CATCODIGO_GENERATOR", sequenceName="SEG_CATALOGO_CAT_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_CATALOGO_CATCODIGO_GENERATOR")
	@Column(name="cat_codigo")
	private Integer catCodigo;

	@Column(name="cat_descripcion")
	private String catDescripcion;

	//bi-directional many-to-one association to CatalogoDTO
	@ManyToOne
	@JoinColumn(name="cat_predecesor")
	private CatalogoDTO segCatalogo;

	//bi-directional many-to-one association to CatalogoDTO
	@OneToMany(mappedBy="segCatalogo")
	private List<CatalogoDTO> segCatalogos;

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

	public CatalogoDTO getSegCatalogo() {
		return this.segCatalogo;
	}

	public void setSegCatalogo(CatalogoDTO segCatalogo) {
		this.segCatalogo = segCatalogo;
	}

	public List<CatalogoDTO> getSegCatalogos() {
		return this.segCatalogos;
	}

	public void setSegCatalogos(List<CatalogoDTO> segCatalogos) {
		this.segCatalogos = segCatalogos;
	}

	public CatalogoDTO addSegCatalogo(CatalogoDTO segCatalogo) {
		getSegCatalogos().add(segCatalogo);
		segCatalogo.setSegCatalogo(this);

		return segCatalogo;
	}

	public CatalogoDTO removeSegCatalogo(CatalogoDTO segCatalogo) {
		getSegCatalogos().remove(segCatalogo);
		segCatalogo.setSegCatalogo(null);

		return segCatalogo;
	}

}