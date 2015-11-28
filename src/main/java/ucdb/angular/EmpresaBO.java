package ucdb.angular;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;

import ucdb.DAO.BairroDAO;
import ucdb.DAO.CategoriaDAO;
import ucdb.DAO.EmpresaDAO;
import ucdb.DAO.RegiaoDAO;
import ucdb.models.Bairro;
import ucdb.models.Categoria;
import ucdb.models.Empresa;
import ucdb.models.Regiao;

@Dependent
public class EmpresaBO {

	public CategoriaDAO categoriaDAO = new CategoriaDAO();
	public Categoria categoria = new Categoria();
	
	public RegiaoDAO regiaoDAO = new RegiaoDAO();
	public Regiao regiao = new Regiao();
	
	public EmpresaDAO empresaDAO = new EmpresaDAO();
	public Empresa empresa = new Empresa();

	public BairroDAO bairroDAO = new BairroDAO();
	public Bairro bairro = new Bairro();
	
	private List<Categoria> categorias;
	private List<Regiao> regioes;
	private List<Empresa> empresas;
	private List<Bairro> bairros;

	//lista todas as empresas
	public List<Empresa> lista(){
		empresas = empresaDAO.buscarTodos();
		return empresas;
    }
	//lista todas categorias
	public List<Categoria> listaCategoria(){
		categorias = categoriaDAO.buscarTodos();
		return categorias;
	}
	//lista todas as regioes
	public List<Regiao> listaRegiao(){
		regioes = regiaoDAO.buscarTodos();
		return regioes;
	}
	//lista todos os bairros
	public List<Bairro> listaBairro(){
		bairros = bairroDAO.buscarTodos();
		return bairros;
	}
	//lista por cateria
	public List<Empresa> buscarPorCategoria(int indice){

		empresas = empresaDAO.buscarPorCategoria(indice);
		return empresas;
	}
	//lista por cateria
	public Empresa buscarPorId(int indice){

		empresa = empresaDAO.buscarPorId(indice);
		return empresa;
	}
	public List<Empresa> buscarPorFiltro(String texto) {
		empresas = empresaDAO.buscarPorFiltro(texto);
		return empresas;
	}

	public List<Empresa> buscaDetalhada(String categoria,String bairro, String endereco) {
		empresas = empresaDAO.buscaDetalhada(categoria, bairro, endereco);
		return empresas;
	}
}
