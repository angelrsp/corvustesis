package ec.edu.uce.silsag.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vie_anio_estudio database table.
 * 
 */
@Entity
@Table(name="vie_anio_estudio")
@NamedQuery(name="AnioEstudioDTO.findAll", query="SELECT a FROM AnioEstudioDTO a")
public class AnioEstudioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="anio_estudio")
	private String anioEstudio;

	public AnioEstudioDTO() {
	}

	public String getAnioEstudio() {
		return this.anioEstudio;
	}

	public void setAnioEstudio(String anioEstudio) {
		this.anioEstudio = anioEstudio;
	}

}