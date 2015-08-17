package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ind_indicador database table.
 * 
 */
@Entity
@Table(name="ind_indicador")
@NamedQuery(name="IndicadorDTO.findAll", query="SELECT i FROM IndicadorDTO i")
public class IndicadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_INDICADOR_INDCODIGO_GENERATOR", sequenceName="IND_INDICADOR_IND_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_INDICADOR_INDCODIGO_GENERATOR")
	@Column(name="ind_codigo")
	private Integer indCodigo;

	@Column(name="ind_descripcion")
	private String indDescripcion;

	@Column(name="ind_nombre")
	private String indNombre;

	@Column(name="ind_version")
	private String indVersion;

	@Column(name="ind_valor_inicial")
	private BigDecimal indValorInicial;

	@Column(name="ind_maximo")
	private BigDecimal indMaximo;

	@Column(name="ind_minimo")
	private BigDecimal indMinimo;
	
	@Column(name="ind_orden")
	private Integer indOrden;

	@Column(name="ind_valor_actual")
	private BigDecimal indValorActual;
	
	//bi-directional many-to-one association to HistoricoIndicadorDTO
	@OneToMany(mappedBy="indIndicador")
	private List<HistoricoIndicadorDTO> indHistoricoIndicadors;

	//bi-directional many-to-one association to IndicadorDTO
	@ManyToOne
	@JoinColumn(name="ind_predecesor")
	private IndicadorDTO indIndicador;

	//bi-directional many-to-one association to IndicadorDTO
	@OneToMany(mappedBy="indIndicador")
	private List<IndicadorDTO> indIndicadors;

	//bi-directional many-to-one association to ModeloDTO
	@ManyToOne
	@JoinColumn(name="ind_modelo")
	private ModeloDTO indModeloBean;

	public IndicadorDTO() {
	}

	public Integer getIndCodigo() {
		return this.indCodigo;
	}

	public void setIndCodigo(Integer indCodigo) {
		this.indCodigo = indCodigo;
	}

	public String getIndDescrpcion() {
		return this.indDescripcion;
	}

	public void setIndDescrpcion(String indDescripcion) {
		this.indDescripcion = indDescripcion;
	}

	public String getIndNombre() {
		return this.indNombre;
	}

	public void setIndNombre(String indNombre) {
		this.indNombre = indNombre;
	}

	public String getIndVersion() {
		return this.indVersion;
	}

	public void setIndVersion(String indVersion) {
		this.indVersion = indVersion;
	}

	public BigDecimal getIndValorInicial() {
		return indValorInicial;
	}

	public void setIndValorInicial(BigDecimal indValorInicial) {
		this.indValorInicial = indValorInicial;
	}

	public BigDecimal getIndValorActual() {
		return indValorActual;
	}

	public void setIndValorActual(BigDecimal indValorActual) {
		this.indValorActual = indValorActual;
	}

	public Integer getIndOrden() {
		return indOrden;
	}

	public void setIndOrden(Integer indOrden) {
		this.indOrden = indOrden;
	}

	public BigDecimal getIndMaximo() {
		return indMaximo;
	}

	public void setIndMaximo(BigDecimal indMaximo) {
		this.indMaximo = indMaximo;
	}

	public BigDecimal getIndMinimo() {
		return indMinimo;
	}

	public void setIndMinimo(BigDecimal indMinimo) {
		this.indMinimo = indMinimo;
	}

	public List<HistoricoIndicadorDTO> getIndHistoricoIndicadors() {
		return this.indHistoricoIndicadors;
	}

	public void setIndHistoricoIndicadors(List<HistoricoIndicadorDTO> indHistoricoIndicadors) {
		this.indHistoricoIndicadors = indHistoricoIndicadors;
	}

	public HistoricoIndicadorDTO addIndHistoricoIndicador(HistoricoIndicadorDTO indHistoricoIndicador) {
		getIndHistoricoIndicadors().add(indHistoricoIndicador);
		indHistoricoIndicador.setIndIndicador(this);

		return indHistoricoIndicador;
	}

	public HistoricoIndicadorDTO removeIndHistoricoIndicador(HistoricoIndicadorDTO indHistoricoIndicador) {
		getIndHistoricoIndicadors().remove(indHistoricoIndicador);
		indHistoricoIndicador.setIndIndicador(null);

		return indHistoricoIndicador;
	}

	public IndicadorDTO getIndIndicador() {
		return this.indIndicador;
	}

	public void setIndIndicador(IndicadorDTO indIndicador) {
		this.indIndicador = indIndicador;
	}

	public List<IndicadorDTO> getIndIndicadors() {
		return this.indIndicadors;
	}

	public void setIndIndicadors(List<IndicadorDTO> indIndicadors) {
		this.indIndicadors = indIndicadors;
	}

	public IndicadorDTO addIndIndicador(IndicadorDTO indIndicador) {
		getIndIndicadors().add(indIndicador);
		indIndicador.setIndIndicador(this);

		return indIndicador;
	}

	public IndicadorDTO removeIndIndicador(IndicadorDTO indIndicador) {
		getIndIndicadors().remove(indIndicador);
		indIndicador.setIndIndicador(null);

		return indIndicador;
	}

	public ModeloDTO getIndModeloBean() {
		return this.indModeloBean;
	}

	public void setIndModeloBean(ModeloDTO indModeloBean) {
		this.indModeloBean = indModeloBean;
	}

}