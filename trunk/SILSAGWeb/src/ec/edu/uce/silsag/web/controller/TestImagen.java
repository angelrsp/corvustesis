package ec.edu.uce.silsag.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ViewScoped
@ManagedBean (name = "testImagen")
public class TestImagen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(TestImagen.class);
	
	private UploadedFile uploadedFile;
	
	public TestImagen() {
		  logger.info("Entro");
	}
	
	@PostConstruct
	private void init()
	{
		logger.info("Entro");
	}
	  public void handleFileUpload(FileUploadEvent event) {  
		  logger.info("Entro imagen");
	        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }
	  
	  
	  public void upload(FileUploadEvent event) {
		  logger.info("Entro uplad");
		  FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded."); 
		  FacesContext.getCurrentInstance().addMessage(null, msg);
     		   
	  }  
	  
	  
	  public void subirImagen()
	  {
		  logger.info("subirImagen");
			//candidato.setCanFoto(uploadedFile.getContents());
		    if(uploadedFile != null) {  
	            FacesMessage msg = new FacesMessage("Succesful", uploadedFile.getFileName() + " is uploaded.");  
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            logger.info("Si");
		    }
		    else
		    {
	            FacesMessage msg = new FacesMessage("Succesful", "No subio");  
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	            logger.info("No");
		    }

	  }

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
		logger.info("veamos");
	}
}
