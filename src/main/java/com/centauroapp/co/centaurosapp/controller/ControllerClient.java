package com.centauroapp.co.centaurosapp.controller;

import com.centauroapp.co.centaurosapp.models.Client;
import com.centauroapp.co.centaurosapp.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"centauro/user"})
public class ControllerClient {

    @Autowired
    ClienteServices clienteServices;

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client){
        return clienteServices.addClient(client);
    }

}
