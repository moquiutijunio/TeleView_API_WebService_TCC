<%--
  Created by IntelliJ IDEA.
  User: Junio
  Date: 11/10/2015
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- Relizado o import do Object e do List da Util, pois nesse JSP será realizado a Listagem-->
<%@page import="ucdb.models.Usuario"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <title>Listar Usuarios</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <!-- Esse JavaScript irá apresentar uma mensagem ao usuario, que deverá confirmar o cancelar a exclusão do
  Object Selecionado, nesse caso um Cliente-->
  <script type="text/javascript">
    function confirmaExclusao(id) {
      confirmou = window.confirm("Tem Certeza que deseja Excluir?")
      if (confirmou == true) {
        location.href = "UsuarioController?acao=exc&id=" + id;
      }
    }
  </script>
  <link rel="shortcut icon" href="icon_freezer.png" >
  <!-- Relizado o include, responsavel por inserir um código padrão, para igualar todas as página
          nesse caso em específico o Menu da header que corresponde as opções do programa, nome da classe
          importada é o header.html-->
  <%@include file="header.html" %>

</head>
<body>

    <div class="container">

      <div class="col-md-6 col-md-offset-3" id="menubox" style="margin-top:45px;" >

        <div class="panel panel-info">
          <div class="panel-heading">
            <div class="panel-title"> LISTA DE USUÁRIOS </div>
          </div>

          <div class="panel-body" style="padding-top:30px" >

            <table class="table table-striped">
              <thead>
                <tr class="alt">
                  <th>Usuário ID</th>
                  <th>Password</th>
                </tr>
              </thead>
              <tbody>
                <!--Scriptlet que cria uma Lista que possui  um  bind com o atributo "usu"
                cujo qual é alimentado pelo servlet atraves do metodo GET, que quando recebe uma ação do tipo
                list prepara e alimenta essa tabela, atributo por atributo-->
                <%
                  //Scriptlet
                  List<Usuario> usuarios = (List<Usuario>) request
                          .getAttribute("usu");

                  for (int i = 0; i < usuarios.size(); i++) {
                    Usuario u = usuarios.get(i);
                %>

                <tr>
                  <td><%=u.getNome()%></td>
                  <td><%=u.getSenha()%></td>
                  <td><button class="btn btn-danger" type="submit" onclick="location.href='javascript:confirmaExclusao(<%=u.getId()%>)'">EXCLUIR</button></td>
                  <td><button class="btn btn" type="submit" onclick="location.href='UsuarioController?acao=edit&id=<%=u.getId()%>'">EDITAR</button></td>
                </tr>
                <%
                  }
                %>
              </tbody>
            </table>
            <button class="btn btn" type="reset" onclick="location.href='http://localhost:8080/TeleView-1.0-SNAPSHOT/menuprincipal.jsp'">RETORNAR</button>

          </div>

        </div>

      </div>

    </div>
</body>
</html>
