package ec.edu.uce.erpmunicipal.util.orm;

import java.io.Serializable;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConPeriodo;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuario;
import ec.edu.uce.erpmunicipal.sistema.orm.SisUsuarioRol;

public class SessionObject implements Serializable {


	private static final long serialVersionUID = 1L;

	private SisUsuario user;
	private SisUsuarioRol userRol;

	private ConPeriodo periodo;
	
	private int anio;

	public SessionObject() {
		
	}

	public SisUsuario getUser() {
		return user;
	}

	public void setUser(SisUsuario user) {
		this.user = user;
	}

	public SisUsuarioRol getUserRol() {
		return userRol;
	}

	public void setUserRol(SisUsuarioRol userRol) {
		this.userRol = userRol;
	}

	public ConPeriodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(ConPeriodo periodo) {
		this.periodo = periodo;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

}
