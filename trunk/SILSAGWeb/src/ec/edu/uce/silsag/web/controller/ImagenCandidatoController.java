package ec.edu.uce.silsag.web.controller;

import java.io.ByteArrayInputStream;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.edu.uce.silsag.commons.util.SilsagException;
import ec.edu.uce.silsag.ejb.negocio.AdministracionService;
import ec.edu.uce.silsag.ejb.negocio.CandidatosService;
import ec.edu.uce.silsag.ejb.persistence.entities.CandidatoDTO;
import ec.edu.uce.silsag.ejb.persistence.entities.UsuarioDTO;
import ec.edu.uce.silsag.web.util.JsfUtil;

@ManagedBean(name = "imagenCandidatoController")
@SessionScoped
public class ImagenCandidatoController {

	
    @EJB
    private CandidatosService candidatosService;
    
    @EJB
    private AdministracionService administracionService;
    

	private UsuarioDTO user;
	private CandidatoDTO candidato;
	

	public ImagenCandidatoController() {
    	user=new UsuarioDTO();
		candidato=new CandidatoDTO();
		user=(UsuarioDTO)JsfUtil.getObject("UsuarioDTO");
		candidato=user.getBemCandidatos().get(0);
	}
    
    public StreamedContent getImage() throws SilsagException{    	
    	byte [] arregloImagen;
    	arregloImagen=candidatosService.obtenerCandidato(candidato.getCanCodigo()).getCanFoto();
    	String mime;
    	if(arregloImagen!=null)
    	{
    		mime=JsfUtil.getTypeFile(arregloImagen);
    		return new DefaultStreamedContent(new ByteArrayInputStream(arregloImagen),mime);
    	}
    	else
    	{
    		if(candidato.getCanSexo()!=null)
    		{
	    		if(candidato.getCanSexo()==33)
	    		{
	    			arregloImagen=administracionService.obtenerParametro(2).getParValorImagen();
	    		}
	    		else if(candidato.getCanSexo()==34)
	    		{
	    			arregloImagen=administracionService.obtenerParametro(1).getParValorImagen();
	    		}
	    		if(arregloImagen!=null)
	    		{
		    		mime=JsfUtil.getTypeFile(arregloImagen);
		    		return new DefaultStreamedContent(new ByteArrayInputStream(arregloImagen),mime);
	    		}
	    		else
	    		{
	    			return new DefaultStreamedContent();
	    		}
    		}
    		else
    		{
    			arregloImagen=administracionService.obtenerParametro(3).getParValorImagen();
    			mime=JsfUtil.getTypeFile(arregloImagen);
	    		return new DefaultStreamedContent(new ByteArrayInputStream(arregloImagen),mime);
    		}
    	}
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