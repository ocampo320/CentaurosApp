package com.centauroapp.co.centaurosapp.controller;

import com.centauroapp.co.centaurosapp.models.Client;
import com.centauroapp.co.centaurosapp.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

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
    public  Client getByIdentification(@PathVariable String identificationClient) {
        return clienteServices.findByIdentification(identificationClient);
    }

    @GetMapping("/users")
    public List<Client> getAllUsers() {
        return clienteServices.findAllClient();
    }

    @PutMapping("/clients/{identificationClient}")
    public Client replaceEmployee(@RequestBody Client newEmployee, @PathVariable String identificationClient) {
       return  clienteServices.replaceClient(newEmployee,identificationClient);
    }




}
