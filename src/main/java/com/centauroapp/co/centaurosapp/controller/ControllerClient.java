package com.centauroapp.co.centaurosapp.controller;

import com.centauroapp.co.centaurosapp.models.Client;
import com.centauroapp.co.centaurosapp.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping({"centauro/user"})
public class ControllerClient {

    @Autowired
    ClienteServices clienteServices;

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
        return clienteServices.addClient(client);
    }


    @GetMapping("/{id}")
    public Client getById(@PathVariable int id) {
        return clienteServices.findById(id);
    }

    @GetMapping("id/{identificationClient}")
    public <Optional> Client getByIdentification(@PathVariable String identificationClient) {
        return clienteServices.findByIdentification(identificationClient).orElseThrow(()
                -> new EntityNotFoundException("Ocurrio un error consultando el usuario por la cc"));
    }

}
