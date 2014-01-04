package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ind_representante_legal database table.
 * 
 */
@Entity
@Table(name="ind_representante_legal")
public class RepresentanteLegal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_REPRESENTANTE_LEGAL_RLECODIGO_GENERATOR", sequenceName="IND_REPRESENTANTE_LEGAL_RLE_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IND_REPRESENTANTE_LEGAL_RLECODIGO_GENERATOR")
	@Column(name="rle_codigo")
	private Integer rleCodigo;

	@Column(name="rle_apellidos")
	private String rleApellidos;

	@Column(name="rle_di")
	private String rleDi;

	@Column(name="rle_nombres")
	private String rleNombres;

	@Column(name="rle_tipo")
	private String rleTipo;

	//bi-directional many-to-one association to ContactoDTO
	@OneToMany(mappedBy="indRepresentanteLegal")
	private List<ContactoDTO> indContactos;

	//bi-directional many-to-one association to RegistroDTO
	@OneToMany(mappedBy="indRepresentanteLegal")
	private List<RegistroDTO> indRegistros;

	public RepresentanteLegal() {
	}

	public Integer getRleCodigo() {
		return this.rleCodigo;
	}

	public void setRleCodigo(Integer rleCodigo) {
		this.rleCodigo = rleCodigo;
	}

	public String getRleApellidos() {
		return this.rleApellidos;
	}

	public void setRleApellidos(String rleApellidos) {
		this.rleApellidos = rleApellidos;
	}

	public String getRleDi() {
		return this.rleDi;
	}

	public void setRleDi(String rleDi) {
		this.rleDi = rleDi;
	}

	public String getRleNombres() {
		return this.rleNombres;
	}

	public void setRleNombres(String rleNombres) {
		this.rleNombres = rleNombres;
	}

	public String getRleTipo() {
		return this.rleTipo;
	}

	public void setRleTipo(String rleTipo) {
		this.rleTipo = rleTipo;
	}

	public List<ContactoDTO> getIndContactos() {
		return this.indContactos;
	}

	public void setIndContactos(List<ContactoDTO> indContactos) {
		this.indContactos = indContactos;
	}

	public ContactoDTO addIndContacto(ContactoDTO indContacto) {
		getIndContactos().add(indContacto);
		indContacto.setIndRepresentanteLegal(this);

		return indContacto;
	}

	public ContactoDTO removeIndContacto(ContactoDTO indContacto) {
		getIndContactos().remove(indContacto);
		indContacto.setIndRepresentanteLegal(null);

		return indContacto;
	}

	public List<RegistroDTO> getIndRegistros() {
		return this.indRegistros;
	}

	public void setIndRegistros(List<RegistroDTO> indRegistros) {
		this.indRegistros = indRegistros;
	}

	public RegistroDTO addIndRegistro(RegistroDTO indRegistro) {
		getIndRegistros().add(indRegistro);
		indRegistro.setIndRepresentanteLegal(this);

		return indRegistro;
	}

	public RegistroDTO removeIndRegistro(RegistroDTO indRegistro) {
		getIndRegistros().remove(indRegistro);
		indRegistro.setIndRepresentanteLegal(null);

		return indRegistro;
	}

}