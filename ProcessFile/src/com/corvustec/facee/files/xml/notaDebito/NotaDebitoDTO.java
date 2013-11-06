package com.corvustec.facee.files.xml.notaDebito;


                             
    
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;                                   
import javax.xml.bind.annotation.XmlAccessorType;                                 
import javax.xml.bind.annotation.XmlAttribute;                                                                        
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;                                  
import javax.xml.bind.annotation.XmlType;                                         
	                                                                                  

import com.corvustec.facee.files.xml.commons.InfoTributariaDTO;
                
           
	                                                                                  
@XmlRootElement(name="notaDebito")                                                
@XmlAccessorType(XmlAccessType.FIELD)                                             
@XmlType(name = "", propOrder = {"infoTributaria", "infoNotaDebito","motivos"})
	                                                                                  
public class NotaDebitoDTO implements Serializable{                                                            
		                                                                              
	/**                                                                           
	*                                                                            
	*/                                                                           
	private static final long serialVersionUID = 1L;                              
		                                                                              
		                                                                              
	@XmlAttribute                                                                 
	private String version;                                                       
	                                                                              
	@XmlAttribute                                                                 
	private String id;                                                            
		                                                                              
	@XmlElement(required = true)                                                  
	private InfoTributariaDTO infoTributaria;                                     
		                                                                              
	@XmlElement(required = true)                                                  
	 InfoNotaDebitoDTO infoNotaDebito;                                     
		                                                                              
	@XmlElement(required = true)                                                  
	private MotivosDTO motivos;                                                   
		                                                                              
//	@XmlElement(required = true)                                                  
//	private infoAdicionalDTO infoAdicional;                                       
		                                                                              
		
	
	public NotaDebitoDTO () {}                                                   
	                                                                                  
	
	/**                                                                           
	* @return the infoTributaria                                                 
	*/                                                                           
	public InfoTributariaDTO getInfoTributaria() {                                
		return infoTributaria;                                                    
	}                                                                             
	                                                                                  
	/**                                                                           
	 * @param infoTributaria the infoTributaria to set                            
	 */                                                                           
	public void setInfoTributaria(InfoTributariaDTO infoTributaria) {             
		this.infoTributaria = infoTributaria;                                     
	}                                                                             
		                                                                              
	/**                                                                           
	 * @return the id                                                             
	 */                                                                           
	public String getId() {                                                       
		return id;                                                                
	}                                                                             
	                                                                                  
	/**                                                                           
	 * @param id the id to set                                                    
	 */                                                                           
	public void setId(String id) {                                                
		this.id = id;                                                             
	}                                                                             
	                                                                                  
	/**                                                                           
	 * @return the version                                                        
	 */                                                                           
	public String getVersion() {                                                  
		return version;                                                           
	}                                                                             
	                                                                                  
	/**                                                                           
	* @param version the version to set                                          
	 */                                                                           
	public void setVersion(String version) {                                      
		this.version = version;                                                   
	}                                                                             
		                                                                              
	/**                                                                           
	* @return the infoNotaDebito                                                 
	 */                                                                           
	public InfoNotaDebitoDTO getInfoNotaDebito() {                               
		return infoNotaDebito;                                                    
	}                                                                             
	                                                                                  
	/**                                                                           
	* @param infoNotaCredito the infoNotaDebito to set                          
	*/                                                                           
	public void setInfoNotaDebito(InfoNotaDebitoDTO infoNotaDebito) {             
		this.infoNotaDebito = infoNotaDebito;                                     
	}


	public MotivosDTO getMotivos() {
		return motivos;
	}


	public void setMotivos(MotivosDTO motivos) {
		this.motivos = motivos;
	}                                                                             
	                                                                                  
	                                                             
	                                                                                  
}                                                                                 
	                                                                                  


