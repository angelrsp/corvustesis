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

import org.primefaces.event.SelectEvent;

import ec.edu.uce.erpmunicipal.sistema.bsl.CrudService;
import ec.edu.uce.erpmunicipal.sistema.bsl.ModuleService;
import ec.edu.uce.erpmunicipal.sistema.bsl.OptionService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisModulo;
import ec.edu.uce.erpmunicipal.sistema.orm.SisPantalla;

@ManagedBean(name = "optionPage")
@ViewScoped
public class OptionPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<SisPantalla> options;
	private List<SisPantalla> optionsPather;
	private List<SisModulo> modules;
	private SisPantalla optionTable;
	private SisPantalla option;

	private Boolean isNode;
	private int moduleCode;
	private int patherCode;

	private Boolean readOnlyUrl;

	@EJB(name = "optionService/local")
	private OptionService optionService;
	@EJB(name = "moduleService/local")
	private ModuleService moduleService;

	@EJB(name = "crudService/local")
	private CrudService crudService;

	public OptionPage() {
		options = new ArrayList<SisPantalla>();
		optionsPather = new ArrayList<SisPantalla>();
		modules = new ArrayList<SisModulo>();
		optionTable = new SisPantalla();
		isNode = false;
		readOnlyUrl = false;
		option = new SisPantalla();
		patherCode = 0;
	}

	/**
	 * @return the options
	 */
	public List<SisPantalla> getOptions() {
		return options;
	}

	/**
	 * @param options
	 *            the options to set
	 */
	public void setOptions(List<SisPantalla> options) {
		this.options = options;
	}

	/**
	 * @return the optionsPather
	 */
	public List<SisPantalla> getOptionsPather() {
		return optionsPather;
	}

	/**
	 * @param optionsPather
	 *            the optionsPather to set
	 */
	public void setOptionsPather(List<SisPantalla> optionsPather) {
		this.optionsPather = optionsPather;
	}

	/**
	 * @return the modules
	 */
	public List<SisModulo> getModules() {
		return modules;
	}

	/**
	 * @param modules
	 *            the modules to set
	 */
	public void setModules(List<SisModulo> modules) {
		this.modules = modules;
	}

	/**
	 * @return the optionTable
	 */
	public SisPantalla getOptionTable() {
		return optionTable;
	}

	/**
	 * @param optionTable
	 *            the optionTable to set
	 */
	public void setOptionTable(SisPantalla optionTable) {
		this.optionTable = optionTable;
	}

	/**
	 * @return the isNode
	 */
	public Boolean getIsNode() {
		return isNode;
	}

	/**
	 * @param isNode
	 *            the isNode to set
	 */
	public void setIsNode(Boolean isNode) {
		this.isNode = isNode;
	}

	/**
	 * @return the moduleCode
	 */
	public int getModuleCode() {
		return moduleCode;
	}

	/**
	 * @param moduleCode
	 *            the moduleCode to set
	 */
	public void setModuleCode(int moduleCode) {
		this.moduleCode = moduleCode;
	}

	/**
	 * @return the patherCode
	 */
	public int getPatherCode() {
		return patherCode;
	}

	/**
	 * @param patherCode
	 *            the patherCode to set
	 */
	public void setPatherCode(int patherCode) {
		this.patherCode = patherCode;
	}

	/**
	 * @return the enabledUrl
	 */
	public Boolean getReadOnlyUrl() {
		return readOnlyUrl;
	}

	/**
	 * @param enabledUrl
	 *            the enabledUrl to set
	 */
	public void setReadOnlyUrl(Boolean readOnlyUrl) {
		this.readOnlyUrl = readOnlyUrl;
	}

	/**
	 * @return the option
	 */
	public SisPantalla getOption() {
		return option;
	}

	/**
	 * @param option
	 *            the option to set
	 */
	public void setOption(SisPantalla option) {
		this.option = option;
	}

	private void readOptions() {
		options = optionService.readByModule(moduleCode);
	}

	private void readOptionsPather() {
		optionsPather=new ArrayList<SisPantalla>();
		optionsPather = optionService.readIsPather(moduleCode);
	}

	private void readModules() {
		modules = moduleService.readAll();
	}

	private void clean() {
		this.option = new SisPantalla();
	}

	public void isNodeClick() {
		if (isNode) {
			option.setPanUrl("Nudo");
			readOnlyUrl = true;
		} else {
			option.setPanUrl("");
			readOnlyUrl = false;
		}
	}

	public void moduleChange() {
		readOptions();
		readOptionsPather();
	}

	public void newClick() {
		clean();
		readOptionsPather();
	}

	public void saveClick() {
		FacesMessage msg = null;
		try {
			SisModulo obj = new SisModulo();
			
			if (moduleCode == 0) {
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Seleccione Modulo", "Intente nuevamente");
				FacesContext.getCurrentInstance().addMessage(null, msg);
				return;
			}
			
			obj.setModCodigo(moduleCode);
			option.setSisModulo(obj);
			option.setPanPadre(patherCode);
			
			if (option.getPanCodigo() == null) {
				crudService.create(option);
			} else {
				crudService.update(option);
			}
			
			clean();
			readOptions();
			readOptionsPather();
		} catch (Exception e) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
					e.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void optionsOnRowSelect(SelectEvent even) {
		option = new SisPantalla();
		setOption((SisPantalla) even.getObject());
		patherCode=getOption().getPanPadre();
	}

	@PostConstruct
	public void init() {
		readOptions();
		readModules();
		readOptionsPather();
	}
}
