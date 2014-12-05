package ec.edu.uce.besg.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the bem_aviso database table.
 * 
 */
@Entity
@Table(name="bem_aviso")
@NamedQuery(name="AvisoDTO.findAll", query="SELECT a FROM AvisoDTO a")
public class AvisoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_AVISO_AVICODIGO_GENERATOR", sequenceName="BEM_AVISO_AVI_CODIGO_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_AVISO_AVICODIGO_GENERATOR")
	@Column(name="avi_codigo")
	private Integer aviCodigo;

	@Column(name="avi_descripcion")
	private String aviDescripcion;

	@Column(name="avi_fecha_caducidad")
	private Timestamp aviFechaCaducidad;

	@Column(name="avi_puesto")
	private Integer aviPuesto;

	@Column(name="avi_remuneracion")
	private BigDecimal aviRemuneracion;

	@Column(name="avi_vacantes")
	private Integer aviVacantes;

	//bi-directional many-to-one association to EmpresaDTO
	@ManyToOne
	@JoinColumn(name="avi_empresa")
	private EmpresaDTO bemEmpresa;

	//bi-directional many-to-one association to PostulacionDTO
	@OneToMany(mappedBy="bemAviso")
	private List<PostulacionDTO> bemPostulacions;

	public AvisoDTO() {
	}

	public Integer getAviCodigo() {
		return this.aviCodigo;
	}

	public void setAviCodigo(Integer aviCodigo) {
		this.aviCodigo = aviCodigo;
	}

	public String getAviDescripcion() {
		return this.aviDescripcion;
	}

	public void setAviDescripcion(String aviDescripcion) {
		this.aviDescripcion = aviDescripcion;
	}

	public Timestamp getAviFechaCaducidad() {
		return this.aviFechaCaducidad;
	}

	public void setAviFechaCaducidad(Timestamp aviFechaCaducidad) {
		this.aviFechaCaducidad = aviFechaCaducidad;
	}

	public Integer getAviPuesto() {
		return this.aviPuesto;
	}

	public void setAviPuesto(Integer aviPuesto) {
		this.aviPuesto = aviPuesto;
	}

	public BigDecimal getAviRemuneracion() {
		return this.aviRemuneracion;
	}

	public void setAviRemuneracion(BigDecimal aviRemuneracion) {
		this.aviRemuneracion = aviRemuneracion;
	}

	public Integer getAviVacantes() {
		return this.aviVacantes;
	}

	public void setAviVacantes(Integer aviVacantes) {
		this.aviVacantes = aviVacantes;
	}

	public EmpresaDTO getBemEmpresa() {
		return this.bemEmpresa;
	}

	public void setBemEmpresa(EmpresaDTO bemEmpresa) {
		this.bemEmpresa = bemEmpresa;
	}

	public List<PostulacionDTO> getBemPostulacions() {
		return this.bemPostulacions;
	}

	public void setBemPostulacions(List<PostulacionDTO> bemPostulacions) {
		this.bemPostulacions = bemPostulacions;
	}

	public PostulacionDTO addBemPostulacion(PostulacionDTO bemPostulacion) {
		getBemPostulacions().add(bemPostulacion);
		bemPostulacion.setBemAviso(this);

		return bemPostulacion;
	}

	public PostulacionDTO removeBemPostulacion(PostulacionDTO bemPostulacion) {
		getBemPostulacions().remove(bemPostulacion);
		bemPostulacion.setBemAviso(null);

		return bemPostulacion;
	}

}