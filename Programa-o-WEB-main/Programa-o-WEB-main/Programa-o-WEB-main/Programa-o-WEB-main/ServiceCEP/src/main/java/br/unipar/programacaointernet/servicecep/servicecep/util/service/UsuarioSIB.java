package br.unipar.programacaointernet.servicecep.servicecep.util.service;

import jakarta.jws.WebService;

@WebService(endpointInterface = "br.unipar.programacaointernet.servicecep.servicecep.util.service.UsuarioSEI")
public class UsuarioSIB implements UsuarioSEI {

    @Override
    public String boasVindas(String nome) {
        return "Bem Vindo(a) " + nome + "!";
    }
}
