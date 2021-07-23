package com.centauroapp.co.centaurosapp.services;

import com.centauroapp.co.centaurosapp.models.Client;
import com.centauroapp.co.centaurosapp.repository.ClientRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Locale;

@Service
public class ClienteServices {

    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client) {


        if (client != null) {
            try {
                Client newClient = Client.builder()
                        .nameClient(WordUtils.capitalize(client.getNameClient()))
                        .lastNameClient(WordUtils.capitalize(client.getLastNameClient()))
                        .birthdayDate(client.getBirthdayDate())
                        .salary(client.getSalary())
                        .addressClient(WordUtils.capitalize(client.getAddressClient()))
                        .typeIdentification((client.getTypeIdentification().toUpperCase()))
                        .addressClient((client.getAddressClient()).toUpperCase())
                        .identificationClient(client.getIdentificationClient())
                        .profession(WordUtils.capitalize(client.getProfession()))
                        .typeContract(WordUtils.capitalize(client.getTypeContract()))
                        .phoneNumberClient(client.getPhoneNumberClient())
                        .email(client.getEmail().toLowerCase())
                        .expenses(client.getExpenses())
                        .typeIdentification(client.getTypeIdentification().toUpperCase()).build();
                clientRepository.save(newClient);
            } catch (Exception e) {
                System.out.println("Ocurrio un error al crear el usuario nuevo!!!  " + e.getMessage());
            }
        }
        return client;
    }

    public Client findById(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ocurrio un error consultando el usuario"));
    }

    public Client findByIdentification(String identification) {
        return clientRepository.findAll().stream().filter(client -> client.getIdentificationClient().equalsIgnoreCase(identification))
                .findFirst().orElse(null);
    }


    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }


    public Client replaceClient(Client newClient, String identification) {

        if (newClient != null) {
            try {
                Client.ClientBuilder c = Client.builder();
                return (Client) clientRepository.findAll().stream().filter(client -> client.getIdentificationClient().equalsIgnoreCase(identification))
                        .findFirst()
                        .map(client -> {
                            c.idClient(newClient.getIdClient());
                            c.email(newClient.getEmail());
                            c.lastNameClient(WordUtils.capitalize(newClient.getLastNameClient()));
                            c.nameClient(WordUtils.capitalize(newClient.getNameClient()));
                            c.expenses((newClient.getExpenses()));
                            c.birthdayDate(newClient.getBirthdayDate());
                            c.salary(newClient.getSalary());
                            c.addressClient(WordUtils.capitalize(newClient.getAddressClient()));
                            c.typeIdentification(WordUtils.capitalize(newClient.getTypeIdentification()));
                            c.addressClient(WordUtils.capitalize(newClient.getAddressClient()));
                            c.identificationClient(newClient.getIdentificationClient());
                            c.profession(WordUtils.capitalize(newClient.getProfession()));
                            c.typeContract(WordUtils.capitalize(newClient.getTypeContract()));
                            c.phoneNumberClient(newClient.getPhoneNumberClient());
                            c.typeIdentification(newClient.getTypeIdentification().toUpperCase());
                            return null;
                        })
                        .orElseGet(() -> {
                            c.idClient(newClient.getIdClient());
                            return clientRepository.save(c.build());
                        });
            } catch (Exception e) {
                System.out.println("Ocurrio un error al actualizar el usuario!!!  " + e.getMessage());

            }
        }
        return newClient;
    }


}
