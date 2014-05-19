package net.ciespal.redxxi.ejb.persistence.entities.security;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seg_empresa database table.
 * 
 */
@Entity
@Table(name="seg_empresa")
@NamedQuery(name="EmpresaDTO.findAll", query="SELECT e FROM EmpresaDTO e")
public class EmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SEG_EMPRESA_EMPCODIGO_GENERATOR", sequenceName="SEG_EMPRESA_EMP_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEG_EMPRESA_EMPCODIGO_GENERATOR")
	@Column(name="emp_codigo")
	private Integer empCodigo;

	@Column(name="emp_nombre")
	private String empNombre;

	@Column(name="emp_ruc")
	private String empRuc;

	//bi-directional many-to-one association to UsuarioDTO
	@OneToMany(mappedBy="segEmpresa")
	private List<UsuarioDTO> segUsuarios;

	public EmpresaDTO() {
	}

	public Integer getEmpCodigo() {
		return this.empCodigo;
	}

	public void setEmpCodigo(Integer empCodigo) {
		this.empCodigo = empCodigo;
	}

	public String getEmpNombre() {
		return this.empNombre;
	}

	public void setEmpNombre(String empNombre) {
		this.empNombre = empNombre;
	}

	public String getEmpRuc() {
		return this.empRuc;
	}

	public void setEmpRuc(String empRuc) {
		this.empRuc = empRuc;
	}

	public List<UsuarioDTO> getSegUsuarios() {
		return this.segUsuarios;
	}

	public void setSegUsuarios(List<UsuarioDTO> segUsuarios) {
		this.segUsuarios = segUsuarios;
	}

	public UsuarioDTO addSegUsuario(UsuarioDTO segUsuario) {
		getSegUsuarios().add(segUsuario);
		segUsuario.setSegEmpresa(this);

		return segUsuario;
	}

	public UsuarioDTO removeSegUsuario(UsuarioDTO segUsuario) {
		getSegUsuarios().remove(segUsuario);
		segUsuario.setSegEmpresa(null);

		return segUsuario;
	}

}