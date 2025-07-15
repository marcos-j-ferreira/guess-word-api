package com.marcos.guessword.repository;

import java.util.ArrayList;
import java.util.List;

import com.marcos.guessword.model.Usuario;

public class RepositoryUser {

    private ArrayList<Usuario> user = new ArrayList<>();

    public final boolean add(Usuario name){
        user.add(name);
        return true;
    } 

    public final List<Usuario> getusers(){
        return new ArrayList<>(user);
    }

}