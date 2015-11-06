<!DOCTYPE html>
<%@page import="br.com.direcaocerta.entidades.Administrador"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Administrador a = (Administrador) request.getAttribute("administrador");
	%>

	<form action="administradorcontroller.do" method="post">
		
		ID:   <input type="number" name="id" value="<%= a.getId_administrador()%>">
		Nome: <input type="text" name="nome_administrador" value="<%=a.getNome_administrador()%>"/>
		Login: <input type="text" name="login_administrador" value="<%=a.getLogin_administrador()%>"/>
		Senha: <input type="text" name="senha_administrador" value="<%=a.getSenha_administrador()%>"/>
		Cpf: <input type="text" name="cpf_administrador" value="<%=a.getCpf_administrador()%>"/>		
		
		<input type="submit" value="Salvar"/>
		
	</form>

</body>
</html>