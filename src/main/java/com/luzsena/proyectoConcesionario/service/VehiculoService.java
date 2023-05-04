package com.luzsena.proyectoConcesionario.service;

import com.luzsena.proyectoConcesionario.entities.Usuario;
import com.luzsena.proyectoConcesionario.entities.Vehiculo;

import java.util.List;

public interface VehiculoService {
    public List<Vehiculo> encontrarTodos();
    public Vehiculo encontrarTodosPorId(int id);
    public void crearVehiculo(Vehiculo vehiculo);
    public void actualizarVehiculo(Vehiculo vehiculo);
    public void eliminarVehiculo(Vehiculo vehiculo);
}
