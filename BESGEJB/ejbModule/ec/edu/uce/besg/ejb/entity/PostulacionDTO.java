package ec.edu.uce.besg.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_postulacion database table.
 * 
 */
@Entity
@Table(name="bem_postulacion")
@NamedQuery(name="PostulacionDTO.findAll", query="SELECT p FROM PostulacionDTO p")
public class PostulacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_POSTULACION_POSCODIGO_GENERATOR", sequenceName="BEM_POSTULACION_POS_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_POSTULACION_POSCODIGO_GENERATOR")
	@Column(name="pos_codigo")
	private Integer posCodigo;

	@Column(name="pos_aceptado")
	private Boolean posAceptado;

	//bi-directional many-to-one association to AvisoDTO
	@ManyToOne
	@JoinColumn(name="pos_aviso")
	private AvisoDTO bemAviso;

	//bi-directional many-to-one association to CandidatoDTO
	@ManyToOne
	@JoinColumn(name="pos_candidato")
	private CandidatoDTO bemCandidato;

	public PostulacionDTO() {
	}

	public Integer getPosCodigo() {
		return this.posCodigo;
	}

	public void setPosCodigo(Integer posCodigo) {
		this.posCodigo = posCodigo;
	}

	public Boolean getPosAceptado() {
		return this.posAceptado;
	}

	public void setPosAceptado(Boolean posAceptado) {
		this.posAceptado = posAceptado;
	}

	public AvisoDTO getBemAviso() {
		return this.bemAviso;
	}

	public void setBemAviso(AvisoDTO bemAviso) {
		this.bemAviso = bemAviso;
	}

	public CandidatoDTO getBemCandidato() {
		return this.bemCandidato;
	}

	public void setBemCandidato(CandidatoDTO bemCandidato) {
		this.bemCandidato = bemCandidato;
	}

}