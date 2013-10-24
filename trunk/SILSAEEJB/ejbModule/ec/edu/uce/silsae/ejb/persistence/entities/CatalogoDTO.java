package ec.edu.uce.silsae.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bem_catalogo database table.
 * 
 */
@Entity
@Table(name="bem_catalogo")
public class CatalogoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_CATALOGO_CATCODIGO_GENERATOR", sequenceName="BEM_CATALOGO_CAT_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_CATALOGO_CATCODIGO_GENERATOR")
	@Column(name="cat_codigo")
	private Integer catCodigo;

	@Column(name="cat_descripcion")
	private String catDescripcion;

	@Column(name="cat_nombre")
	private String catNombre;

	//bi-directional many-to-one association to CatalogoDTO
    @ManyToOne
	@JoinColumn(name="cat_padre")
	private CatalogoDTO bemCatalogo;

	//bi-directional many-to-one association to CatalogoDTO
	@OneToMany(mappedBy="bemCatalogo")
	private List<CatalogoDTO> bemCatalogos;

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

	public String getCatNombre() {
		return this.catNombre;
	}

	public void setCatNombre(String catNombre) {
		this.catNombre = catNombre;
	}

	public CatalogoDTO getBemCatalogo() {
		return this.bemCatalogo;
	}

	public void setBemCatalogo(CatalogoDTO bemCatalogo) {
		this.bemCatalogo = bemCatalogo;
	}
	
	public List<CatalogoDTO> getBemCatalogos() {
		return this.bemCatalogos;
	}

	public void setBemCatalogos(List<CatalogoDTO> bemCatalogos) {
		this.bemCatalogos = bemCatalogos;
	}
	
}