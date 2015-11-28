package ucdb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ucdb.Util.ConexaoUtil;
import ucdb.models.Categoria;


public class CategoriaDAO {
	Connection conexao;
	
	public CategoriaDAO(){
		conexao = ConexaoUtil.getConnection();
	}

	public Categoria buscarPorId(Integer id) {
		String sql = "select * from categoria where codcategoria=?";
		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
			preparadorSQL.setInt(1, id);
			//Armazenamento Resultado da consulta
			ResultSet resultado = preparadorSQL.executeQuery();
			if (resultado.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(Long.parseLong(resultado.getString("codcategoria")));
				categoria.setNome(resultado.getString("nome"));
				
				preparadorSQL.close();
				return categoria;
			} else {
				return null;
			}
		} catch (SQLException ex) {
			
			Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public List<Categoria> buscarTodos() {
		String sql = "select * from categoria order by nome";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
			List<Categoria> lista = new ArrayList<Categoria>();
            while (resultado.next()) {

				Categoria categoria = new Categoria();

                //Atribuindo dados do resultado no objeto
                categoria.setId(Long.parseLong(resultado.getString("codcategoria")));
                categoria.setNome(resultado.getString("nome"));
                //Adicionando objeto na lista
                lista.add(categoria);
            }
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {
        	Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
	}
	
	
}
