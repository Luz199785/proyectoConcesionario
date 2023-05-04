package com.luzsena.proyectoConcesionario.service;

import com.luzsena.proyectoConcesionario.entities.Usuario;
import com.luzsena.proyectoConcesionario.entities.Venta;

import java.util.List;

public interface VentaService {
    public List<Venta> encontrarTodos();
    public Venta encontrarTodosPorId(int id);
    public void crearVenta(Venta venta);
    public void actualizarVenta(Venta venta);
    public void eliminarVenta(Venta venta);
}
