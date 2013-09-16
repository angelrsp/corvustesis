package ec.edu.uce.erpmunicipal.presupuesto.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;
import ec.edu.uce.erpmunicipal.presupuesto.bsl.PresupuestoService;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PrePrograma;
import ec.edu.uce.erpmunicipal.presupuesto.orm.PreProgramaCuenta;

@ManagedBean(name = "initialRegisterPage")
@ViewScoped
public class InitialRegisterPage implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB(name = "presupuestoService/local")
	private PresupuestoService presupuestoService;

		
	private PreProgramaCuenta programaCuenta;
	private List<PreProgramaCuenta> programaCuentas;
	
	private List<PrePrograma> programList;
	
	private List<ConCuenta> accountList;
	
	private ConCuenta accountSelect;
	
	private String cuentaCode;
	private String cuentaDescription;
	
	private String searchText;
	
	private int type;
	
	private double totalIngresos;
	private double totalGastos;
	
	private String valor;
	
	private int programCode;
	
	public InitialRegisterPage()
	{
		accountList=new ArrayList<ConCuenta>();
		programaCuentas=new ArrayList<PreProgramaCuenta>();
		type=1;	
	}

	public PreProgramaCuenta getProgramaCuenta() {
		return programaCuenta;
	}

	public void setProgramaCuenta(PreProgramaCuenta programaCuenta) {
		this.programaCuenta = programaCuenta;
	}

	public List<PreProgramaCuenta> getProgramaCuentas() {
		return programaCuentas;
	}

	public void setProgramaCuentas(List<PreProgramaCuenta> programaCuentas) {
		this.programaCuentas = programaCuentas;
	}
	
	public String getCuentaCode() {
		return cuentaCode;
	}

	public void setCuentaCode(String cuentaCode) {
		this.cuentaCode = cuentaCode;
	}

	public String getCuentaDescription() {
		return cuentaDescription;
	}

	public void setCuentaDescription(String cuentaDescription) {
		this.cuentaDescription = cuentaDescription;
	}

	public List<PrePrograma> getProgramList() {
		programList=presupuestoService.readPrograms();
		return programList;
	}

	public List<ConCuenta> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<ConCuenta> accountList) {
		this.accountList = accountList;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public ConCuenta getAccountSelect() {
		return accountSelect;
	}

	public void setAccountSelect(ConCuenta accountSelect) {
		this.accountSelect = accountSelect;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getTotalIngresos() {
		return totalIngresos;
	}

	public void setTotalIngresos(double totalIngresos) {
		this.totalIngresos = totalIngresos;
	}

	public double getTotalGastos() {
		return totalGastos;
	}

	public void setTotalGastos(double totalGastos) {
		this.totalGastos = totalGastos;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getProgramCode() {
		return programCode;
	}

	public void setProgramCode(int programCode) {
		this.programCode = programCode;
	}

	public void add()
	{
		if(cuentaCode.trim().equals(""))
		{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Ingrese cuenta"));
			return;
		}
		if(valor.trim().equals(""))
		{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Ingrese Valor"));
			return;
		}
		PreProgramaCuenta proCuenta=new PreProgramaCuenta();
		if(type==1)
		{
			totalIngresos=totalIngresos+Double.valueOf(valor);
			proCuenta.setPreTipoProgramaCuenta(presupuestoService.findByIdProgramCuenta(type));	
		}
		else if(type==2)
		{
			totalGastos=totalGastos+Double.valueOf(valor);
			proCuenta.setPreTipoProgramaCuenta(presupuestoService.findByIdProgramCuenta(type));
		}
		proCuenta.setPcuValor(BigDecimal.valueOf(Double.valueOf(valor)));
		proCuenta.setConCuenta(new ConCuenta(cuentaDescription, cuentaCode));
		programaCuentas.add(proCuenta);
		cuentaCode="";
		cuentaDescription="";
		valor="";
	}
	
	public void searchCuentaCode() {
		this.cuentaDescription = ((ConCuenta) presupuestoService
				.getAccoutingService().search(cuentaCode,2)).getCueDescripcion();
	}
	
	public void searchCuenta() {
		this.accountList = presupuestoService.getAccoutingService().dynamicSearch(
				searchText,2);
	}

	public void onRowSelect(SelectEvent event) {
		ConCuenta obj = (ConCuenta) event.getObject();
		this.cuentaCode = obj.getCueNumero();
		this.cuentaDescription = obj.getCueDescripcion();
		this.accountList = new ArrayList<ConCuenta>();
		this.searchText = "";
	}
	
	public void create()
	{
		presupuestoService.initialRegister(programCode, programaCuentas);
	}
	
	public void clear()
	{
		
	}
	
	@PostConstruct
	private void init()
	{
		
	}
}
