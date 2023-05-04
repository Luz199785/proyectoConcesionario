package com.luzsena.proyectoConcesionario.repositoy;

import com.luzsena.proyectoConcesionario.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Query(value = "SELECT u FROM Usuario u WHERE u.id=id")
    public Usuario encontrarPorId(int id);
}
