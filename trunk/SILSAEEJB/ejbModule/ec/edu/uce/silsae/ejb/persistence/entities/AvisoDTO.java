package ec.edu.uce.silsae.ejb.persistence.entities;

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
public class AvisoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BEM_AVISO_AVINOMBRE_GENERATOR", sequenceName="BEM_AVISO_AVI_NOMBRE_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_AVISO_AVINOMBRE_GENERATOR")
	@Column(name="avi_nombre")
	private Integer aviNombre;

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

	public Integer getAviNombre() {
		return this.aviNombre;
	}

	public void setAviNombre(Integer aviNombre) {
		this.aviNombre = aviNombre;
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
	
}