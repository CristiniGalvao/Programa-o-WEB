package br.unipar.programacaointernet.servicecep.servicecep.util.dao;

import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

import java.util.List;

public class EnderecoDAOImpl implements EnderecoDao{
    private EntityManager em  = EntityManagerUtil.getManeger();
    public EnderecoDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void save(Endereco endereco){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(endereco);
        transaction.commit();
        System.out.println("Usuário" +"Salvo com Sucesso!");
    }

    @Override
    public void update(Endereco endereco){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(endereco);
        transaction.commit();
        System.out.println("Usuário" +" Atualizado com Sucesso!");
    }
    @Override
    public void delete(Endereco endereco){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(endereco);
        transaction.commit();
        System.out.println("Usuário " +  "removido com sucesso!");
    }
    @Override
    public Endereco consultaCep(String cep) {
        try {
            return em.createQuery("select e from Endereco e where e.cep = :cep", Endereco.class)
                    .setParameter("cep", cep)
                    .getSingleResult();
        } catch (NoResultException e) {
            return  null;
        }
    }
    @Override
    public Endereco findById(Long id){
        return em.find(Endereco.class, id);
    }
    @Override
    public List<Endereco> findAll() {
        return em.createQuery("SELECT e FROM Endereco e", Endereco.class).getResultList();
    }

}
