package br.unipar.programacaointernet.servicecep.servicecep.util.dao;

import br.unipar.programacaointernet.servicecep.servicecep.util.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;

import java.util.List;

public interface EnderecoDao {
    public void save(Endereco endereco);
    public void update(Endereco endereco);
    public void delete(Endereco endereco);

    public Endereco findById(Long id);
    public List<Endereco> findAll();
}
