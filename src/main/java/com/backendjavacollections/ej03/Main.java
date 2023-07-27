package com.backendjavacollections.ej03;

import com.backendjavacollections.ej03.service.AlumnoService;

public class Main {

    public static void main(String[] args) {
        AlumnoService as = new AlumnoService();
        as.ingresarAlumnos();
        as.mostrarAlumnos();
        as.mostrarNotaFinal();
    }
    
}
