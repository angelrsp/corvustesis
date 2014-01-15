package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the bem_contacto database table.
 * 
 */
@Entity
@Table(name="bem_contacto")
public class ContactoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_CONTACTO_CONCODIGO_GENERATOR", sequenceName="BEM_CONTACTO_CON_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_CONTACTO_CONCODIGO_GENERATOR")
	@Column(name="con_codigo")
	private Integer conCodigo;

	@Column(name="con_apellidos")
	private String conApellidos;

	@Column(name="con_cargo")
	private Integer conCargo;

	@Column(name="con_mail")
	private String conMail;

	@Column(name="con_nombres")
	private String conNombres;

	@Column(name="con_telefono")
	private String conTelefono;

    @ManyToOne
	@JoinColumn(name="con_empresa")
	private EmpresaDTO bemEmpresa;

    public ContactoDTO() {
    }

	public Integer getConCodigo() {
		return this.conCodigo;
	}

	public void setConCodigo(Integer conCodigo) {
		this.conCodigo = conCodigo;
	}

	public String getConApellidos() {
		return this.conApellidos;
	}

	public void setConApellidos(String conApellidos) {
		this.conApellidos = conApellidos;
	}

	public Integer getConCargo() {
		return this.conCargo;
	}

	public void setConCargo(Integer conCargo) {
		this.conCargo = conCargo;
	}

	public String getConMail() {
		return this.conMail;
	}

	public void setConMail(String conMail) {
		this.conMail = conMail;
	}

	public String getConNombres() {
		return this.conNombres;
	}

	public void setConNombres(String conNombres) {
		this.conNombres = conNombres;
	}

	public String getConTelefono() {
		return this.conTelefono;
	}

	public void setConTelefono(String conTelefono) {
		this.conTelefono = conTelefono;
	}

	public EmpresaDTO getBemEmpresa() {
		return bemEmpresa;
	}

	public void setBemEmpresa(EmpresaDTO bemEmpresa) {
		this.bemEmpresa = bemEmpresa;
	}
	
}