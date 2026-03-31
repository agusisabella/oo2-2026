package com.ej01;

import java.util.ArrayList;

public class Usuario {

    private ArrayList<Post> posts;
    
	private String screenName;

    Usuario(String screenName) {
        this.screenName = screenName;  
    }
	
	public String getScreenName() {
		return this.screenName;
	}

	
    public boolean isEqual(String screenName) {
        return this.screenName.equals(screenName);
    }

    public boolean eliminar(){
        return this.eliminarPosts();
    }

    private boolean eliminarPosts(){
        this.posts.clear();
        return true;
    }

    public boolean isEqualName(String screenName){
        return this.screenName.equals(screenName);
    }   



}
