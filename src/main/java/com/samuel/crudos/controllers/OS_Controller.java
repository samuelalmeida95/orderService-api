package com.samuel.crudos.controllers;

import com.samuel.crudos.DTOS.OSDTO;
import com.samuel.crudos.services.OS_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/os")
public class OS_Controller {

    @Autowired
    private OS_Service service;
    
    @GetMapping(value = "/{idOS}")
    public ResponseEntity<OSDTO> findById(@PathVariable Integer idOS){
        OSDTO obj = new OSDTO(service.findById(idOS));
        return ResponseEntity.ok().body(obj);
    }
}