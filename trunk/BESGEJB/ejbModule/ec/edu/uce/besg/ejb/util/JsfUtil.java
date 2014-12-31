package ec.edu.uce.besg.ejb.util;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public class JsfUtil {

	public static SelectItem[] getSelectItems(List<?> entities,
			boolean selectOne) {
		int size = selectOne ? entities.size() + 1 : entities.size();
		SelectItem[] items = new SelectItem[size];
		int i = 0;
		if (selectOne) {
			items[0] = new SelectItem("", "---");
			i++;
		}
		for (Object x : entities) {
			items[i++] = new SelectItem(x, x.toString());
		}
		return items;
	}

	public static void addErrorMessage(Exception ex, String defaultMsg) {
		String msg = ex.getLocalizedMessage();
		if (msg != null && msg.length() > 0) {
			addErrorMessage(msg);
		} else {
			addErrorMessage(defaultMsg);
		}
	}

	public static void addErrorMessages(List<String> messages) {
		for (String message : messages) {
			addErrorMessage(message);
		}
	}

	public static void addErrorMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	public static void addInfoMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
	}

	public static void addWarningMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
		FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
	}

	public static void addFatalMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg);
		FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
	}

	
	public static String getRequestParameter(String key) {
		return FacesContext.getCurrentInstance().getExternalContext() .getRequestParameterMap().get(key);
	}

	public static ExternalContext getExternalContext()
	{
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	public static void redirect(String url) throws IOException
	{
		FacesContext.getCurrentInstance().getExternalContext().redirect(url);
	}
	
	public static void putObject(String key,Object value)
	{
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key,value);
	}
	
	public static Object getObject(String key)
	{
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	}
	
	public static Object getObjectFromRequestParameter(
			String requestParameterName, Converter converter, UIComponent component) {
		String theId = JsfUtil.getRequestParameter(requestParameterName);
		return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
	}
	
	 public static HttpSession getSession() {
	        return (HttpSession)
	          FacesContext.
	          getCurrentInstance().
	          getExternalContext().
	          getSession(false);
	 }

	 
	/*public static String getTypeFile(byte[] content)
	{
		String mimeType = null;
		try {		
			MagicMatch match = Magic.getMagicMatch(content);
			mimeType = match.getMimeType();
		} catch (MagicParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MagicMatchNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MagicException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mimeType;
	}
	*/
	public static String getRealPath()
	{
		ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();
		String deploymentDirectoryPath = ctx.getRealPath("/");
		return deploymentDirectoryPath;
	}
	
	
	
	/*public static Boolean descargarArchivo(byte[] fileArray)
	{
		boolean flag=false;
		if(fileArray!=null)
		{
			byte[] pdfData = fileArray;
		    FacesContext facesContext = FacesContext.getCurrentInstance();
		    ExternalContext externalContext = facesContext.getExternalContext();
		    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
	
		    // Initialize response.
		    response.reset(); // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
		    response.setContentType(JsfUtil.getTypeFile(pdfData)); // Check http://www.iana.org/assignments/media-types for all types. Use if necessary ServletContext#getMimeType() for auto-detection based on filename.
		    response.setHeader("Content-disposition", "attachment; filename=\"name.pdf\""); // The Save As popup magic is done here. You can give it any filename you want, this only won't work in MSIE, it will use current request URL as filename instead.
	
		    // Write file to response.
		    OutputStream output;
			try {
				output = response.getOutputStream();
			    output.write(pdfData);
			    output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JsfUtil.addErrorMessage(e.toString());
			}
	
		    // Inform JSF to not take the response in hands.
		    facesContext.responseComplete(); // Important! Else JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
		    flag=true;
		}
		return flag;
	}*/
}
