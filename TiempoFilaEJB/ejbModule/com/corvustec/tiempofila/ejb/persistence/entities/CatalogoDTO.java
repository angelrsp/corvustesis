package com.corvustec.tiempofila.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tfi_catalogo database table.
 * 
 */
@Entity
@Table(name="tfi_catalogo")
@NamedQuery(name="CatalogoDTO.findAll", query="SELECT c FROM CatalogoDTO c")
public class CatalogoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TFI_CATALOGO_CATCODIGO_GENERATOR", sequenceName="TFI_CATALOGO_CAT_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TFI_CATALOGO_CATCODIGO_GENERATOR")
	@Column(name="cat_codigo")
	private Integer catCodigo;

	@Column(name="cat_descripcion")
	private String catDescripcion;

	//bi-directional many-to-one association to CatalogoDTO
	@ManyToOne
	@JoinColumn(name="cat_predecesor")
	private CatalogoDTO tfiCatalogo;

	//bi-directional many-to-one association to CatalogoDTO
	@OneToMany(mappedBy="tfiCatalogo")
	private List<CatalogoDTO> tfiCatalogos;

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

	public CatalogoDTO getTfiCatalogo() {
		return this.tfiCatalogo;
	}

	public void setTfiCatalogo(CatalogoDTO tfiCatalogo) {
		this.tfiCatalogo = tfiCatalogo;
	}

	public List<CatalogoDTO> getTfiCatalogos() {
		return this.tfiCatalogos;
	}

	public void setTfiCatalogos(List<CatalogoDTO> tfiCatalogos) {
		this.tfiCatalogos = tfiCatalogos;
	}

	public CatalogoDTO addTfiCatalogo(CatalogoDTO tfiCatalogo) {
		getTfiCatalogos().add(tfiCatalogo);
		tfiCatalogo.setTfiCatalogo(this);

		return tfiCatalogo;
	}

	public CatalogoDTO removeTfiCatalogo(CatalogoDTO tfiCatalogo) {
		getTfiCatalogos().remove(tfiCatalogo);
		tfiCatalogo.setTfiCatalogo(null);

		return tfiCatalogo;
	}

}