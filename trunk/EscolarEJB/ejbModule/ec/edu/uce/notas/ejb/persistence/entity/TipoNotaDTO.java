package ec.edu.uce.notas.ejb.persistence.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the not_tipo_nota database table.
 * 
 */
@Entity
@Table(name="not_tipo_nota")
@NamedQuery(name="TipoNotaDTO.findAll", query="SELECT t FROM TipoNotaDTO t")
public class TipoNotaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOT_TIPO_NOTA_TNOCODIGO_GENERATOR", sequenceName="NOT_TIPO_NOTA_TNO_CODIGO_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOT_TIPO_NOTA_TNOCODIGO_GENERATOR")
	@Column(name="tno_codigo")
	private Integer tnoCodigo;

	@Column(name="tno_descripcion")
	private String tnoDescripcion;

	//bi-directional many-to-one association to NotaDTO
	@OneToMany(mappedBy="notTipoNotaBean")
	private List<NotaDTO> notNotas;

	public TipoNotaDTO() {
	}

	public Integer getTnoCodigo() {
		return this.tnoCodigo;
	}

	public void setTnoCodigo(Integer tnoCodigo) {
		this.tnoCodigo = tnoCodigo;
	}

	public String getTnoDescripcion() {
		return this.tnoDescripcion;
	}

	public void setTnoDescripcion(String tnoDescripcion) {
		this.tnoDescripcion = tnoDescripcion;
	}

	public List<NotaDTO> getNotNotas() {
		return this.notNotas;
	}

	public void setNotNotas(List<NotaDTO> notNotas) {
		this.notNotas = notNotas;
	}

	public NotaDTO addNotNota(NotaDTO notNota) {
		getNotNotas().add(notNota);
		notNota.setNotTipoNotaBean(this);

		return notNota;
	}

	public NotaDTO removeNotNota(NotaDTO notNota) {
		getNotNotas().remove(notNota);
		notNota.setNotTipoNotaBean(null);

		return notNota;
	}

}