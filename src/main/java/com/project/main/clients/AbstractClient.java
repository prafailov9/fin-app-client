/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.main.clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author user
 */
public abstract class AbstractClient {
    
    private final static String BASE_URI = "http://localhost:8080/rest/";

    private Client client;
    private WebTarget target;
    
    public AbstractClient() {
        
        this.client = ClientBuilder.newClient();
        this.target = client.target(BASE_URI);
        
    }
    
    protected Client getClient() {
        return client;
    }
    
    protected WebTarget getTarget() {
        return target;
    }
    
}
