package com.example.polly.dao;


import java.util.List;

import com.example.polly.enty.Client;
import com.example.polly.util.MyBatisDao;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@MyBatisDao
public interface ClientDao {

    public Client createClient(Client client);
    public Client updateClient(Client client);
    public void deleteClient(Long clientId);

    Client findOne(Long id);

    List<Client> findAll();

    Client findByClientId(String clientId);
    Client findByClientKey(String clientKey);

}
