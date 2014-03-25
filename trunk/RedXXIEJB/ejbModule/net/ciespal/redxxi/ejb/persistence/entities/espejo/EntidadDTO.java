package net.ciespal.redxxi.ejb.persistence.entities.espejo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the esp_entidad database table.
 * 
 */
@Entity
@Table(name="esp_entidad")
@NamedQuery(name="EntidadDTO.findAll", query="SELECT e FROM EntidadDTO e")
public class EntidadDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ESP_ENTIDAD_ENTCODIGO_GENERATOR", sequenceName="ESP_ENTIDAD_ENT_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESP_ENTIDAD_ENTCODIGO_GENERATOR")
	@Column(name="ent_codigo")
	private Integer entCodigo;

	@Column(name="ent_tipo")
	private Integer entTipo;

	//bi-directional many-to-one association to EticaDTO
	@OneToMany(mappedBy="espEntidad")
	private List<EticaDTO> espEticas;

	//bi-directional many-to-one association to GranMaestroDTO
	@OneToMany(mappedBy="espEntidad")
	private List<GranMaestroDTO> espGranMaestros;

	//bi-directional many-to-one association to LeyDTO
	@OneToMany(mappedBy="espEntidad")
	private List<LeyDTO> espLeys;

	//bi-directional many-to-one association to MaestroCiespalDTO
	@OneToMany(mappedBy="espEntidad")
	private List<MaestroCiespalDTO> espMaestroCiespals;

	//bi-directional many-to-one association to NoticiaDTO
	@OneToMany(mappedBy="espEntidad")
	private List<NoticiaDTO> espNoticias;

	//bi-directional many-to-one association to ObraDTO
	@OneToMany(mappedBy="espEntidad")
	private List<ObraDTO> espObras;

	//bi-directional many-to-one association to PremioDTO
	@OneToMany(mappedBy="espEntidad")
	private List<PremioDTO> espPremios;

	//bi-directional many-to-one association to PremioCiespalDTO
	@OneToMany(mappedBy="espEntidad")
	private List<PremioCiespalDTO> espPremioCiespals;

	public EntidadDTO() {
	}

	public Integer getEntCodigo() {
		return this.entCodigo;
	}

	public void setEntCodigo(Integer entCodigo) {
		this.entCodigo = entCodigo;
	}

	public Integer getEntTipo() {
		return this.entTipo;
	}

	public void setEntTipo(Integer entTipo) {
		this.entTipo = entTipo;
	}

	public List<EticaDTO> getEspEticas() {
		return this.espEticas;
	}

	public void setEspEticas(List<EticaDTO> espEticas) {
		this.espEticas = espEticas;
	}

	public EticaDTO addEspEtica(EticaDTO espEtica) {
		getEspEticas().add(espEtica);
		espEtica.setEspEntidad(this);

		return espEtica;
	}

	public EticaDTO removeEspEtica(EticaDTO espEtica) {
		getEspEticas().remove(espEtica);
		espEtica.setEspEntidad(null);

		return espEtica;
	}

	public List<GranMaestroDTO> getEspGranMaestros() {
		return this.espGranMaestros;
	}

	public void setEspGranMaestros(List<GranMaestroDTO> espGranMaestros) {
		this.espGranMaestros = espGranMaestros;
	}

	public GranMaestroDTO addEspGranMaestro(GranMaestroDTO espGranMaestro) {
		getEspGranMaestros().add(espGranMaestro);
		espGranMaestro.setEspEntidad(this);

		return espGranMaestro;
	}

	public GranMaestroDTO removeEspGranMaestro(GranMaestroDTO espGranMaestro) {
		getEspGranMaestros().remove(espGranMaestro);
		espGranMaestro.setEspEntidad(null);

		return espGranMaestro;
	}

	public List<LeyDTO> getEspLeys() {
		return this.espLeys;
	}

	public void setEspLeys(List<LeyDTO> espLeys) {
		this.espLeys = espLeys;
	}

	public LeyDTO addEspLey(LeyDTO espLey) {
		getEspLeys().add(espLey);
		espLey.setEspEntidad(this);

		return espLey;
	}

	public LeyDTO removeEspLey(LeyDTO espLey) {
		getEspLeys().remove(espLey);
		espLey.setEspEntidad(null);

		return espLey;
	}

	public List<MaestroCiespalDTO> getEspMaestroCiespals() {
		return this.espMaestroCiespals;
	}

	public void setEspMaestroCiespals(List<MaestroCiespalDTO> espMaestroCiespals) {
		this.espMaestroCiespals = espMaestroCiespals;
	}

	public MaestroCiespalDTO addEspMaestroCiespal(MaestroCiespalDTO espMaestroCiespal) {
		getEspMaestroCiespals().add(espMaestroCiespal);
		espMaestroCiespal.setEspEntidad(this);

		return espMaestroCiespal;
	}

	public MaestroCiespalDTO removeEspMaestroCiespal(MaestroCiespalDTO espMaestroCiespal) {
		getEspMaestroCiespals().remove(espMaestroCiespal);
		espMaestroCiespal.setEspEntidad(null);

		return espMaestroCiespal;
	}

	public List<NoticiaDTO> getEspNoticias() {
		return this.espNoticias;
	}

	public void setEspNoticias(List<NoticiaDTO> espNoticias) {
		this.espNoticias = espNoticias;
	}

	public NoticiaDTO addEspNoticia(NoticiaDTO espNoticia) {
		getEspNoticias().add(espNoticia);
		espNoticia.setEspEntidad(this);

		return espNoticia;
	}

	public NoticiaDTO removeEspNoticia(NoticiaDTO espNoticia) {
		getEspNoticias().remove(espNoticia);
		espNoticia.setEspEntidad(null);

		return espNoticia;
	}

	public List<ObraDTO> getEspObras() {
		return this.espObras;
	}

	public void setEspObras(List<ObraDTO> espObras) {
		this.espObras = espObras;
	}

	public ObraDTO addEspObra(ObraDTO espObra) {
		getEspObras().add(espObra);
		espObra.setEspEntidad(this);

		return espObra;
	}

	public ObraDTO removeEspObra(ObraDTO espObra) {
		getEspObras().remove(espObra);
		espObra.setEspEntidad(null);

		return espObra;
	}

	public List<PremioDTO> getEspPremios() {
		return this.espPremios;
	}

	public void setEspPremios(List<PremioDTO> espPremios) {
		this.espPremios = espPremios;
	}

	public PremioDTO addEspPremio(PremioDTO espPremio) {
		getEspPremios().add(espPremio);
		espPremio.setEspEntidad(this);

		return espPremio;
	}

	public PremioDTO removeEspPremio(PremioDTO espPremio) {
		getEspPremios().remove(espPremio);
		espPremio.setEspEntidad(null);

		return espPremio;
	}

	public List<PremioCiespalDTO> getEspPremioCiespals() {
		return this.espPremioCiespals;
	}

	public void setEspPremioCiespals(List<PremioCiespalDTO> espPremioCiespals) {
		this.espPremioCiespals = espPremioCiespals;
	}

	public PremioCiespalDTO addEspPremioCiespal(PremioCiespalDTO espPremioCiespal) {
		getEspPremioCiespals().add(espPremioCiespal);
		espPremioCiespal.setEspEntidad(this);

		return espPremioCiespal;
	}

	public PremioCiespalDTO removeEspPremioCiespal(PremioCiespalDTO espPremioCiespal) {
		getEspPremioCiespals().remove(espPremioCiespal);
		espPremioCiespal.setEspEntidad(null);

		return espPremioCiespal;
	}

}