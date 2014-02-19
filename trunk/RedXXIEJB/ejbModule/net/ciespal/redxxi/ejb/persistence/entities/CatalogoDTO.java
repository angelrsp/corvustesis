package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ate_catalogo database table.
 * 
 */
@Entity
@Table(name="ate_catalogo")
@NamedQuery(name="CatalogoDTO.findAll", query="SELECT c FROM CatalogoDTO c")
public class CatalogoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_CATALOGO_CATCODIGO_GENERATOR", sequenceName="ATE_CATALOGO_CAT_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_CATALOGO_CATCODIGO_GENERATOR")
	@Column(name="cat_codigo")
	private Integer catCodigo;

	@Column(name="cat_descripcion")
	private String catDescripcion;

	@Column(name="cat_descripcion2")
	private String catDescripcion2;

	@Column(name="cat_auxiliar")
	private String catAuxiliar;

	@Column(name="cat_imagen")
	private byte[] catImagen;

	
	//bi-directional many-to-one association to CatalogoDTO
	@ManyToOne
	@JoinColumn(name="cat_predecesor")
	private CatalogoDTO ateCatalogo;

	//bi-directional many-to-one association to CatalogoDTO
	@OneToMany(mappedBy="ateCatalogo")
	private List<CatalogoDTO> ateCatalogos;

	public CatalogoDTO() {
	}

	public CatalogoDTO(Integer catCodigo) {
		super();
		this.catCodigo = catCodigo;
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

	public String getCatDescripcion2() {
		return catDescripcion2;
	}

	public void setCatDescripcion2(String catDescripcion2) {
		this.catDescripcion2 = catDescripcion2;
	}

	public String getCatAuxiliar() {
		return catAuxiliar;
	}

	public void setCatAuxiliar(String catAuxiliar) {
		this.catAuxiliar = catAuxiliar;
	}

	public byte[] getCatImagen() {
		return catImagen;
	}

	public void setCatImagen(byte[] catImagen) {
		this.catImagen = catImagen;
	}

	public CatalogoDTO getAteCatalogo() {
		return this.ateCatalogo;
	}

	public void setAteCatalogo(CatalogoDTO ateCatalogo) {
		this.ateCatalogo = ateCatalogo;
	}

	public List<CatalogoDTO> getAteCatalogos() {
		return this.ateCatalogos;
	}

	public void setAteCatalogos(List<CatalogoDTO> ateCatalogos) {
		this.ateCatalogos = ateCatalogos;
	}

	public CatalogoDTO addAteCatalogo(CatalogoDTO ateCatalogo) {
		getAteCatalogos().add(ateCatalogo);
		ateCatalogo.setAteCatalogo(this);

		return ateCatalogo;
	}

	public CatalogoDTO removeAteCatalogo(CatalogoDTO ateCatalogo) {
		getAteCatalogos().remove(ateCatalogo);
		ateCatalogo.setAteCatalogo(null);

		return ateCatalogo;
	}

}