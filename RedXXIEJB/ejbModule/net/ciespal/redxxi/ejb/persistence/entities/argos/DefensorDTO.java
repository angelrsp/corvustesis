package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the arg_defensor database table.
 * 
 */
@Entity
@Table(name="arg_defensor")
@NamedQuery(name="DefensorDTO.findAll", query="SELECT d FROM DefensorDTO d")
public class DefensorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARG_DEFENSOR_DEFCODIGO_GENERATOR", sequenceName="ARG_DEFENSOR_DEF_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARG_DEFENSOR_DEFCODIGO_GENERATOR")
	@Column(name="def_codigo")
	private Integer defCodigo;

	@Column(name="def_activo")
	private Boolean defActivo;

	@Column(name="def_medio")
	private String defMedio;

	@Column(name="def_opinion")
	private String defOpinion;

	@Column(name="def_tema_referencia")
	private String defTemaReferencia;

	@Column(name="def_usuario")
	private Integer defUsuario;

	//bi-directional many-to-one association to EntidadDTO
	@ManyToOne
	@JoinColumn(name="def_entidad")
	private EntidadDTO argEntidad;

	public DefensorDTO() {
	}

	public Integer getDefCodigo() {
		return this.defCodigo;
	}

	public void setDefCodigo(Integer defCodigo) {
		this.defCodigo = defCodigo;
	}

	public Boolean getDefActivo() {
		return this.defActivo;
	}

	public void setDefActivo(Boolean defActivo) {
		this.defActivo = defActivo;
	}

	public String getDefMedio() {
		return this.defMedio;
	}

	public void setDefMedio(String defMedio) {
		this.defMedio = defMedio;
	}

	public String getDefOpinion() {
		return this.defOpinion;
	}

	public void setDefOpinion(String defOpinion) {
		this.defOpinion = defOpinion;
	}

	public String getDefTemaReferencia() {
		return this.defTemaReferencia;
	}

	public void setDefTemaReferencia(String defTemaReferencia) {
		this.defTemaReferencia = defTemaReferencia;
	}

	public Integer getDefUsuario() {
		return this.defUsuario;
	}

	public void setDefUsuario(Integer defUsuario) {
		this.defUsuario = defUsuario;
	}

	public EntidadDTO getArgEntidad() {
		return this.argEntidad;
	}

	public void setArgEntidad(EntidadDTO argEntidad) {
		this.argEntidad = argEntidad;
	}

}