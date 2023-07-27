package com.backendjavacollections.ej03.service;

import com.backendjavacollections.ej03.entity.Alumno;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlumnoService {
    
    Scanner sc;
    List<Alumno> alumnos;

    public AlumnoService() {
        sc = new Scanner(System.in).useDelimiter("\n");
        alumnos = new ArrayList<>();
    }
    
    public void ingresarAlumnos() {
        boolean salir;
        do {            
            alumnos.add(crearAlumno());
            System.out.println("¿Desea agregar otro alumno? (S/N)");
            salir = !sc.next().equalsIgnoreCase("S");
        } while (!salir);
    }
    
    public Alumno crearAlumno() {
        List<Double> notas = new ArrayList<>();
        
        System.out.println("Ingresar nombre del alumno:");
        String nombre = sc.next();
        System.out.println("Ingresar nota 1:");
        notas.add(sc.nextDouble());
        System.out.println("Ingresar nota 2:");
        notas.add(sc.nextDouble());
        System.out.println("Ingresar nota 3:");
        notas.add(sc.nextDouble());
        
        return new Alumno(nombre, notas);
    }
      
    public void mostrarAlumnos() {
        System.out.println("\nAlumnos:");
        alumnos.forEach(System.out::println);
    }
    
    public Alumno buscarAlumno(String nombre) {
        for (Alumno alumno : alumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre))
                    return alumno;
        }
        
        System.out.println("Alumno no se encuentra registrado.");
        return null;
    }
    
    public void mostrarNotaFinal() {
        System.out.println("\nNota final obtenida");
        System.out.println("Ingresar nombre del alumno:");
        double nota = obtenerNotaFinal(sc.next());
        
        if (nota != -1)
            System.out.println("Nota final: " + nota);
    }
    
    private double obtenerNotaFinal(String nombre) {
        if (buscarAlumno(nombre) == null)
            return -1.0;
        
        return alumnos.stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(nombre))
                .flatMap(alumno -> alumno.getNotas().stream())
                .mapToDouble(Double::doubleValue).average()
                .getAsDouble();
    }
    
}
