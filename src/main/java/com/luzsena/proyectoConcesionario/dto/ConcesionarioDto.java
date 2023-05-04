package com.luzsena.proyectoConcesionario.dto;

import com.luzsena.proyectoConcesionario.entities.Vehiculo;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ConcesionarioDto {
    private int idConcesionario;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;

    private List<Vehiculo> vehiculos;
}
