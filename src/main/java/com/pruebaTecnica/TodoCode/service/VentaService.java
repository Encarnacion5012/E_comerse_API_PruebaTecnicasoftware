package com.pruebaTecnica.TodoCode.service;

import com.pruebaTecnica.TodoCode.dto.venta.RegistrarVentaDTO;
import com.pruebaTecnica.TodoCode.dto.venta.VentaDetalladaDTO;
import com.pruebaTecnica.TodoCode.infra.exception.StockInsuficienteExeption;
import com.pruebaTecnica.TodoCode.model.DetalleVenta;
import com.pruebaTecnica.TodoCode.model.Venta;
import com.pruebaTecnica.TodoCode.repository.ProductoRepository;
import com.pruebaTecnica.TodoCode.repository.SucursalRepository;
import com.pruebaTecnica.TodoCode.repository.VentaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VentaService {
    private final VentaRepository ventaRepository;
    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;

    @Transactional
    public Venta registrarVenta(RegistrarVentaDTO dto){
       //Contruccion lista detalle ventas
        var detalleVentas = dto.detalle_Venta().stream().map(dv-> {
          var detalleVenta = new DetalleVenta();
           var producto = productoRepository.findById(dv.id_Producto())
                    .orElseThrow(()-> new EntityNotFoundException("Producto no encontrado"));

           detalleVenta.setProducto(producto);
           detalleVenta.setCantidad(dv.cantidad());

           //calculamos diferencia de stok
            var difierencia_Stock = producto.getStok() - detalleVenta.getCantidad();

           if (difierencia_Stock <0){
               throw new StockInsuficienteExeption("No hay estok suficiente de: " + producto.getNombre());
           }
           else {
               producto.setStok(difierencia_Stock);
           }

            var subTotal = producto.getPrecio().multiply(new BigDecimal(detalleVenta.getCantidad()));
            detalleVenta.setSub_total(subTotal);
            return detalleVenta;
        }).toList();
        //busqeda sucursal
       var sucursal = sucursalRepository.findById(dto.id_sucursal())
               .orElseThrow(()-> new EntityNotFoundException("Sucursal no encontrada"));

       //construccion ventas
       var venta = new Venta();
       detalleVentas.forEach(venta::agregarVentaADetalle);

       venta.setSucursal(sucursal);
       venta.setFecha_venta(LocalDateTime.now());
       var total = detalleVentas.stream()
               .map(DetalleVenta::getSub_total)
               .filter(Objects::nonNull)
                       .reduce(BigDecimal.ZERO, BigDecimal::add);

       venta.setTotal(total);
       return ventaRepository.save(venta);
    }

    public Page<VentaDetalladaDTO> listarVentas(Pageable pageable) {
        return ventaRepository.findAll(pageable)
                .map(VentaDetalladaDTO::new);

    }

    public List<Venta> listarVentasEnUnaCiertaFecha(LocalDate fechaLImite){
        return ventaRepository.listarVentasHastaCiertaFecha(fechaLImite);
    }


}
