package com.backendjavacollections.ej05;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> countries = new LinkedHashSet<>();
        String input;
        
        while (true) {
            System.out.println("Ingresar un país:");
            input = sc.nextLine();
            countries.add(input);
            
            System.out.println("¿Desea agregar otro país? (S/N):");
            if (sc.nextLine().equalsIgnoreCase("n"))
                break;
        } 
        
        System.out.println("\nPaíses:");
        countries.forEach(System.out::println);
        
        System.out.println("\nPaíses en orden alfabético:");
        countries = new TreeSet<>(countries);
        countries.forEach(System.out::println);
        
        System.out.println("\nIngresar país a eliminar:");
        input = sc.nextLine();
        
        Iterator<String> iterator = countries.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equalsIgnoreCase(input)) {
                iterator.remove();
                System.out.println("\nPaíses restantes:");
                countries.forEach(System.out::println);
                return;
            }
        }
        System.out.println("No se encontró el país.");
    }
    
}
