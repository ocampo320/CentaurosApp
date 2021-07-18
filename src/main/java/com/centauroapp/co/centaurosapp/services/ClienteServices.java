package com.centauroapp.co.centaurosapp.services;

import com.centauroapp.co.centaurosapp.models.Client;
import com.centauroapp.co.centaurosapp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;
import java.util.List;


public class ClienteServices {

    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client) {
        if (client != null) {
            try {
                clientRepository.save(client);
            } catch (Exception e) {
                System.out.println("Ocurrio un error al crear el usuario nuevo!!!  " + e.getMessage());
            }
        }
        clientRepository.save(client);
        return client;
    }

    public Client findByIdentification(String id) {
        return clientRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new EntityNotFoundException("Ocurrio un error consultando el usuario"));
    }

    public List<Client> findAllClient() {
        return clientRepository.findAll();


    }

}
