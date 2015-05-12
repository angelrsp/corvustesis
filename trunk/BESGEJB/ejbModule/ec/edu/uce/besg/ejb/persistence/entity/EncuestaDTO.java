package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the cue_encuesta database table.
 * 
 */
@Entity
@Table(name="cue_encuesta")
@NamedQuery(name="EncuestaDTO.findAll", query="SELECT e FROM EncuestaDTO e")
public class EncuestaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUE_ENCUESTA_ENCCODIGO_GENERATOR", sequenceName="CUE_ENCUESTA_ENC_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUE_ENCUESTA_ENCCODIGO_GENERATOR")
	@Column(name="enc_codigo")
	private Integer encCodigo;

	@Column(name="enc_descripcion")
	private String encDescripcion;

	@Column(name="enc_habilitado")
	private Boolean encHabilitado;
	
	//bi-directional many-to-one association to RespuestaDTO
	@OneToMany(mappedBy="cueEncuesta")
	private List<CategoriaDTO> cueCategorias;


	public EncuestaDTO() {
	}

	public Integer getEncCodigo() {
		return this.encCodigo;
	}

	public void setEncCodigo(Integer encCodigo) {
		this.encCodigo = encCodigo;
	}

	public String getEncDescripcion() {
		return this.encDescripcion;
	}

	public void setEncDescripcion(String encDescripcion) {
		this.encDescripcion = encDescripcion;
	}

	public Boolean getEncHabilitado() {
		return this.encHabilitado;
	}

	public void setEncHabilitado(Boolean encHabilitado) {
		this.encHabilitado = encHabilitado;
	}

	public List<CategoriaDTO> getCueCategorias() {
		return cueCategorias;
	}

	public void setCueCategorias(List<CategoriaDTO> cueCategorias) {
		this.cueCategorias = cueCategorias;
	}

}