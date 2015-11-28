<%--
  Created by IntelliJ IDEA.
  User: Junio
  Date: 11/10/2015
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <!-- Método de validação dos Campos-->
  <script>
    function validar(){
      var usuario = form1.usuario.value.trim();
      var senha = form1.senha.value.trim();
      var senha2 = form1.senha2.value.trim();


      if(usuario == "") {
        alert( "Verifique o Campo USUÁRIO!" );
        form1.usuario.focus();
        return false;
      }
      if(senha == ""){
        alert( "Verifique o Campo SENHA!" );
        form1.senha.focus();
        return false;
      }
      if(senha2 == ""){
        alert( "Verifique o Campo SENHA!" );
        form1.senha2.focus();
        return false;
      }
      if(senha != senha2){
        alert( "Campos senhas não conferem!" );
        form1.senha.focus();
      }
    }
  </script>
  <title>Cadastrar Usuario</title>
  <!-- Relizado o include, responsavel por inserir um código padrão, para igualar todas as página
  nesse caso em específico o Menu da header que corresponde as opções do programa, nome da classe
  importada é o header.html-->
  <%@include file="header.html" %>
</head>
<body>

<!-- Esse Formulário é responsavel somente pelo cadastro, aqui será inserido todos os dados do respectivo
objeto e após o preenchimento da lista, os dados serão direcionados para a servlet para a inserção no banco-->
<div class="container">
  <div class="col-md-6 col-md-offset-3" id="menubox" style="margin-top:45px;" >
    <div class="panel panel-info">
      <div class="panel-heading">
        <div class="panel-title"> CADASTRO DE USUÁRIO </div>
      </div>
      <div class="panel-body" style="padding-top:30px" >

        <form class="form-horizontal" action="UsuarioServlet" method="POST" name="form1" role="form" runat="server">

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <input type="hidden" name="id">

          <div class="input-input" style="margin-bottom:25px" >
            <input type="text" Class="form-control" name="usuario" placeholder="Usuário"  runat="server">
          </div>

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <div class="input-input" style="margin-bottom:25px" >
            <input type="password" class="form-control" name="senha" placeholder="Senha" runat="server">
          </div>

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <div class="input-input" style="margin-bottom:25px" >
            <input type="password" class="form-control" name="senha2" placeholder="Confirme a senha" runat="server">
          </div>

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <div class="form-group" style="margin-top:10px" >
            <!-- Button -->
            <div class="col-sm-12 controls">
              <button name="bot" class="btn btn-success" type="submit" onfocus="return validar()">Salvar</button>
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
