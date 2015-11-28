<%@ page import="ucdb.models.Bairro" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Junio
  Date: 11/10/2015
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


  <title>Listar Bairros</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <!-- Esse JavaScript irá apresentar uma mensagem ao usuario, que deverá confirmar o cancelar a exclusão do
  Object Selecionado, nesse caso um Cliente-->
  <script type="text/javascript">
    function confirmaExclusao(id) {
      confirmou = window.confirm("Tem Certeza que deseja Excluir?")
      if (confirmou == true) {
        location.href = "BairroController?acao=exc&id=" + id;
      }
    }
  </script>
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
            <div class="panel-title"> LISTA DE BAIRROS </div>
          </div>

          <div class="panel-body" style="padding-top:30px" >

            <table class="table table-striped">
              <thead>
                <tr class="alt">
                  <th>Nome</th>
                </tr>
              </thead>
              <tbody>
                <!--Scriptlet que cria uma Lista que possui  um  bind com o atributo "usu"
                cujo qual é alimentado pelo servlet atraves do metodo GET, que quando recebe uma ação do tipo
                list prepara e alimenta essa tabela, atributo por atributo-->
                <%
                  //Scriptlet
                  List<Bairro> bairros = (List<Bairro>) request.getAttribute("bai");

                  for (int i = 0; i < bairros.size(); i++) {
                    Bairro b = bairros.get(i);
                %>

                <tr>
                  <td><%=b.getNome()%></td>
                  <td><button class="btn btn-danger" type="submit" onclick="location.href='javascript:confirmaExclusao(<%=b.getId()%>)'">EXCLUIR</button></td>
                  <td><button class="btn btn" type="submit" onclick="location.href='BairroController?acao=edit&id=<%=b.getId()%>'">EDITAR</button></td>
                </tr>
                <%
                  }
                %>
              <tbody>
            </table>
            <button class="btn btn" type="reset" onclick="location.href='http://localhost:8080/TeleView-1.0-SNAPSHOT/menuprincipal.jsp'">RETORNAR</button>

          </div>

        </div>

      </div>

    </div>
</body>
</html>
