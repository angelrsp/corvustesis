package ec.edu.uce.erpmunicipal.presupuesto.bean;

import java.io.Serializable;
import java.util.List;

import ec.edu.uce.erpmunicipal.presupuesto.orm.PreProgramaCuenta;

public class InitialRegisterPage implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PreProgramaCuenta programaCuenta;
	private List<PreProgramaCuenta> programaCuentasIngreso;
	private List<PreProgramaCuenta> programaCuentasGasto;
	private List<PreProgramaCuenta> programaCuentas;
	
	
	public InitialRegisterPage()
	{
		
	}

	public PreProgramaCuenta getProgramaCuenta() {
		return programaCuenta;
	}

	public void setProgramaCuenta(PreProgramaCuenta programaCuenta) {
		this.programaCuenta = programaCuenta;
	}

	public List<PreProgramaCuenta> getProgramaCuentasIngreso() {
		return programaCuentasIngreso;
	}

	public void setProgramaCuentasIngreso(
			List<PreProgramaCuenta> programaCuentasIngreso) {
		this.programaCuentasIngreso = programaCuentasIngreso;
	}

	public List<PreProgramaCuenta> getProgramaCuentasGasto() {
		return programaCuentasGasto;
	}

	public void setProgramaCuentasGasto(List<PreProgramaCuenta> programaCuentasGasto) {
		this.programaCuentasGasto = programaCuentasGasto;
	}

	public List<PreProgramaCuenta> getProgramaCuentas() {
		return programaCuentas;
	}

	public void setProgramaCuentas(List<PreProgramaCuenta> programaCuentas) {
		this.programaCuentas = programaCuentas;
	}
	
	public void add()
	{
		
	}
}
