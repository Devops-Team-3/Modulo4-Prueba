package com.healthtrack;

public class Usuario {
    private String nombre;
    private double peso;

    public Usuario(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    //Bug Corregido
    public void actualizarPeso(double nuevoPeso) {
<<<<<<< HEAD
        // ERROR: En lugar de asignar el nuevo peso, se está restando 1kg.
        this.peso -= 1;
        // correccion.
        this.peso = nuevoPeso;
=======
    this.peso = nuevoPeso;
>>>>>>> 7c668c82fa2cc6b2fdb8ee259ce7c14d47c863de
    }


    public void mostrarInformacion() {
        System.out.println("Usuario: " + nombre + ", Peso Actual: " + peso + " kg");
    }
}