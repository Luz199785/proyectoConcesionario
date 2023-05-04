package com.luzsena.proyectoConcesionario.negocio;

import com.luzsena.proyectoConcesionario.dto.UsuarioDto;
import com.luzsena.proyectoConcesionario.entities.Usuario;
import com.luzsena.proyectoConcesionario.implementacion.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioNegocio {
    @Autowired
    private UsuarioImpl usuarioImpl;

    private List<UsuarioDto> listUsuarioDto;

    public List<UsuarioDto> encontrarTodos(){
        listUsuarioDto = new ArrayList<>();
        this.usuarioImpl.encontrarTodos().forEach(usuario -> {

            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto.setIdUsuario(usuario.getIdUsuario());
            usuarioDto.setNombre(usuario.getNombre());
            usuarioDto.setApellido(usuario.getApellido());
            usuarioDto.setCorreo(usuario.getCorreo());
            usuarioDto.setIdentificacion(usuario.getIdentificacion());
            usuarioDto.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioDto.setFechaIngreso(usuario.getFechaIngreso());
            usuarioDto.setTelefono(usuario.getTelefono());
            usuarioDto.setDireccion(usuario.getDireccion());
            usuarioDto.setPassword(usuario.getPassword());
            this.listUsuarioDto.add(usuarioDto);
        });
        return this.listUsuarioDto;
    }

    public String guardarUsuario(UsuarioDto usuarioDto){
        Usuario usuario = new Usuario();
        try {
         if (usuarioDto.getIdUsuario() != 0)  {
             usuario.setIdUsuario(usuarioDto.getIdUsuario());
             usuario.setNombre(usuarioDto.getNombre());
             usuario.setApellido(usuarioDto.getApellido());
             usuario.setCorreo(usuarioDto.getCorreo());
             usuario.setIdentificacion(usuarioDto.getIdentificacion());
             usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
             usuario.setFechaIngreso(usuarioDto.getFechaIngreso());
             usuario.setTelefono(usuarioDto.getTelefono());
             usuario.setDireccion(usuarioDto.getDireccion());
             usuario.setPassword(usuarioDto.getPassword());
             this.usuarioImpl.actualizarUsuario(usuario);


         }else {
             usuario.setNombre(usuarioDto.getNombre());
             usuario.setApellido(usuarioDto.getApellido());
             usuario.setCorreo(usuarioDto.getCorreo());
             usuario.setIdentificacion(usuarioDto.getIdentificacion());
             usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
             usuario.setFechaIngreso(usuarioDto.getFechaIngreso());
             usuario.setTelefono(usuarioDto.getTelefono());
             usuario.setDireccion(usuarioDto.getDireccion());
             usuario.setPassword(usuarioDto.getPassword());
             this.usuarioImpl.actualizarUsuario(usuario);

         }
         return "OK";
        }
        catch (Exception e){
            return "BAD";

        }
    }
}
