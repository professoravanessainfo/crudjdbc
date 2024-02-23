package repositories;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import entities.Pessoa;
import factories.ConnectionFactory;

public class PessoaRepository {
	// classe criada para fazer operações no banco de dados
	// o throws exception quer dizer que quem chamar este método tem que fazer isto
	// dentro do try/catch
	public void inserir(Pessoa pessoa) throws Exception {

		// abrindo conexão com bd
		Connection connection = ConnectionFactory.getConnection();

		// gravando
		PreparedStatement statement = connection
				.prepareStatement("insert into pessoa(id,nome,cpf,telefone) values(?,?,?,?)");

		statement.setObject(1, pessoa.getId());// é setObject pq o id é UUID
		statement.setString(2, pessoa.getNome());
		statement.setString(3, pessoa.getCpf());
		statement.setString(4, pessoa.getTelefone());
		statement.execute();

		connection.close();

	}

	public void editar(Pessoa pessoa) throws Exception {
		// abrindo conexão com bd
		Connection connection = ConnectionFactory.getConnection();

		// escrevendo o script sql para editar um registro
		PreparedStatement statement = connection
				.prepareStatement("update pessoa set nome=?, cpf=?, telefone=? where id=?");

		// preenchendo os parâmetros do update
		statement.setString(1, pessoa.getNome());
		statement.setString(2, pessoa.getCpf());
		statement.setString(3, pessoa.getTelefone());
		statement.setObject(4, pessoa.getId());
		statement.execute();

		// fechando a conexão com bd
		connection.close();
	}

	public void excluir(Pessoa pessoa) throws Exception {

		// abrindo conexão com bd
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from pessoa) where id=?");

		statement.setObject(1, pessoa.getId());
		statement.execute();

		// fechando a conexão com bd
		connection.close();
	}

	public List<Pessoa> obterTodos() throws Exception {
		// abrindo conexão com bd
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from pessoa order by nome");

		// interface do jdbc capaz de ler consultas executadas no bd
		// todos os resgistros obtidos são retornados e armazenados num objto tipo
		// ResultSet
		ResultSet resultSet = statement.executeQuery();

		// criando uma lista de objetos da classe pessoa
		List<Pessoa> lista = new ArrayList<Pessoa>();

		// percorrer cada registro obtido no resultSet
		while (resultSet.next()) {
			Pessoa pessoa = new Pessoa();
			// está lendo o i que veio da tabela; convertendo para o tipo UUID e setando em
			// pessoa
			pessoa.setId(UUID.fromString(resultSet.getString("id")));
			pessoa.setNome(resultSet.getString("nome"));
			pessoa.setCpf(resultSet.getString("cpf"));
			pessoa.setTelefone(resultSet.getString("telefone"));

			lista.add(pessoa); // adicionando o objeto pessoa na lista
		}

		// fechando a conexão com bd
		connection.close();

		// retornando a lista
		return lista;
	}

	public Pessoa obterPorId(UUID id) throws Exception {
		// abrindo conexão com bd
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement statement = connection.prepareStatement("select * from pessoa where id=?");

		statement.setObject(1, id);
		ResultSet resultSet = statement.executeQuery();
		Pessoa pessoa = null; // vazio (sem espaço em memória)

		if (resultSet.next()) {
			
			pessoa = new Pessoa();
			pessoa.setId(UUID.fromString(resultSet.getString("id")));
			pessoa.setNome(resultSet.getString("nome"));
			pessoa.setCpf(resultSet.getString("cpf"));
			pessoa.setTelefone(resultSet.getString("telefone"));

		}

		// fechando a conexão com bd
		connection.close();
		
		return pessoa;

	}
}
