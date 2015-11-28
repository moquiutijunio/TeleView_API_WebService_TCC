package ucdb.Controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ucdb.DAO.UsuarioService;
import ucdb.models.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet({ "/UsuarioController", "/UsuarioController.do", "/UsuarioServlet",
		"/UsuarioControlador", "/UsuarioControle" })
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsuarioService usuarioService = new UsuarioService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String acao = req.getParameter("acao");

		if (acao == null || acao == "") {
			Usuario usuario = new Usuario();
			usuario.setNome("");
			usuario.setSenha("");
			usuario.setId(0);
			req.setAttribute("usu", usuario);
			req.getRequestDispatcher("usuarioListar.jsp").forward(req, resp);
		}
		if (acao.equals("lis")) {
			// Pegar a lista
			List<Usuario> usuarios = usuarioService.buscarTodos();
			req.setAttribute("usu", usuarios);

			// Levar para o JSP
			RequestDispatcher view = req.getRequestDispatcher("usuarioListar.jsp");
			view.forward(req, resp);
		}else if (acao.equals("exc")) {
			String id = req.getParameter("id");
			usuarioService.excluir(Integer.parseInt(id));
			resp.getWriter()
					.print("<script> window.alert('Excluido com Sucesso!'); location.href='UsuarioController?acao=lis'; </script>");

		} else if (acao.equals("edit")) {
			String id = req.getParameter("id");
			Usuario usuarioBuscado = usuarioService.buscarPorId(Integer.parseInt(id));

			req.setAttribute("usu", usuarioBuscado);
			req.getRequestDispatcher("usuarioEditar.jsp").forward(req, resp);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");

		// instanciando uma classe
		Usuario usuario = new Usuario();

		// recebendo os valores da tela para variaveis comuns
		String id = req.getParameter("id");

		// esse if foi criado para atribuir valor 0 ao id, cambiarra feita para
		// funcionar
		if (id.equals("")) {
			id = "0";
		}

		// recebendo os valor da tela para variaveis comuns
		String user = req.getParameter("usuario");
		String senha = req.getParameter("senha");

		// ele sempre vai entrar nesse if quando o objeto for a cadastrar
		// pois se os valores vierem preenchidos que no caso sempre virao e o id
		// vier vazio ele tera o valor 0 por padrão do codigo feito por mim para
		// que posso funcionar
		// temporariamente ficara assim até a busca da solução
		if (id != null && id != "" && id == "0") {

			usuario.setNome(user);
			usuario.setSenha(senha);

		} else if (id != null && id != "" && id != "0") {
			int temp = Integer.parseInt(id);
			System.out.println(temp);

			usuarioService.excluir(Integer.parseInt(id));

			usuario.setId(temp);
			usuario.setNome(user);
			usuario.setSenha(senha);
		}

		try {
			// Chama-se o metodo salvar da classe de serviços
			// passando a classe do objeto
			usuarioService.salvar(usuario);

			// caso tudo corra corretamente é disparada esse alert na tela como
			// operação realizada com sucesso
			resp.getWriter()
					.print("<script> window.alert('Salvo Sucesso!'); location.href='UsuarioController?acao=lis'; </script>");

		} catch (Exception e) {
			// TODO: handle exception
			// caso não é disparado essa exceção na tela configurado com o nome
			// da mesma
			resp.getWriter()
					.print("<script> window.alert('"
							+ e.getMessage()
							+ "'); location.href='menuprincipal.jsp'; </script>");

			e.printStackTrace();
		}
	}
}
