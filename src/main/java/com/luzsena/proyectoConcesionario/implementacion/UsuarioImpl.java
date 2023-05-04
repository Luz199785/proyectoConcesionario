package com.luzsena.proyectoConcesionario.implementacion;

import com.luzsena.proyectoConcesionario.entities.Usuario;
import com.luzsena.proyectoConcesionario.repositoy.UsuarioRepository;
import com.luzsena.proyectoConcesionario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImpl implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public List<Usuario> encontrarTodos() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario encontrarTodosPorId(int id) {
        return this.usuarioRepository.encontrarPorId(id);
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {

    }
}
