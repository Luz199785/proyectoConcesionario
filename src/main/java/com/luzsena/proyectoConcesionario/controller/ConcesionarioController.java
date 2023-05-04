package com.luzsena.proyectoConcesionario.controller;

import com.luzsena.proyectoConcesionario.dto.ConcesionarioDto;
import com.luzsena.proyectoConcesionario.dto.UsuarioDto;
import com.luzsena.proyectoConcesionario.entities.Concesionario;
import com.luzsena.proyectoConcesionario.negocio.ConcesionarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/concesionarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ConcesionarioController {
    @Autowired
    private ConcesionarioNegocio concesionarioNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> mostrarConcesionario(){
        Map<String,Object> res= new HashMap<>();
        List<ConcesionarioDto> listConcesionarioDto = this.concesionarioNegocio.encontrarTodos();
        res.put("Status", HttpStatus.ACCEPTED);
        res.put("data", listConcesionarioDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearConcesionario(@RequestBody Map<String,Object> request){
        Map<String,Object> res= new HashMap<>();

        System.out.println("@@@@@"+request.toString());
        ConcesionarioDto concesionarioDto = new ConcesionarioDto();

        concesionarioDto.setIdConcesionario(0);
        concesionarioDto.setNombre(request.get("nombre").toString());
        concesionarioDto.setCorreo(request.get("correo").toString());
        concesionarioDto.setTelefono(request.get("telefono").toString());
        concesionarioDto.setDireccion(request.get("direccion").toString());

        String respuesta = this.concesionarioNegocio.guardarConcesionario(concesionarioDto);

        res.put("Status", HttpStatus.ACCEPTED);
        res.put("data",respuesta);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarConcesionario(@RequestBody Map<String,Object> request){
        Map<String,Object> res= new HashMap<>();

        System.out.println("@@@@@"+request.toString());

     ConcesionarioDto concesionarioDto = new ConcesionarioDto();

        concesionarioDto.setIdConcesionario(0);
        concesionarioDto.setNombre(request.get("nombre").toString());
        concesionarioDto.setCorreo(request.get("correo").toString());
        concesionarioDto.setTelefono(request.get("telefono").toString());
        concesionarioDto.setDireccion(request.get("direccion").toString());

        String respuesta = this.concesionarioNegocio.guardarConcesionario(concesionarioDto);

        res.put("Status", HttpStatus.ACCEPTED);
        res.put("data",respuesta);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
