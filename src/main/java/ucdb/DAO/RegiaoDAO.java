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
import ucdb.models.Regiao;


public class RegiaoDAO {

	Connection conexao;
		
		public RegiaoDAO(){
		conexao = ConexaoUtil.getConnection();
		}

		public Regiao buscarPorId(Integer id) {
			String sql = "select * from regiao where codregiao=?";
			try {
				PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
				preparadorSQL.setInt(1, id);
				//Armazenamento Resultado da consulta
				ResultSet resultado = preparadorSQL.executeQuery();
				if (resultado.next()) {
					Regiao regiao = new Regiao();
					regiao.setIdRegiao(Long.parseLong(resultado.getString("codregiao")));
					regiao.setNome(resultado.getString("nome"));
					
					preparadorSQL.close();
					return regiao;
				} else {
					return null;
				}
			} catch (SQLException ex) {
				
				Logger.getLogger(RegiaoDAO.class.getName()).log(Level.SEVERE, null, ex);
				return null;
			}
		}

		public List<Regiao> buscarTodos() {
			String sql = "select * from regiao order by nome";
	        try {
	            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
	            //Armazenando Resultado da consulta
	            ResultSet resultado = preparadorSQL.executeQuery();

				List<Regiao> lista = new ArrayList<Regiao>();

	            while (resultado.next()) {
					Regiao regiao = new Regiao();

	                //Atribuindo dados do resultado no objeto
	                regiao.setIdRegiao(Long.parseLong(resultado.getString("codregiao")));
	                regiao.setNome(resultado.getString("nome"));
	                
	                //Adicionando objeto na lista
	                lista.add(regiao);
	            }
	            
	            preparadorSQL.close();
	            return lista;
	        } catch (SQLException ex) {
	        	Logger.getLogger(RegiaoDAO.class.getName()).log(Level.SEVERE, null, ex);
	            return null;
	        }
		}
}
