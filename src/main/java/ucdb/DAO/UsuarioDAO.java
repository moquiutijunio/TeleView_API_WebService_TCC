package ucdb.DAO;

import ucdb.Util.ConexaoUtil;
import ucdb.models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioDAO {
	Connection conexao;
	
	public UsuarioDAO(){
		conexao = ConexaoUtil.getConnection();
	}
	public boolean buscarPorUserSenha(String usuario, String senha) {
		String sql = "select * from usuario where upper(usuario) = upper(?) and upper(senha) = upper(?) ";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, usuario);
            preparadorSQL.setString(2, senha);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            if (resultado.next()) {
                //Instancia de cliente
                Usuario u = new Usuario();

                //Atribuindo dados do resultado no objeto cliente
                u.setId(resultado.getInt("codusuario"));
                u.setNome(resultado.getString("usuario"));
                u.setSenha(resultado.getString("senha"));
                preparadorSQL.close();
                return true;
            } 
            else
                return false;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
	}


    public void salvar(Usuario usuario) {
        String sql = "insert into usuario (usuario,senha) values (?,?)";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, usuario.getNome());
            preparadorSQL.setString(2, usuario.getSenha());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void excluir(Integer id) {
        String sql = "delete from usuario where codusuario=?";

        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);

            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Usuario> buscarTodos() {
        String sql = "select * from usuario order by usuario";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            List<Usuario> lista = new ArrayList<Usuario>();
            while (resultado.next()) {
                //Instancia do objeto
                Usuario usu = new Usuario();

                //Atribuindo dados do resultado no objeto
                usu.setId(resultado.getInt("codusuario"));
                usu.setNome(resultado.getString("usuario"));
                usu.setSenha(resultado.getString("senha"));
                //Adicionando objeto na lista
                lista.add(usu);
            }
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Usuario buscarPorId(Integer id) {
        String sql = "select * from usuario where codusuario=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            if (resultado.next()) {
                //Instancia o objeto
                Usuario usu = new Usuario();

                //Atribuindo dados do resultado no objeto
                usu.setId(id);
                usu.setNome(resultado.getString("usuario"));
                usu.setSenha(resultado.getString("senha"));
                preparadorSQL.close();
                return usu;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
