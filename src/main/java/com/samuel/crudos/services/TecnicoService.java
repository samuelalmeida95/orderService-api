package com.samuel.crudos.services;

import java.util.Optional;

import com.samuel.crudos.model.Tecnico;
import com.samuel.crudos.repositories.TecnicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnicoService {

    @Autowired
    public TecnicoRepository tecnicoRepository;

    public Tecnico findById(Integer idTecnico) {
        Optional <Tecnico> tecnicoBuscado = tecnicoRepository.findById(idTecnico);
        return tecnicoBuscado.get();
    }
    
}