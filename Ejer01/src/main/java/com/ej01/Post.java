package com.ej01;

import java.sql.Date;

public abstract class Post {
    
    private Usuario creador;
    
    private Date fechaCreacion;

    Post(Usuario creador, Date fechaCreacion){
       this.setCreador(creador); //? PREGUNTAR SI ES NECESARIO CREAR SETTERS PRIVADOS PARA USAR DENTRO DE LOS CONSTRUCTORES
       this.setFechaCreacion(fechaCreacion);
    }
  
    private void setCreador(Usuario creador) {
        this.creador = creador;
    }

    private void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getCreador() {
        return creador;
    }
    public abstract boolean eliminar();

    protected abstract String getInfoPost();

    public  String mostrarInfo()
    {
        return "Post creado por: " + this.getCreador().getScreenName() + " - Fecha de creación: " + this.getFechaCreacion()+"\n"+this.getInfoPost();
    };


}
