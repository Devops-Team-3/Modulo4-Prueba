package com.healthtrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Luis", 70.0);
    }

    @Test
    void testGetNombre() {
        assertEquals("Luis", usuario.getNombre());
    }

    @Test
    void testGetPesoInicial() {
        assertEquals(70.0, usuario.getPeso());
    }

    @Test
    void testActualizarPesoDeberiaAsignarNuevoValor() {
        usuario.actualizarPeso(72.5);
        assertEquals(72.5, usuario.getPeso(), "El peso no fue actualizado correctamente");
    }
    //Bug Fixed
    // @Test
    // void testActualizarPesoConBugActual() {
    //     usuario.actualizarPeso(72.5);
    //     assertEquals(69.0, usuario.getPeso(), "El peso debería haber sido reducido en 1kg por el bug");
    // }
}