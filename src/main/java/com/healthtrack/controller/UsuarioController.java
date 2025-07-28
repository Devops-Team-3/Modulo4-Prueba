package com.healthtrack.controller;

import com.healthtrack.Usuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private Usuario usuario = new Usuario("Douglas", 70.0);

    @GetMapping
    public Usuario obtenerUsuario() {
        return usuario;
    }

    @PostMapping("/actualizar-peso")
    public String actualizarPeso(@RequestParam double nuevoPeso) {
        usuario.actualizarPeso(nuevoPeso);
        return "Peso actualizado a " + nuevoPeso + " kg";
    }
}
