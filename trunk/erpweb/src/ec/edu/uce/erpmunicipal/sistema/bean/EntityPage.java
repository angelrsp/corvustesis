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

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import ec.edu.uce.erpmunicipal.sistema.bsl.CrudService;
import ec.edu.uce.erpmunicipal.sistema.bsl.EntityService;
import ec.edu.uce.erpmunicipal.sistema.orm.SisInstitucion;

@ManagedBean(name = "entityPage")
@ViewScoped
public class EntityPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SisInstitucion entity;
	private List<SisInstitucion> entities;
	private SisInstitucion entityTable;

	@EJB(name = "entityService/local")
	private EntityService entityService;
	@EJB(name = "crudService/local")
	private CrudService crudService;

	public EntityPage() {
		super();
		entity = new SisInstitucion();
		entities = new ArrayList<SisInstitucion>();
		entityTable = new SisInstitucion();
		clean();
	}

	/**
	 * @return the entity
	 */
	public SisInstitucion getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(SisInstitucion entity) {
		this.entity = entity;
	}

	/**
	 * @return the entities
	 */
	public List<SisInstitucion> getEntities() {
		return entities;
	}

	/**
	 * @param entities
	 *            the entities to set
	 */
	public void setEntities(List<SisInstitucion> entities) {
		this.entities = entities;
	}

	/**
	 * @return the entityTable
	 */
	public SisInstitucion getEntityTable() {
		return entityTable;
	}

	/**
	 * @param entityTable
	 *            the entityTable to set
	 */
	public void setEntityTable(SisInstitucion entityTable) {
		this.entityTable = entityTable;
	}

	public void create() {
		FacesMessage msg = null;
		try {
			if (entity.getInsCodigo() != null && entity.getInsCodigo() > 0) {
				crudService.update(entity);
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Actualizado", "Operacion Realizada con Exito");
			} else {
				RequestContext.getCurrentInstance().execute(
						"confirmation2.show();");
				crudService.create(entity);
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardado",
						"Operacion Realizada con Exito");
			}
			clean();
		} catch (Exception e) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),
					e.getMessage() + " " + e.getLocalizedMessage());
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		readEntities();
	}

	private void readEntities() {
		entities = entityService.readAll();
	}

	public void onRowDeleting(SisInstitucion en) {
		entity = new SisInstitucion();
		entity = en;
		if (entityService.delete(entity)) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion","Cambio Exitoso"));
			readEntities();
		} else {
			RequestContext.getCurrentInstance()
					.execute("confirmation2.show();");
		}
	}

	public void update() {
		entity.setInsActivo(false);
		crudService.update(entity);
		readEntities();
	}

	public void clean() {
		entity = new SisInstitucion();
		entity.setInsCodigo(null);
		entity.setInsNombre(null);
		entity.setInsDireccion(null);
		entity.setInsTelefono(null);
		entity.setInsActivo(true);
		// RequestContext.getCurrentInstance().reset(":formEntity:controls");
	}

	public void onRowSelect(SelectEvent event) {
		entity = new SisInstitucion();
		setEntity((SisInstitucion) event.getObject());
		entityTable = new SisInstitucion();
	}

	@PostConstruct
	public void init() {
		readEntities();
	}

}
