package ec.edu.uce.indicadores.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the ind_registro database table.
 * 
 */
@Entity
@Table(name="ind_registro")
public class RegistroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reg_fecha_inicio")
	private Date regFechaInicio;

	@Column(name="reg_fecha_fin")
	private Timestamp regFechaFin;

	//bi-directional many-to-one association to IesDTO
	@ManyToOne
	@JoinColumn(name="reg_ies")
	private IesDTO indy;

	//bi-directional many-to-one association to RepresentanteLegal
	@ManyToOne
	@JoinColumn(name="reg_representante_legal")
	private RepresentanteLegal indRepresentanteLegal;

	public RegistroDTO() {
	}

	public Date getRegFechaInicio() {
		return this.regFechaInicio;
	}

	public void setRegFechaInicio(Date regFechaInicio) {
		this.regFechaInicio = regFechaInicio;
	}

	public Timestamp getRegFechaFin() {
		return this.regFechaFin;
	}

	public void setRegFechaFin(Timestamp regFechaFin) {
		this.regFechaFin = regFechaFin;
	}

	public IesDTO getIndy() {
		return this.indy;
	}

	public void setIndy(IesDTO indy) {
		this.indy = indy;
	}

	public RepresentanteLegal getIndRepresentanteLegal() {
		return this.indRepresentanteLegal;
	}

	public void setIndRepresentanteLegal(RepresentanteLegal indRepresentanteLegal) {
		this.indRepresentanteLegal = indRepresentanteLegal;
	}

}