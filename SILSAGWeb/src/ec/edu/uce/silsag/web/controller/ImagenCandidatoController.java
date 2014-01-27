package ec.edu.uce.silsag.web.controller;

import java.io.ByteArrayInputStream;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ManagedBean(name = "imagenCandidatoController")
@SessionScoped
public class ImagenCandidatoController {

	
    @EJB
    private CandidatosService candidatosService;

	private UsuarioDTO user;
	private CandidatoDTO candidato;
	

	public ImagenCandidatoController() {
    	user=new UsuarioDTO();
		candidato=new CandidatoDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
	}
    
    public StreamedContent getImage() throws SilsagException{    	
    	byte [] arregloImagen=candidatosService.obtenerCandidato(candidato.getCanCodigo()).getCanFoto();
    	String mime=JsfUtil.getTypeFile(arregloImagen);
        return new DefaultStreamedContent(new ByteArrayInputStream(arregloImagen),mime);
    }
    
    
	public void handleFileUpload(FileUploadEvent event) {        
		try {
			candidato.setCanFoto(event.getFile().getContents());
			candidatosService.actualizarCandidato(candidato);
			JsfUtil.addInfoMessage("Imagen "+ event.getFile().getFileName() + " fue subida.");
			getImage();
		} catch (SilsagException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
	}
    
}