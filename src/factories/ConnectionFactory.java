package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//para conectar com o Bd são necessárias 4 informações/parâmetros
			//driver, url, usuario e senha
			private static String driver = "org.postgresql.Driver";
			private static String url = "jdbc:postgresql://localhost:5432/bd_aula04";
			private static String user = "postgres";
			private static String password = "postgree";
			
			//método para abrir e retornar a conexão do bd
			public static Connection getConnection() throws Exception{
				
				//abrir conexão com o BD
				Class.forName(driver);
				Connection connection = DriverManager.getConnection(url,user,password);
				
				return connection;
				
			}
}
