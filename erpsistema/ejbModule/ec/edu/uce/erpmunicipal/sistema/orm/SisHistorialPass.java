package ec.edu.uce.erpmunicipal.sistema.orm;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the sis_historial_pass database table.
 * 
 */
@Entity
@Table(name="sis_historial_pass")
public class SisHistorialPass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SIS_HISTORIAL_PASS_HPACODIGO_GENERATOR", sequenceName="sis_historial_pass_hpa_codigo_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SIS_HISTORIAL_PASS_HPACODIGO_GENERATOR")
	@Column(name="hpa_codigo")
	private Integer hpaCodigo;

	@Column(name="hpa_fecha_registro")
	private Timestamp hpaFechaRegistro;

	@Column(name="hpa_pass")
	private String hpaPass;

	//bi-directional many-to-one association to SisUsuario
	@ManyToOne
	@JoinColumn(name="hpa_usuario")
	private SisUsuario sisUsuario;

	public SisHistorialPass() {
	}

	public Integer getHpaCodigo() {
		return this.hpaCodigo;
	}

	public void setHpaCodigo(Integer hpaCodigo) {
		this.hpaCodigo = hpaCodigo;
	}

	public Timestamp getHpaFechaRegistro() {
		return this.hpaFechaRegistro;
	}

	public void setHpaFechaRegistro(Timestamp hpaFechaRegistro) {
		this.hpaFechaRegistro = hpaFechaRegistro;
	}

	public String getHpaPass() {
		return this.hpaPass;
	}

	public void setHpaPass(String hpaPass) {
		this.hpaPass = hpaPass;
	}

	public SisUsuario getSisUsuario() {
		return this.sisUsuario;
	}

	public void setSisUsuario(SisUsuario sisUsuario) {
		this.sisUsuario = sisUsuario;
	}

}