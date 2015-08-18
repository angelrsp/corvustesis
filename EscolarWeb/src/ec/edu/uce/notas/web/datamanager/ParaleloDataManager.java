package ec.edu.uce.notas.web.datamanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.notas.ejb.persistence.entity.ParaleloDTO;

@ViewScoped
@ManagedBean(name = "paraleloDataManager")
public class ParaleloDataManager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ParaleloDTO paraleloDTO; 
	
	private List<ParaleloDTO> paraleloList;

	public ParaleloDataManager() {
		paraleloDTO=new ParaleloDTO();
		paraleloList=new ArrayList<ParaleloDTO>();
	}

	public ParaleloDTO getParaleloDTO() {
		return paraleloDTO;
	}

	public void setParaleloDTO(ParaleloDTO paraleloDTO) {
		this.paraleloDTO = paraleloDTO;
	}

	public List<ParaleloDTO> getParaleloList() {
		return paraleloList;
	}

	public void setParaleloList(List<ParaleloDTO> paraleloList) {
		this.paraleloList = paraleloList;
	}

	
}
