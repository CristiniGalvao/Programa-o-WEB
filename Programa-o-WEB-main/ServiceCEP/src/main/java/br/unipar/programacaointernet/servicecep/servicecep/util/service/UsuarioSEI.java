package br.unipar.programacaointernet.servicecep.servicecep.util.service;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface UsuarioSEI {

    @WebMethod
    String boasVindas(String nome);

}
