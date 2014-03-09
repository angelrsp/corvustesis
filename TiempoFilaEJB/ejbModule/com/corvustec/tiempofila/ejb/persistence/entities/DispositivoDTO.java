package com.corvustec.tiempofila.ejb.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tfi_dispositivo database table.
 * 
 */
@Entity
@Table(name="tfi_dispositivo")
@NamedQuery(name="DispositivoDTO.findAll", query="SELECT d FROM DispositivoDTO d")
public class DispositivoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TFI_DISPOSITIVO_DISCODIGO_GENERATOR", sequenceName="TFI_DISPOSITIVO_DIS_CODIGO_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TFI_DISPOSITIVO_DISCODIGO_GENERATOR")
	@Column(name="dis_codigo")
	private Integer disCodigo;

	@Column(name="dis_autorizado")
	private Boolean disAutorizado;

	@Column(name="dis_serie")
	private String disSerie;

	//bi-directional many-to-one association to ClienteDTO
	@OneToMany(mappedBy="tfiDispositivo")
	private List<ClienteDTO> tfiClientes;

	public DispositivoDTO() {
	}

	public Integer getDisCodigo() {
		return this.disCodigo;
	}

	public void setDisCodigo(Integer disCodigo) {
		this.disCodigo = disCodigo;
	}

	public Boolean getDisAutorizado() {
		return this.disAutorizado;
	}

	public void setDisAutorizado(Boolean disAutorizado) {
		this.disAutorizado = disAutorizado;
	}

	public String getDisSerie() {
		return this.disSerie;
	}

	public void setDisSerie(String disSerie) {
		this.disSerie = disSerie;
	}

	public List<ClienteDTO> getTfiClientes() {
		return this.tfiClientes;
	}

	public void setTfiClientes(List<ClienteDTO> tfiClientes) {
		this.tfiClientes = tfiClientes;
	}

	public ClienteDTO addTfiCliente(ClienteDTO tfiCliente) {
		getTfiClientes().add(tfiCliente);
		tfiCliente.setTfiDispositivo(this);

		return tfiCliente;
	}

	public ClienteDTO removeTfiCliente(ClienteDTO tfiCliente) {
		getTfiClientes().remove(tfiCliente);
		tfiCliente.setTfiDispositivo(null);

		return tfiCliente;
	}

}