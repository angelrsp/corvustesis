package ec.edu.uce.besg.web.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import ec.edu.uce.besg.common.util.UtilApplication;

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
//		String[] msgs=msg.split(":");
//        if(msgs.length>0)
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msgs[1], null));
//        else
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msgs[0], null));
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
        }

	public static void addInfoMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));		
	}

	public static void addWarningMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null));
	}

	public static void addFatalMessage(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null));		
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
		FacesContext.getCurrentInstance().getExternalContext().redirect(UtilApplication.appendStringBuilder("/",FacesContext.getCurrentInstance().getExternalContext().getContextName(),"/"+url).toString());
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

	 public static String getRandomName(String extension)
		{
			return UUID.randomUUID().toString()+"."+extension;	
		}
	 
	 public static String saveToDiskUpdload(byte[] bytefile,String fileName)
		{
			String pathDir,pathFile = null;
			String[] split;
			File f;
			try {
				split= fileName.split("\\.");
				fileName=JsfUtil.getRandomName(split[split.length-1]);
				
//				pathDir=getRealPath()+"\\images\\tmp\\upload\\";
				
				String pathRetalivaImagenes=File.separator+"images"+File.separator+"tmp"+File.separator+"upload"+File.separator;
				
				pathDir=getRealPath()+pathRetalivaImagenes;
				
				pathFile=pathDir+File.separator+fileName;
				
				f= new File(pathFile);
				if(f.exists())
					f.delete();
				
				f= new File(pathDir);
				if(!f.exists())
					f.mkdirs();
				FileOutputStream fos=new FileOutputStream(pathFile);
				fos.write(bytefile);
				fos.close();
				if(fileName.split("\\.")[1].equals("pdf")){
//					pathFile="\\images\\tmp\\upload\\"+fileName;
					pathFile=pathRetalivaImagenes+fileName;
				} else{
//					pathFile="\\images\\tmp\\upload\\"+fileName;
					pathFile=pathRetalivaImagenes+fileName;
				}
				pathFile=pathFile.replace('\\', '/');
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return pathFile;
		}
		
	 public static String getRealPath()
		{
			ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
					.getExternalContext().getContext();
			String deploymentDirectoryPath = ctx.getRealPath("/");
			return deploymentDirectoryPath;
		}
}
