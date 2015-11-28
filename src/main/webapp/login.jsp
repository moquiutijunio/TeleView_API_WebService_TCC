<%--
  Created by IntelliJ IDEA.
  User: Junio
  Date: 11/10/2015
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="ucdb.models.Regiao"%>
<%@page import="ucdb.models.Categoria"%>
<%@page import="ucdb.models.Empresa"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <!-- jQuery library -->
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>


  <script>
    function validar(){
      var nome = form1.nome.value.trim();
      var senha = form1.senha.value.trim();
      if(nome == "") {
        alert( "Campo usuário obrigatorio!" );
        form1.nome.focus();
        return false;
      }
      if(senha == "") {
        alert( "Campo senha obrigatorio!" );
        form1.senha.focus();
        return false;
      }
    }
  </script>

  <title>LOGIN</title>
</head>
<body>


<div class="container">

  <div class="col-md-6 col-md-offset-3" id="loginbox" style="margin-top:45px;" >

    <div class="panel panel-info">
      <div class="panel-heading">
        <div class="panel-title">Sistema de Login</div>
      </div>

      <div class="panel-body" style="padding-top:30px" >

        <form class="form-horizontal" action="LoginController" method="POST" name="form1" role="form" runat="server">

          <div class="input-group" style="margin-bottom:25px" >
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </span>
            <input type="text" Class="form-control" name="nome" placeholder="usuario"  runat="server">
          </div>

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <div class="input-group" style="margin-bottom:25px" >
                                <span class="input-group-addon">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </span>
            <input type="password" class="form-control" name="senha" placeholder="senha" runat="server">
          </div>

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <div class="form-group" style="margin-top:10px" >

            <!-- Button -->
            <div class="col-sm-12 controls">
              <button name="bot" class="btn btn-success" type="submit" onfocus="return validar()">LOGAR</button>
              <button class="btn btn-danger" type="reset" >LIMPAR</button>
            </div>
          </div>

        </form>

      </div>

    </div>

  </div>

</div>

</body>
</html>
