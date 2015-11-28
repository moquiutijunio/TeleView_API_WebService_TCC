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
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<fieldset class="grupo">
			<div class="campo" >
				<h1>Lista de empresas</h1>
				<table border="2">
					<tr class="alt">
						<td>ID Empresa</td>
						<td>Nome Empresa</td>
						<td>Nome Categoria</td>
						<td>Endereço</td>
					</tr>

					<%
						//Scriptlet
						List<Empresa> empresa = (List<Empresa>) request.getAttribute("empresas");

						for (int i = 0; i < empresa.size(); i++) {
							Empresa e = empresa.get(i);
					%>

					<tr>
						<td><%=e.getId()%></td>
						<td><%=e.getNome()%></td>
						<td><%=e.getCategoria().getNome()%></td>
						<td><%=e.getEndereco()%></td>
					</tr>
					<%
						}
					%>
				</table>

			</div>
		</fieldset>
	</fieldset>

</body>
</html>