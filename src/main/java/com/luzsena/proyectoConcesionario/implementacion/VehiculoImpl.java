package com.luzsena.proyectoConcesionario.implementacion;

import com.luzsena.proyectoConcesionario.entities.Usuario;
import com.luzsena.proyectoConcesionario.entities.Vehiculo;
import com.luzsena.proyectoConcesionario.repositoy.VehiculoRepository;
import com.luzsena.proyectoConcesionario.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoImpl implements VehiculoService {

    @Autowired
    VehiculoRepository vehiculoRepository;

    @Override
    public List<Vehiculo> encontrarTodos() {
        return this.vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo encontrarTodosPorId(int id) {
        return this.vehiculoRepository.encontrarPorId(id);
    }

    @Override
    public void crearVehiculo(Vehiculo vehiculo) {
        this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {
        this.vehiculoRepository.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(Vehiculo vehiculo) {

    }
}
