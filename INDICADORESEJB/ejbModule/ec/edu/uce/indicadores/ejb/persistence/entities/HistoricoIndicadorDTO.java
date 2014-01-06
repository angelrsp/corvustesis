package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ind_historico_indicador database table.
 * 
 */
@Entity
@Table(name="ind_historico_indicador")
public class HistoricoIndicadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_HISTORICO_INDICADOR_HINCODIGO_GENERATOR", sequenceName="IND_HISTORICO_INDICADOR_HIN_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_HISTORICO_INDICADOR_HINCODIGO_GENERATOR")
	@Column(name="hin_codigo")
	private Integer hinCodigo;

	@Column(name="hin_fecha")
	private Timestamp hinFecha;

	@Column(name="hin_observacion")
	private String hinObservacion;

	@Column(name="hin_valor")
	private String hinValor;

	//bi-directional many-to-one association to EvidenciaDTO
	@OneToMany(mappedBy="indHistoricoIndicador")
	private List<EvidenciaDTO> indEvidencias;

	//bi-directional many-to-one association to IndicadorDTO
	@ManyToOne
	@JoinColumn(name="hin_indicador")
	private IndicadorDTO indIndicador;

	public HistoricoIndicadorDTO() {
	}

	public Integer getHinCodigo() {
		return this.hinCodigo;
	}

	public void setHinCodigo(Integer hinCodigo) {
		this.hinCodigo = hinCodigo;
	}

	public Timestamp getHinFecha() {
		return this.hinFecha;
	}

	public void setHinFecha(Timestamp hinFecha) {
		this.hinFecha = hinFecha;
	}

	public String getHinObservacion() {
		return this.hinObservacion;
	}

	public void setHinObservacion(String hinObservacion) {
		this.hinObservacion = hinObservacion;
	}

	public String getHinValor() {
		return this.hinValor;
	}

	public void setHinValor(String hinValor) {
		this.hinValor = hinValor;
	}

	public List<EvidenciaDTO> getIndEvidencias() {
		return this.indEvidencias;
	}

	public void setIndEvidencias(List<EvidenciaDTO> indEvidencias) {
		this.indEvidencias = indEvidencias;
	}

	public EvidenciaDTO addIndEvidencia(EvidenciaDTO indEvidencia) {
		getIndEvidencias().add(indEvidencia);
		indEvidencia.setIndHistoricoIndicador(this);

		return indEvidencia;
	}

	public EvidenciaDTO removeIndEvidencia(EvidenciaDTO indEvidencia) {
		getIndEvidencias().remove(indEvidencia);
		indEvidencia.setIndHistoricoIndicador(null);

		return indEvidencia;
	}

	public IndicadorDTO getIndIndicador() {
		return this.indIndicador;
	}

	public void setIndIndicador(IndicadorDTO indIndicador) {
		this.indIndicador = indIndicador;
	}

}