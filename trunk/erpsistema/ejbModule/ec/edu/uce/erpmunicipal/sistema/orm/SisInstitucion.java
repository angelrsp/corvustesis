package ec.edu.uce.erpmunicipal.sistema.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sis_institucion database table.
 * 
 */
@Entity
@Table(name="sis_institucion")
public class SisInstitucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_INSTITUCION_INSCODIGO_GENERATOR", sequenceName="sis_institucion_ins_codigo_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_INSTITUCION_INSCODIGO_GENERATOR")
	@Column(name="ins_codigo")
	private Integer insCodigo;

	@Column(name="ins_activo")
	private Boolean insActivo;

	@Column(name="ins_direccion")
	private String insDireccion;

	@Column(name="ins_nombre")
	private String insNombre;

	@Column(name="ins_telefono")
	private String insTelefono;

	//bi-directional many-to-one association to SisUsuario
	@OneToMany(mappedBy="sisInstitucion")
	private List<SisUsuario> sisUsuarios;

	public SisInstitucion() {
	}

	public Integer getInsCodigo() {
		return this.insCodigo;
	}

	public void setInsCodigo(Integer insCodigo) {
		this.insCodigo = insCodigo;
	}

	public Boolean getInsActivo() {
		return this.insActivo;
	}

	public void setInsActivo(Boolean insActivo) {
		this.insActivo = insActivo;
	}

	public String getInsDireccion() {
		return this.insDireccion;
	}

	public void setInsDireccion(String insDireccion) {
		this.insDireccion = insDireccion;
	}

	public String getInsNombre() {
		return this.insNombre;
	}

	public void setInsNombre(String insNombre) {
		this.insNombre = insNombre;
	}

	public String getInsTelefono() {
		return this.insTelefono;
	}

	public void setInsTelefono(String insTelefono) {
		this.insTelefono = insTelefono;
	}

	public List<SisUsuario> getSisUsuarios() {
		return this.sisUsuarios;
	}

	public void setSisUsuarios(List<SisUsuario> sisUsuarios) {
		this.sisUsuarios = sisUsuarios;
	}

}