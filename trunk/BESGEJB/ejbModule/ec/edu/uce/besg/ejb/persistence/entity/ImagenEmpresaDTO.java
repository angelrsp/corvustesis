package ec.edu.uce.besg.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bem_imagen_empresa database table.
 * 
 */
@Entity
@Table(name="bem_imagen_empresa")
@NamedQuery(name="ImagenEmpresaDTO.findAll", query="SELECT i FROM ImagenEmpresaDTO i")
public class ImagenEmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_IMAGEN_EMPRESA_IEMCODIGO_GENERATOR", sequenceName="BEM_IMAGEN_EMPRESA_IEM_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_IMAGEN_EMPRESA_IEMCODIGO_GENERATOR")
	@Column(name="iem_codigo")
	private Integer iemCodigo;

	@Column(name="iem_imagen")
	private byte[] iemImagen;

	@Column(name="iem_path")
	private String iemPath;

	//bi-directional many-to-one association to EmpresaDTO
	@ManyToOne
	@JoinColumn(name="iem_empresa")
	private EmpresaDTO bemEmpresa;

	public ImagenEmpresaDTO() {
	}

	public Integer getIemCodigo() {
		return this.iemCodigo;
	}

	public void setIemCodigo(Integer iemCodigo) {
		this.iemCodigo = iemCodigo;
	}

	public byte[] getIemImagen() {
		return this.iemImagen;
	}

	public void setIemImagen(byte[] iemImagen) {
		this.iemImagen = iemImagen;
	}

	public String getIemPath() {
		return this.iemPath;
	}

	public void setIemPath(String iemPath) {
		this.iemPath = iemPath;
	}

	public EmpresaDTO getBemEmpresa() {
		return this.bemEmpresa;
	}

	public void setBemEmpresa(EmpresaDTO bemEmpresa) {
		this.bemEmpresa = bemEmpresa;
	}

}