package br.com.direcaocerta.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.direcaocerta.entidades.Empresa;

public class EmpresaDAO {

	private Connection con = ConexaoFactory.getConnection();

	/**
	 * 
	 * @param empresa
	 */
	public void cadastrar(Empresa empresa) {

		String sql = "insert into empresas(nome_empresa, login_empresa, senha_empresa, cnpj_empresa, telefone_empresa) values (?,?,?,?,?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			// substitui as interrogaçoes pelos dados
			preparador.setString(1, empresa.getNome_empresa());
			preparador.setString(2, empresa.getLogin_empresa());
			preparador.setString(3, empresa.getSenha_empresa());
			preparador.setString(4, empresa.getCnpj_empresa());
			preparador.setString(5, empresa.getTelefone_empresa());

			// executando o comando no banco
			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param empresa
	 */
	public void alterar(Empresa empresa) {

		String sql = "update empresas set nome_empresa=?, login_empresa=?, senha_empresa=?, cnpj_empresa=?, telefone_empresa=? where id_empresa=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			// substitui as interrogaçoes pelos dados
			preparador.setString(1, empresa.getNome_empresa());
			preparador.setString(2, empresa.getLogin_empresa());
			preparador.setString(3, empresa.getSenha_empresa());
			preparador.setString(4, empresa.getCnpj_empresa());
			preparador.setString(5, empresa.getTelefone_empresa());
			preparador.setInt(6, empresa.getId_empresa());
			// executando o comando no banco
			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	/**
	 * 
	 * @param empresa
	 */
	public void excluir(Empresa empresa) {
		// TODO Auto-generated method stub

		String sql = "delete from empresas where id_empresa=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			// substitui as interrogaçoes pelos dados
			preparador.setInt(1, empresa.getId_empresa());
			// executando o comando no banco
			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	/**
	 * 
	 * @param empresa
	 */
	public void salvar(Empresa empresa) {
		if (empresa.getId_empresa() != null) {
			alterar(empresa);
		} else {
			cadastrar(empresa);
		}
	}
	/**
	 * 
	 * @param id_empresa
	 * @return
	 */
	public Empresa buscarPorId(Integer id_empresa) {

		String sql = "Select * from empresas where id_empresa=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id_empresa);

			ResultSet resultado = preparador.executeQuery();

			// posicionando o cursor no primeiro registro
			if (resultado.next()) {
				Empresa empresa = new Empresa();

				empresa.setId_empresa(resultado.getInt("id_empresa"));
				empresa.setNome_empresa(resultado.getString("nome_empresa"));
				empresa.setLogin_empresa(resultado.getString("login_empresa"));
				empresa.setSenha_empresa(resultado.getString("senha_empresa"));
				empresa.setCnpj_empresa(resultado.getString("cnpj_empresa"));
				empresa.setTelefone_empresa(resultado
						.getString("telefone_empresa"));

				return empresa;
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Realiza a busca de varios registros da tabela de todos os administrador
	 * 
	 * @return Uma lista de Objetos Administrador contendo 0 elementos quando
	 *         nao tiver registros ou 'n' elementos quanto retornar resultados
	 */
	public List<Empresa> buscarTodos() {

		String sql = "Select * from empresas";

		List<Empresa> lista = new ArrayList<Empresa>();

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();

			// posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Empresa empresa = new Empresa();

				empresa.setId_empresa(resultado.getInt("id_empresa"));
				empresa.setNome_empresa(resultado.getString("nome_empresa"));
				empresa.setLogin_empresa(resultado.getString("login_empresa"));
				empresa.setSenha_empresa(resultado.getString("senha_empresa"));
				empresa.setCnpj_empresa(resultado.getString("cnpj_empresa"));
				empresa.setTelefone_empresa(resultado
						.getString("telefone_empresa"));

				lista.add(empresa);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}