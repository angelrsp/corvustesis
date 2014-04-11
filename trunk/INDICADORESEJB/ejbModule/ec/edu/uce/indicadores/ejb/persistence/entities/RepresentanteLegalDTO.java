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
@NamedQuery(name="RepresentanteLegalDTO.findAll", query="SELECT r FROM RepresentanteLegalDTO r")
public class RepresentanteLegalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="IND_REPRESENTANTE_LEGAL_RLECODIGO_GENERATOR", sequenceName="IND_REPRESENTANTE_LEGAL_RLE_CODIGO_SEQ",allocationSize=1)
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
	private Integer rleTipo;

	@Column(name="rle_foto")
	private byte[] rleFoto;

	@Column(name="rle_foto_nombre")
	private String rleFotoNombre;
	
	@Transient
	private String rlePathFoto;
	
	//bi-directional many-to-one association to ContactoDTO
	@OneToMany(mappedBy="indRepresentanteLegal")
	private List<ContactoDTO> indContactos;

	//bi-directional many-to-one association to RegistroDTO
	@OneToMany(mappedBy="indRepresentanteLegal")
	private List<RegistroDTO> indRegistros;

	public RepresentanteLegalDTO() {
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

	public Integer getRleTipo() {
		return this.rleTipo;
	}

	public void setRleTipo(Integer rleTipo) {
		this.rleTipo = rleTipo;
	}

	public List<ContactoDTO> getIndContactos() {
		return this.indContactos;
	}

	public void setIndContactos(List<ContactoDTO> indContactos) {
		this.indContactos = indContactos;
	}

	public byte[] getRleFoto() {
		return rleFoto;
	}

	public void setRleFoto(byte[] rleFoto) {
		this.rleFoto = rleFoto;
	}

	public String getRleFotoNombre() {
		return rleFotoNombre;
	}

	public void setRleFotoNombre(String rleFotoNombre) {
		this.rleFotoNombre = rleFotoNombre;
	}

	public String getRlePathFoto() {
		return rlePathFoto;
	}

	public void setRlePathFoto(String rlePathFoto) {
		this.rlePathFoto = rlePathFoto;
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