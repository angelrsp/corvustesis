package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ind_modelo database table.
 * 
 */
@Entity
@Table(name="ind_modelo")
@NamedQuery(name="ModeloDTO.findAll", query="SELECT m FROM ModeloDTO m")
public class ModeloDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_MODELO_MODCODIGO_GENERATOR", sequenceName="IND_MODELO_MOD_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_MODELO_MODCODIGO_GENERATOR")
	@Column(name="mod_codigo")
	private Integer modCodigo;

	@Column(name="mod_descripcion")
	private String modDescripcion;

	//bi-directional many-to-one association to IndicadorDTO
	@OneToMany(mappedBy="indModeloBean")
	private List<IndicadorDTO> indIndicadors;

	public ModeloDTO() {
	}

	public Integer getModCodigo() {
		return this.modCodigo;
	}

	public void setModCodigo(Integer modCodigo) {
		this.modCodigo = modCodigo;
	}

	public String getModDescripcion() {
		return this.modDescripcion;
	}

	public void setModDescripcion(String modDescripcion) {
		this.modDescripcion = modDescripcion;
	}

	public List<IndicadorDTO> getIndIndicadors() {
		return this.indIndicadors;
	}

	public void setIndIndicadors(List<IndicadorDTO> indIndicadors) {
		this.indIndicadors = indIndicadors;
	}

	public IndicadorDTO addIndIndicador(IndicadorDTO indIndicador) {
		getIndIndicadors().add(indIndicador);
		indIndicador.setIndModeloBean(this);

		return indIndicador;
	}

	public IndicadorDTO removeIndIndicador(IndicadorDTO indIndicador) {
		getIndIndicadors().remove(indIndicador);
		indIndicador.setIndModeloBean(null);

		return indIndicador;
	}

}