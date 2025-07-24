package com.healthtrack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FlujoCompletoTest {

    @Test
    public void testFlujoCompletoDeUsuario() {
        // Crear nuevo usuario
        Usuario usuario = new Usuario("Juan", 70.0);
        assertEquals("Juan", usuario.getNombre());
        assertEquals(70.0, usuario.getPeso());

        // Actualizar peso
        usuario.actualizarPeso(75.0);
        assertEquals(75.0, usuario.getPeso());

        // Mostrar info por consola
        usuario.mostrarInformacion();
    }
}
