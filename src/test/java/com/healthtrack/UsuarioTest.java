package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
    @Test
    public void testActualizarPesoCorrectamente() {
        Usuario usuario = new Usuario("Juan", 70.0);
        usuario.actualizarPeso(72.5);
        // Este test fallará si no corregimos el error del método actualizarPeso
        assertEquals(72.5, usuario.getPeso(), 0.01);
    }
}
