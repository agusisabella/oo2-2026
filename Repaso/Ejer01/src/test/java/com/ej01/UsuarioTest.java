package com.ej01;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        this.usuario = new Usuario("agus");
    }

    @Test
    void testGetScreenName() {
        assertEquals("agus", this.usuario.getScreenName());
    }

    @Test
    void testIsEqual() {
        assertTrue(this.usuario.isEqual("agus"));
        assertFalse(this.usuario.isEqual("otro"));
    }

    @Test
    void testIsEqualName() {
        assertTrue(this.usuario.isEqualName("agus"));
        assertFalse(this.usuario.isEqualName("otro"));
    }

    @Test
    void testEliminarDevuelveTrueConPostsInicializados() throws Exception {
        inicializarPosts(this.usuario);

        assertTrue(this.usuario.eliminar());
    }

    private void inicializarPosts(Usuario usuario) throws Exception {
        Field posts = Usuario.class.getDeclaredField("posts");
        posts.setAccessible(true);
        ArrayList<Post> lista = new ArrayList<>();
        lista.add(new Tweet("t1", usuario));
        posts.set(usuario, lista);
    }
}
