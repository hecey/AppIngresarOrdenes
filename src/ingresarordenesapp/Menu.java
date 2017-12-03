/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ingresarordenesapp;

import java.util.Scanner;

/**
 *
 * @author prof_uide_e
 */
public class Menu {

    public final static String PRODUCTO = "Producto";

    Orden orden = new Orden();

    Menu(String menuTipo, Orden orden) {
        this.orden = orden;
        crearMenu(menuTipo);
    }

    private void crearMenu(String menuTipo) {
        switch (menuTipo) {
            case PRODUCTO:
                presentarMenuProductos();
                validarOpcionProductos(obtenerInt());
                break;
            default:
                System.out.println("Menu no existe");
                break;
        }
    }

    private static void presentarMenuProductos() {
        System.out.println("Menu Principal");
        System.out.println("1.- Ingresar Producto");
        System.out.println("2.- Ver Productos");
        System.out.println("3.- Eliminar Productos");
        System.out.println("4.- Modificar Productos");
        System.out.println("5.- Salir");
    }

    private static int obtenerInt() {
        Scanner entrada = new Scanner(System.in);
        try {
            int val = entrada.nextInt();
            return val;
        } catch (Exception e) {
            return 0;
        }

    }

    private void validarOpcionProductos(int opcion) {
        String menuTipo = "Producto";
        switch (opcion) {
            case 1:
                System.out.println("Ingresar Producto");
                orden.ingresarProducto();
                crearMenu(menuTipo);
                break;
            case 2:
                System.out.println("Ver Producto(s)");
                orden.verProducto();
                crearMenu(menuTipo);
                break;
            case 3:
                System.out.println("Eliminar Producto(s)");
                System.out.println("Ingresar ID:");
                orden.eliminarProducto(Orden.obtenerPorTeclado(String.class));
                crearMenu(menuTipo);
                break;
            case 4:
                System.out.println("Modificar Producto(s)");
                System.out.println("Ingresar ID:");
                orden.modificarProducto(Orden.obtenerPorTeclado(String.class));
                crearMenu(menuTipo);
                break;

            case 5:
                System.out.println("Terminado");
                break;
            default:
                System.out.println("Opcion no existe");
                crearMenu(menuTipo);
                break;
        }
    }

}
