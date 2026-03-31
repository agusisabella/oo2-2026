package com.ej01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RetweetTest {

    private Usuario autorOriginal;
    private Usuario retweeter;
    private Tweet original;
    private Retweet retweet;

    @BeforeEach
    void setUp() {
        this.autorOriginal = new Usuario("james");
        this.retweeter = new Usuario("ana");
        this.original = new Tweet("Mensaje original", this.autorOriginal);
        this.retweet = new Retweet(this.original, this.retweeter);
    }

    @Test
    void testGetOriginal() {
        assertEquals(this.original, this.retweet.getOriginal());
    }

    @Test
    void testMostrarInfoIncluyeRetweetYOriginal() {
        String info = this.retweet.mostrarInfo();

        assertTrue(info.contains("ana"));
        assertTrue(info.contains("Retweet"));
        assertTrue(info.contains("james"));
        assertTrue(info.contains("Mensaje original"));
    }

    @Test
    void testEliminarLanzaExcepcion() {
        assertThrows(UnsupportedOperationException.class, () -> this.retweet.eliminar());
    }
}
