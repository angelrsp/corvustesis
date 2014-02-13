package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ind_perfil database table.
 * 
 */
@Entity
@Table(name="ind_perfil")
@NamedQuery(name="PerfilDTO.findAll", query="SELECT p FROM PerfilDTO p")
public class PerfilDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_PERFIL_PERCODIGO_GENERATOR", sequenceName="IND_PERFIL_PER_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_PERFIL_PERCODIGO_GENERATOR")
	@Column(name="per_codigo")
	private Integer perCodigo;

	@Column(name="per_descripcion")
	private String perDescripcion;

	//bi-directional many-to-one association to AccesoDTO
	@OneToMany(mappedBy="indPerfil")
	private List<AccesoDTO> indAccesos;

	//bi-directional many-to-one association to UsuarioPerfilDTO
	@OneToMany(mappedBy="indPerfil")
	private List<UsuarioPerfilDTO> indUsuarioPerfils;

	public PerfilDTO() {
	}

	public PerfilDTO(Integer perCodigo) {
		super();
		this.perCodigo = perCodigo;
	}



	public Integer getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Integer perCodigo) {
		this.perCodigo = perCodigo;
	}

	public String getPerDescripcion() {
		return this.perDescripcion;
	}

	public void setPerDescripcion(String perDescripcion) {
		this.perDescripcion = perDescripcion;
	}

	public List<AccesoDTO> getIndAccesos() {
		return this.indAccesos;
	}

	public void setIndAccesos(List<AccesoDTO> indAccesos) {
		this.indAccesos = indAccesos;
	}

	public AccesoDTO addIndAcceso(AccesoDTO indAcceso) {
		getIndAccesos().add(indAcceso);
		indAcceso.setIndPerfil(this);

		return indAcceso;
	}

	public AccesoDTO removeIndAcceso(AccesoDTO indAcceso) {
		getIndAccesos().remove(indAcceso);
		indAcceso.setIndPerfil(null);

		return indAcceso;
	}

	public List<UsuarioPerfilDTO> getIndUsuarioPerfils() {
		return this.indUsuarioPerfils;
	}

	public void setIndUsuarioPerfils(List<UsuarioPerfilDTO> indUsuarioPerfils) {
		this.indUsuarioPerfils = indUsuarioPerfils;
	}

	public UsuarioPerfilDTO addIndUsuarioPerfil(UsuarioPerfilDTO indUsuarioPerfil) {
		getIndUsuarioPerfils().add(indUsuarioPerfil);
		indUsuarioPerfil.setIndPerfil(this);

		return indUsuarioPerfil;
	}

	public UsuarioPerfilDTO removeIndUsuarioPerfil(UsuarioPerfilDTO indUsuarioPerfil) {
		getIndUsuarioPerfils().remove(indUsuarioPerfil);
		indUsuarioPerfil.setIndPerfil(null);

		return indUsuarioPerfil;
	}

}