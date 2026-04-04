package com.pruebaTecnica.TodoCode.model;

import com.pruebaTecnica.TodoCode.model.producto.Producto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "detalle_ventas")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Producto")
    private Producto producto;

    private int cantidad;

    private BigDecimal sub_total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    private Venta venta;

}
