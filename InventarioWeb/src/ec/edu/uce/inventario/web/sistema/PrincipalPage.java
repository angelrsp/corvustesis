package ec.edu.uce.inventario.web.sistema;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import ec.edu.uce.inventario.entidades.SisModulo;
import ec.edu.uce.inventario.entidades.SisOpcion;
import ec.edu.uce.inventario.sistema.servicio.PerfilService;
import ec.edu.uce.inventario.sistema.servicio.UserService;


@ManagedBean(name = "principalPage")
@ViewScoped
public class PrincipalPage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MenuModel menuModel;

	@EJB(name = "perfilService/local")
	private PerfilService rolService;
	@EJB(name = "userService/local")
	private UserService userService;

	public PrincipalPage() {
		menuModel = new DefaultMenuModel();
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public MenuModel getMenuModel() {
		IndexPage indexPage = (IndexPage) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("indexPage");

		int rol = indexPage.getSysUser().getSisPerfil().getPrlCodigo();

		List<SisModulo> listModule = rolService.readModule(rol);

		if (listModule.size() > 0) {
			this.menuModel.getContents().clear();
			for (SisModulo temp : listModule) {
				List<SisOpcion> listOpc = rolService.readMenu(rol,
						temp.getModCodigo());
				Submenu subMenu = new Submenu();
				subMenu.setLabel(temp.getModDescripcion());

				for (SisOpcion tempOpc : listOpc) {
					if (rolService.isFather(rol, tempOpc.getOpcCodigo())) {
						subMenu.getChildren().add(generaSubmenu(tempOpc, rol));
					} else {
						MenuItem mi = new MenuItem();
						mi.setValue(tempOpc.getOpcNombre());
						mi.setUrl(tempOpc.getOpcUrl());

						subMenu.getChildren().add(mi);
					}
				}
				menuModel.addSubmenu(subMenu);
			}

		}
		return menuModel;
	}

	private Submenu generaSubmenu(SisOpcion opcion, int rol) {
		Submenu submenu = new Submenu();
		submenu.setLabel(opcion.getOpcNombre());

		for (SisOpcion temp : rolService.readChildren(rol,
				opcion.getOpcCodigo())) {
			if (!rolService.isFather(rol, temp.getOpcCodigo())) {
				MenuItem menuItem = new MenuItem();
				menuItem.setUrl(temp.getOpcUrl());

				menuItem.setValue(temp.getOpcNombre());
				submenu.getChildren().add(menuItem);
			} else {
				submenu.getChildren().add(generaSubmenu(temp, rol));
			}

		}
		return submenu;
	}

}
