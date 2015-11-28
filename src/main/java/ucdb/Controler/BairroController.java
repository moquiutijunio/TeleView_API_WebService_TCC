package ucdb.Controler;

import ucdb.DAO.BairroDAO;
import ucdb.DAO.UsuarioService;
import ucdb.models.Bairro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Junio on 11/10/2015.
 */

@WebServlet({ "/BairroController", "/BairroController.do", "/BairroServlet",
        "/BairroControlador", "/BairroControle" })
public class BairroController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    BairroDAO bairroDAO = new BairroDAO();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String acao = req.getParameter("acao");

        if (acao == null || acao == "") {
            Bairro bairro = new Bairro();
            bairro.setNome("");
            req.setAttribute("bai", bairro);
            req.getRequestDispatcher("bairroListar.jsp").forward(req, resp);
        }
        if (acao.equals("lis")) {
            // Pegar a lista
            List<Bairro> bairros = bairroDAO.buscarTodos();
            req.setAttribute("bai", bairros);

            // Levar para o JSP
            RequestDispatcher view = req.getRequestDispatcher("bairroListar.jsp");
            view.forward(req, resp);
        }else if (acao.equals("exc")) {
            String id = req.getParameter("id");
            bairroDAO.excluir(Integer.parseInt(id));
            resp.getWriter()
                    .print("<script> window.alert('Excluido com Sucesso!'); location.href='BairroController?acao=lis'; </script>");

        } else if (acao.equals("edit")) {
            String id = req.getParameter("id");
            Bairro bairroBuscado = bairroDAO.buscarPorId(Integer.parseInt(id));

            req.setAttribute("bai", bairroBuscado);
            req.getRequestDispatcher("bairroEditar.jsp").forward(req, resp);
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
        Bairro bairro = new Bairro();

        // recebendo os valores da tela para variaveis comuns
        String id = req.getParameter("id");

        // esse if foi criado para atribuir valor 0 ao id, cambiarra feita para
        // funcionar
        if (id.equals("")) {
            id = "0";
        }

        // recebendo os valor da tela para variaveis comuns
        String nome = req.getParameter("nome");

        // ele sempre vai entrar nesse if quando o objeto for a cadastrar
        // pois se os valores vierem preenchidos que no caso sempre virao e o id
        // vier vazio ele tera o valor 0 por padrão do codigo feito por mim para
        // que posso funcionar
        // temporariamente ficara assim até a busca da solução
        if (id != null && id != "" && id == "0") {

            bairro.setNome(nome);

        } else if (id != null && id != "" && id != "0") {
            String temp = id;

            bairroDAO.excluir(Integer.parseInt(id));

            bairro.setId(Long.parseLong(temp));
            bairro.setNome(nome);
        }

        try {
            // Chama-se o metodo salvar da classe de serviços
            // passando a classe do objeto
            bairroDAO.salvar(bairro);

            // caso tudo corra corretamente é disparada esse alert na tela como
            // operação realizada com sucesso
            resp.getWriter()
                    .print("<script> window.alert('Salvo Sucesso!'); location.href='BairroController?acao=lis'; </script>");

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
