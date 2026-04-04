package com.pruebaTecnica.TodoCode.model.producto;

import com.pruebaTecnica.TodoCode.model.DetalleVenta;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private BigDecimal precio;

    private int stok;

    private boolean activo;

    @Enumerated(EnumType.STRING)
    private CategoriaProducto categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetalleVenta> detalleVentas;

    public void eliminar() {
        this.activo = false;
    }
}
