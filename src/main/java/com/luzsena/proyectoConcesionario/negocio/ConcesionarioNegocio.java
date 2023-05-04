package com.luzsena.proyectoConcesionario.negocio;

import com.luzsena.proyectoConcesionario.dto.ConcesionarioDto;
import com.luzsena.proyectoConcesionario.dto.UsuarioDto;
import com.luzsena.proyectoConcesionario.entities.Concesionario;
import com.luzsena.proyectoConcesionario.entities.Usuario;
import com.luzsena.proyectoConcesionario.implementacion.ConcesionarioImpl;
import com.luzsena.proyectoConcesionario.implementacion.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConcesionarioNegocio {
    @Autowired
    private ConcesionarioImpl concesionarioImpl;

    private List<ConcesionarioDto> listConcesionarioDto;

    public List<ConcesionarioDto> encontrarTodos(){
        listConcesionarioDto = new ArrayList<>();
        this.concesionarioImpl.encontrarTodos().forEach(concesionario -> {

            ConcesionarioDto concesionarioDto = new ConcesionarioDto();

            concesionarioDto.setIdConcesionario(concesionario.getIdConcesionario());
            concesionarioDto.setNombre(concesionario.getNombre());
            concesionarioDto.setCorreo(concesionario.getCorreo());
            concesionarioDto.setTelefono(concesionario.getTelefono());
            concesionarioDto.setDireccion(concesionario.getDireccion());

            this.listConcesionarioDto.add(concesionarioDto);
        });
        return this.listConcesionarioDto;
    }

    public String guardarConcesionario(ConcesionarioDto concesionarioDto){
        Concesionario concesionario = new Concesionario();
        try {
            if (concesionarioDto.getIdConcesionario() != 0)  {
                concesionarioDto.setIdConcesionario(concesionario.getIdConcesionario());
                concesionarioDto.setNombre(concesionario.getNombre());
                concesionarioDto.setCorreo(concesionario.getCorreo());
                concesionarioDto.setTelefono(concesionario.getTelefono());
                concesionarioDto.setDireccion(concesionario.getDireccion());
                this.concesionarioImpl.actualizarConcesionario(concesionario);


            }else {

                concesionarioDto.setNombre(concesionario.getNombre());
                concesionarioDto.setCorreo(concesionario.getCorreo());
                concesionarioDto.setTelefono(concesionario.getTelefono());
                concesionarioDto.setDireccion(concesionario.getDireccion());
                this.concesionarioImpl.crearConcesionario(concesionario);

            }
            return "OK";
        }
        catch (Exception e){
            return "BAD";

        }
    }
}
