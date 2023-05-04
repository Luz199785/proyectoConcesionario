package com.luzsena.proyectoConcesionario.repositoy;

import com.luzsena.proyectoConcesionario.entities.Usuario;
import com.luzsena.proyectoConcesionario.entities.Vehiculo;
import com.luzsena.proyectoConcesionario.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VentaRepository extends JpaRepository<Venta, Integer> {
    @Query(value = "SELECT t FROM Venta t WHERE t.id=id")
    public Venta encontrarPorId(int id);
}
