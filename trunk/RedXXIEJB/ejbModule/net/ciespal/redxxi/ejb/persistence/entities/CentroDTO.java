package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ate_centro database table.
 * 
 */
@Entity
@Table(name="ate_centro")
@NamedQuery(name="CentroDTO.findAll", query="SELECT c FROM CentroDTO c")
public class CentroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_CENTRO_CENCODIGO_GENERATOR", sequenceName="ATE_CENTRO_CEN_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_CENTRO_CENCODIGO_GENERATOR")
	@Column(name="cen_codigo")
	private Integer cenCodigo;

	@Column(name="cen_anio_fundacion")
	private Integer cenAnioFundacion;

	@Column(name="cen_categoria")
	private String cenCategoria;

	@Column(name="cen_dato_institucional")
	private String cenDatoInstitucional;

	@Column(name="cen_nombre")
	private String cenNombre;

	@Column(name="cen_tipo")
	private Integer cenTipo;

	@Column(name="cen_ciudad")
	private Integer cenCiudad;

	@Column(name="cen_provincia")
	private Integer cenProvincia;

	@Column(name="cen_pais")
	private Integer cenPais;

	//bi-directional many-to-one association to CarreraDTO
	@OneToMany(mappedBy="ateCentro")
	private List<CarreraDTO> ateCarreras;

	//bi-directional many-to-one association to CentroDTO
	@ManyToOne
	@JoinColumn(name="cen_predecesor")
	private CentroDTO ateCentro;

	//bi-directional many-to-one association to CentroDTO
	@OneToMany(mappedBy="ateCentro")
	private List<CentroDTO> ateCentros;

	public CentroDTO() {
	}

	public Integer getCenCodigo() {
		return this.cenCodigo;
	}

	public void setCenCodigo(Integer cenCodigo) {
		this.cenCodigo = cenCodigo;
	}

	public Integer getCenAnioFundacion() {
		return this.cenAnioFundacion;
	}

	public void setCenAnioFundacion(Integer cenAnioFundacion) {
		this.cenAnioFundacion = cenAnioFundacion;
	}

	public String getCenCategoria() {
		return this.cenCategoria;
	}

	public void setCenCategoria(String cenCategoria) {
		this.cenCategoria = cenCategoria;
	}

	public String getCenDatoInstitucional() {
		return this.cenDatoInstitucional;
	}

	public void setCenDatoInstitucional(String cenDatoInstitucional) {
		this.cenDatoInstitucional = cenDatoInstitucional;
	}

	public String getCenNombre() {
		return this.cenNombre;
	}

	public void setCenNombre(String cenNombre) {
		this.cenNombre = cenNombre;
	}

	public Integer getCenTipo() {
		return this.cenTipo;
	}

	public void setCenTipo(Integer cenTipo) {
		this.cenTipo = cenTipo;
	}


	public Integer getCenCiudad() {
		return cenCiudad;
	}

	public void setCenCiudad(Integer cenCiudad) {
		this.cenCiudad = cenCiudad;
	}

	public Integer getCenProvincia() {
		return cenProvincia;
	}

	public void setCenProvincia(Integer cenProvincia) {
		this.cenProvincia = cenProvincia;
	}

	public Integer getCenPais() {
		return cenPais;
	}

	public void setCenPais(Integer cenPais) {
		this.cenPais = cenPais;
	}

	public List<CarreraDTO> getAteCarreras() {
		return this.ateCarreras;
	}

	public void setAteCarreras(List<CarreraDTO> ateCarreras) {
		this.ateCarreras = ateCarreras;
	}

	public CarreraDTO addAteCarrera(CarreraDTO ateCarrera) {
		getAteCarreras().add(ateCarrera);
		ateCarrera.setAteCentro(this);

		return ateCarrera;
	}

	public CarreraDTO removeAteCarrera(CarreraDTO ateCarrera) {
		getAteCarreras().remove(ateCarrera);
		ateCarrera.setAteCentro(null);

		return ateCarrera;
	}

	public CentroDTO getAteCentro() {
		return this.ateCentro;
	}

	public void setAteCentro(CentroDTO ateCentro) {
		this.ateCentro = ateCentro;
	}

	public List<CentroDTO> getAteCentros() {
		return this.ateCentros;
	}

	public void setAteCentros(List<CentroDTO> ateCentros) {
		this.ateCentros = ateCentros;
	}

	public CentroDTO addAteCentro(CentroDTO ateCentro) {
		getAteCentros().add(ateCentro);
		ateCentro.setAteCentro(this);

		return ateCentro;
	}

	public CentroDTO removeAteCentro(CentroDTO ateCentro) {
		getAteCentros().remove(ateCentro);
		ateCentro.setAteCentro(null);

		return ateCentro;
	}

}