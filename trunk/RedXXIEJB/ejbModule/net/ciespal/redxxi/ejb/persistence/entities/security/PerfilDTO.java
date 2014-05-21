package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_perfil database table.
 * 
 */
@Entity
@Table(name="seg_perfil")
@NamedQuery(name="PerfilDTO.findAll", query="SELECT p FROM PerfilDTO p")
public class PerfilDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_PERFIL_PERCODIGO_GENERATOR", sequenceName="SEG_PERFIL_PER_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_PERFIL_PERCODIGO_GENERATOR")
	@Column(name="per_codigo")
	private Integer perCodigo;

	@Column(name="per_nombre")
	private String perNombre;

	//bi-directional many-to-one association to AccesoDTO
	@OneToMany(mappedBy="segPerfil")
	private List<AccesoDTO> segAccesos;

	//bi-directional many-to-one association to UsuarioPerfilDTO
	@OneToMany(mappedBy="segPerfil")
	private List<UsuarioPerfilDTO> segUsuarioPerfils;

	public PerfilDTO() {
	}

	public Integer getPerCodigo() {
		return this.perCodigo;
	}

	public void setPerCodigo(Integer perCodigo) {
		this.perCodigo = perCodigo;
	}

	public String getPerNombre() {
		return this.perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public List<AccesoDTO> getSegAccesos() {
		return this.segAccesos;
	}

	public void setSegAccesos(List<AccesoDTO> segAccesos) {
		this.segAccesos = segAccesos;
	}

	public AccesoDTO addSegAcceso(AccesoDTO segAcceso) {
		getSegAccesos().add(segAcceso);
		segAcceso.setSegPerfil(this);

		return segAcceso;
	}

	public AccesoDTO removeSegAcceso(AccesoDTO segAcceso) {
		getSegAccesos().remove(segAcceso);
		segAcceso.setSegPerfil(null);

		return segAcceso;
	}

	public List<UsuarioPerfilDTO> getSegUsuarioPerfils() {
		return this.segUsuarioPerfils;
	}

	public void setSegUsuarioPerfils(List<UsuarioPerfilDTO> segUsuarioPerfils) {
		this.segUsuarioPerfils = segUsuarioPerfils;
	}

	public UsuarioPerfilDTO addSegUsuarioPerfil(UsuarioPerfilDTO segUsuarioPerfil) {
		getSegUsuarioPerfils().add(segUsuarioPerfil);
		segUsuarioPerfil.setSegPerfil(this);

		return segUsuarioPerfil;
	}

	public UsuarioPerfilDTO removeSegUsuarioPerfil(UsuarioPerfilDTO segUsuarioPerfil) {
		getSegUsuarioPerfils().remove(segUsuarioPerfil);
		segUsuarioPerfil.setSegPerfil(null);

		return segUsuarioPerfil;
	}

}