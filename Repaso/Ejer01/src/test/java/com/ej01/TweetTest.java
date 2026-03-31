package com.ej01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TweetTest {

    private Usuario usuario;
    private Tweet tweet;

    @BeforeEach
    void setUp() {
        this.usuario = new Usuario("guido");
        this.tweet = new Tweet("Aprendiendo objetos", this.usuario);
    }

    @Test
    void testGetTexto() {
        assertEquals("Aprendiendo objetos", this.tweet.getTexto());
    }

    @Test
    void testMostrarInfoIncluyeUsuarioYTexto() {
        String info = this.tweet.mostrarInfo();

        assertTrue(info.contains("guido"));
        assertTrue(info.contains("Tweet"));
        assertTrue(info.contains("Aprendiendo objetos"));
    }

    @Test
    void testEliminarLanzaExcepcion() {
        assertThrows(UnsupportedOperationException.class, () -> this.tweet.eliminar());
    }
}
