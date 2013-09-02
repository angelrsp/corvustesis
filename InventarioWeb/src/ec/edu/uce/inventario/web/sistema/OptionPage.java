package ec.edu.uce.inventario.web.sistema;

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

import ec.edu.uce.inventario.entidades.SisModulo;
import ec.edu.uce.inventario.entidades.SisOpcion;
import ec.edu.uce.inventario.sistema.servicio.CrudService;
import ec.edu.uce.inventario.sistema.servicio.ModuleService;
import ec.edu.uce.inventario.sistema.servicio.OptionService;


@ManagedBean(name = "optionPage")
@ViewScoped
public class OptionPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<SisOpcion> options;
    private List<SisOpcion> optionsPather;
    private List<SisModulo> modules;
    private SisOpcion optionTable;
    private SisOpcion option;

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
        options = new ArrayList<SisOpcion>();
        optionsPather = new ArrayList<SisOpcion>();
        modules = new ArrayList<SisModulo>();
        optionTable = new SisOpcion();
        isNode = false;
        readOnlyUrl = false;
        option = new SisOpcion();
        patherCode = 0;
    }

    public List<SisOpcion> getOptions() {
        return options;
    }

    public void setOptions(List<SisOpcion> options) {
        this.options = options;
    }

    public List<SisOpcion> getOptionsPather() {
        return optionsPather;
    }

    public void setOptionsPather(List<SisOpcion> optionsPather) {
        this.optionsPather = optionsPather;
    }

    public List<SisModulo> getModules() {
        return modules;
    }

    public void setModules(List<SisModulo> modules) {
        this.modules = modules;
    }

    public SisOpcion getOptionTable() {
        return optionTable;
    }

    public void setOptionTable(SisOpcion optionTable) {
        this.optionTable = optionTable;
    }

    public Boolean getIsNode() {
        return isNode;
    }

    public void setIsNode(Boolean isNode) {
        this.isNode = isNode;
    }

    public int getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(int moduleCode) {
        this.moduleCode = moduleCode;
    }

    public int getPatherCode() {
        return patherCode;
    }

    public void setPatherCode(int patherCode) {
        this.patherCode = patherCode;
    }

    public Boolean getReadOnlyUrl() {
        return readOnlyUrl;
    }

    public void setReadOnlyUrl(Boolean readOnlyUrl) {
        this.readOnlyUrl = readOnlyUrl;
    }

    public SisOpcion getOption() {
        return option;
    }

    public void setOption(SisOpcion option) {
        this.option = option;
    }

    private void readOptions() {
        options = optionService.readByModule(moduleCode);
    }

    private void readOptionsPather() {
        optionsPather = optionService.readIsPather(moduleCode);
    }

    private void readModules() {
        modules = moduleService.readAll();
    }

    private void clean() {
        this.option = new SisOpcion();
    }

    public void isNodeClick() {
        if (isNode) {
            option.setOpcUrl("Nudo");
            readOnlyUrl = true;
        } else {
            option.setOpcUrl("");
            readOnlyUrl = false;
        }
    }

    public void moduleChange() {
        readOptions();
        readOptionsPather();
    }

    public void newClick() {
        clean();
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
            option.setOpcPadre(patherCode);
           
            if (option.getOpcCodigo() == null) {
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
        option = new SisOpcion();
        setOption((SisOpcion) even.getObject());
    }

    @PostConstruct
    public void init() {
        readOptions();
        readModules();
        readOptionsPather();
    }	
	
}
