package ec.edu.uce.inventario.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_opcion database table.
 * 
 */
@Entity
@Table(name="sis_opcion")
public class SisOpcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_OPCION_OPCCODIGO_GENERATOR", sequenceName="SIS_OPCION_OPC_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_OPCION_OPCCODIGO_GENERATOR")
	@Column(name="opc_codigo")
	private Integer opcCodigo;

	@Column(name="opc_nombre")
	private String opcNombre;

	@Column(name="opc_orden")
	private Integer opcOrden;

	@Column(name="opc_padre")
	private Integer opcPadre;

	@Column(name="opc_url")
	private String opcUrl;

	//bi-directional many-to-one association to SisModulo
	@ManyToOne
	@JoinColumn(name="opc_modulo")
	private SisModulo sisModulo;

	//bi-directional many-to-one association to SisPerfilOpcion
	@OneToMany(mappedBy="sisOpcion")
	private List<SisPerfilOpcion> sisPerfilOpcions;

	public SisOpcion() {
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

	public Integer getOpcOrden() {
		return this.opcOrden;
	}

	public void setOpcOrden(Integer opcOrden) {
		this.opcOrden = opcOrden;
	}

	public Integer getOpcPadre() {
		return this.opcPadre;
	}

	public void setOpcPadre(Integer opcPadre) {
		this.opcPadre = opcPadre;
	}

	public String getOpcUrl() {
		return this.opcUrl;
	}

	public void setOpcUrl(String opcUrl) {
		this.opcUrl = opcUrl;
	}

	public SisModulo getSisModulo() {
		return this.sisModulo;
	}

	public void setSisModulo(SisModulo sisModulo) {
		this.sisModulo = sisModulo;
	}

	public List<SisPerfilOpcion> getSisPerfilOpcions() {
		return this.sisPerfilOpcions;
	}

	public void setSisPerfilOpcions(List<SisPerfilOpcion> sisPerfilOpcions) {
		this.sisPerfilOpcions = sisPerfilOpcions;
	}

	public SisPerfilOpcion addSisPerfilOpcion(SisPerfilOpcion sisPerfilOpcion) {
		getSisPerfilOpcions().add(sisPerfilOpcion);
		sisPerfilOpcion.setSisOpcion(this);

		return sisPerfilOpcion;
	}

	public SisPerfilOpcion removeSisPerfilOpcion(SisPerfilOpcion sisPerfilOpcion) {
		getSisPerfilOpcions().remove(sisPerfilOpcion);
		sisPerfilOpcion.setSisOpcion(null);

		return sisPerfilOpcion;
	}

}