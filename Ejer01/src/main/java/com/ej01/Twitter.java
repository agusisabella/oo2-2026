package com.ej01;

import java.util.List;

public class Twitter {
    private List<Usuario> usuarios;
    
    Twitter(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    public boolean agregarUsuario(String screenName){
        if (this.usuarios.stream()
                .anyMatch(u -> u.isEqualName(screenName))
        )
           return false;
        return this.usuarios.add(new Usuario(screenName));

    }
     public boolean eliminarUsuario(Usuario usuario){
        if(usuario.eliminar())
            return this.usuarios.remove(usuario);
        return false;
    }

   
    
}
