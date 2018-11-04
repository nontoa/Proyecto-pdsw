package edu.eci.pdsw.samples.services;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import static com.google.inject.Guice.createInjector;

import com.google.inject.Injector;

import edu.eci.pdsw.sampleprj.dao.IniciativaDAO;
import edu.eci.pdsw.sampleprj.dao.UsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISIniciativaDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.MyBATISUsuarioDAO;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoImpl;

public class ServiciosBancoFactory {

	private static ServiciosBancoFactory instance = new ServiciosBancoFactory();
	private static Injector injector;
	private static Injector testInjector;
	
	public ServiciosBancoFactory() {
		
		injector = createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				install(JdbcHelper.PostgreSQL);
				setClassPathResource("my-batis-config.xml");
	            bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
	            bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
	            bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);
			}
		});
		
		testInjector = createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				install(JdbcHelper.PostgreSQL);
				setClassPathResource("my-batis-config-h2.xml");
				bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
				bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
				bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);
			}
		});
	}
	
	public ServiciosBanco getServiciosBanco() {
		return injector.getInstance(ServiciosBanco.class);
	}
	
	public ServiciosBanco getServiciosBancoTesting() {
		return testInjector.getInstance(ServiciosBanco.class);
	}
	public static ServiciosBancoFactory getInstance() {
		return instance;
	}	
}