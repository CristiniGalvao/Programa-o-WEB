package br.unipar.programacaointernet.servicecep.servicecep.util;

import br.unipar.programacaointernet.servicecep.servicecep.util.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.util.dao.UsuarioDao;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;

public class Main {
    public static void main(String[] args){
        try{
            EntityManagerUtil.getEntityManagerFactory();

            UsuarioDao usuarioDao = new UsuarioDAOImpl(EntityManagerUtil.getManeger());
            Usuario usuario = new Usuario();
            usuario.setNome("Ruan");
            usuario.setLogin("Ruan12");
            usuario.setSenha("123456");

            editarUsuario();
            EntityManagerUtil.closeEntityManagerFactory();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void editarUsuario(){
        UsuarioDao usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManeger());

        Usuario usuario = usuarioDAO.findById(1L);

        usuario.setSenha("nicolasbroxa");

        usuarioDAO.update(usuario);
    }
}
