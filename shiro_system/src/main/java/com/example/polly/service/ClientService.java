package com.example.polly.service;


import java.util.List;

import com.example.polly.enty.Client;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public interface ClientService {

    public Client createClient(Client client);
    public Client updateClient(Client client);
    public void deleteClient(Long clientId);

    Client findOne(Long clientId);

    List<Client> findAll();

    Client findByClientId(String clientId);
    Client findByClientKey(String clientKey);
    
    public boolean checkClientId(String clientId);


     public boolean checkClientSecret(String clientSecret);

}
