package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the fac_datos database table.
 * 
 */
@Entity
@Table(name="fac_datos")
public class FacDato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FAC_DATOS_DATCODIGO_GENERATOR", sequenceName="FAC_DATOS_DAT_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAC_DATOS_DATCODIGO_GENERATOR")
	@Column(name="dat_codigo")
	private Integer datCodigo;

	@Column(name="dat_empresa")
	private String datEmpresa;

	@Column(name="dat_iva")
	private BigDecimal datIva;

	@Column(name="dat_sri")
	private String datSri;

	@Column(name="dat_telefono")
	private String datTelefono;

	public FacDato() {
	}

	public Integer getDatCodigo() {
		return this.datCodigo;
	}

	public void setDatCodigo(Integer datCodigo) {
		this.datCodigo = datCodigo;
	}

	public String getDatEmpresa() {
		return this.datEmpresa;
	}

	public void setDatEmpresa(String datEmpresa) {
		this.datEmpresa = datEmpresa;
	}

	public BigDecimal getDatIva() {
		return this.datIva;
	}

	public void setDatIva(BigDecimal datIva) {
		this.datIva = datIva;
	}

	public String getDatSri() {
		return this.datSri;
	}

	public void setDatSri(String datSri) {
		this.datSri = datSri;
	}

	public String getDatTelefono() {
		return this.datTelefono;
	}

	public void setDatTelefono(String datTelefono) {
		this.datTelefono = datTelefono;
	}

}