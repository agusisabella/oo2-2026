package com.ej01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwitterTest {

    private List<Usuario> usuarios;
    private Twitter twitter;

    @BeforeEach
    void setUp() {
        this.usuarios = new ArrayList<>();
        this.twitter = new Twitter(this.usuarios);
    }

    @Test
    void testAgregarUsuarioNuevo() {
        boolean agregado = this.twitter.agregarUsuario("agus");

        assertTrue(agregado);
        assertEquals(1, this.usuarios.size());
        assertEquals("agus", this.usuarios.get(0).getScreenName());
    }

    @Test
    void testAgregarUsuarioDuplicado() {
        this.twitter.agregarUsuario("agus");

        boolean agregado = this.twitter.agregarUsuario("agus");

        assertFalse(agregado);
        assertEquals(1, this.usuarios.size());
    }

    @Test
    void testEliminarUsuarioCuandoEliminarRetornaTrue() throws Exception {
        Usuario usuario = new Usuario("ana");
        inicializarPosts(usuario);
        this.usuarios.add(usuario);

        boolean eliminado = this.twitter.eliminarUsuario(usuario);

        assertTrue(eliminado);
        assertEquals(0, this.usuarios.size());
    }

    @Test
    void testEliminarUsuarioCuandoEliminarRetornaFalse() {
        Usuario usuario = new UsuarioNoEliminable("bob");
        this.usuarios.add(usuario);

        boolean eliminado = this.twitter.eliminarUsuario(usuario);

        assertFalse(eliminado);
        assertEquals(1, this.usuarios.size());
    }

    private void inicializarPosts(Usuario usuario) throws Exception {
        Field posts = Usuario.class.getDeclaredField("posts");
        posts.setAccessible(true);
        posts.set(usuario, new ArrayList<Post>());
    }

    static class UsuarioNoEliminable extends Usuario {
        UsuarioNoEliminable(String screenName) {
            super(screenName);
        }

        @Override
        public boolean eliminar() {
            return false;
        }
    }
}
