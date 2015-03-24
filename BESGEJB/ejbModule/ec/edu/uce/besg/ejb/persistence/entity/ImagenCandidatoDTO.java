package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_imagen_candidato database table.
 * 
 */
@Entity
@Table(name="bem_imagen_candidato")
@NamedQuery(name="ImagenCandidatoDTO.findAll", query="SELECT i FROM ImagenCandidatoDTO i")
public class ImagenCandidatoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_IMAGEN_CANDIDATO_ICACODIGO_GENERATOR", sequenceName="BEM_IMAGEN_CANDIDATO_ICA_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_IMAGEN_CANDIDATO_ICACODIGO_GENERATOR")
	@Column(name="ica_codigo")
	private Integer icaCodigo;

	@Column(name="ica_imagen")
	private byte[] icaImagen;

	@Column(name="ica_path")
	private String icaPath;

	//bi-directional many-to-one association to CandidatoDTO
	@ManyToOne
	@JoinColumn(name="ica_candidato")
	private CandidatoDTO bemCandidato;

	public ImagenCandidatoDTO() {
	}

	public Integer getIcaCodigo() {
		return this.icaCodigo;
	}

	public void setIcaCodigo(Integer icaCodigo) {
		this.icaCodigo = icaCodigo;
	}

	public byte[] getIcaImagen() {
		return this.icaImagen;
	}

	public void setIcaImagen(byte[] icaImagen) {
		this.icaImagen = icaImagen;
	}

	public String getIcaPath() {
		return this.icaPath;
	}

	public void setIcaPath(String icaPath) {
		this.icaPath = icaPath;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}

}