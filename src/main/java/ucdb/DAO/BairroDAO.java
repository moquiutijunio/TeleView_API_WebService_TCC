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
import ucdb.models.Bairro;

/**
 * Created by Junio on 03/10/2015.
 */
public class BairroDAO {

    Connection conexao;

    public BairroDAO(){
        conexao = ConexaoUtil.getConnection();
    }

    public Bairro buscarPorId(Integer id) {
        String sql = "select * from bairro where codbairro=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);
            //Armazenamento Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            if (resultado.next()) {
                Bairro bairro = new Bairro();
                bairro.setId(Long.parseLong(resultado.getString("codbairro")));
                bairro.setNome(resultado.getString("nome"));

                preparadorSQL.close();
                return bairro;
            } else {
                return null;
            }
        } catch (SQLException ex) {

            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Bairro> buscarTodos() {
        String sql = "select * from bairro order by nome";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            List<Bairro> lista = new ArrayList<Bairro>();
            while (resultado.next()) {

                Bairro bairro = new Bairro();

                //Atribuindo dados do resultado no objeto
                bairro.setId(Long.parseLong(resultado.getString("codbairro")));
                bairro.setNome(resultado.getString("nome"));

                //Adicionando objeto na lista
                lista.add(bairro);
            }

            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void excluir(int id) {
        String sql = "delete from bairro where codbairro=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);

            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(Bairro bairro) {
        String sql = "insert into bairro (nome) values (?)";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, bairro.getNome());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(BairroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
