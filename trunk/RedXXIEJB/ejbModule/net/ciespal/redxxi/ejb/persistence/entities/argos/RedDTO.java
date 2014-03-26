package net.ciespal.redxxi.ejb.persistence.entities.argos;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the arg_red database table.
 * 
 */
@Entity
@Table(name="arg_red")
@NamedQuery(name="RedDTO.findAll", query="SELECT r FROM RedDTO r")
public class RedDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ARG_RED_REDCODIGO_GENERATOR", sequenceName="ARG_RED_RED_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARG_RED_REDCODIGO_GENERATOR")
	@Column(name="red_codigo")
	private Integer redCodigo;

	@Column(name="red_nombre")
	private String redNombre;

	//bi-directional many-to-one association to ObservatorioDTO
	@OneToMany(mappedBy="argRed")
	private List<ObservatorioDTO> argObservatorios;

	public RedDTO() {
	}
	
	public RedDTO(Integer redCodigo) {
		this.redCodigo = redCodigo;
	}

	public Integer getRedCodigo() {
		return this.redCodigo;
	}

	public void setRedCodigo(Integer redCodigo) {
		this.redCodigo = redCodigo;
	}

	public String getRedNombre() {
		return this.redNombre;
	}

	public void setRedNombre(String redNombre) {
		this.redNombre = redNombre;
	}

	public List<ObservatorioDTO> getArgObservatorios() {
		return this.argObservatorios;
	}

	public void setArgObservatorios(List<ObservatorioDTO> argObservatorios) {
		this.argObservatorios = argObservatorios;
	}

	public ObservatorioDTO addArgObservatorio(ObservatorioDTO argObservatorio) {
		getArgObservatorios().add(argObservatorio);
		argObservatorio.setArgRed(this);

		return argObservatorio;
	}

	public ObservatorioDTO removeArgObservatorio(ObservatorioDTO argObservatorio) {
		getArgObservatorios().remove(argObservatorio);
		argObservatorio.setArgRed(null);

		return argObservatorio;
	}

}