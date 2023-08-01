package com.backendjavacollections.ej06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Store {
    
    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private final Map<String, Integer> products = new HashMap<>();
    
    public void addProduct() {
        System.out.println("Ingresar nombre del producto:");
        String productName = sc.next();
        System.out.println("Ingresar precio del producto:");
        int productPrice = sc.nextInt();
        
        products.put(productName, productPrice);
    }
    
    public void modifyPrice() {
        System.out.println("Ingresar nombre del producto:");
        String productName = sc.next();

        if (!products.containsKey(productName)) {
            System.err.println("¡Producto no encontrado!");
            return;
        }

        System.out.println("Ingresar precio del producto:");
        int productPrice = sc.nextInt();
        
        products.put(productName, productPrice);
    }
    
    public void removeProduct() {
        System.out.println("Ingresar nombre del producto:");
        String productName = sc.next();

        if (!products.containsKey(productName)) {
            System.err.println("¡Producto no encontrado!");
            return;
        }

        products.remove(productName);
    }
    
    public void listProducts() {
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + ". Precio: " + entry.getValue());
        }
    }
    
    public void menu() {
        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Ver productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Modificar precio");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Salir");
            System.out.print("\nElegir opción: ");
            
            String option = sc.next();
            
            switch (option) {
                case "1":
                    listProducts();
                    break;
                case "2":
                    addProduct();
                    break;
                case "3":
                    modifyPrice();
                    break;
                case "4":
                    removeProduct();
                    break;
                case "5":
                    return;
                default:
                    System.err.println("¡Opción incorrecta!");
            }
        }
    }
}
