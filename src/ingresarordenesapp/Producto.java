/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresarordenesapp;

/**
 *
 * @author prof_uide_e
 */
public class Producto {
    private String productoID;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    

    public Producto() {
        this.productoID = "";
        this.nombre = "";
        this.descripcion = "";
        this.precio = 0.00;
        this.cantidad = 0;
    }
    
    public Producto(String productoID, String nombre, String descripcion, double precio, int cantidad) {
        this.productoID = productoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getProductoID() {
        return productoID;
    }

    public void setProductoID(String ProductoID) {
        this.productoID = ProductoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = Descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double Precio) {
        this.precio = Precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    @Override
    public String toString() {
        return "Producto{" + "ProductoID=" + productoID + ", Nombre=" + nombre + ", Descripcion=" + descripcion + ", Precio=" + precio + '}';
    }
    
    
    
    
    

}
