package ec.edu.uce.notas.ejb.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.edu.uce.notas.ejb.dao.factory.FactoryDAO;
import ec.edu.uce.notas.ejb.service.LoginService;

@Stateless
public class LoginServiceImpl implements LoginService{
	
	
	@EJB
	private FactoryDAO factoryDAO;
	
	


}
