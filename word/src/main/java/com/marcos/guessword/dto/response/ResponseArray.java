package com.marcos.guessword.dto.response;

import java.util.ArrayList;
import java.util.List;

public record ResponseArray(String Estado, ArrayList<UsuarioResponseDTO> Alunos){}

