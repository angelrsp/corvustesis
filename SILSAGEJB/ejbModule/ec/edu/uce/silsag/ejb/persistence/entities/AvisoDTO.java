package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


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
	@SequenceGenerator(name="BEM_AVISO_AVICODIGO_GENERATOR", sequenceName="BEM_AVISO_AVI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BEM_AVISO_AVICODIGO_GENERATOR")
	@Column(name="avi_codigo")
	private Integer aviCodigo;

	@Column(name="avi_descripcion")
	private String aviDescripcion;

	@Column(name="avi_fecha_caducidad")
	private Timestamp aviFechaCaducidad;

	@Column(name="avi_puesto")
	private String aviPuesto;

	@Column(name="avi_remuneracion")
	private String aviRemuneracion;

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

	public String getAviPuesto() {
		return this.aviPuesto;
	}

	public void setAviPuesto(String aviPuesto) {
		this.aviPuesto = aviPuesto;
	}

	public String getAviRemuneracion() {
		return this.aviRemuneracion;
	}

	public void setAviRemuneracion(String aviRemuneracion) {
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