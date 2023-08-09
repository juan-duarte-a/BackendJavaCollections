package com.backendjavacollections.ex.ej03;

import java.util.HashSet;
import java.util.Scanner;

public class Libreria {
    
    HashSet<Libro> libros;
    Scanner input;

    public Libreria() {
        libros = new HashSet<>();
        input = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Libro crearLibro(String titulo, String autor, int numeroEjemplares, int numeroPrestados){
        Libro libro = new Libro(titulo, autor, numeroEjemplares, numeroPrestados);
        libros.add(libro);
        return libro;
    }
    
    public void agregarLibro() {
        do {
            System.out.println("Ingrese el título del libro a agregar:");
            String titulo = input.next();
            System.out.println("Ingrese el autor del libro a agregar:");
            String autor = input.next();
            System.out.println("Ingrese la cantidad de ejemplares del libro:");
            int ejemplares = input.nextInt();
            int prestados = 0;

            crearLibro(titulo, autor, ejemplares, prestados);
            
            System.out.println("¿Desea agregar otro libro? (S/N):");
        } while (input.next().equalsIgnoreCase("S"));
    }
    
    public boolean prestamo() {
        System.out.println("Ingrese el nombre del libro que desea llevar prestado:");
        String titulo = input.next();
        Libro libro = buscarLibro(titulo);
        
        if (libro != null) {
            if (libro.getNumeroPrestados() < libro.getNumeroEjemplares()){
                libro.setNumeroPrestados(libro.getNumeroPrestados()+1);
                System.out.println("El préstamo ha sido exitoso.");
                return true;
                
            } else {
                System.out.println("No hay ejemplares disponibles.");
            }
        }  
        
        return false;
    }
    
    public Libro buscarLibro(String titulo){
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo))
                return libro;
        }
        System.out.println("El libro solicitado no existe.");
        return null;
    }
    
    public boolean devolucion(){
        System.out.println("Ingrese el nombre del libro que desea devolver: ");
        String titulo = input.next();
        Libro libro = buscarLibro(titulo);

        if (libro != null) {
            if (libro.getNumeroPrestados() > 0) {
                libro.setNumeroPrestados(libro.getNumeroPrestados() - 1);
                System.out.println("Ha devuelto el libro con éxito.");
                return true;

            } else {
                System.out.println("No hay ejemplares prestados de ese libro.");
            }
        }

        return false;
    }
    
    public void mostrarLibros(){
        libros.forEach(System.out::println);
    }
    
    public void menu(){
        while (true) {
            System.out.println("Seleccionar una opción: ");
            System.out.println("1. Mostrar libros");
            System.out.println("2. Agregar libros");
            System.out.println("3. Prestar libros");
            System.out.println("4. devolver libro");
            System.out.println("5. salir");
            String opcion = input.next();
            switch(opcion){
                case "1":
                    mostrarLibros();
                    break;
                case "2":
                    agregarLibro();
                    break;
                case "3":
                    prestamo();
                    break;
                case "4":
                    devolucion();
                    break;
                case "5":
                    System.out.println("Finalizado");
                    return;
                default:
                    System.out.println("opcion incorrecta");
            }
        }
    }
            
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        libreria.menu();
    }
    
}
