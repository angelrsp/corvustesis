package ec.edu.uce.indicadores.ejb.persistence.entities;

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

	@Column(name="ind_nombre_corto")
	private String indNombreCorto;

	@Column(name="ind_nombre_largo")
	private String indNombreLargo;

	@Column(name="ind_peso")
	private String indPeso;

	@Column(name="ind_utilidad")
	private String indUtilidad;

	@Column(name="ind_valor_inicial")
	private BigDecimal indValorInicial;

	@Column(name="ind_valor_actual")
	private BigDecimal indValorActual;

	@Column(name="ind_valor_objetivo")
	private BigDecimal indValorObjetivo;

	@Column(name="ind_valor_ideal")
	private BigDecimal indValorIdeal;

	@Column(name="ind_descriptor")
	private String indDescriptor;

	@Column(name="ind_orden")
	private Integer indOrden;

	@Column(name="ind_tipo")
	private Integer indTipo;

	//bi-directional many-to-one association to HistoricoIndicadorDTO
	@OneToMany(mappedBy="indIndicador")
	private List<HistoricoIndicadorDTO> indHistoricoIndicadors;

	//bi-directional many-to-one association to IesDTO
	@ManyToOne
	@JoinColumn(name="ind_ies")
	private IesDTO indy;

	//bi-directional many-to-one association to IndicadorDTO
	@ManyToOne
	@JoinColumn(name="ind_predecesor")
	private IndicadorDTO indIndicador;

	//bi-directional many-to-one association to IndicadorDTO
	@OneToMany(mappedBy="indIndicador")
	@OrderBy("indOrden")
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

	public String getIndNombreCorto() {
		return this.indNombreCorto;
	}

	public void setIndNombreCorto(String indNombreCorto) {
		this.indNombreCorto = indNombreCorto;
	}

	public String getIndNombreLargo() {
		return this.indNombreLargo;
	}

	public void setIndNombreLargo(String indNombreLargo) {
		this.indNombreLargo = indNombreLargo;
	}

	public String getIndPeso() {
		return this.indPeso;
	}

	public void setIndPeso(String indPeso) {
		this.indPeso = indPeso;
	}

	public String getIndUtilidad() {
		return this.indUtilidad;
	}

	public void setIndUtilidad(String indUtilidad) {
		this.indUtilidad = indUtilidad;
	}

	public List<HistoricoIndicadorDTO> getIndHistoricoIndicadors() {
		return this.indHistoricoIndicadors;
	}

	public void setIndHistoricoIndicadors(List<HistoricoIndicadorDTO> indHistoricoIndicadors) {
		this.indHistoricoIndicadors = indHistoricoIndicadors;
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

	public BigDecimal getIndValorObjetivo() {
		return indValorObjetivo;
	}

	public void setIndValorObjetivo(BigDecimal indValorObjetivo) {
		this.indValorObjetivo = indValorObjetivo;
	}

	public BigDecimal getIndValorIdeal() {
		return indValorIdeal;
	}

	public void setIndValorIdeal(BigDecimal indValorIdeal) {
		this.indValorIdeal = indValorIdeal;
	}

	public String getIndDescriptor() {
		return indDescriptor;
	}

	public void setIndDescriptor(String indDescriptor) {
		this.indDescriptor = indDescriptor;
	}

	public Integer getIndOrden() {
		return indOrden;
	}

	public void setIndOrden(Integer indOrden) {
		this.indOrden = indOrden;
	}

	public Integer getIndTipo() {
		return indTipo;
	}

	public void setIndTipo(Integer indTipo) {
		this.indTipo = indTipo;
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

	public IesDTO getIndy() {
		return this.indy;
	}

	public void setIndy(IesDTO indy) {
		this.indy = indy;
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