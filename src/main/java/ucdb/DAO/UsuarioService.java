package ucdb.DAO;


import ucdb.Util.ServiceException;
import ucdb.models.Usuario;

import java.util.List;

public class UsuarioService {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioService(){
		usuarioDAO = new UsuarioDAO();
	}
	
	public boolean validar(Usuario u) {
		if(usuarioDAO.buscarPorUserSenha(u.getNome(), u.getSenha()))
			return true;
		return false;
	}

	public void salvar(Usuario usuario) throws ServiceException {
		usuarioDAO.salvar(usuario);
	}

	public void excluir(Integer id) {
		usuarioDAO.excluir(id);
	}

	public Usuario buscarPorId(Integer id) {
		return usuarioDAO.buscarPorId(id);
	}

	public List<Usuario> buscarTodos() {
		return usuarioDAO.buscarTodos();
	}
}
