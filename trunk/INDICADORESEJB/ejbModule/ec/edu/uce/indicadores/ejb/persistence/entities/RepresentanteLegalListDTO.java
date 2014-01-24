package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vie_representante_legal database table.
 * 
 */
@Entity
@Table(name="vie_representante_legal")
@NamedQuery(name="RepresentanteLegalListDTO.findAll", query="SELECT r FROM RepresentanteLegalListDTO r")
public class RepresentanteLegalListDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="cat_tipo_documento")
	private String catTipoDocumento;

	@Column(name="rle_apellidos")
	private String rleApellidos;

	@Id
	@Column(name="rle_codigo")
	private Integer rleCodigo;

	@Column(name="rle_di")
	private String rleDi;

	@Column(name="rle_nombres")
	private String rleNombres;

	@Column(name="rle_tipo")
	private Integer rleTipo;

	public RepresentanteLegalListDTO() {
	}

	public String getCatTipoDocumento() {
		return this.catTipoDocumento;
	}

	public void setCatTipoDocumento(String catTipoDocumento) {
		this.catTipoDocumento = catTipoDocumento;
	}

	public String getRleApellidos() {
		return this.rleApellidos;
	}

	public void setRleApellidos(String rleApellidos) {
		this.rleApellidos = rleApellidos;
	}

	public Integer getRleCodigo() {
		return this.rleCodigo;
	}

	public void setRleCodigo(Integer rleCodigo) {
		this.rleCodigo = rleCodigo;
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

}