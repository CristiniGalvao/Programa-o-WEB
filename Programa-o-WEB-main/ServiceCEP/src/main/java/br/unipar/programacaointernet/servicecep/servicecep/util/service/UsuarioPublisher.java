package br.unipar.programacaointernet.servicecep.servicecep.util.service;

import jakarta.xml.ws.Endpoint;

public class UsuarioPublisher {
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8080/usuario", new UsuarioSIB());

    }
}
