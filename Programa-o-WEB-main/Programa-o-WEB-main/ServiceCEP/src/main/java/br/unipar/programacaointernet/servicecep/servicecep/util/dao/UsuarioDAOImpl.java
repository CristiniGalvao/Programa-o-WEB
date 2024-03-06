package br.unipar.programacaointernet.servicecep.servicecep.util.dao;

import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UsuarioDAOImpl implements UsuarioDao{
    private EntityManager em  = EntityManagerUtil.getManeger();
    public UsuarioDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void save(Usuario usuario){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(usuario);
        transaction.commit();
        System.out.println("Usuário" + usuario.getNome()+"Salvo com Sucesso!");
    }

    @Override
    public void update(Usuario usuario){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(usuario);
        transaction.commit();
        System.out.println("Usuário" + usuario.getNome()+" Atualizado com Sucesso!");
    }
    @Override
    public void delete(Usuario usuario){

    }
    @Override
    public Usuario findById(Long id){
        return em.find(Usuario.class, id);
    }
    @Override
    public List<Usuario>findAll(){
        return null;
    }

}
