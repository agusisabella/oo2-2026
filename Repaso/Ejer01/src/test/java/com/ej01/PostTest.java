package com.ej01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PostTest {

    private Usuario creador;
    private Post post;

    @BeforeEach
    void setUp() {
        this.creador = new Usuario("agus");
        this.post = new Tweet("Hola mundo", this.creador);
    }

    @Test
    void testGetCreador() {
        assertEquals(this.creador, this.post.getCreador());
    }

    @Test
    void testGetFechaCreacionNoNula() {
        assertNotNull(this.post.getFechaCreacion());
    }

    @Test
    void testMostrarInfoIncluyeDatosBasicos() {
        String info = this.post.mostrarInfo();

        assertTrue(info.contains("Post creado por: agus"));
        assertTrue(info.contains("Tweet"));
        assertTrue(info.contains("Hola mundo"));
    }
}
