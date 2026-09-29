/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 * TDA: Producto
 * Descripción: Clase padre que modela un producto genérico de inventario.
 * Aplica encapsulamiento y constructores con validaciones.
 */
public class Producto {
// Atributos privados (Encapsulamiento)
    private String nombre;
    private double precioBase;
    private int stock;

    // Constructor con validaciones
    public Producto(String nombre, double precioBase, int stock) {
        this.nombre = nombre;
        // Validación: El precio no puede ser negativo
        if (precioBase >= 0) {
            this.precioBase = precioBase;
        } else {
            this.precioBase = 0;
        }
        // Validación: El stock no puede ser negativo
        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
    }

    // Métodos de acceso (Getters y Setters)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase >= 0) this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) this.stock = stock;
    }
}
