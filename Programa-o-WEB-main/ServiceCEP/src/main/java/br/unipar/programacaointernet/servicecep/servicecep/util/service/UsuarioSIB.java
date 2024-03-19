package br.unipar.programacaointernet.servicecep.servicecep.util.service;

import br.unipar.programacaointernet.servicecep.servicecep.util.EntityManagerUtil;
import br.unipar.programacaointernet.servicecep.servicecep.util.dao.UsuarioDAOImpl;
import br.unipar.programacaointernet.servicecep.servicecep.util.dao.UsuarioDao;
import br.unipar.programacaointernet.servicecep.servicecep.util.model.Usuario;
import jakarta.jws.WebService;

import java.util.List;

@WebService(endpointInterface = "br.unipar.programacaointernet.servicecep.servicecep.util.service.UsuarioSEI")
public class UsuarioSIB implements UsuarioSEI {

    @Override
    public String boasVindas(String nome) {
        return "Bem Vindo(a) " + nome + "!";
    }

    @Override
    public Usuario consultaUsuario(Long idUsuario) {
        UsuarioDao usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManeger()
        );


        return usuarioDAO.findById(idUsuario);
    }

    @Override
    public List<Usuario> consultaTodosUsuario() {
        UsuarioDao usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManeger()
        );

        return usuarioDAO.findAll();
    }

    @Override
    public String deletaUsuario(Long idUsuario) {
       UsuarioDao usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManeger()
        );

        Usuario a = usuarioDAO.findById(idUsuario);

        usuarioDAO.delete(a);

        return "usuário deletado com sucesso!" + a.getNome();
    }

    @Override
    public String salvarUsuario(Usuario usuario) {
        UsuarioDao usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManeger()
        );

        usuarioDAO.save(usuario);

        return "Usuário salvo com sucesso!";
    }

    @Override
    public String editarUsuario(Long idUsuario, String login) {
        UsuarioDao usuarioDAO = new UsuarioDAOImpl(
                EntityManagerUtil.getManeger()
        );

        Usuario a = usuarioDAO.findById(idUsuario);

        a.setLogin(login);

        usuarioDAO.update(a);

        return "Usuário editado com sucesso!";
    }
}
