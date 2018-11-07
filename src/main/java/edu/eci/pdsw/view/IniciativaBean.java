package edu.eci.pdsw.view;
import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Iniciativa;

import edu.eci.pdsw.samples.entities.Rol;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.services.ExcepcionServicesBanco;
import edu.eci.pdsw.samples.services.ServiciosBanco;
import edu.eci.pdsw.samples.services.impl.ServiciosBancoStub;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@SessionScoped
public class IniciativaBean extends BasePageBean{
    
    private static final long serialVersionUID = 3594009161252782831L;
    
    
    @Inject
    ServiciosBanco servicioBanco;
    
    private String descripcion,area;
    private TipoEstado estado;
    private Date fecha;
    
   
    public List<Iniciativa> getIniciativas(){
        try{
            return servicioBanco.getIniciativas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
        
    }
    
    public void setDescripcion(String d){
        this.descripcion=d;
    }
    
    public void setArea(String a){
        this.area=a;
    }
    
    public void setEstado(TipoEstado e){
        this.estado=e;
    }
    
    public void setFecha(Date f){
        this.fecha=f;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getArea(){
        return area;
    }
    
    public TipoEstado getEstado(){
        return estado;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    
   
}