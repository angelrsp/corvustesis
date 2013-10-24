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

	@Column(name="avi_fecha_caducidad")
	private Timestamp aviFechaCaducidad;

	@Column(name="avi_puesto")
	private Integer aviPuesto;

	@Column(name="avi_remuneracion_bruto")
	private BigDecimal aviRemuneracionBruto;

	@Column(name="avi_remuneracion_neta")
	private BigDecimal aviRemuneracionNeta;

	@Column(name="avi_requisito")
	private String aviRequisito;

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

	public BigDecimal getAviRemuneracionBruto() {
		return this.aviRemuneracionBruto;
	}

	public void setAviRemuneracionBruto(BigDecimal aviRemuneracionBruto) {
		this.aviRemuneracionBruto = aviRemuneracionBruto;
	}

	public BigDecimal getAviRemuneracionNeta() {
		return this.aviRemuneracionNeta;
	}

	public void setAviRemuneracionNeta(BigDecimal aviRemuneracionNeta) {
		this.aviRemuneracionNeta = aviRemuneracionNeta;
	}

	public String getAviRequisito() {
		return this.aviRequisito;
	}

	public void setAviRequisito(String aviRequisito) {
		this.aviRequisito = aviRequisito;
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