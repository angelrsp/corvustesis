package net.ciespal.redxxi.web.controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

import net.ciespal.redxxi.web.commons.util.JsfUtil;


@ViewScoped
@ManagedBean(name = "loginController")
public class LoginController {

	public void logout()
	{
	      try {
			HttpSession session = JsfUtil.getSession();
		      session.invalidate();
			JsfUtil.redirect("/RedXXIWeb/index.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
