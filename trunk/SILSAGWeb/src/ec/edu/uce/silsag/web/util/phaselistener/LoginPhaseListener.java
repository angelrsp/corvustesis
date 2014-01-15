/**
 * 
 */
package ec.edu.uce.silsag.web.util.phaselistener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 
 *
 */
public class LoginPhaseListener implements PhaseListener{

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent phaseEvent) {
		FacesContext facesContext = phaseEvent.getFacesContext();
		HttpServletResponse httpServletResponse = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		httpServletResponse.setHeader("Cache-Control", "no-cache");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", -1L);
		
//		FacesContext fc = phaseEvent.getFacesContext();
		String [] paginasPermitidas = {"principal"};
		
		String paginaActual = facesContext.getViewRoot().getViewId();
		NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
		
		Boolean paginaLogin = paginaActual.lastIndexOf("login") > -1 ? Boolean.TRUE : Boolean.FALSE;
		
	}

	@Override
	public void beforePhase(PhaseEvent phaseEvent) {}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
