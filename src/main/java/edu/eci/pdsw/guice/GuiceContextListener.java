package edu.eci.pdsw.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.pdsw.sampleprj.dao.mybatis.*;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.impl.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import edu.eci.pdsw.sampleprj.dao.*;

public class GuiceContextListener implements ServletContextListener{
     public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                bind(ProponenteDAO.class).to(MyBATISProponenteDAO.class);
                bind(IniciativaDAO.class).to(MyBATISIniciativaDAO.class);
                bind(AdministradorDAO.class).to(MyBATISAdministradorDAO.class);
                bind(ComentarioDAO.class).to(MyBATISComentarioDAO.class);
                bind(ServiciosBanco.class).to(ServiciosBancoImpl.class);
            }   
       });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}