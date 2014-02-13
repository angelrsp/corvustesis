package ec.edu.uce.indicadores.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ec.edu.uce.indicadores.commons.util.IndicadoresException;
import ec.edu.uce.indicadores.ejb.negocio.AdministracionService;
import ec.edu.uce.indicadores.ejb.persistence.entities.OpcionDTO;
import ec.edu.uce.indicadores.ejb.persistence.entities.PerfilDTO;
import ec.edu.uce.indicadores.web.util.JsfUtil;

@ViewScoped
@ManagedBean(name="accesoController")
public class AccesoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private AdministracionService administracionService;
	
	private Object pefilSelect;
	
	private List<PerfilDTO> perfilList;
	
	private List<String> opcionSelect;
	
	private List<OpcionDTO> opcionCheck;
	
	private Map<String,OpcionDTO> checkList; 
	
	public AccesoController() {
	}
	
	@PostConstruct
	private void init()	{
		perfilList=new ArrayList<PerfilDTO>(); 
		opcionCheck=new ArrayList<OpcionDTO>();
		opcionSelect=new ArrayList<String>();
	}
	
	public Object getPefilSelect() {
		return pefilSelect;
	}

	public void setPefilSelect(Object pefilSelect) {
		this.pefilSelect = pefilSelect;
	}
	
	public List<PerfilDTO> getPerfilList() {
		try {
			perfilList=administracionService.readPerfil();
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
		return perfilList;
	}

	public void setPerfilList(List<PerfilDTO> perfilList) {
		this.perfilList = perfilList;
	}


	public Map<String, OpcionDTO> getCheckList() {
		return checkList;
	}

	public List<OpcionDTO> getOpcionCheck() {
		return opcionCheck;
	}

	public void setOpcionCheck(List<OpcionDTO> opcionCheck) {
		this.opcionCheck = opcionCheck;
	}



	public List<String> getOpcionSelect() {
		return opcionSelect;
	}

	public void setOpcionSelect(List<String> opcionSelect) {
		this.opcionSelect = opcionSelect;
	}

	public void readAcceso()
	{
		PerfilDTO perfil;
		Boolean flag=false;
		try {
			checkList=new HashMap<String,OpcionDTO>();
			perfil=new PerfilDTO();
			perfil.setPerCodigo(Integer.valueOf(getPefilSelect().toString()));
			opcionCheck=administracionService.readOpcion();

			for(OpcionDTO opt: administracionService.readOpcion(perfil))
			{
				opcionSelect.add(opt.getOpcCodigo().toString());
				flag=true;
			}
			if(!flag)
				opcionSelect=new ArrayList<String>();
			
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
	
	public void save()
	{
		try {
			administracionService.createAcceso(opcionSelect, pefilSelect);
			readAcceso();
		} catch (IndicadoresException e) {
			JsfUtil.addErrorMessage(e.toString());
		}
	}
}
