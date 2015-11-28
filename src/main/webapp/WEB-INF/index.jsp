<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Realizado os Import's necessários para a criação da tela -->
<%@page import="java.util.List"%>
<%@page import="ucdb.models.Regiao"%>
<%@page import="ucdb.models.Categoria"%>
<%@page import="ucdb.models.Empresa"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Escolha alguma das buscas para busca</h3>
	<p/>
<!-- Criação do objeto que compoem esse jsp, cujo quais sera utilizados no preenchimento do combobox
que dara a opção de seleção ao usuario-->
	<%
		List<Regiao> regiao = (List<Regiao>) request.getAttribute("regioes");
		List<Categoria> categoria = (List<Categoria>) request.getAttribute("categorias");
	%>

	<form action="EmpresaControler" method="POST">
		<fieldset  >
			<fieldset class="grupo">
				<input type="hidden" name="opcao" value="buscategoria">	
				<div class="campo">
						<select name="categoria" style="width: 175px">
							<%	
								for (Categoria c : categoria) {
							%>
								<option id="categoria" style="width: 10em" value=<%=c.getId()%>>
									<%=c.getNome()%>
								</option>
							<%	}	%>
						</select>
						<button class="botao submit" type="submit"> Buscar Categoria</button>
				</div>	
			</fieldset>
		</fieldset>
	</form>
	<form action="EmpresaControler" method="POST">
		<fieldset>
			<fieldset class="grupo">
				<input type="hidden" name="opcao" value="busregiao">	
				<div class="campo">
						<select name="regiao" style="width: 175px">
							<%	
								for (Regiao r : regiao) {
							%>
								<option id="regiao" style="width: 10em" value=<%=r.getId()%>>
									<%=r.getNome()%>
								</option>
							<%	}	%>
						</select>
						<button class="botao submit" type="submit"> Buscar Regiao</button>
				</div>	
			</fieldset>
		</fieldset>
	</form>
</body>
</html>

<ul class="nav navbar-nav">
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" >Cadastrar<span class="caret"></span></a>
		<ul class="dropdown-menu">
			<li><a href="http://localhost:8080/TeleView-1.0-SNAPSHOT/EmpresaController?acao=prepara">EMPRESA</a></li>
			<li><a href="http://localhost:8080/TeleView-1.0-SNAPSHOT/cadastrobairro.jsp">BAIRRO</a></li>
			<li><a href="http://localhost:8080/TeleView-1.0-SNAPSHOT/cadastrousuario.jsp">USUÁRIO</a></li>
		</ul>
	</li>
</ul>
<ul class="nav navbar-nav">
	<li class="dropdown">
		<a href="#" class="dropdown-toggle" data-toggle="dropdown" >Editar<span class="caret"></span></a>
		<ul class="dropdown-menu">
			<li><a href="http://localhost:8080/TeleView-1.0-SNAPSHOT/EmpresaController?acao=lis">EMPRESA</a></li>
			<li><a href="http://localhost:8080/TeleView-1.0-SNAPSHOT/BairroController?acao=lis">BAIRRO</a></li>
			<li><a href="http://localhost:8080/TeleView-1.0-SNAPSHOT/UsuarioController?acao=lis">USUÁRIO</a></li>
		</ul>
	</li>
</ul>