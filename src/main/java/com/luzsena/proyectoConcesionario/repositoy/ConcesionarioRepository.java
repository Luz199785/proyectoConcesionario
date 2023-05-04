package com.luzsena.proyectoConcesionario.repositoy;

import com.luzsena.proyectoConcesionario.entities.Concesionario;
import com.luzsena.proyectoConcesionario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConcesionarioRepository extends JpaRepository<Concesionario, Integer> {
    @Query(value = "SELECT c FROM Concesionario c WHERE c.id=id")
    public Concesionario encontrarPorId(int id);
}
