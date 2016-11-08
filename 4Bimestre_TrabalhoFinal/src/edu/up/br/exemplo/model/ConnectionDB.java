package edu.up.br.exemplo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB 
{
	private String driverName;
	private String urlPattern;
	private String user;
	private String password;
	
	public ConnectionDB() {
		this.loadConfigurations();
	}
	
	private void loadConfigurations() {
		//O driver é fornecido com a instalação do banco de dados.
		//Procurar no ../lib do diretório de instalação.
		this.driverName = "org.hsqldb.jdbcDriver";
		//Cada banco de dados tem um driverName e um UrlPattern personalizado.
		this.urlPattern = "jdbc:hsqldb:hsql://localhost";
		this.user		= "sa";
		this.password	= "";
	}	
	
    public Connection connect() throws SQLException, ClassNotFoundException
    {
    	// carrega driver: Verificar se o .jar que contém o driver do banco de dados
    	//foi adicionado ao classpath e classloader do projeto.
    	try {
			Class.forName( this.driverName );
		} catch (ClassNotFoundException e) {
			System.out.println( "Problemas ao carregar o driver JDBC ["+e.getMessage()+"]" );
			throw e;
		}
    	// estabelece conexao com banco de dados
    	Connection cn;
		try {
			cn = DriverManager.getConnection( this.urlPattern, this.user, this.password );
		} catch (SQLException e) {
			System.out.println( "Problemas ao abrir conexão ["+e.getMessage()+"]" );
			throw e;
		}
		//System.out.println( "Database Connected!" );
    	return cn;
    }
    
    public void disconnect(Connection cn) {
    	if( cn != null ) {
    		try {
    			cn.close();
				//System.out.println( "Database connection closed!" );
			} catch (SQLException e) {}
    	}
    }
}
