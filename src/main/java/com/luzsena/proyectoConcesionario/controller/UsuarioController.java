package com.luzsena.proyectoConcesionario.controller;

import com.luzsena.proyectoConcesionario.dto.UsuarioDto;
import com.luzsena.proyectoConcesionario.negocio.UsuarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping (path = "/usuarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {
    @Autowired
    private UsuarioNegocio usuarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> mostrarUsuarios(){
        Map<String,Object> res= new HashMap<>();
        List<UsuarioDto> listUsuarioDto = this.usuarioNegocio.encontrarTodos();
        res.put("Status", HttpStatus.ACCEPTED);
        res.put("data",listUsuarioDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearUsuarios(@RequestBody Map<String,Object> request){
        Map<String,Object> res= new HashMap<>();

        System.out.println("@@@@@"+request.toString());

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(0);
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setIdentificacion(Integer.parseInt(request.get("identificacion").toString()));
        usuarioDto.setFechaNacimiento(new Date());
        usuarioDto.setFechaIngreso(new Date());
        usuarioDto.setTelefono(request.get("telefono").toString());
        usuarioDto.setDireccion(request.get("direccion").toString());
        usuarioDto.setPassword(request.get("password").toString());

        String respuesta = this.usuarioNegocio.guardarUsuario(usuarioDto);

        res.put("Status", HttpStatus.ACCEPTED);
        res.put("data",respuesta);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarUsuarios(@RequestBody Map<String,Object> request){
        Map<String,Object> res= new HashMap<>();

        System.out.println("@@@@@"+request.toString());

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setIdUsuario(0);
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setIdentificacion(Integer.parseInt(request.get("identificacion").toString()));
        usuarioDto.setFechaNacimiento(new Date());
        usuarioDto.setFechaIngreso(new Date());
        usuarioDto.setTelefono(request.get("telefono").toString());
        usuarioDto.setDireccion(request.get("direccion").toString());
        usuarioDto.setPassword(request.get("password").toString());

        String respuesta = this.usuarioNegocio.guardarUsuario(usuarioDto);

        res.put("Status", HttpStatus.ACCEPTED);
        res.put("data",respuesta);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }





}
