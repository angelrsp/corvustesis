package ec.edu.uce.besg.ejb.persistence.entity.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the seg_parametro database table.
 * 
 */
@Entity
@Table(name="seg_parametro")
@NamedQuery(name="ParametroDTO.findAll", query="SELECT p FROM ParametroDTO p")
public class ParametroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_PARAMETRO_PARCODIGO_GENERATOR", sequenceName="SEG_PARAMETRO_PAR_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_PARAMETRO_PARCODIGO_GENERATOR")
	@Column(name="par_codigo")
	private Integer parCodigo;

	@Column(name="par_descripcion")
	private String parDescripcion;

	@Column(name="par_valor")
	private String parValor;

	public ParametroDTO() {
	}

	public Integer getParCodigo() {
		return this.parCodigo;
	}

	public void setParCodigo(Integer parCodigo) {
		this.parCodigo = parCodigo;
	}

	public String getParDescripcion() {
		return this.parDescripcion;
	}

	public void setParDescripcion(String parDescripcion) {
		this.parDescripcion = parDescripcion;
	}

	public String getParValor() {
		return this.parValor;
	}

	public void setParValor(String parValor) {
		this.parValor = parValor;
	}

}