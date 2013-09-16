package ec.edu.uce.erpmunicipal.contabilidad.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import ec.edu.uce.erpmunicipal.contabilidad.bsl.JournalService;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConClase;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConCuenta;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConMovimiento;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConMovimientoDetalle;
import ec.edu.uce.erpmunicipal.contabilidad.orm.ConTipoMovimiento;
import ec.edu.uce.erpmunicipal.sistema.bsl.CrudService;
import ec.edu.uce.erpmunicipal.util.CalendarUtil;
import ec.edu.uce.erpmunicipal.util.orm.SessionObject;

@ManagedBean(name = "journalPage")
@ViewScoped
public class JournalPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(name = "crudService/local")
	private CrudService crudService;
	@EJB(name = "journalService/local")
	private JournalService journalService;

	@SuppressWarnings("unused")
	private List<ConTipoMovimiento> typeMove;
	@SuppressWarnings("unused")
	private List<ConClase> clas;

	private List<ConCuenta> cuentas;

	private List<ConMovimientoDetalle> detalles;

	private ConMovimientoDetalle detalle;

	private ConMovimiento movimiento;

	private String search;
	private String searchCode;
	private String descripcionCuenta;

	private String debe;
	private String haber;
	private Double cuadre;

	private int claseCode;
	private int tipoMovimientoCode;

	private Date fecha;
	private Date fechaMax;
	private Date fechaMin;
	

	private String transaccion;

	public JournalPage() {
		clas = new ArrayList<ConClase>();
		typeMove = new ArrayList<ConTipoMovimiento>();
		cuentas = new ArrayList<ConCuenta>();
		cuadre = 0.0;
		detalles = new ArrayList<ConMovimientoDetalle>();
		detalle = new ConMovimientoDetalle();
		movimiento = new ConMovimiento();
		Calendar cal = Calendar.getInstance();
		fecha = cal.getTime();
		fechaMin=CalendarUtil.getCalendar(((SessionObject)FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get("sessionObject")).getAnio(), 01, 01).getTime();
		fechaMax=CalendarUtil.getCalendar(((SessionObject)FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap()
				.get("sessionObject")).getAnio(), 12, 31).getTime();
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ConTipoMovimiento> getTypeMove() {
		return typeMove = (List<ConTipoMovimiento>) (List) crudService
				.find("ConTipoMovimiento");
	}

	public void setTypeMove(List<ConTipoMovimiento> typeMove) {
		this.typeMove = typeMove;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ConClase> getClas() {
		return clas = (List<ConClase>) (List) crudService.find("ConClase");
	}

	public void setClas(List<ConClase> clas) {
		this.clas = clas;
	}

	public List<ConCuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<ConCuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearchCode() {
		return searchCode;
	}

	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

	public String getDescripcionCuenta() {
		return descripcionCuenta;
	}

	public void setDescripcionCuenta(String descripcionCuenta) {
		this.descripcionCuenta = descripcionCuenta;
	}

	public String getDebe() {
		return debe;
	}

	public void setDebe(String debe) {
		this.debe = debe;
	}

	public String getHaber() {
		return haber;
	}

	public void setHaber(String haber) {
		this.haber = haber;
	}

	public List<ConMovimientoDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalle(List<ConMovimientoDetalle> detalles) {
		this.detalles = detalles;
	}

	public ConMovimientoDetalle getDetalle() {
		return detalle;
	}

	public void setDetalle(ConMovimientoDetalle detalle) {
		this.detalle = detalle;
	}

	public ConMovimiento getMovimiento() {
		return movimiento;
	}

	public void setMovimiento(ConMovimiento movimiento) {
		this.movimiento = movimiento;
	}

	public int getClaseCode() {
		return claseCode;
	}

	public void setClaseCode(int claseCode) {
		this.claseCode = claseCode;
	}

	public int getTipoMovimientoCode() {
		return tipoMovimientoCode;
	}

	public void setTipoMovimientoCode(int tipoMovimientoCode) {
		this.tipoMovimientoCode = tipoMovimientoCode;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaMax() {
		return fechaMax;
	}

	public void setFechaMax(Date fechaMax) {
		this.fechaMax = fechaMax;
	}

	public Date getFechaMin() {
		return fechaMin;
	}

	public void setFechaMin(Date fechaMin) {
		this.fechaMin = fechaMin;
	}

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public void searchCuenta() {
		this.cuentas = journalService.getAccoutingService().dynamicSearch(
				search,1);
	}

	public void searchCuentaCode() {
		this.descripcionCuenta = ((ConCuenta) journalService
				.getAccoutingService().search(searchCode,1)).getCueDescripcion();
	}

	public void onRowSelect(SelectEvent event) {
		ConCuenta obj = (ConCuenta) event.getObject();
		this.searchCode = obj.getCueNumero();
		this.descripcionCuenta = obj.getCueDescripcion();
		this.cuentas = new ArrayList<ConCuenta>();
		this.search = "";
	}

	public void addClick() {
		if (debe.equals("") && haber.equals("")) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Ingrese valor de debe"));

		} else {
			ConMovimientoDetalle det = new ConMovimientoDetalle();
			if (!debe.equals("")&&haber.trim().equals("")) {
				Double deb = Double.valueOf(debe.replace(',', '.'));
				cuadre = cuadre + deb;
				//haber = cuadre.toString();
				debe = "";
				haber="";
				det.setConCuenta(new ConCuenta(null, null, descripcionCuenta,
						null, searchCode, null, null, null, null, null, null));
				det.setMdeDebe(BigDecimal.valueOf(deb));
				detalles.add(det);
				searchCode = "";
				descripcionCuenta = "";
			} else if (!haber.equals("")&&debe.trim().equals("")) {
				Double hab = Double.valueOf(haber.replace(',', '.'));
				cuadre = cuadre - hab;

				//haber = cuadre.toString();

				debe = "";
				haber="";
				det.setConCuenta(new ConCuenta(null, null, descripcionCuenta,
						null, searchCode, null, null, null, null, null, null));
				det.setMdeHaber(BigDecimal.valueOf(hab));
				detalles.add(det);
				searchCode = "";
				descripcionCuenta = "";
			}
			else
			{
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
								"Ingrese un solo valor"));
			}
		}
	}

	public void onRowDeleting(ConMovimientoDetalle de) {
		detalles.remove(de);
	}

	public void create() {
		try {
			if (detalles.size() <= 0) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
								"Ingrese detalles"));
				return;
			}
			if (cuadre != 0) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
								"El asiento no esta cuadrado"));
				return;
			}
			movimiento.setMovFechaContable(new Timestamp(fecha.getTime()));
			transaccion = String.valueOf(journalService.create(
					(SessionObject) FacesContext.getCurrentInstance()
							.getExternalContext().getSessionMap()
							.get("sessionObject"), claseCode,
					tipoMovimientoCode, movimiento, detalles));
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado",
							"Exitosamente"));			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							e.getMessage()));
		}
	}

	public void clear() {
		detalles = new ArrayList<ConMovimientoDetalle>();
	}
}
