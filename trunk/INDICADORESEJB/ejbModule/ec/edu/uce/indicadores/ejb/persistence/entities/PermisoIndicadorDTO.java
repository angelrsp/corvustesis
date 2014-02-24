package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ind_permiso_indicador database table.
 * 
 */
@Entity
@Table(name="ind_permiso_indicador")
@NamedQuery(name="PermisoIndicadorDTO.findAll", query="SELECT p FROM PermisoIndicadorDTO p")
public class PermisoIndicadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_PERMISO_INDICADOR_PEICODIGO_GENERATOR", sequenceName="IND_PERMISO_INDICADOR_PEI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_PERMISO_INDICADOR_PEICODIGO_GENERATOR")
	@Column(name="pei_codigo")
	private Integer peiCodigo;

	@Column(name="pei_indicador")
	private Integer peiIndicador;

	@ManyToOne
	@JoinColumn(name="pei_perfil")
	private PerfilDTO indPerfil;

	
	public PermisoIndicadorDTO() {
	}

	public Integer getPeiCodigo() {
		return this.peiCodigo;
	}

	public void setPeiCodigo(Integer peiCodigo) {
		this.peiCodigo = peiCodigo;
	}

	public Integer getPeiIndicador() {
		return this.peiIndicador;
	}

	public void setPeiIndicador(Integer peiIndicador) {
		this.peiIndicador = peiIndicador;
	}

	public PerfilDTO getIndPerfil() {
		return indPerfil;
	}

	public void setIndPerfil(PerfilDTO indPerfil) {
		this.indPerfil = indPerfil;
	}

}