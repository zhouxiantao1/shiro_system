package com.example.polly.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polly.dao.ClientDao;
import com.example.polly.enty.Client;
import com.example.polly.service.ClientService;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-17
 * <p>Version: 1.0
 */

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    public Client createClient(Client client) {

        client.setClientId(UUID.randomUUID().toString());
        client.setClientSecret(UUID.randomUUID().toString());
        return clientDao.createClient(client);
    }

    public Client updateClient(Client client) {
        return clientDao.updateClient(client);
    }

    public void deleteClient(Long clientId) {
        clientDao.deleteClient(clientId);
    }


    public Client findOne(Long clientId) {
        return clientDao.findOne(clientId);
    }


    public List<Client> findAll() {
        return clientDao.findAll();
    }


    public Client findByClientId(String clientId) {
        return clientDao.findByClientId(clientId);
    }


    public Client findByClientKey(String clientKey) {
        return clientDao.findByClientKey(clientKey);
    }
    
    public boolean checkClientId(String clientId) {
      return clientDao.findByClientId(clientId) != null;
   }


   public boolean checkClientSecret(String clientSecret) {
      return clientDao.findByClientKey(clientSecret) != null;
   }
}
