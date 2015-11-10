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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		HttpSession sessao = req.getSession(false);
		
		if (sessao != null) {
			sessao.invalidate();
			
		}
		resp.sendRedirect("login.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//captura os dados da tela
		String login_administrador = req.getParameter("login_administrador");
		String senha_administrador = req.getParameter("senha_administrador");
		//coloca os dados em um objeto
		Administrador admin = new Administrador();
		admin.setLogin_administrador(login_administrador);
		admin.setSenha_administrador(senha_administrador);
		//Consulta se o usuario esta no banco
		AdministradorDAO adminDAO = new AdministradorDAO();
		Administrador administradorAutenticado = adminDAO.autenticar(admin);
		
		//verificando se administrador foi encontrado
		if (administradorAutenticado != null) {
			//colocando usuario na sessao
			HttpSession sessao = req.getSession();
			sessao.setAttribute("administradorAutenticado", administradorAutenticado);
			
				//redireciona para index
			req.getRequestDispatcher("/index.html").forward(req, resp);
	
		}else{
			
			resp.getWriter().print("<script> window.alert('Não Encontrado!')location.href='login.html'</script>");
			
		}
	}
}