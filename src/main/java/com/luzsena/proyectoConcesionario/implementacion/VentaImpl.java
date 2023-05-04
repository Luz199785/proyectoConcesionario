package com.luzsena.proyectoConcesionario.implementacion;


import com.luzsena.proyectoConcesionario.entities.Venta;
import com.luzsena.proyectoConcesionario.repositoy.VentaRepository;
import com.luzsena.proyectoConcesionario.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaImpl implements VentaService {


    @Autowired
    VentaRepository ventaRepository;

    @Override
    public List<Venta> encontrarTodos() {

        return this.ventaRepository.findAll();
    }

    @Override
    public Venta encontrarTodosPorId(int id) {

        return this.ventaRepository.encontrarPorId(id);
    }

    @Override
    public void crearVenta(Venta venta) {
        this.ventaRepository.save(venta);
    }

    @Override
    public void actualizarVenta(Venta venta) {
        this.ventaRepository.save(venta);

    }

    @Override
    public void eliminarVenta(Venta venta) {

    }
}
