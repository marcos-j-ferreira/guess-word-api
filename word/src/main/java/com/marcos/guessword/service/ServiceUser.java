package com.marcos.guessword.service;

import com.marcos.guessword.dto.request.UsuarioRequestDTO;
import com.marcos.guessword.repository.RepositoryUser;
import com.marcos.guessword.model.Usuario;

public class ServiceUser {

    private RepositoryUser repository = new RepositoryUser();

    public final String adduser( UsuarioRequestDTO name){
        Usuario user = new Usuario(name.name());
        repository.add(user);

        return name.name();
    } 
}
