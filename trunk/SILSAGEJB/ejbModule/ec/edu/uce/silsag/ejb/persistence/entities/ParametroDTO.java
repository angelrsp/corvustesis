package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_parametro database table.
 * 
 */
@Entity
@Table(name="bem_parametro")
public class ParametroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_PARAMETRO_PARCODIGO_GENERATOR", sequenceName="BEM_PARAMETRO_PAR_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_PARAMETRO_PARCODIGO_GENERATOR")
	@Column(name="par_codigo")
	private Integer parCodigo;

	@Column(name="par_nombre")
	private String parNombre;

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

	public String getParNombre() {
		return this.parNombre;
	}

	public void setParNombre(String parNombre) {
		this.parNombre = parNombre;
	}

	public String getParValor() {
		return this.parValor;
	}

	public void setParValor(String parValor) {
		this.parValor = parValor;
	}

}