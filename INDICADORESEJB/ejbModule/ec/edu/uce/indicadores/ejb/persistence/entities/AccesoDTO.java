package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ind_acceso database table.
 * 
 */
@Entity
@Table(name="ind_acceso")
@NamedQuery(name="AccesoDTO.findAll", query="SELECT a FROM AccesoDTO a")
public class AccesoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_ACCESO_ACCCODIGO_GENERATOR", sequenceName="IND_ACCESO_ACC_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_ACCESO_ACCCODIGO_GENERATOR")
	@Column(name="acc_codigo")
	private Integer accCodigo;

	//bi-directional many-to-one association to OpcionDTO
	@ManyToOne
	@JoinColumn(name="acc_opcion")
	private OpcionDTO indOpcion;

	//bi-directional many-to-one association to PerfilDTO
	@ManyToOne
	@JoinColumn(name="acc_perfil")
	private PerfilDTO indPerfil;

	public AccesoDTO() {
	}

	public Integer getAccCodigo() {
		return this.accCodigo;
	}

	public void setAccCodigo(Integer accCodigo) {
		this.accCodigo = accCodigo;
	}

	public OpcionDTO getIndOpcion() {
		return this.indOpcion;
	}

	public void setIndOpcion(OpcionDTO indOpcion) {
		this.indOpcion = indOpcion;
	}

	public PerfilDTO getIndPerfil() {
		return this.indPerfil;
	}

	public void setIndPerfil(PerfilDTO indPerfil) {
		this.indPerfil = indPerfil;
	}

}