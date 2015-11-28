package ucdb.Controler;

import ucdb.DAO.UsuarioService;
import ucdb.models.Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Usuario u = new Usuario();
		UsuarioService us = new UsuarioService();
		
		String nome = req.getParameter("nome");
		String senha = req.getParameter("senha");
		
		u.setNome(nome);
		u.setSenha(senha);
		
		try {
			boolean logado = false;
			if(us.validar(u))
				logado = true;
			if(logado == true)
			// caso tudo corra corretamente é disparada esse alert na tela como
			// operação realizada com sucesso
			resp.getWriter().print("<script> window.alert('Logado com Sucesso!'); location.href='menuprincipal.jsp'; </script>");
			else
				resp.getWriter().print("<script> window.alert('Usuario ou Senha nao Conferem!'); location.href='login.jsp'; </script>");
		}catch (Exception e) {
			// caso não é disparado essa exceção na tela configurado com o nome
						// da mesma
						resp.getWriter()
								.print("<script> window.alert('"
										+ e.getMessage()
										+ "'); location.href='login.jsp'; </script>");
			e.printStackTrace();
		}
		
	}

}
