/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2125509
 */
public interface ServiciosBanco {
    
    public abstract void registrarUsuario(Usuario u) throws ExcepcionServicesBanco;
    public abstract Usuario consultarUsuario(String correo) throws ExcepcionServicesBanco;

    public List<Usuario> consultarUsuarios() throws ExcepcionServicesBanco;

    public void cambiarEstado(Iniciativa iniciativa, TipoEstado tipoEstado) throws ExcepcionServicesBanco;

    public List<Usuario> consultarUsuariosSinRol() throws ExcepcionServicesBanco;
    
}
