<%@ page import="ucdb.models.Empresa" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Junio
  Date: 11/10/2015
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>Listar Pedidos</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <!-- Esse JavaScript irá apresentar uma mensagem ao cliente, que deverá confirmar o cancelar a exclusão do Object Selecionado, nesse caso um Pedido-->
  <script type="text/javascript">
    function confirmaExclusao(id) {
      confirmou = window.confirm("Tem Certeza que deseja Excluir?")
      if (confirmou == true) {
        location.href = "EmpresaController?acao=exc&id=" + id;
      }
    }
  </script>
  <title>Empresa</title>
  <!-- Relizado o include, responsavel por inserir um código padrão, para igualar todas as página
  nesse caso em específico o Menu da header que corresponde as opções do programa, nome da classe
  importada é o header.html-->
  <%@include file="header.html" %>

</head>
<body>

    <div class="container">

      <div class="col-md-12 col-md-offset-1" id="menubox" style="margin-top:45px;" >

        <div class="panel panel-info">
          <div class="panel-heading">
            <div class="panel-title"> LISTA DE EMPRESAS </div>
          </div>

          <div class="panel-body" style="padding-top:30px" >

            <table class="table table-striped">
              <thead>
                <tr class="alt">
                  <th>Nome</th>
                  <th>Endereço</th>
                  <th>Numero</th>
                  <th>Telefone</th>
                  <th>Categoria</th>
                  <th>Bairro</th>
                  <th>Região</th>
                </tr>
              </thead>
              <tbody>
                <!--Scriptlet que cria uma Lista de pedidos que possui  um  bind com o atributo "pdo"
                                    cujo qual é alimentado pelo servlet atraves do metodo GET, que quando recebe uma ação do tipo
                                    list prepara e alimenta essa tabela, atributo por atributo-->
                <%
                  //Scriptlet
                  List<Empresa> empresas;
                  empresas = (List<Empresa>) request.getAttribute("emp");

                  for (int i = 0; i < empresas.size(); i++) {
                    Empresa emp = empresas.get(i);
                %>

                <tr>
                  <td><%=emp.getNome()%></td>
                  <td><%=emp.getEndereco()%></td>
                  <td><%=emp.getNumero()%></td>
                  <td><%=emp.getTelefone()%></td>
                  <td><%=emp.getCategoria().getNome()%></td>
                  <td><%=emp.getBairro().getNome()%></td>
                  <td><%=emp.getRegiao().getNome()%></td>
                  <td><button class="btn btn-danger" type="submit" onclick="location.href='javascript:confirmaExclusao(<%=emp.getId()%>)'">EXCLUIR</button></td>
                  <td><button class="btn btn" type="submit" onclick="location.href='EmpresaController?acao=edit&id=<%=emp.getId()%>'">EDITAR</button></td>
                </tr>
                <%
                  }
                %>
              </tbody>
            </table>
            <button class="btn btn" type="reset" onclick="location.href='http://localhost:8080/TeleView-1.0-SNAPSHOT/menuprincipal.jsp'">Retornar</button>

          </div>

        </div>

      </div>

    </div>

</body>
</html>

