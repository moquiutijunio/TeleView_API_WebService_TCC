package ucdb.Controler;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucdb.DAO.BairroDAO;
import ucdb.DAO.CategoriaDAO;
import ucdb.DAO.EmpresaDAO;
import ucdb.DAO.RegiaoDAO;
import ucdb.models.Bairro;
import ucdb.models.Categoria;
import ucdb.models.Empresa;
import ucdb.models.Regiao;

@WebServlet({ "/EmpresaController", "/EmpresaController.do", "/EmpresaServlet",
	"/EmpresaControlador", "/EmpresaControle" })
public class EmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
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
	public List<Bairro> bairros;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");

		 if (acao.equals("lis")) {

			// Pegar a lista
			List<Empresa> empresas = empresaDAO.buscarTodos();

			// Adiciona a lista no request como atributo
			request.setAttribute("emp", empresas);

			// Levar para o JSP
			RequestDispatcher view = request.getRequestDispatcher("empresaListar.jsp");
			view.forward(request, response);

		} else if (acao.equals("exc")) {

			String id = request.getParameter("id");
			empresaDAO.excluir(Integer.parseInt(id));
			response.getWriter()
					.print("<script> window.alert('Excluido com Sucesso!'); location.href='EmpresaController?acao=lis'; </script>");

		} else if (acao.equals("edit")) {
			String id = request.getParameter("id");
			Empresa empresaBuscada = empresaDAO.buscarPorId(Integer.parseInt(id));
			List<Bairro> bairros = bairroDAO.buscarTodos();
			List<Regiao> regioes = regiaoDAO.buscarTodos();
			List<Categoria> categorias = categoriaDAO.buscarTodos();
			request.setAttribute("listabairros", bairros);
			request.setAttribute("listacategorias", categorias);
			request.setAttribute("listaregioes", regioes);
			request.setAttribute("emp", empresaBuscada);

			request.getRequestDispatcher("empresaEditar.jsp").forward(request, response);
		}

		/*Esse método será chamado toda vez que for realizado uma requizição da tela principal para a tela de pedidos
		* pois ele que irá preparar todos os combobox da tela, no caso todos que recebem objetos e mostram para o usuario
		* o nome de seus respectivos. ou seja essa classe foi criada para alimentar o jsp pedidos com os valores iniciais*/
		else if(acao.equals("prepara")){

			List<Bairro> bairros = bairroDAO.buscarTodos();
			List<Regiao> regioes = regiaoDAO.buscarTodos();
			List<Categoria> categorias = categoriaDAO.buscarTodos();

			request.setAttribute("listabairros", bairros);
			request.setAttribute("listacategorias", categorias);
			request.setAttribute("listaregioes", regioes);

			request.getRequestDispatcher("empresaCadastro.jsp").forward(request, response);

		}

		/*// Pegar as listas
		categorias = categoriaDAO.buscarTodos();
		regioes = regiaoDAO.buscarTodos();
		// Adiciona as listas no request como atributo
		request.setAttribute("categorias", categorias);
		request.setAttribute("regioes", regioes);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		// Levar para o JSP
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);*/
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String validador = request.getParameter("opcao");

		if(validador.equals("buscategoria")){

			String id = request.getParameter("categoria");
			empresas = empresaDAO.buscarPorCategoria(Integer.parseInt(id));
			request.setAttribute("empresas", empresas);
			request.getRequestDispatcher("consulta.jsp").forward(request, response);

		}else if(validador.equals("busregiao")){

			String id = request.getParameter("regiao");
			empresas = empresaDAO.buscarPorRegiao(Integer.parseInt(id));
			request.setAttribute("empresas", empresas);
			request.getRequestDispatcher("consulta.jsp").forward(request, response);

		}else if(validador.equals("salvar")){

			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String numero = request.getParameter("numero");
			String telefone = request.getParameter("telefone");
			String atendimentoSegSab = request.getParameter("atendimentosegsex");
			String atendimentoSabado = request.getParameter("atendimentosabado");
			String atendimentoDomingo = request.getParameter("atendimentodomingo");
			String idBairro = request.getParameter("bairro");
			String idCategoria = request.getParameter("categoria");
			String idRegiao = request.getParameter("regiao");

			Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(idBairro));
			Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(idCategoria));
			Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(idRegiao));

			Empresa empresa = new Empresa();

			empresa.setCategoria(categoria);
			empresa.setNome(nome);
			empresa.setEndereco(endereco);
			empresa.setNumero(Integer.parseInt(numero));
			empresa.setTelefone(telefone);
			empresa.setAtendimentoSegSex(atendimentoSegSab);
			empresa.setAtendimentoSabado(atendimentoSabado);
			empresa.setAtendimentoDoming(atendimentoDomingo);
			empresa.setRegiao(regiao);
			empresa.setBairro(bairro);

			try {
			empresaDAO.salvar(empresa);
				response.getWriter()
						.print("<script> window.alert('Salvo com Sucesso!'); location.href='EmpresaController?acao=lis'; </script>");

			} catch (Exception e) {
				response.getWriter()
						.print("<script> window.alert('"
								+ e.getMessage()
								+ "'); location.href='EmpresaController?acao=prepara'; </script>");

				e.printStackTrace();
			}
		}else if(validador.equals("editar")){

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String endereco = request.getParameter("endereco");
			String numero = request.getParameter("numero");
			String telefone = request.getParameter("telefone");
			String atendimentoSegSab = request.getParameter("atendimentosegsex");
			String atendimentoSabado = request.getParameter("atendimentosabado");
			String atendimentoDomingo = request.getParameter("atendimentodomingo");
			String idBairro = request.getParameter("bairro");
			String idCategoria = request.getParameter("categoria");
			String idRegiao = request.getParameter("regiao");

			Bairro bairro = bairroDAO.buscarPorId(Integer.parseInt(idBairro));
			Categoria categoria = categoriaDAO.buscarPorId(Integer.parseInt(idCategoria));
			Regiao regiao = regiaoDAO.buscarPorId(Integer.parseInt(idRegiao));

			Empresa empresa = new Empresa();

			empresa.setId(Long.parseLong(id));
			empresa.setCategoria(categoria);
			empresa.setNome(nome);
			empresa.setEndereco(endereco);
			empresa.setNumero(Integer.parseInt(numero));
			empresa.setTelefone(telefone);
			empresa.setAtendimentoSegSex(atendimentoSegSab);
			empresa.setAtendimentoSabado(atendimentoSabado);
			empresa.setAtendimentoDoming(atendimentoDomingo);
			empresa.setRegiao(regiao);
			empresa.setBairro(bairro);

			try {
				empresaDAO.excluir(Integer.parseInt(id));
				empresaDAO.salvar(empresa);
				response.getWriter()
						.print("<script> window.alert('Empresa Atualizada com Sucesso!'); location.href='EmpresaController?acao=lis'; </script>");

			} catch (Exception e) {
				response.getWriter()
						.print("<script> window.alert('"
								+ e.getMessage()
								+ "'); location.href='EmpresaController?acao=prepara'; </script>");

				e.printStackTrace();
			}
		}

	}
}
