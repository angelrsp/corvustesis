package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the esp_noticia database table.
 * 
 */
@Entity
@Table(name="esp_noticia")
@NamedQuery(name="NoticiaEspejoDTO.findAll", query="SELECT n FROM NoticiaDTO n")
public class NoticiaEspejoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESP_NOTICIA_NOTCODIGO_GENERATOR", sequenceName="ESP_NOTICIA_NOT_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESP_NOTICIA_NOTCODIGO_GENERATOR")
	@Column(name="not_codigo")
	private Integer notCodigo;

	@Column(name="not_noticia")
	private String notNoticia;

	@Column(name="not_resumen")
	private String notResumen;

	@Column(name="not_titulo")
	private String notTitulo;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="not_entidad")
	private EntidadEspejoDTO espEntidad;

	public NoticiaEspejoDTO() {
	}

	public Integer getNotCodigo() {
		return this.notCodigo;
	}

	public void setNotCodigo(Integer notCodigo) {
		this.notCodigo = notCodigo;
	}

	public String getNotNoticia() {
		return this.notNoticia;
	}

	public void setNotNoticia(String notNoticia) {
		this.notNoticia = notNoticia;
	}

	public String getNotResumen() {
		return this.notResumen;
	}

	public void setNotResumen(String notResumen) {
		this.notResumen = notResumen;
	}

	public String getNotTitulo() {
		return this.notTitulo;
	}

	public void setNotTitulo(String notTitulo) {
		this.notTitulo = notTitulo;
	}

	public EntidadEspejoDTO getEspEntidad() {
		return this.espEntidad;
	}

	public void setEspEntidad(EntidadEspejoDTO espEntidad) {
		this.espEntidad = espEntidad;
	}

}