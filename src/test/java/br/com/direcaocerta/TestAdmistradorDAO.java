package br.com.direcaocerta;

import java.util.List;

import br.com.direcaocerta.entidades.Administrador;
import br.com.direcaocerta.persistencia.jdbc.AdministradorDAO;

public class TestAdmistradorDAO {

	public static void main(String[] args) {

		//testAutenticar();
		//testBuscarTodos();
		//testBuscarPorId();
		//testSalvar();
		testCadastrar();
		//testAlterar();
		//testExcluir();
	}

	
	private static Administrador testAutenticar() {
		// TODO Auto-generated method stub

		AdministradorDAO administradorDAO = new AdministradorDAO();

		Administrador administrador = new Administrador();

		administrador.setLogin_administrador("teste2");
		administrador.setSenha_administrador("teste2");

		Administrador adminRetorno = administradorDAO.autenticar(administrador);

		System.out.println(adminRetorno);

		return adminRetorno;
	}

	private static void testBuscarPorId() {

		AdministradorDAO adminDAO = new AdministradorDAO();
		Administrador administrador = adminDAO.buscarPorId(1);
		System.out.println(administrador);
	}

	private static void testBuscarTodos() {

		AdministradorDAO adminDAO = new AdministradorDAO();
		List<Administrador> lista = adminDAO.buscarTodos();
		for (Administrador a : lista) {
			System.out.println(a);
		}

		Administrador administrador = adminDAO.buscarPorId(1);
		System.out.println(administrador);
	}

	public static void testCadastrar() {
		Administrador administrador = new Administrador();
		// Criando o administrador
		administrador.setNome_administrador("wilsonCarlos");
		administrador.setLogin_administrador("wilsonCarlos");
		administrador.setSenha_administrador("123456");
		administrador.setCpf_administrador("12345678910");

		AdministradorDAO administradorDao = new AdministradorDAO();
		administradorDao.cadastrar(administrador);

		System.out.println("Cadastrado com Sucesso!");
	}

	public static void testAlterar() {
		Administrador administrador = new Administrador();
		// Criando o administrador
		administrador.setId_administrador(13);
		administrador.setNome_administrador("vv	");
		administrador.setLogin_administrador("VATeste");
		administrador.setSenha_administrador("Go");
		administrador.setCpf_administrador("12345678910");

		AdministradorDAO administradorDao = new AdministradorDAO();
		administradorDao.alterar(administrador);

		System.out.println("Alterado com Sucesso!");
	}

	public static void testExcluir() {
		Administrador administrador = new Administrador();
		// Criando o administrador
		administrador.setId_administrador(13);

		AdministradorDAO administradorDao = new AdministradorDAO();
		administradorDao.excluir(administrador);

		System.out.println("Excluido com Sucesso!");
	}

	public static void testSalvar() {
		Administrador administrador = new Administrador();

		administrador.setId_administrador(2);
		administrador.setNome_administrador("Evil");
		administrador.setCpf_administrador("12312354");
		administrador.setLogin_administrador("diabo");
		administrador.setSenha_administrador("asdrfasdf");

		AdministradorDAO administradorDAO = new AdministradorDAO();
		administradorDAO.salvar(administrador);
	}
}
