/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresarordenesapp;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author prof_uide_e
 */
public class Orden {

    private String ordenID;
    private Producto[] producto;
    private double total;
    private String fecha;
    private boolean enviado;

    public Orden() {
        producto = new Producto[10];
        for (int i = 0; i <= producto.length - 1; i++) {
            producto[i] = new Producto();
        }
    }

    public Orden(String ordenID, double total, String fecha, boolean enviado) {
        this.ordenID = ordenID;
        this.total = total;
        this.fecha = fecha;
        this.enviado = enviado;
    }

    public String getOrdenID() {
        return ordenID;
    }

    public void setOrdenID(String OrdenID) {
        this.ordenID = OrdenID;
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] Producto) {
        this.producto = Producto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double Total) {
        this.total = Total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String Fecha) {
        this.fecha = Fecha;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean Enviado) {
        this.enviado = Enviado;
    }

    @Override
    public String toString() {
        return "Orden{" + "OrdenID=" + ordenID + ", Producto=" + producto + ", Total=" + total + ", Fecha=" + fecha + ", Enviado=" + enviado + '}';
    }

    public void ingresarProducto() {
        Scanner entrada = new Scanner(System.in);

        recorrer:
        for (int i = 0; i <= producto.length - 1; i++) {
            //System.out.println("Debug-VerProductos: " + i);

            if (producto[i].getProductoID().equals("")) {
                System.out.println("Ingresar ID:");
                producto[i].setProductoID(obtenerPorTeclado(String.class));

                System.out.println("Ingresar Nombre:");
                producto[i].setNombre(obtenerPorTeclado(String.class));

                System.out.println("Ingresar Descripcion:");
                producto[i].setDescripcion(obtenerPorTeclado(String.class));

                System.out.println("Ingresar Precio:");
                producto[i].setPrecio(obtenerPorTeclado(Double.class));

                System.out.println("Ingresar Cantidad:");
                producto[i].setCantidad(obtenerPorTeclado(Integer.class));

                break recorrer;
            }
        }

    }

    public void ingresarProducto(int i) {
        Scanner entrada = new Scanner(System.in);

        //validarEntrada(entrada.next(),producto[i].getProductoID())            
        producto[i]
                .setProductoID(validarEntrada(
                        obtenerPorTeclado(String.class), producto[i].getProductoID()));

        System.out.println("Ingresar Nombre:");
        producto[i].setNombre(entrada.next());

        System.out.println("Ingresar Descripcion:");
        producto[i].setDescripcion(entrada.next());

        System.out.println("Ingresar Precio:");
        producto[i]
                .setPrecio(validarEntrada(
                        obtenerPorTeclado(Double.class), producto[i].getPrecio()));

        System.out.println("Ingresar Cantidad:");
        producto[i].setCantidad(entrada.nextInt());
    }

    public void verProducto() {
        for (int i = 0; i <= producto.length - 1; i++) {
            //System.out.println("Debug-VerProductos: " + i);
            if (!producto[i].getProductoID().equals("")) {
                System.out.println("ID: " + producto[i].getProductoID());
                System.out.println("Nombre: " + producto[i].getNombre());
                System.out.println("Descripcion: " + producto[i].getDescripcion());
                System.out.println("Precio: " + producto[i].getPrecio());
                System.out.println("Cantidad: " + producto[i].getCantidad());
            }
        }
    }

    public void eliminarProducto(String productoId) {
        boolean productoExiste = false;
        recorrer:
        for (int i = 0; i <= producto.length - 1; i++) {
            if (producto[i].getProductoID().equals(productoId)) {
                productoExiste = true;
                producto[i].setProductoID("");
                producto[i].setCantidad(0);
                producto[i].setDescripcion("");
                producto[i].setNombre("");
                producto[i].setPrecio(0.00);
                break recorrer;
            }
        }
        if (productoExiste == true) {
            System.out.println("Producto Eliminado: " + productoId);
        } else {
            System.out.println("Producto no existe: " + productoId);
        }
    }

    public static <T> T obtenerPorTeclado(Class<T> c) {
        Scanner entrada = new Scanner(System.in);

        try {
            if (c == Integer.class) {
                return c.cast(entrada.nextInt());
            }
            if (c == String.class) // the next cast to String is safe
            {
                return c.cast(entrada.next());
            }
            if (c == Double.class) // the next cast to Double is safe
            {
                return c.cast(entrada.nextDouble());
            }
        } catch (Exception e) {
            System.out.println("Intenta de nuevo....");
        }
        return obtenerPorTeclado(c);
    }

    void modificarProducto(String productoId) {
        boolean productoExiste = false;
        recorrer:
        for (int i = 0; i <= producto.length - 1; i++) {
            if (producto[i].getProductoID().equals(productoId)) {
                productoExiste = true;
                //Codigo para modificar el producto
                ingresarProducto(i);
                break recorrer;
            }
        }
        //Evaluo si existe el producto con la variable productoExiste
        if (productoExiste == true) {
            System.out.println("Producto Modificado: " + productoId);
        } else {
            System.out.println("Producto no existe: " + productoId);
        }
    }

    private static <T> T validarEntrada(T entradaPorTeclado, T entradaExistente) {

        // String valor = "" + entradaPorTeclado;
        if (entradaPorTeclado instanceof String) {
            if (((String) entradaPorTeclado).isEmpty()) {
                return entradaExistente;
            }

        }
        if (entradaPorTeclado instanceof Integer) {
            if (((Integer) entradaPorTeclado).equals(0)) {
                return entradaExistente;
            }

        }

        return entradaPorTeclado;
    }

}
