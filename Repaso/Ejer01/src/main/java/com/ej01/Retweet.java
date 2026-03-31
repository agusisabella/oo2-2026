package com.ej01;

public class Retweet extends Post {
    private Post original;

    public Retweet(Post original, Usuario usuario) {
        super(usuario, new java.sql.Date(System.currentTimeMillis()));
        this.original = original;
    }

    public Post getOriginal() {
        return original;
    }

    @Override
    public boolean eliminar() {
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    protected String getInfoPost() {
        return " ------Retweet--------- \n " + this.getOriginal().mostrarInfo();
    }
}