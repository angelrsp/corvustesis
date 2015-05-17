package ec.edu.uce.besg.web.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import ec.edu.uce.besg.web.util.*;


@ViewScoped
@ManagedBean(name = "indexController")
public class IndexController implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IndexController() {

	}
	@PostConstruct
	public void inicializarObjetos() {
	}

	public void redirectLoginEmpresa(ActionEvent actionEvent) throws IOException {
		JsfUtil.redirect("public/loginEmpresa.xhtml");
    }

	public void redirectRegistroEmpresa(ActionEvent actionEvent) throws IOException {
		JsfUtil.redirect("public/registroEmpresa.xhtml");
    }

	
	
	public void redirectLoginUsuario(ActionEvent actionEvent) throws IOException {
		JsfUtil.redirect("loginUsuario.xhtml");
    }
	
	public void redirectLoginCandidato(ActionEvent actionEvent) throws IOException {
		JsfUtil.redirect("loginCandidato.xhtml");
    }

	public void redirectEmpresa(ActionEvent actionEvent) throws IOException {
		JsfUtil.redirect("pages/empresa/bienvenido.xhtml");
    }
	
	public void redirectBienCandidato(ActionEvent actionEvent) throws IOException {
		JsfUtil.redirect("pages/candidato/bienvenido.xhtml");
    }
	
	public void logout() {
        try {
        	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			JsfUtil.redirect("index.xhtml");
		} catch (IOException e) {
			JsfUtil.addErrorMessage(e.getMessage());
		}
    }
}
