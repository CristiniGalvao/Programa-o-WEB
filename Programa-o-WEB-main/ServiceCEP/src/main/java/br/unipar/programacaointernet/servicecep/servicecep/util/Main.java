package br.unipar.programacaointernet.servicecep.servicecep.util;

import br.unipar.programacaointernet.servicecep.servicecep.util.dao.EnderecoDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.util.dao.EnderecoDao;
import br.unipar.programacaointernet.servicecep.servicecep.util.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.util.dao.UsuarioDao;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Endereco;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args){
        try{
            EntityManagerUtil.getEntityManagerFactory();

//            UsuarioDao usuarioDao = new UsuarioDAOImpl(EntityManagerUtil.getManeger());
//            Usuario usuario = new Usuario();
//            usuario.setNome("Rafael");
//            usuario.setLogin("Rafael55");
//            usuario.setSenha("987654");

            salvarEndereco();

            //editarUsuario();
           // deletarUsuario();
           // buscarPorID();
           // buscarTodos();
            EntityManagerUtil.closeEntityManagerFactory();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private static void buscarTodos() {
        UsuarioDao usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManeger());
        List<Usuario> usuarios = usuarioDAO.findAll();
        for (Usuario usuario : usuarios){
            System.out.println("Usuário "+usuario.getNome() + " encontrado com sucesso");
        }

    }

    private static void buscarPorID() {
    }

    private static void deletarUsuario() {
        UsuarioDao usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManeger());

        Usuario usuario = usuarioDAO.findById(1L);
        usuario.setSenha("132451");

        usuarioDAO.update(usuario);
    }

    public static void editarUsuario(){
        UsuarioDao usuarioDAO = new UsuarioDAOImpl(EntityManagerUtil.getManeger());

        Usuario usuario = usuarioDAO.findById(1L);

        usuario.setSenha("senha123");

        usuarioDAO.update(usuario);
    }


    private static Endereco getViaCep(String cep) throws Exception{
        URL url = new URL("http://viacep.com.br/ws/"
                +cep.replace("-", "")
                .replace(".", "")
                +"/xml/");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String inputLine;
        String result = "";
        while ((inputLine = in.readLine()) != null)
            result += inputLine;

        in.close();
        //  return result;
        Endereco objEndereco = new Endereco();
        objEndereco = Endereco.unmarhslaFromString(result);

        return objEndereco;
    }



    public static void salvarEndereco(){
        try{
            EnderecoDao enderecoDAO = new EnderecoDAOImpl(EntityManagerUtil.getManeger());
            enderecoDAO.save(getViaCep("85802190"));
        }catch(Exception e){

        }
    }
}
