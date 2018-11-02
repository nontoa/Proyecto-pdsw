package edu.eci.pdsw.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.pdsw.sampleprj.dao.UsuarioDAO;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.pdsw.samples.entities.Iniciativa;
import edu.eci.pdsw.samples.entities.TipoEstado;
import edu.eci.pdsw.samples.entities.Usuario;

public class MyBATISUsuarioDAO implements UsuarioDAO{

	@Inject 
	private UsuarioMapper usuarioMapper;
	
	
	@Override
	public List<Usuario> consultarUsuarios() throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuarios();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
		    throw new PersistenceException("Error al consultar los clientes");
		}
		
	}

	@Override
	public List<Usuario> consultarUsuariosSinRol() throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuariosSinRol();
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
		    throw new PersistenceException("Error al consultar los clientes sin rol");
		}
	}

	@Override
	public void registrarUsuario(Usuario u) throws PersistenceException {
		try {
			usuarioMapper.insertarUsuario(u);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
		    throw new PersistenceException("Error al registar el cliente");
		}
	}

	@Override
	public Usuario consultarUsuario(String correo) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuario(correo);
		}
		catch(org.apache.ibatis.exceptions.PersistenceException e) {
		    throw new PersistenceException("Error al consultar el cliente");
		}
	}
}