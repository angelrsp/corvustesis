package ec.edu.uce.silsae.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.silsae.commons.util.SilsaeException;
import ec.edu.uce.silsae.ejb.negocio.AdministracionService;
import ec.edu.uce.silsae.ejb.persistence.entities.CandidatoDTO;

@ViewScoped
@ManagedBean(name = "verCandidatoController")
public class VerCandidatoController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AdministracionService administracionService;

	public List<CandidatoDTO> candidatoList;
	
	public VerCandidatoController()
	{
		
	}
	
	@PostConstruct
	private void init()
	{
		candidatoList=new ArrayList<CandidatoDTO>();	
	}

	public List<CandidatoDTO> getCandidatoList() throws SilsaeException {
		this.candidatoList=administracionService.obtenerCandidatos();
		return candidatoList;
	}
}
