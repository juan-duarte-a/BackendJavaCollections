package com.backendjavacollections.ej03.entity;

import java.util.List;

public class Alumno {
    
    private String nombre;
    private List<Double> notas;

    public Alumno(String nombre, List<Double> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    
}
