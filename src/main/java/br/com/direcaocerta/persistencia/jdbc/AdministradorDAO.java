package br.com.direcaocerta.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.direcaocerta.entidades.Administrador;

public class AdministradorDAO {

	private Connection con = ConexaoFactory.getConnection();

	/**
	 * 
	 * @param administrador
	 */
	
	public void cadastrar(Administrador administrador) {

		String sql = "insert into administrador(nome_administrador, login_administrador, senha_administrador, cpf_administrador) values (?,?,?,?)";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			// substitui as interrogaçoes pelos dados
			preparador.setString(1, administrador.getNome_administrador());
			preparador.setString(2, administrador.getLogin_administrador());
			preparador.setString(3, administrador.getSenha_administrador());
			preparador.setString(4, administrador.getCpf_administrador());
			// executando o comando no banco
			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param administrador
	 */
	
	public void alterar(Administrador administrador) {

		String sql = "update administrador set nome_administrador = ?, login_administrador=?, senha_administrador=?, cpf_administrador=? where id_administrador=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			// substitui as interrogaçoes pelos dados
			preparador.setString(1, administrador.getNome_administrador());
			preparador.setString(2, administrador.getLogin_administrador());
			preparador.setString(3, administrador.getSenha_administrador());
			preparador.setString(4, administrador.getCpf_administrador());
			preparador.setInt(5, administrador.getId_administrador());
			// executando o comando no banco
			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param administrador
	 */
	public void excluir(Administrador administrador) {

		String sql = "delete from administrador where id_administrador=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			// substitui as interrogaçoes pelos dados
			preparador.setInt(1, administrador.getId_administrador());
			// executando o comando no banco
			preparador.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param administrador
	 */
	public void salvar(Administrador administrador) {
		if (administrador.getId_administrador() != null) {
			alterar(administrador);
		} else {
			cadastrar(administrador);
		}
	}

	/**
	 * Busca de um registro no banco de dados pelo numerod do id do usuario
	 * 
	 * @param id_administrador
	 *            é um inteiro que representa o numero do id do administrador a
	 *            ser buscado
	 * @return Um objeto administrador quando encontrado e nulo quando nao
	 *         encontra
	 */
	public Administrador buscarPorId(Integer id_administrador) {

		String sql = "Select * from administrador where id_administrador=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {
			preparador.setInt(1, id_administrador);

			ResultSet resultado = preparador.executeQuery();

			// posicionando o cursor no primeiro registro
			if (resultado.next()) {
				Administrador administrador = new Administrador();

				administrador.setId_administrador(resultado
						.getInt("id_administrador"));
				administrador.setNome_administrador(resultado
						.getString("nome_administrador"));
				administrador.setLogin_administrador(resultado
						.getString("login_administrador"));
				administrador.setSenha_administrador(resultado
						.getString("senha_administrador"));
				administrador.setCpf_administrador(resultado
						.getString("cpf_administrador"));

				return administrador;
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
	public List<Administrador> buscarTodos() {

		String sql = "Select * from administrador";

		List<Administrador> lista = new ArrayList<Administrador>();

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();

			// posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Administrador administrador = new Administrador();

				administrador.setId_administrador(resultado
						.getInt("id_administrador"));
				administrador.setNome_administrador(resultado
						.getString("nome_administrador"));
				administrador.setLogin_administrador(resultado
						.getString("login_administrador"));
				administrador.setSenha_administrador(resultado
						.getString("senha_administrador"));
				administrador.setCpf_administrador(resultado
						.getString("cpf_administrador"));

				lista.add(administrador);
			}

		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	/**
	 * 
	 * @param adminConsulta
	 * @return
	 */
	
	public Administrador autenticar(Administrador adminConsulta) {

		String sql = "Select *from administrador where login_administrador = ? and senha_administrador=?";

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			preparador.setString(1, adminConsulta.getLogin_administrador());
			preparador.setString(2, adminConsulta.getSenha_administrador());

			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {

				Administrador administrador = new Administrador();
				administrador.setId_administrador(resultado
						.getInt("id_administrador"));
				administrador.setNome_administrador(resultado
						.getString("nome_administrador"));
				administrador.setLogin_administrador(resultado
						.getString("login_administrador"));
				administrador.setSenha_administrador(resultado
						.getString("senha_administrador"));
				administrador.setCpf_administrador(resultado
						.getString("cpf_administrador"));

				return administrador;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
