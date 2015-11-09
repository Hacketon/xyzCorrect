package br.com.direcaocerta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.direcaocerta.entidades.Administrador;
import br.com.direcaocerta.persistencia.jdbc.AdministradorDAO;

@WebServlet("/autenticador.do")

public class AutenticadorController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String login_administrador = req.getParameter("login_administrador");
		String senha_administrador = req.getParameter("senha_administrador");
		
		
		Administrador admin = new Administrador();
		admin.setLogin_administrador(login_administrador);
		admin.setSenha_administrador(senha_administrador);
		
		
		AdministradorDAO adminDAO = new AdministradorDAO();
		Administrador administradorAutenticado = adminDAO.autenticar(admin);
		
		if (administradorAutenticado != null) {
			
			HttpSession sessao = req.getSession();
			sessao.setAttribute("administradorAutenticado", administradorAutenticado);
			
			//sessao.setMaxInactiveInterval(3000);
			
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
			
		}else{
			
			resp.getWriter().print("<script> window.alert('Não Encontrado!')location.href='login.html'</script>");
			
		}
	}
}