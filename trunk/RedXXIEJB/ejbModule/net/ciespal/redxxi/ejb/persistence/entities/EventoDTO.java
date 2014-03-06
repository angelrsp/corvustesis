package net.ciespal.redxxi.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the ate_evento database table.
 * 
 */
@Entity
@Table(name="ate_evento")
@NamedQuery(name="EventoDTO.findAll", query="SELECT e FROM EventoDTO e")
public class EventoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATE_EVENTO_EVECODIGO_GENERATOR", sequenceName="ATE_EVENTO_EVE_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATE_EVENTO_EVECODIGO_GENERATOR")
	@Column(name="eve_codigo")
	private Integer eveCodigo;

	@Column(name="eve_nombre")
	private String eveNombre;

	@Column(name="eve_perfil")
	private String evePerfil;

	@Column(name="eve_periocidad")
	private String evePeriocidad;

	@Column(name="eve_ciudad")
	private Integer eveCiudad;

	@Column(name="eve_provincia")
	private Integer eveProvincia;

	@Column(name="eve_pais")
	private Integer evePais;

	@Transient
	private Long eveCount;
	
	//bi-directional many-to-one association to EntidadDTO
	@OneToMany(mappedBy="ateEvento",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<EntidadDTO> ateEntidads;

	public EventoDTO() {
	}

	public EventoDTO(Long eveCount) {
		this.eveCount=eveCount;
	}

	public Integer getEveCodigo() {
		return this.eveCodigo;
	}

	public void setEveCodigo(Integer eveCodigo) {
		this.eveCodigo = eveCodigo;
	}

	public String getEveNombre() {
		return this.eveNombre;
	}

	public void setEveNombre(String eveNombre) {
		this.eveNombre = eveNombre;
	}

	public String getEvePerfil() {
		return this.evePerfil;
	}

	public void setEvePerfil(String evePerfil) {
		this.evePerfil = evePerfil;
	}

	public String getEvePeriocidad() {
		return this.evePeriocidad;
	}

	public void setEvePeriocidad(String evePeriocidad) {
		this.evePeriocidad = evePeriocidad;
	}

	public Integer getEveCiudad() {
		return eveCiudad;
	}

	public void setEveCiudad(Integer eveCiudad) {
		this.eveCiudad = eveCiudad;
	}

	public Integer getEveProvincia() {
		return eveProvincia;
	}

	public void setEveProvincia(Integer eveProvincia) {
		this.eveProvincia = eveProvincia;
	}

	public Integer getEvePais() {
		return evePais;
	}

	public void setEvePais(Integer evePais) {
		this.evePais = evePais;
	}

	public Long getEveCount() {
		return eveCount;
	}

	public void setEveCount(Long eveCount) {
		this.eveCount = eveCount;
	}

	public List<EntidadDTO> getAteEntidads() {
		return this.ateEntidads;
	}

	public void setAteEntidads(List<EntidadDTO> ateEntidads) {
		this.ateEntidads = ateEntidads;
	}

	public EntidadDTO addAteEntidad(EntidadDTO ateEntidad) {
		if(ateEntidad!=null)
		{
			if(getAteEntidads()==null)
				setAteEntidads(new ArrayList<EntidadDTO>());
			getAteEntidads().add(ateEntidad);
			ateEntidad.setAteEvento(this);
		}
		return ateEntidad;
	}

	public EntidadDTO removeAteEntidad(EntidadDTO ateEntidad) {
		getAteEntidads().remove(ateEntidad);
		ateEntidad.setAteEvento(null);

		return ateEntidad;
	}

}