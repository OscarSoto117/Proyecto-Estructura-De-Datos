/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 * TDA: ProductoMayorista (Aplica Herencia y Recursividad)
 * Descripción: Modela un producto con reglas de negocio para ventas y proyecciones.
 */
public class ProductoMayorista extends Producto {
    private double porcentajeDescuento;

    // Constructor que usa super() para inicializar la clase padre
    public ProductoMayorista(String nombre, double precioBase, int stock, double porcentajeDescuento) {
        super(nombre, precioBase, stock);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    // Métodos de logica
    
    // Realizar una venta, validando el stock
    public boolean vender(int cantidadAComprar) {
        if (cantidadAComprar > 0 && cantidadAComprar <= getStock()) {
            setStock(getStock() - cantidadAComprar);
            return true; // Venta exitosa
        }
        return false; // Sin stock suficiente
    }
    
    // Abastecer el inventario del producto
    public void abastecerStock(int cantidadNuevos) {
        if (cantidadNuevos > 0) {
            setStock(getStock() + cantidadNuevos);
        }
    }

    // Aplicar un descuento del 5% si se compran 5 o más productos
    public double calcularTotalPagar(int cantidadAComprar) {
        double subtotal = cantidadAComprar * getPrecioBase();
        if (cantidadAComprar >= 5) { // Regla de mayoreo
            return subtotal - (subtotal * (porcentajeDescuento / 100));
        }
        return subtotal;
    }

    /**
     * Lógica 4 (RECURSIVIDAD): Proyecta las ganancias futuras.
     * Caso base: meses == 0
     * Condición de avance: meses - 1
     */
    public double proyectarVentasRecursivo(int meses, double ventaActual, double porcentajeCrecimiento) {
        if (meses == 0) {
            return ventaActual; // Caso base
        } else {
            // Convierte el porcentaje (ej. 5) en un multiplicador (1.05)
            double multiplicador = 1 + (porcentajeCrecimiento / 100);
            return proyectarVentasRecursivo(meses - 1, ventaActual * multiplicador, porcentajeCrecimiento); 
        }
    }

    // Método de acceso
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
}
