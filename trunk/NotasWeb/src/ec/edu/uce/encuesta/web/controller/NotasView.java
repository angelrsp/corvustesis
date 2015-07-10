package ec.edu.uce.encuesta.web.controller;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
 
@ManagedBean(name="dtEditView")
@ViewScoped
public class NotasView implements Serializable {
     
	 private List<Alumno> cars1;
	    private List<Alumno> cars2;
	    private String myText;
	    private Boolean edit;
	         
	    @ManagedProperty("#{carService}")
	    private AlumnosService service;
	     
	    @PostConstruct
	    public void init() {
	        cars1 = service.createAlumnos(10);
	        cars2 = service.createAlumnos(10);
	        edit=false;
	    }
	 
	    public List<Alumno> getCars1() {
	        return cars1;
	    }
	 
	    public List<Alumno> getCars2() {
	        return cars2;
	    }
	     
	    public List<String> getBrands() {
	        return service.getBrands();
	    }
	     
	    public List<String> getColors() {
	        return service.getColors();
	    }
	 
	    public void setService(AlumnosService service) {
	        this.service = service;
	    }
	     
	    public void onRowEdit(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Car Edited", ((Alumno) event.getObject()).getApellidos());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onRowCancel(RowEditEvent event) {
	        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Alumno) event.getObject()).getApellidos());
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	     
	    public void onCellEdit(CellEditEvent event) {
	        Object oldValue = event.getOldValue();
	        Object newValue = event.getNewValue();
	         
	        if(newValue != null && !newValue.equals(oldValue)) {
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }
	    }
	    
	    public void addTextAction(){
	    	   Alumno myClassObj =new Alumno();
	    	   if(!myText.isEmpty()){
	    	   myClassObj.setText(myText);
	    	   }
	    	   else{
	    	   myClassObj.setText(null);
	    	   }
	    	}

		public String getMyText() {
			return myText;
		}

		public void setMyText(String myText) {
			this.myText = myText;
		}

		public Boolean getEdit() {
			return edit;
		}

		public void setEdit(Boolean edit) {
			this.edit = edit;
		}
	    
	   public void editar() {
			edit = true;
		}
}


