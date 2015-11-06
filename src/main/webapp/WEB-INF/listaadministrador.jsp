<%@page import="java.util.List"%>
<%@page import="br.com.direcaocerta.entidades.Administrador"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista dos Administradores</title>
<script type="text/javascript">
	function confirmaExclusao(id_administrador){
		
		if(window.confirm('Tem certeza que deseja excluir')){
			location.href="administradorcontroller.do?acao=exc&id_administrador="+id_administrador;
		}
		
	}
</script>
</head>
<body>
	
	<%
		List <Administrador> lista = (List<Administrador>)request.getAttribute("lista");
		
	%>
		<table border = 1>
		
			<tr><th>Id:</th><th>Nome:</th></tr>
		
		<%for(Administrador a : lista){ %>
			
			<tr>
				
				<td><% out.print( a.getId_administrador()); %></td>			
				
				<td><%=a.getNome_administrador() %></td>
				
				<td>
					
					<a href = "javascript:confirmaExclusao(<%=a.getId_administrador()%>)"> excluir </a> |
					<a href="administradorcontroller.do?acao=alt&id_administrador=<%=a.getId_administrador() %>">alterar</a>
					
				</td>
			
			</tr>
	
			<%out.print(a.getId_administrador()+ " "+ a.getNome_administrador() + "</br>"); %>
		
		<% }%>	
		
	</table>
	
</body>
</html>
