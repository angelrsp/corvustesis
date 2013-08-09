package ec.edu.uce.erpmunicipal.sistema.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ec.edu.uce.erpmunicipal.sistema.bsl.CrudService;
import ec.edu.uce.erpmunicipal.sistema.bsl.ModuleService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisModulo;

@ManagedBean(name = "modulePage")
@ViewScoped
public class ModulePage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<SisModulo> modules;
	private SisModulo module;
	private SisModulo moduleTable;

	@EJB(name = "moduleService/local")
	private ModuleService moduleService;
	@EJB(name = "crudService/local")
	private CrudService crudService;

	public ModulePage() {
		super();
		module = new SisModulo();
		moduleTable = new SisModulo();
		modules = new ArrayList<SisModulo>();
	}

	public List<SisModulo> getModules() {
		return modules;
	}

	public void setModules(List<SisModulo> modules) {
		this.modules = modules;
	}

	public SisModulo getModule() {
		return module;
	}

	public void setModule(SisModulo module) {
		this.module = module;
	}

	public SisModulo getModuleTable() {
		return moduleTable;
	}

	public void setModuleTable(SisModulo moduleTable) {
		this.moduleTable = moduleTable;
	}

	private void readModules() {
		modules = moduleService.readAll();
	}

	public void create() {
		if (module.getModCodigo() == null) {
			crudService.create(module);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion",
							"Guardado Exitosamente"));
			readModules();
		} else {
			crudService.update(module);
		}
	}

	@PostConstruct
	public void init() {
		readModules();
	}

}
