package br.com.direcaocerta.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import br.com.direcaocerta.entidades.Administrador;
import br.com.direcaocerta.persistencia.jdbc.AdministradorDAO;

@WebServlet("/administradorcontroller.do")
public class AdministradorController extends HttpServlet {


	public AdministradorController() {
		
		System.out.println("Construtor..");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		String acao = req.getParameter("acao");
		if (acao.equals("exc")) {
			String id_administrador = req.getParameter("id_administrador");
			Administrador administrador = new Administrador();
			
			if(id_administrador!=null){
				administrador.setId_administrador(Integer.parseInt(id_administrador));
			}
			
			AdministradorDAO administradorDAO = new AdministradorDAO();
			administradorDAO.excluir(administrador);
			
			resp.sendRedirect("administradorcontroller.do?acao=lis");
			
			
		}else if(acao.equals("lis")){
			AdministradorDAO administradorDAO = new AdministradorDAO();
			List<Administrador> lista = administradorDAO.buscarTodos();
			req.setAttribute("lista", lista);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listaadministrador.jsp");
			dispatcher.forward(req, resp);
			
		}else if (acao.equals("alt")) {
			String id_administrador = req.getParameter("id_administrador");
			AdministradorDAO administradorDAO = new AdministradorDAO();
			Administrador administrador = administradorDAO.buscarPorId(Integer.parseInt(id_administrador));
			req.setAttribute("administrador", administrador);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formadministrador.jsp");
			dispatcher.forward(req, resp);
		
		}else if (acao.equals("cad")) {
			
			Administrador administrador = new Administrador();
			administrador.setId_administrador(0);
			administrador.setNome_administrador("");
			administrador.setLogin_administrador("");
			administrador.setSenha_administrador("");
			administrador.setCpf_administrador("");
			
			req.setAttribute("administrador",administrador);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formadministrador.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		System.out.println("post");
	
		String id_administrador = req.getParameter("id_administrador");
		String nome_administrador = req.getParameter  ("nome_administrador");
		String login_administrador = req.getParameter("login_administrador");
		String senha_administrador = req.getParameter("senha_administrador");
		String cpf_administrador = req.getParameter ("cpf_administrador");
		
		Administrador administrador = new Administrador();
		
		if(id_administrador!=null){
			administrador.setId_administrador(Integer.parseInt(id_administrador));
		}
		
		administrador.setNome_administrador(nome_administrador);
		administrador.setLogin_administrador(login_administrador);
		administrador.setSenha_administrador(senha_administrador);
		administrador.setCpf_administrador(cpf_administrador);	
		
		AdministradorDAO administradorDAO = new AdministradorDAO();
		
		administradorDAO.salvar(administrador);
		
		resp.getWriter().print("<h1>Sucesso!</h1>");
	}
}