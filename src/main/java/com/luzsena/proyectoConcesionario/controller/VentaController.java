package com.luzsena.proyectoConcesionario.controller;

import com.luzsena.proyectoConcesionario.dto.UsuarioDto;
import com.luzsena.proyectoConcesionario.dto.VentaDto;
import com.luzsena.proyectoConcesionario.negocio.UsuarioNegocio;
import com.luzsena.proyectoConcesionario.negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/venta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VentaController {
    @Autowired
    private VentaNegocio ventaNegocio;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> mostrarVenta(){
        Map<String,Object> res= new HashMap<>();
        List<VentaDto> listVentaDto = this.ventaNegocio.encontrarTodos();
        res.put("Status", HttpStatus.ACCEPTED);
        res.put("data",listVentaDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearVenta(@RequestBody Map<String,Object> request){
        Map<String,Object> res= new HashMap<>();

        System.out.println("@@@@@"+request.toString());

        VentaDto ventaDto = new VentaDto();
        ventaDto.setIdVenta(0);
        ventaDto.setFechaVenta(new Date());
        ventaDto.setPrecioFinal(Integer.parseInt(request.get("precioFinal").toString()));
        ventaDto.setObservaciones(request.get("observaciones").toString());


        String respuesta = this.ventaNegocio.guardarVenta(ventaDto);

        res.put("Status", HttpStatus.ACCEPTED);
        res.put("data",respuesta);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarUsuarios(@RequestBody Map<String,Object> request){
        Map<String,Object> res= new HashMap<>();

        System.out.println("@@@@@"+request.toString());

        VentaDto ventaDto = new VentaDto();
        ventaDto.setIdVenta(0);
        ventaDto.setFechaVenta(new Date());
        ventaDto.setPrecioFinal(Integer.parseInt(request.get("precioFinal").toString()));
        ventaDto.setObservaciones(request.get("observaciones").toString());


        String respuesta = this.ventaNegocio.guardarVenta(ventaDto);

        res.put("Status", HttpStatus.ACCEPTED);
        res.put("data",respuesta);


        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
