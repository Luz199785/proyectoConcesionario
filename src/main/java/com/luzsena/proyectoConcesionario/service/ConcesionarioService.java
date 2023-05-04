package com.luzsena.proyectoConcesionario.service;



import com.luzsena.proyectoConcesionario.entities.Concesionario;

import java.util.List;

public interface ConcesionarioService {
    public List<Concesionario> encontrarTodos();
    public Concesionario encontrarTodosPorId(int id);
    public void crearConcesionario(Concesionario concesionario);
    public void actualizarConcesionario(Concesionario concesionario);
    public void eliminarConcesionario(Concesionario concesionario);
}
