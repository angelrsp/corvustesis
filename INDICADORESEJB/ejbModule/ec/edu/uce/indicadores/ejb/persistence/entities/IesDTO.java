package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import ec.edu.uce.indicadores.commons.util.ApplicationUtil;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ind_ies database table.
 * 
 */
@Entity
@Table(name="ind_ies")
@NamedQuery(name="IesDTO.findAll", query="SELECT i FROM IesDTO i")
public class IesDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_IES_IESCODIGO_GENERATOR", sequenceName="IND_IES_IES_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_IES_IESCODIGO_GENERATOR")
	@Column(name="ies_codigo")
	private Integer iesCodigo;

	@Column(name="ies_fecha_creacion")
	private Timestamp iesFechaCreacion;

	@Column(name="ies_ley_creacion")
	private String iesLeyCreacion;

	@Column(name="ies_nombre_corto")
	private String iesNombreCorto;

	@Column(name="ies_razon_social")
	private String iesRazonSocial;

	@Column(name="ies_ruc")
	private String iesRuc;

	@Column(name="ies_imagen")
	private byte[] iesImagen;

	@Column(name="ies_imagen_name")
	private String iesImagenName;

	
	@Transient
	private String iesPathImagen;

	
	//bi-directional many-to-one association to LocalizacionDTO
	@ManyToOne
	@JoinColumn(name="ies_localizacion")
	private LocalizacionDTO indLocalizacion;

	//bi-directional many-to-one association to IndicadorDTO
	@OneToMany(mappedBy="indy")
	private List<IndicadorDTO> indIndicadors;

	//bi-directional many-to-one association to RegistroDTO
	@OneToMany(mappedBy="indy")
	private List<RegistroDTO> indRegistros;

	//bi-directional many-to-one association to UsuarioDTO
	@OneToMany(mappedBy="indy")
	private List<UsuarioDTO> indUsuarios;

	public IesDTO() {
	}

	
	
	public IesDTO(Integer iesCodigo) {
		super();
		this.iesCodigo = iesCodigo;
	}



	public Integer getIesCodigo() {
		return this.iesCodigo;
	}

	public void setIesCodigo(Integer iesCodigo) {
		this.iesCodigo = iesCodigo;
	}

	public Timestamp getIesFechaCreacion() {
		return this.iesFechaCreacion;
	}

	public void setIesFechaCreacion(Timestamp iesFechaCreacion) {
		this.iesFechaCreacion = iesFechaCreacion;
	}

	public String getIesLeyCreacion() {
		return this.iesLeyCreacion;
	}

	public void setIesLeyCreacion(String iesLeyCreacion) {
		this.iesLeyCreacion = iesLeyCreacion;
	}

	public String getIesNombreCorto() {
		return this.iesNombreCorto;
	}

	public void setIesNombreCorto(String iesNombreCorto) {
		this.iesNombreCorto = iesNombreCorto;
	}

	public String getIesRazonSocial() {
		return this.iesRazonSocial;
	}

	public void setIesRazonSocial(String iesRazonSocial) {
		this.iesRazonSocial = iesRazonSocial;
	}

	public String getIesRuc() {
		return this.iesRuc;
	}

	public void setIesRuc(String iesRuc) {
		this.iesRuc = iesRuc;
	}

	public byte[] getIesImagen() {
		return iesImagen;
	}

	public void setIesImagen(byte[] iesImagen) {
		this.iesImagen = iesImagen;
	}

	public String getIesImagenName() {
		return iesImagenName;
	}

	public void setIesImagenName(String iesImagenName) {
		this.iesImagenName = iesImagenName;
	}

	public String getIesPathImagen() {
		if(getIesImagen()!=null)
			iesPathImagen=ApplicationUtil.saveToDisk(getIesImagen(),getIesImagenName());
		return iesPathImagen;
	}

	public void setIesPathImagen(String iesPathImagen) {
		this.iesPathImagen = iesPathImagen;
	}

	public LocalizacionDTO getIndLocalizacion() {
		return this.indLocalizacion;
	}

	public void setIndLocalizacion(LocalizacionDTO indLocalizacion) {
		this.indLocalizacion = indLocalizacion;
	}

	public List<IndicadorDTO> getIndIndicadors() {
		return this.indIndicadors;
	}

	public void setIndIndicadors(List<IndicadorDTO> indIndicadors) {
		this.indIndicadors = indIndicadors;
	}

	public IndicadorDTO addIndIndicador(IndicadorDTO indIndicador) {
		getIndIndicadors().add(indIndicador);
		indIndicador.setIndy(this);

		return indIndicador;
	}

	public IndicadorDTO removeIndIndicador(IndicadorDTO indIndicador) {
		getIndIndicadors().remove(indIndicador);
		indIndicador.setIndy(null);

		return indIndicador;
	}

	public List<RegistroDTO> getIndRegistros() {
		return this.indRegistros;
	}

	public void setIndRegistros(List<RegistroDTO> indRegistros) {
		this.indRegistros = indRegistros;
	}

	public RegistroDTO addIndRegistro(RegistroDTO indRegistro) {
		getIndRegistros().add(indRegistro);
		indRegistro.setIndy(this);

		return indRegistro;
	}

	public RegistroDTO removeIndRegistro(RegistroDTO indRegistro) {
		getIndRegistros().remove(indRegistro);
		indRegistro.setIndy(null);

		return indRegistro;
	}

	public List<UsuarioDTO> getIndUsuarios() {
		return this.indUsuarios;
	}

	public void setIndUsuarios(List<UsuarioDTO> indUsuarios) {
		this.indUsuarios = indUsuarios;
	}

	public UsuarioDTO addIndUsuario(UsuarioDTO indUsuario) {
		getIndUsuarios().add(indUsuario);
		indUsuario.setIndy(this);

		return indUsuario;
	}

	public UsuarioDTO removeIndUsuario(UsuarioDTO indUsuario) {
		getIndUsuarios().remove(indUsuario);
		indUsuario.setIndy(null);

		return indUsuario;
	}

}