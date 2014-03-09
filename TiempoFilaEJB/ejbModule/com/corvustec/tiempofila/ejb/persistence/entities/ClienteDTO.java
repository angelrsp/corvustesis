package com.corvustec.tiempofila.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tfi_cliente database table.
 * 
 */
@Entity
@Table(name="tfi_cliente")
@NamedQuery(name="ClienteDTO.findAll", query="SELECT c FROM ClienteDTO c")
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TFI_CLIENTE_CLICODIGO_GENERATOR", sequenceName="TFI_CLIENTE_CLI_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TFI_CLIENTE_CLICODIGO_GENERATOR")
	@Column(name="cli_codigo")
	private Integer cliCodigo;

	@Column(name="cli_numero")
	private String cliNumero;

	//bi-directional many-to-one association to DispositivoDTO
	@ManyToOne
	@JoinColumn(name="cli_dispositivo")
	private DispositivoDTO tfiDispositivo;

	//bi-directional many-to-one association to TiempoDTO
	@OneToMany(mappedBy="tfiCliente")
	private List<TiempoDTO> tfiTiempos;

	public ClienteDTO() {
	}

	public Integer getCliCodigo() {
		return this.cliCodigo;
	}

	public void setCliCodigo(Integer cliCodigo) {
		this.cliCodigo = cliCodigo;
	}

	public String getCliNumero() {
		return this.cliNumero;
	}

	public void setCliNumero(String cliNumero) {
		this.cliNumero = cliNumero;
	}

	public DispositivoDTO getTfiDispositivo() {
		return this.tfiDispositivo;
	}

	public void setTfiDispositivo(DispositivoDTO tfiDispositivo) {
		this.tfiDispositivo = tfiDispositivo;
	}

	public List<TiempoDTO> getTfiTiempos() {
		return this.tfiTiempos;
	}

	public void setTfiTiempos(List<TiempoDTO> tfiTiempos) {
		this.tfiTiempos = tfiTiempos;
	}

	public TiempoDTO addTfiTiempo(TiempoDTO tfiTiempo) {
		getTfiTiempos().add(tfiTiempo);
		tfiTiempo.setTfiCliente(this);

		return tfiTiempo;
	}

	public TiempoDTO removeTfiTiempo(TiempoDTO tfiTiempo) {
		getTfiTiempos().remove(tfiTiempo);
		tfiTiempo.setTfiCliente(null);

		return tfiTiempo;
	}

}