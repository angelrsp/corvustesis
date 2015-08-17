package com.corvustec.notas.common.util.dto;

import java.io.Serializable;

import ec.edu.uce.notas.ejb.persistence.entity.UsuarioDTO;

public class PasswordDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String actualPassword;
	private String nuevoPassword;
	private String confirmarPassword;
	
	private UsuarioDTO usuarioDTO;
	
	public PasswordDTO() {
		usuarioDTO=new UsuarioDTO();
	}

	public String getActualPassword() {
		return actualPassword;
	}

	public void setActualPassword(String actualPassword) {
		this.actualPassword = actualPassword;
	}

	public String getNuevoPassword() {
		return nuevoPassword;
	}

	public void setNuevoPassword(String nuevoPassword) {
		this.nuevoPassword = nuevoPassword;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
}
