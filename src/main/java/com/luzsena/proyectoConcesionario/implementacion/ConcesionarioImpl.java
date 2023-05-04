package com.luzsena.proyectoConcesionario.implementacion;

import com.luzsena.proyectoConcesionario.entities.Concesionario;
import com.luzsena.proyectoConcesionario.entities.Usuario;
import com.luzsena.proyectoConcesionario.repositoy.ConcesionarioRepository;
import com.luzsena.proyectoConcesionario.service.ConcesionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcesionarioImpl implements ConcesionarioService {

    @Autowired
    ConcesionarioRepository concesionarioRepository;

    @Override
    public List<Concesionario> encontrarTodos() {
        return this.concesionarioRepository.findAll();
    }

    @Override
    public Concesionario encontrarTodosPorId(int id) {
        return this.concesionarioRepository.encontrarPorId(id);
    }

    @Override
    public void crearConcesionario(Concesionario concesionario) {
        this.concesionarioRepository.save(concesionario);
    }

    @Override
    public void actualizarConcesionario(Concesionario concesionario) {
        this.concesionarioRepository.save(concesionario);
    }

    @Override
    public void eliminarConcesionario(Concesionario concesionario) {

    }
}
