/**
 * 
 */
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
import ucdb.models.Categoria;
import ucdb.models.Empresa;
import ucdb.models.Regiao;

public class EmpresaDAO {
	Connection conexao;
	
	public CategoriaDAO categoriaDAO = new CategoriaDAO();
	public Categoria categoria = new Categoria();
	
	public RegiaoDAO regiaoDAO = new RegiaoDAO();
	public Regiao regiao = new Regiao();

	public BairroDAO bairroDAO = new BairroDAO();
	public Bairro bairro = new Bairro();

	List<Empresa> lista = new ArrayList<Empresa>();
	
	public EmpresaDAO(){
		conexao = ConexaoUtil.getConnection();
	}
	
	public List<Empresa> buscarTodos() {
		String sql = "select * from empresa order by nome";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
			List<Empresa> lista = new ArrayList<Empresa>();
            while (resultado.next()) {
				//Instancia do Objeto
				Empresa empresa = new Empresa();

				//Atribuindo dados do resultado no objeto
				empresa.setId(Long.parseLong(resultado.getString("codempresa")));
				Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(resultado.getString("codcategoria")));
				empresa.setCategoria(categoria);
				empresa.setNome(resultado.getString("nome"));
				empresa.setEndereco(resultado.getString("endereco"));
				empresa.setNumero(resultado.getInt("numero"));
				empresa.setTelefone(resultado.getString("telefone"));
				empresa.setAtendimentoSegSex(resultado.getString("atendimento_seg_sex"));
				empresa.setAtendimentoSabado(resultado.getString("atendimento_sabado"));
				empresa.setAtendimentoDoming(resultado.getString("atendimento_domingo"));
				Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(resultado.getString("codregiao")));
				empresa.setRegiao(regiao);
				Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(resultado.getString("codbairro")));
				empresa.setBairro(bairro);
				
				lista.add(empresa);
			}
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {
        	Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
	}

	public List<Empresa> buscarPorCategoria(Integer id) {
		String sql = "select * from empresa where codcategoria=? order by nome";
		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
			preparadorSQL.setInt(1, id);
			//Armazenamento Resultado da consulta
			ResultSet resultado = preparadorSQL.executeQuery();
			List<Empresa> lista = new ArrayList<Empresa>();
			while (resultado.next()) {
				//Instancia do Objeto
				Empresa empresa = new Empresa();
				
				//Atribuindo dados do resultado no objeto
				empresa.setId(Long.parseLong(resultado.getString("codempresa")));
				Categoria categoria = categoriaDAO.buscarPorId(id);
				empresa.setCategoria(categoria);
				empresa.setNome(resultado.getString("nome"));
				empresa.setEndereco(resultado.getString("endereco"));
				empresa.setNumero(resultado.getInt("numero"));
				empresa.setTelefone(resultado.getString("telefone"));
				empresa.setAtendimentoSegSex(resultado.getString("atendimento_seg_sex"));
				empresa.setAtendimentoSabado(resultado.getString("atendimento_sabado"));
				empresa.setAtendimentoDoming(resultado.getString("atendimento_domingo"));
				Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(resultado.getString("codregiao")));
				empresa.setRegiao(regiao);
				Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(resultado.getString("codbairro")));
				empresa.setBairro(bairro);
				
				lista.add(empresa);
			}	
				preparadorSQL.close();
				return lista;
		} catch (SQLException ex) {
			
			Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public Empresa buscarPorId(Integer id) {
		String sql = "select * from empresa where codempresa=?";
		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
			preparadorSQL.setInt(1, id);
			//Armazenamento Resultado da consulta
			ResultSet resultado = preparadorSQL.executeQuery();

			//Instancia do Objeto
			Empresa empresa = new Empresa();

			while (resultado.next()) {

				//Atribuindo dados do resultado no objeto
				empresa.setId(Long.parseLong(resultado.getString("codempresa")));
				Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(resultado.getString("codcategoria")));
				empresa.setCategoria(categoria);
				empresa.setNome(resultado.getString("nome"));
				empresa.setEndereco(resultado.getString("endereco"));
				empresa.setNumero(resultado.getInt("numero"));
				empresa.setTelefone(resultado.getString("telefone"));
				empresa.setAtendimentoSegSex(resultado.getString("atendimento_seg_sex"));
				empresa.setAtendimentoSabado(resultado.getString("atendimento_sabado"));
				empresa.setAtendimentoDoming(resultado.getString("atendimento_domingo"));
				Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(resultado.getString("codregiao")));
				empresa.setRegiao(regiao);
				Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(resultado.getString("codbairro")));
				empresa.setBairro(bairro);

			}
			preparadorSQL.close();
			return empresa;
		} catch (SQLException ex) {

			Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}
	
	public List<Empresa> buscarPorRegiao(Integer id) {
		String sql = "select * from empresa where codregiao=? order by nome";
		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
			preparadorSQL.setInt(1, id);
			//Armazenamento Resultado da consulta
			ResultSet resultado = preparadorSQL.executeQuery();
			
			List<Empresa> lista = new ArrayList<Empresa>();
			
			while (resultado.next()) {
				//Instancia do Objeto
				Empresa empresa = new Empresa();
				
				//Atribuindo dados do resultado no objeto
				empresa.setId(Long.parseLong(resultado.getString("codempresa")));
				Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(resultado.getString("codcategoria")));
				empresa.setCategoria(categoria);
				empresa.setNome(resultado.getString("nome"));
				empresa.setEndereco(resultado.getString("endereco"));
				empresa.setNumero(resultado.getInt("numero"));
				empresa.setTelefone(resultado.getString("telefone"));
				empresa.setAtendimentoSegSex(resultado.getString("atendimento_seg_sex"));
				empresa.setAtendimentoSabado(resultado.getString("atendimento_sabado"));
				empresa.setAtendimentoDoming(resultado.getString("atendimento_domingo"));
				Regiao regiao = regiaoDAO.buscarPorId(id);
				empresa.setRegiao(regiao);
				Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(resultado.getString("codbairro")));
				empresa.setBairro(bairro);
				
				lista.add(empresa);
			}	
				preparadorSQL.close();
				return lista;
		} catch (SQLException ex) {
			
			Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public List<Empresa> buscarPorFiltro(String texto) {
		String sql1 = "select * from empresa where upper(nome) = upper(?) or upper(endereco) = upper(?) or upper(atendimento_seg_sex) = upper(?) or upper(atendimento_sabado) = upper(?) or upper(atendimento_domingo) = upper(?) order by nome";
		String sql2 = "select * from empresa join regiao on upper(regiao.nome) = upper(?) where regiao.codregiao = empresa.codregiao order by empresa.nome";
		String sql3 = "select * from empresa join categoria on upper(categoria.nome) = upper(?) where categoria.codcategoria = empresa.codcategoria order by empresa.nome";
		String sql4 = "select * from empresa join bairro on upper(bairro.nome) = upper(?) where bairro.codbairro = empresa.codbairro order by empresa.nome";
		try {
			//SQL 1
			PreparedStatement preparadorSQL1 = conexao.prepareStatement(sql1);
			preparadorSQL1.setString(1, texto);
			preparadorSQL1.setString(2, texto);
			preparadorSQL1.setString(3, texto);
			preparadorSQL1.setString(4, texto);
			preparadorSQL1.setString(5, texto);

			//SQL 2
			PreparedStatement preparadorSQL2 = conexao.prepareStatement(sql2);
			preparadorSQL2.setString(1, texto);
			//SQL 3
			PreparedStatement preparadorSQL3 = conexao.prepareStatement(sql3);
			preparadorSQL3.setString(1, texto);
			//SQL 4
			PreparedStatement preparadorSQL4 = conexao.prepareStatement(sql4);
			preparadorSQL4.setString(1, texto);

			List<Empresa> lista = new ArrayList<Empresa>();

			//Armazenamento Resultado da consulta
			ResultSet resultado1 = preparadorSQL1.executeQuery();
			while (resultado1.next()) {
				//Instancia do Objeto
				Empresa empresa = new Empresa();

				//Atribuindo dados do resultado no objeto
				empresa.setId(Long.parseLong(resultado1.getString("codempresa")));
				Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(resultado1.getString("codcategoria")));
				empresa.setCategoria(categoria);
				empresa.setNome(resultado1.getString("nome"));
				empresa.setEndereco(resultado1.getString("endereco"));
				empresa.setNumero(resultado1.getInt("numero"));
				empresa.setTelefone(resultado1.getString("telefone"));
				empresa.setAtendimentoSegSex(resultado1.getString("atendimento_seg_sex"));
				empresa.setAtendimentoSabado(resultado1.getString("atendimento_sabado"));
				empresa.setAtendimentoDoming(resultado1.getString("atendimento_domingo"));
				Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(resultado1.getString("codregiao")));
				empresa.setRegiao(regiao);
				Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(resultado1.getString("codbairro")));
				empresa.setBairro(bairro);

				lista.add(empresa);
			}
			preparadorSQL1.close();

			//Armazenamento Resultado da consulta
			ResultSet resultado2 = preparadorSQL2.executeQuery();
			while (resultado2.next()) {
				//Instancia do Objeto
				Empresa empresa = new Empresa();
				//Atribuindo dados do resultado no objeto
				empresa.setId(Long.parseLong(resultado2.getString("codempresa")));
				Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(resultado2.getString("codcategoria")));
				empresa.setCategoria(categoria);
				empresa.setNome(resultado2.getString("nome"));
				empresa.setEndereco(resultado2.getString("endereco"));
				empresa.setNumero(resultado2.getInt("numero"));
				empresa.setTelefone(resultado2.getString("telefone"));
				empresa.setAtendimentoSegSex(resultado2.getString("atendimento_seg_sex"));
				empresa.setAtendimentoSabado(resultado2.getString("atendimento_sabado"));
				empresa.setAtendimentoDoming(resultado2.getString("atendimento_domingo"));
				Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(resultado2.getString("codregiao")));
				empresa.setRegiao(regiao);
				Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(resultado2.getString("codbairro")));
				empresa.setBairro(bairro);

				lista.add(empresa);
			}
			preparadorSQL2.close();

			//Armazenamento Resultado da consulta
			ResultSet resultado3 = preparadorSQL3.executeQuery();
			while (resultado3.next()) {
				//Instancia do Objeto
				Empresa empresa = new Empresa();
				//Atribuindo dados do resultado no objeto
				empresa.setId(Long.parseLong(resultado3.getString("codempresa")));
				Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(resultado3.getString("codcategoria")));
				empresa.setCategoria(categoria);
				empresa.setNome(resultado3.getString("nome"));
				empresa.setEndereco(resultado3.getString("endereco"));
				empresa.setNumero(resultado3.getInt("numero"));
				empresa.setTelefone(resultado3.getString("telefone"));
				empresa.setAtendimentoSegSex(resultado3.getString("atendimento_seg_sex"));
				empresa.setAtendimentoSabado(resultado3.getString("atendimento_sabado"));
				empresa.setAtendimentoDoming(resultado3.getString("atendimento_domingo"));
				Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(resultado3.getString("codregiao")));
				empresa.setRegiao(regiao);
				Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(resultado3.getString("codbairro")));
				empresa.setBairro(bairro);

				lista.add(empresa);
			}
			preparadorSQL3.close();

			//Armazenamento Resultado da consulta
			ResultSet resultado4 = preparadorSQL4.executeQuery();
			while (resultado4.next()) {
				//Instancia do Objeto
				Empresa empresa = new Empresa();
				//Atribuindo dados do resultado no objeto
				empresa.setId(Long.parseLong(resultado4.getString("codempresa")));
				Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(resultado4.getString("codcategoria")));
				empresa.setCategoria(categoria);
				empresa.setNome(resultado4.getString("nome"));
				empresa.setEndereco(resultado4.getString("endereco"));
				empresa.setNumero(resultado4.getInt("numero"));
				empresa.setTelefone(resultado4.getString("telefone"));
				empresa.setAtendimentoSegSex(resultado4.getString("atendimento_seg_sex"));
				empresa.setAtendimentoSabado(resultado4.getString("atendimento_sabado"));
				empresa.setAtendimentoDoming(resultado4.getString("atendimento_domingo"));
				Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(resultado4.getString("codregiao")));
				empresa.setRegiao(regiao);
				Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(resultado4.getString("codbairro")));
				empresa.setBairro(bairro);

				lista.add(empresa);
			}
			preparadorSQL4.close();

			return lista;

		} catch (SQLException ex) {

			Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public List<Empresa> buscaDetalhada(String categ, String bair, String ende) {
		String sql = "select * from empresa JOIN categoria on categoria.nome =?"+
					 "JOIN bairro on bairro.nome =?"+
					 "Where bairro.codbairro = empresa.codbairro and categoria.codcategoria = empresa.codcategoria and endereco=? order by nome";


		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
			preparadorSQL.setString(1, categ);
			preparadorSQL.setString(2, bair);
			preparadorSQL.setString(3, ende);
			//Armazenamento Resultado da consulta
			ResultSet resultado = preparadorSQL.executeQuery();

			List<Empresa> lista = new ArrayList<Empresa>();

			while (resultado.next()) {
				//Instancia do Objeto
				Empresa empresa = new Empresa();

				//Atribuindo dados do resultado no objeto
				empresa.setId(Long.parseLong(resultado.getString("codempresa")));
				Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(resultado.getString("codcategoria")));
				empresa.setCategoria(categoria);
				empresa.setNome(resultado.getString("nome"));
				empresa.setEndereco(ende);
				empresa.setNumero(resultado.getInt("numero"));
				empresa.setTelefone(resultado.getString("telefone"));
				empresa.setAtendimentoSegSex(resultado.getString("atendimento_seg_sex"));
				empresa.setAtendimentoSabado(resultado.getString("atendimento_sabado"));
				empresa.setAtendimentoDoming(resultado.getString("atendimento_domingo"));
				Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(resultado.getString("codregiao")));
				empresa.setRegiao(regiao);
				Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(resultado.getString("codbairro")));
				empresa.setBairro(bairro);

				lista.add(empresa);
			}
			preparadorSQL.close();
			return lista;
		} catch (SQLException ex) {

			Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public void salvar(Empresa empresa) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO empresa(codcategoria,nome,endereco,"
				+ "numero,telefone,atendimento_seg_sex,atendimento_sabado,"
				+ "atendimento_domingo,codregiao,codbairro)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);

			//Setando no Banco as informações executa e close
			preparadorSQL.setInt(1, empresa.getCategoria().getId());
			preparadorSQL.setString(2, empresa.getNome());
			preparadorSQL.setString(3, empresa.getEndereco());
			preparadorSQL.setInt(4, empresa.getNumero());
			preparadorSQL.setString(5, empresa.getTelefone());
			preparadorSQL.setString(6, empresa.getAtendimentoSegSex());
			preparadorSQL.setString(7, empresa.getAtendimentoSabado());
			preparadorSQL.setString(8, empresa.getAtendimentoDoming());
			preparadorSQL.setInt(9, empresa.getRegiao().getId());
			preparadorSQL.setInt(10, empresa.getBairro().getId());

			preparadorSQL.execute();
			preparadorSQL.close();

		} catch (SQLException ex) {
			Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void excluir(int id) {
		String sql = "delete from empresa where codempresa=?";

		try {
			PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
			preparadorSQL.setInt(1, id);
			preparadorSQL.execute();
			preparadorSQL.close();

		} catch (SQLException ex) {
			Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
