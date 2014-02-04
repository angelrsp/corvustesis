package net.ciespal.redxxi.ejb.persistence.dao;

public interface FactoryDAO {

	CatalogoDAO getCatalogoImpl();

	CentroDAO getCentroDAOImpl();

}
