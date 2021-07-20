package com.centauroapp.co.centaurosapp.services;

import com.centauroapp.co.centaurosapp.models.Client;
import com.centauroapp.co.centaurosapp.repository.ClientRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

@Service
public class ClienteServices {

    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client) {

        if (client != null) {
            try {
                Client newClient = Client.builder()
                        .nameClient( WordUtils.capitalize(client.getNameClient()) )
                        .lastNameClient(WordUtils.capitalize(client.getLastNameClient()))
                        .birthdayDate(client.getBirthdayDate())
                        .salary(client.getSalary())
                        .addressClient(WordUtils.capitalize(client.getAddressClient()))
                        .typeIdentification(WordUtils.capitalize(client.getTypeIdentification()))
                        .addressClient(WordUtils.capitalize(client.getAddressClient()))
                        .identificationClient(client.getIdentificationClient())
                        .profession(WordUtils.capitalize(client.getProfession()))
                        .typeContract(WordUtils.capitalize(client.getTypeContract()))
                        .typeIdentification(client.getTypeIdentification().toUpperCase()).build();
                clientRepository.save(newClient);
            } catch (Exception e) {
                System.out.println("Ocurrio un error al crear el usuario nuevo!!!  " + e.getMessage());
            }
        }
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
