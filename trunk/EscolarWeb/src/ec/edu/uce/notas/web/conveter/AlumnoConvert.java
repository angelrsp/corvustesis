package ec.edu.uce.notas.web.conveter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ec.edu.uce.notas.ejb.persistence.entity.view.AlumnoViewDTO;
import ec.edu.uce.notas.web.service.AlumnoService;


@FacesConverter("alumnoConvert")
public class AlumnoConvert implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent arg1, String value) {
		AlumnoViewDTO alumnoDTO = null;
		if(value != null && value.trim().length() > 0) {
			AlumnoService alumnoService=(AlumnoService) fc.getExternalContext().getApplicationMap().get("alumnoService");
			for(AlumnoViewDTO alu	:alumnoService.getAlumnoList())
			{
				if(alu.getUsuIdentificacion().equals(value))
					alumnoDTO=alu;
			}
		}
		return alumnoDTO;				
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if(object != null) {
            return String.valueOf(((AlumnoViewDTO) object).getUsuIdentificacion());
        }
        else {
            return null;
        }
	}

	
	 
	
}
