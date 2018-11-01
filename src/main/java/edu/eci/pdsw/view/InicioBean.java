package edu.eci.pdsw.view;


import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoStub;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SuppressWarnings("deprecation")
@ManagedBean(name = "inicioBean")
@SessionScoped
public class InicioBean extends BasePageBean{
    
    private static final long serialVersionUID = 3594009161252782831L;
    
    @Inject
    ServiciosBanco servicioBanco;
    
    private int id;
    private String email;
    
    public Usuario consultar(String correo){
        try{
            /*Usuario a =servicioBanco.consultarUsuario(correo);
            System.out.println(a.toString());*/
            return servicioBanco.consultarUsuario(correo);
        }catch(ExcepcionServicesBanco ex){
            System.out.println(ex.getMessage());
            return null;
        }        	
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int ID){
        this.id=ID;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String mail){
        this.email=mail;
    }
    
    
}