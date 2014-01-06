package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ind_evidencias database table.
 * 
 */
@Entity
@Table(name="ind_evidencias")
@NamedQuery(name="EvidenciaDTO.findAll", query="SELECT e FROM EvidenciaDTO e")
public class EvidenciaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_EVIDENCIAS_EVICODIGO_GENERATOR", sequenceName="IND_EVIDENCIAS_EVI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_EVIDENCIAS_EVICODIGO_GENERATOR")
	@Column(name="evi_codigo")
	private Integer eviCodigo;

	@Column(name="evi_nombre")
	private String eviNombre;

	@Column(name="evi_observacion")
	private String eviObservacion;

	@Column(name="evi_valor")
	private String eviValor;

	//bi-directional many-to-one association to HistoricoIndicadorDTO
	@ManyToOne
	@JoinColumn(name="evi_his_indicador")
	private HistoricoIndicadorDTO indHistoricoIndicador;

	public EvidenciaDTO() {
	}

	public Integer getEviCodigo() {
		return this.eviCodigo;
	}

	public void setEviCodigo(Integer eviCodigo) {
		this.eviCodigo = eviCodigo;
	}

	public String getEviNombre() {
		return this.eviNombre;
	}

	public void setEviNombre(String eviNombre) {
		this.eviNombre = eviNombre;
	}

	public String getEviObservacion() {
		return this.eviObservacion;
	}

	public void setEviObservacion(String eviObservacion) {
		this.eviObservacion = eviObservacion;
	}

	public String getEviValor() {
		return this.eviValor;
	}

	public void setEviValor(String eviValor) {
		this.eviValor = eviValor;
	}

	public HistoricoIndicadorDTO getIndHistoricoIndicador() {
		return this.indHistoricoIndicador;
	}

	public void setIndHistoricoIndicador(HistoricoIndicadorDTO indHistoricoIndicador) {
		this.indHistoricoIndicador = indHistoricoIndicador;
	}

}