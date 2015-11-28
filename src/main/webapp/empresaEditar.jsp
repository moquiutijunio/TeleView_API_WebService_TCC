<%@ page import="ucdb.models.Bairro" %>
<%@ page import="java.util.List" %>
<%@ page import="ucdb.models.Categoria" %>
<%@ page import="ucdb.models.Regiao" %>
<%@ page import="ucdb.models.Empresa" %>
<%--
  Created by IntelliJ IDEA.
  User: Junio
  Date: 24/10/2015
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


  <!-- Método de validação dos Campos-->
  <script>
    function validar(){
      var nome = form1.nome.value.trim();
      var endereco = form1.endereco.value.trim();
      var numero = form1.numero.value.trim();
      var telefone = form1.telefone.value.trim();
      var atendimentosegsex = form1.atendimentosegsex.value.trim();
      var atendimentosabado = form1.atendimentosabado.value.trim();
      var atendimentodomingo = form1.atendimentodomingo.value.trim();

      if(nome == "") {
        alert( "Campo obrigatorio: NOME!" );
        form1.nome.focus();
        return false;
      }
      if(endereco == ""){
        alert( "Campo obrigatorio: ENDEREÇO!" );
        form1.endereco.focus();
        return false;
      }
      if(numero == ""){
        alert( "Campo obrigatorio: NUMERO!" );
        form1.numero.focus();
        return false;
      }
      if(telefone == ""){
        alert( "Campo obrigatorio: TELEFONE!" );
        form1.telefone.focus();
        return false;
      }
      if(atendimentosegsex == ""){
        alert( "Campo obrigatorio: ATENDIMENTO SEGUNDA À SEXTA!" );
        form1.atendimentosegsex.focus();
        return false;
      }
      if(atendimentosabado == ""){
        alert( "Campo obrigatorio: ATENDIMENTO SABADO!" );
        form1.atendimentosabado.focus();
        return false;
      }
      if(atendimentodomingo == ""){
        alert( "Campo obrigatorio: ATENDIMENTO DOMINGO!" );
        form1.atendimentodomingo.focus();
        return false;
      }
    }
  </script>

  <title>Editar Empresa</title>
  <!-- Relizado o include, responsavel por inserir um código padrão, para igualar todas as página
              nesse caso em específico o Menu da header que corresponde as opções do programa, nome da classe
              importada é o header.html-->
  <%@include file="header.html" %>

</head>
<body>

<!-- Relizado a criação de um Object e o alimenta com os atributos vindo do servlet-->
<%	 %>
<%
  List<Bairro> bairros = (List<Bairro>) request.getAttribute("listabairros");
  List<Categoria> categorias = (List<Categoria>) request.getAttribute("listacategorias");
  List<Regiao> regioes = (List<Regiao>) request.getAttribute("listaregioes");
  Empresa empresa = (Empresa) request.getAttribute("emp");

%>


<!--Formulario de edição, ou seja quando esse jsp for chamado, ele ja será criado com os valores do objeto hà ser editado.-->

<div class="container">

  <div class="col-md-6 col-md-offset-3" id="menubox" style="margin-top:45px;" >

    <div class="panel panel-info">
      <div class="panel-heading">
        <div class="panel-title"> EDITAR EMPRESA </div>
      </div>

      <div class="panel-body" style="padding-top:30px" >

        <form class="form-horizontal" action="EmpresaControlador" method="POST" name="form1" role="form" runat="server">

          <!-- Quebra linha -->
          <div class="clearfix"></div>

          <input type="hidden" name="id" value="<%=empresa.getId()%>">

          <fieldset class="grupo">

            <!-- Quebra linha -->
            <div class="clearfix"></div>

            <div class="input-input" style="margin-bottom:25px" >
              <input type="text" Class="form-control" id="nome" name="nome" placeholder="Nome"  runat="server" value="<%=empresa.getNome()%>">
            </div>

            <!-- Quebra linha -->
            <div class="clearfix"></div>

            <div class="input-input" style="margin-bottom:25px" >
              <input type="text" Class="form-control" id="endereco" name="endereco" placeholder="Endereço"  runat="server" value="<%=empresa.getEndereco()%>">
            </div>

            <!-- Quebra linha -->
            <div class="clearfix"></div>

            <div class="input-input" style="margin-bottom:25px" >
              <input type="text" Class="form-control" id="numero" name="numero" placeholder="Número"  runat="server" value="<%=empresa.getNumero()%>">
            </div>

            <!-- Quebra linha -->
            <div class="clearfix"></div>

            <div class="input-input" style="margin-bottom:25px" >
              <input type="text" Class="form-control" id="telefone" name="telefone" placeholder="Telefone"  runat="server" value="<%=empresa.getTelefone()%>">
            </div>

          </fieldset>

          <fieldset class="grupo">

            <!-- Quebra linha -->
            <div class="clearfix"></div>

            <label>Horário de Atendimento</label>

            <!-- Quebra linha -->
            <div class="clearfix"></div>

            <div class="campo">
              <div class="input-input" style="margin-bottom:25px" >
                <input type="text" Class="form-control" id="atendimentosegsex" name="atendimentosegsex" placeholder="Segunda - Sexta"  runat="server" value="<%=empresa.getAtendimentoSegSex()%>">
              </div>

              <!-- Quebra linha -->
              <div class="clearfix"></div>

              <div class="input-input" style="margin-bottom:25px" >
                <input type="text" Class="form-control" id="atendimentosabado" name="atendimentosabado" placeholder="Sábado"  runat="server" value="<%=empresa.getAtendimentoSabado()%>">
              </div>

              <!-- Quebra linha -->
              <div class="clearfix"></div>

              <div class="input-input" style="margin-bottom:25px" >
                <input type="text" Class="form-control" id="atendimentodomingo" name="atendimentodomingo" placeholder="Domingo"  runat="server" value="<%=empresa.getAtendimentoDoming()%>">
              </div>

            </div>
          </fieldset>

          <fieldset>
            <input type="hidden" name="opcao" value="editar">
            <fieldset class="grupo">
              <div class="campo">
                <label for="categoria">Categoria</label>

                <!-- Quebra linha -->
                <div class="clearfix"></div>

                <div class="input-input" style="margin-bottom:25px" >
                  <select name="categoria" style="width: 175px">
                    <%
                      for (Categoria c : categorias) {
                    %>
                    <option name="categoria" id="categoria" style="width: 10em" value=<%=c.getId()%>>
                      <%=c.getNome()%>
                    </option>
                    <%
                      }
                    %>
                  </select>
                </div>
              </div>
              <div class="campo">
                <label for="bairro">Bairro</label>

                <!-- Quebra linha -->
                <div class="clearfix"></div>

                <div class="input-input" style="margin-bottom:25px" >
                  <select name="bairro" style="width: 175px">
                    <%
                      for (int i = 0; i < bairros.size(); i++) {
                        Bairro  b = bairros.get(i);
                    %>
                    <option name="bairro" id="bairro" style="width: 10em"
                            value="<%=b.getId()%>">
                      <%=b.getNome()
                      %>
                    </option>
                    <%
                      }
                    %>
                  </select>
                </div>
              </div>
              <div class="campo">
                <label for="regiao">Região</label>

                <!-- Quebra linha -->
                <div class="clearfix"></div>

                <div class="input-input" style="margin-bottom:25px" >
                  <select class="input-input" name="regiao" style="width: 175px">
                    <%
                      for (int i = 0; i < regioes.size(); i++) {
                        Regiao  r = regioes.get(i);
                    %>
                    <option name="regiao" id="regiao" style="width: 10em"
                            value="<%=r.getId()%>">
                      <%=r.getNome()
                      %>
                    </option>
                    <%
                      }
                    %>
                  </select>
                </div>
              </div>
            </fieldset>
          </fieldset>

          <div class="form-group" style="margin-top:10px" >
            <!-- Button -->
            <div class="col-sm-12 controls">
              <button name="bot" class="btn btn-success" type="submit" onfocus="return validar()">Atualizar</button>
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
