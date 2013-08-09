package ec.edu.uce.erpmunicipal.sistema.bean;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import ec.edu.uce.erpmunicipal.sistema.orm.SisModulo;
import ec.edu.uce.erpmunicipal.sistema.orm.SisPantalla;
import ec.edu.uce.erpmunicipal.sistema.bsl.RolService;
import ec.edu.uce.erpmunicipal.sistema.bsl.UserService;

@ManagedBean(name = "principalPage")
@ViewScoped
public class PrincipalPage {

	private MenuModel menuModel;

	@EJB(name = "rolService/local")
	private RolService rolService;
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

		int rol = userService.readUserRol(indexPage.getSysUser().getUsuLogin())
				.getSisRole().getRolCodigo();

		List<SisModulo> listModule = rolService.readModule(rol);

		if (listModule.size() > 0) {
			this.menuModel.getContents().clear();
			for (SisModulo temp : listModule) {
				List<SisPantalla> listPan = rolService.readMenu(rol,
						temp.getModCodigo());
				Submenu subMenu = new Submenu();
				subMenu.setLabel(temp.getModDescripcion());

				for (SisPantalla tempPan : listPan) {
					if (rolService.isFather(rol, tempPan.getPanCodigo())) {
						subMenu.getChildren().add(generaSubmenu(tempPan, rol));
					} else {
						MenuItem mi = new MenuItem();
						mi.setValue(tempPan.getPanDescripcion());
						//mi.setUrl(tempPan.getPanUrl());
						mi.setOnclick("addTab('"+tempPan.getPanDescripcion()+"','"+tempPan.getPanUrl()+"');");
						//mi.setOnclick(tempPan.getPanOnClick());
						
						subMenu.getChildren().add(mi);
					}
				}
				menuModel.addSubmenu(subMenu);
			}

		}
		return menuModel;
	}

	private Submenu generaSubmenu(SisPantalla pantalla, int rol) {
		Submenu submenu = new Submenu();
		submenu.setLabel(pantalla.getPanDescripcion());

		for (SisPantalla temp : rolService.readChildren(rol,
				pantalla.getPanCodigo())) {
			if (!rolService.isFather(rol, temp.getPanCodigo())) {
				MenuItem menuItem = new MenuItem();
				//menuItem.setUrl(temp.getPanUrl());
				menuItem.setOnclick("addTab('"+temp.getPanDescripcion()+"','"+temp.getPanUrl()+"');");
				//menuItem.setOnclick(temp.getPanOnClick());
				
				menuItem.setValue(temp.getPanDescripcion());
				submenu.getChildren().add(menuItem);
			} else {
				submenu.getChildren().add(generaSubmenu(temp, rol));
			}

		}
		return submenu;
	}

	public void logout() {
		ExternalContext ctx = FacesContext.getCurrentInstance()
				.getExternalContext();
		String ctxPath = ((ServletContext) ctx.getContext()).getContextPath();

		try {
			// Usar el contexto de JSF para invalidar la sesión,
			// NO EL DE SERVLETS (nada de HttpServletRequest)
			((HttpSession) ctx.getSession(false)).invalidate();
			((HttpSession) ctx.getSession(false)).removeAttribute("indexPage");
			// Redirección de nuevo con el contexto de JSF,
			// si se usa una HttpServletResponse fallará.
			// Sin embargo, como ya está fuera del ciclo de vida
			// de JSF se debe usar la ruta completa -_-U
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("user");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("indexPage");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
			
			ctx.redirect(ctxPath + "");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
