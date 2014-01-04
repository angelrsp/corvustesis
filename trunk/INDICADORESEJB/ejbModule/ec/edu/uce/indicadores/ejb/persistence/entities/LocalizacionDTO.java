package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ind_localizacion database table.
 * 
 */
@Entity
@Table(name="ind_localizacion")
public class LocalizacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_LOCALIZACION_LOCCODIGO_GENERATOR", sequenceName="IND_LOCALIZACION_LOC_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_LOCALIZACION_LOCCODIGO_GENERATOR")
	@Column(name="loc_codigo")
	private Integer locCodigo;

	@Column(name="loc_nombre")
	private String locNombre;

	@Column(name="loc_tipo")
	private String locTipo;

	//bi-directional many-to-one association to IesDTO
	@OneToMany(mappedBy="indLocalizacion")
	private List<IesDTO> indIes;

	//bi-directional many-to-one association to LocalizacionDTO
	@ManyToOne
	@JoinColumn(name="loc_predecesor")
	private LocalizacionDTO indLocalizacion;

	//bi-directional many-to-one association to LocalizacionDTO
	@OneToMany(mappedBy="indLocalizacion")
	private List<LocalizacionDTO> indLocalizacions;

	public LocalizacionDTO() {
	}

	public Integer getLocCodigo() {
		return this.locCodigo;
	}

	public void setLocCodigo(Integer locCodigo) {
		this.locCodigo = locCodigo;
	}

	public String getLocNombre() {
		return this.locNombre;
	}

	public void setLocNombre(String locNombre) {
		this.locNombre = locNombre;
	}

	public String getLocTipo() {
		return this.locTipo;
	}

	public void setLocTipo(String locTipo) {
		this.locTipo = locTipo;
	}

	public List<IesDTO> getIndIes() {
		return this.indIes;
	}

	public void setIndIes(List<IesDTO> indIes) {
		this.indIes = indIes;
	}

	public IesDTO addIndy(IesDTO indy) {
		getIndIes().add(indy);
		indy.setIndLocalizacion(this);

		return indy;
	}

	public IesDTO removeIndy(IesDTO indy) {
		getIndIes().remove(indy);
		indy.setIndLocalizacion(null);

		return indy;
	}

	public LocalizacionDTO getIndLocalizacion() {
		return this.indLocalizacion;
	}

	public void setIndLocalizacion(LocalizacionDTO indLocalizacion) {
		this.indLocalizacion = indLocalizacion;
	}

	public List<LocalizacionDTO> getIndLocalizacions() {
		return this.indLocalizacions;
	}

	public void setIndLocalizacions(List<LocalizacionDTO> indLocalizacions) {
		this.indLocalizacions = indLocalizacions;
	}

	public LocalizacionDTO addIndLocalizacion(LocalizacionDTO indLocalizacion) {
		getIndLocalizacions().add(indLocalizacion);
		indLocalizacion.setIndLocalizacion(this);

		return indLocalizacion;
	}

	public LocalizacionDTO removeIndLocalizacion(LocalizacionDTO indLocalizacion) {
		getIndLocalizacions().remove(indLocalizacion);
		indLocalizacion.setIndLocalizacion(null);

		return indLocalizacion;
	}

}