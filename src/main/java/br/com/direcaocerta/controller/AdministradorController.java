package br.com.direcaocerta.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.direcaocerta.entidades.Administrador;
import br.com.direcaocerta.persistencia.jdbc.AdministradorDAO;

@WebServlet("/administradorcontroller.do")
public class AdministradorController extends HttpServlet {

	public AdministradorController() {
		
		System.out.println("Construtor..");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		System.out.println("post");
		
		String nome_administrador = req.getParameter  ("nome_administrador");
		String login_administrador = req.getParameter("login_administrador");
		String senha_administrador = req.getParameter("senha_administrador");
		String cpf_administrador = req.getParameter ("cpf_administrador");
		
		Administrador administrador = new Administrador();
		
		administrador.setNome_administrador(nome_administrador);
		administrador.setLogin_administrador(login_administrador);
		administrador.setSenha_administrador(senha_administrador);
		administrador.setCpf_administrador(cpf_administrador);	
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		
		administradorDAO.salvar(administrador);
		
		resp.getWriter().print("<h1>Sucesso!</h1>");
	}
}