package com.luzsena.proyectoConcesionario.service;

import com.luzsena.proyectoConcesionario.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> encontrarTodos();
    public Usuario encontrarTodosPorId(int id);
    public void crearUsuario(Usuario usuario);
    public void actualizarUsuario(Usuario usuario);
    public void eliminarUsuario(int id);

}
