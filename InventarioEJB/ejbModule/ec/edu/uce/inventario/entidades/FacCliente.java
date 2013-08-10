package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the fac_cliente database table.
 * 
 */
@Entity
@Table(name="fac_cliente")
public class FacCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FAC_CLIENTE_CLICODIGO_GENERATOR", sequenceName="FAC_CLIENTE_CLI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FAC_CLIENTE_CLICODIGO_GENERATOR")
	@Column(name="cli_codigo")
	private Integer cliCodigo;

	@Column(name="cli_apellidos")
	private String cliApellidos;

	@Column(name="cli_direccion")
	private String cliDireccion;

	@Column(name="cli_nombres")
	private String cliNombres;

	@Column(name="cli_telefono")
	private String cliTelefono;

	//bi-directional many-to-one association to FacVenta
	@OneToMany(mappedBy="facCliente")
	private List<FacVenta> facVentas;

	public FacCliente() {
	}

	public Integer getCliCodigo() {
		return this.cliCodigo;
	}

	public void setCliCodigo(Integer cliCodigo) {
		this.cliCodigo = cliCodigo;
	}

	public String getCliApellidos() {
		return this.cliApellidos;
	}

	public void setCliApellidos(String cliApellidos) {
		this.cliApellidos = cliApellidos;
	}

	public String getCliDireccion() {
		return this.cliDireccion;
	}

	public void setCliDireccion(String cliDireccion) {
		this.cliDireccion = cliDireccion;
	}

	public String getCliNombres() {
		return this.cliNombres;
	}

	public void setCliNombres(String cliNombres) {
		this.cliNombres = cliNombres;
	}

	public String getCliTelefono() {
		return this.cliTelefono;
	}

	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}

	public List<FacVenta> getFacVentas() {
		return this.facVentas;
	}

	public void setFacVentas(List<FacVenta> facVentas) {
		this.facVentas = facVentas;
	}

	public FacVenta addFacVenta(FacVenta facVenta) {
		getFacVentas().add(facVenta);
		facVenta.setFacCliente(this);

		return facVenta;
	}

	public FacVenta removeFacVenta(FacVenta facVenta) {
		getFacVentas().remove(facVenta);
		facVenta.setFacCliente(null);

		return facVenta;
	}

}