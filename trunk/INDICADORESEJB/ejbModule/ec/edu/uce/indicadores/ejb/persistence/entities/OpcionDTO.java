package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ind_opcion database table.
 * 
 */
@Entity
@Table(name="ind_opcion")
@NamedQuery(name="OpcionDTO.findAll", query="SELECT o FROM OpcionDTO o")
public class OpcionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_OPCION_OPCCODIGO_GENERATOR", sequenceName="IND_OPCION_OPC_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_OPCION_OPCCODIGO_GENERATOR")
	@Column(name="opc_codigo")
	private Integer opcCodigo;

	@Column(name="opc_nombre")
	private String opcNombre;

	@Column(name="opc_url")
	private String opcUrl;

	//bi-directional many-to-one association to AccesoDTO
	@OneToMany(mappedBy="indOpcion")
	private List<AccesoDTO> indAccesos;

	public OpcionDTO() {
	}

	public Integer getOpcCodigo() {
		return this.opcCodigo;
	}

	public void setOpcCodigo(Integer opcCodigo) {
		this.opcCodigo = opcCodigo;
	}

	public String getOpcNombre() {
		return this.opcNombre;
	}

	public void setOpcNombre(String opcNombre) {
		this.opcNombre = opcNombre;
	}

	public String getOpcUrl() {
		return this.opcUrl;
	}

	public void setOpcUrl(String opcUrl) {
		this.opcUrl = opcUrl;
	}

	public List<AccesoDTO> getIndAccesos() {
		return this.indAccesos;
	}

	public void setIndAccesos(List<AccesoDTO> indAccesos) {
		this.indAccesos = indAccesos;
	}

	public AccesoDTO addIndAcceso(AccesoDTO indAcceso) {
		getIndAccesos().add(indAcceso);
		indAcceso.setIndOpcion(this);

		return indAcceso;
	}

	public AccesoDTO removeIndAcceso(AccesoDTO indAcceso) {
		getIndAccesos().remove(indAcceso);
		indAcceso.setIndOpcion(null);

		return indAcceso;
	}

}