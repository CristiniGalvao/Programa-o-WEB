package br.unipar.programacaointernet.servicecep.servicecep.util.service;

import jakarta.jws.WebService;

@WebService(endpointInterface = )
public class UsuarioSIB implements UsuarioSEI{

    @Override
    public String boasVindas(String nome) {
        return "Bem vindo(a) "+ nome +"!";
    }
}
