package com.ej01;
import java.sql.Date;

public class Tweet extends Post {
    private String texto;

    public Tweet(String texto, Usuario usuario) {
        super(usuario, new Date(System.currentTimeMillis()));
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public boolean eliminar() {
        
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

   @Override
   protected String getInfoPost() {
      
       return " ------Tweet--------- \n " + this.getTexto();
   }
 
}
