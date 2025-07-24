package com.healthtrack;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Juan", 70.0);
        usuario.mostrarInformacion();

        usuario.actualizarPeso(75.0);
        usuario.mostrarInformacion();
    }
}
