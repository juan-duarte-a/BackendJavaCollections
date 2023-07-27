package com.backendjavacollections.ej01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static Scanner sc;
    private static List<String> razas;
    
    public static void main(String[] args) {
        sc = new Scanner(System.in).useDelimiter("\n");
        razas = new ArrayList<>();
        
        solicitarRazas();
        mostrarRazas();
        eliminarRaza();
        mostrarRazas();
    }
    
    public static void solicitarRazas() {
        for (String opcion = "s"; opcion.equalsIgnoreCase("S"); ) {
            System.out.println("Ingresar una raza de perro:");
            String raza = sc.next();
            razas.add(raza);
            
            System.out.println("¿Desea ingresar otra raza? (S/N)");
            opcion = sc.next();
        }
    }
    
    public static void mostrarRazas() {
        System.out.println("\nRazas guardadas:\n");
        razas.forEach(System.out::println);
    }
    
    public static void eliminarRaza() {
        System.out.println("Ingresar raza a eliminar:");
        String razaAEliminar = sc.next();
        boolean encontrada = false;
        
        Iterator<String> iterator = razas.iterator();
        while (iterator.hasNext()) {
            String raza = iterator.next();
            if (raza.equalsIgnoreCase(razaAEliminar)) {
                iterator.remove();
                encontrada = true;
            }
        }
        
        System.out.println(encontrada ? "Raza eliminada." : "Raza no encontrada.");
    }
    
}
