<%@ page import="ucdb.models.Usuario" %>
<%--
  Created by IntelliJ IDEA.
  User: Junio
  Date: 11/10/2015
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">

  <title>Editar Usuario</title>
  <!-- Relizado o include, responsavel por inserir um código padrão, para igualar todas as página
      nesse caso em específico o Menu da header que corresponde as opções do programa, nome da classe
      importada é o header.html-->
  <%@include file="header.html" %>

</head>
<body>

<!-- Relizado a criação de um Object do tipo Cliente e o alimenta com os atributos vindo do servlet-->
<%	Usuario usuario = (Usuario) request.getAttribute("usu"); %>

<!--Formulario de edição, ou seja quando esse jsp for chamado, ele ja será criado com os valores do objeto hà ser editado.-->
<div class="container">
  <div class="col-md-6 col-md-offset-3" id="menubox" style="margin-top:45px;" >
    <div class="panel panel-info">
      <div class="panel-heading">
        <div class="panel-title"> EDITAR USUÁRIO</div>
      </div>
      <div class="panel-body" style="padding-top:30px" >

        <form class="form-horizontal" action="UsuarioServlet" method="POST" name="form1" role="form" runat="server">

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <input type="hidden" name="id" value="<%=usuario.getId()%>">

          <div class="input-input" style="margin-bottom:25px" >
            <input type="text" Class="form-control" name="usuario" placeholder="Usuário"  runat="server" value="<%=usuario.getNome()%>">
          </div>

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <div class="input-input" style="margin-bottom:25px" >
            <input type="text" class="form-control" name="senha" placeholder="Senha" runat="server" value="<%=usuario.getSenha()%>">
          </div>

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <div class="form-group" style="margin-top:10px" >
            <!-- Button -->
            <div class="col-sm-12 controls">
              <button name="bot" class="btn btn-success" type="submit">Atualizar</button>
              <button class="btn btn-" type="reset" onclick="location.href='http://localhost:8080/TeleView-1.0-SNAPSHOT/menuprincipal.jsp'">Retornar</button>
            </div>
          </div>

        </form>
      </div>
    </div>
  </div>
</div>

</body>
</html>
