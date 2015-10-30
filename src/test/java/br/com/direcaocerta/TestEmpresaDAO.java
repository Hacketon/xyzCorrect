package br.com.direcaocerta;

import java.util.List;

import br.com.direcaocerta.entidades.Empresa;
import br.com.direcaocerta.persistencia.jdbc.EmpresaDAO;

public class TestEmpresaDAO {

	public static void main(String[] args) {

		// testBuscarTodos();
		//testBuscarPorId();
		// testCadastrar();
		// testAlterar();
		// testExcluir();
	}

	public static void testCadastrar() {

		Empresa empresa = new Empresa();

		// Criando a Empresa no banco

		empresa.setId_empresa(1);
		empresa.setNome_empresa("test");
		empresa.setLogin_empresa("algo@hotmail.com");
		empresa.setSenha_empresa("123");
		empresa.setCnpj_empresa("1231231234134");
		empresa.setTelefone_empresa("81 999999");

		EmpresaDAO empresaDao = new EmpresaDAO();
		empresaDao.cadastrar(empresa);

		System.out.println("Empresa Cadastrada com Sucesso!");
	}

	public static void testAlterar() {

		Empresa empresa = new Empresa();
		// alterando a empresa no banco
		empresa.setId_empresa(2);
		empresa.setNome_empresa("xyz");
		empresa.setLogin_empresa("xyz@test.com");
		empresa.setSenha_empresa("xyz");
		empresa.setCnpj_empresa("12345678910");
		empresa.setTelefone_empresa("81 9999 9999");

		EmpresaDAO empresaDao = new EmpresaDAO();
		empresaDao.alterar(empresa);

		System.out.println("Alterado com Sucesso!");
	}

	public static void testExcluir() {
		Empresa empresa = new Empresa();
		// deletando a empresa do banco

		empresa.setId_empresa(1);

		EmpresaDAO empresaDao = new EmpresaDAO();
		empresaDao.excluir(empresa);

		System.out.println("Excluido com Sucesso!");

	}

	public static void testSalvar() {
		Empresa empresa = new Empresa();

		empresa.setId_empresa(1);
		empresa.setCnpj_empresa("12378127389");
		empresa.setNome_empresa("testando");
		empresa.setLogin_empresa("test");
		empresa.setSenha_empresa("123");
		empresa.setTelefone_empresa("82899999");

		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.salvar(empresa);
	}

	private static void testBuscarPorId() {

		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = empresaDAO.buscarPorId(1);
		System.out.println(empresa);
	}

	private static void testBuscarTodos() {

		EmpresaDAO empresaDAO = new EmpresaDAO();
		List<Empresa> lista = empresaDAO.buscarTodos();
		for (Empresa e : lista) {
			System.out.println(e);
		}

		Empresa empresa = empresaDAO.buscarPorId(1);
		System.out.println(empresa);
	}
}