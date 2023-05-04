package com.luzsena.proyectoConcesionario.negocio;

import com.luzsena.proyectoConcesionario.dto.UsuarioDto;
import com.luzsena.proyectoConcesionario.dto.VentaDto;
import com.luzsena.proyectoConcesionario.entities.Usuario;
import com.luzsena.proyectoConcesionario.entities.Venta;
import com.luzsena.proyectoConcesionario.implementacion.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VentaNegocio {
    @Autowired
    private VentaImpl ventaImpl;

    private List<VentaDto> listVentaDto;

    public List<VentaDto> encontrarTodos(){
        listVentaDto = new ArrayList<>();
        this.ventaImpl.encontrarTodos().forEach(venta -> {

            VentaDto ventaDto = new VentaDto();

            ventaDto.setIdVenta(venta.getIdVenta());
            ventaDto.setFechaVenta(venta.getFechaVenta());
            ventaDto.setPrecioFinal(venta.getPrecioFinal());
            ventaDto.setObservaciones(venta.getObservaciones());

            this.listVentaDto.add(ventaDto);
        });
        return this.listVentaDto;
    }

    public String guardarVenta(VentaDto ventaDto){
        Venta venta = new Venta();
        try {
            if (ventaDto.getIdVenta() != 0)  {
                venta.setIdVenta(ventaDto.getIdVenta());
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setPrecioFinal(ventaDto.getPrecioFinal());
                venta.setObservaciones(ventaDto.getObservaciones());

                this.ventaImpl.actualizarVenta(venta);


            }else {
                venta.setFechaVenta(ventaDto.getFechaVenta());
                venta.setPrecioFinal(ventaDto.getPrecioFinal());
                venta.setObservaciones(ventaDto.getObservaciones());
                this.ventaImpl.actualizarVenta(venta);

            }
            return "OK";
        }
        catch (Exception e){
            return "BAD";

        }
    }
}
