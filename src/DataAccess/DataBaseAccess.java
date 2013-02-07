package DataAccess;

import java.sql.*;

public class DataBaseAccess {
	
	
		public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
		public Connection connection;
		private Statement statement;
		
		private String  dbName;
		    
		    // constructeur qui permet de choisir la bdd
		    public DataBaseAccess (String dbName)
		    {
		        try
		        {
		            Class.forName("org.sqlite.JDBC");
		        }
		        catch (ClassNotFoundException e)
		        {
		            System.err.println(e.getMessage());
		        }
		 
		        this.dbName     = dbName;
		        this.connection = null;
		    }
	
		    //classe qui permet la connection à la BBD
		    public boolean connect ()
		    {
		        try
		        {
		            connection = DriverManager.getConnection("jdbc:sqlite:"+this.dbName);
		            statement = connection.createStatement();
		             
		             
		            return true;
		        }
		        catch(SQLException e)
		        {
		            e.printStackTrace();
		            return false;
		        }
		    }
		     //classe qui permet la déconnexion
		    public boolean disconnect ()
		    {
		        try
		        {
		            if(connection != null)
		                connection.close();
		             
		            return true;
		        }
		        catch(SQLException e)
		        {
		            e.printStackTrace();
		            return false;
		        }
		    }
	        //classe qui permet de récupérer le résultat d'un sélect
	
		    public ResultSet getResultOf (String requete)
		    {
		        try
		        {
		            return this.statement.executeQuery(requete);
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		         
		        return null;
		    }
		    // classe qui permet de mettre à jour la BDD
		    public void updateValue (String requete)
		    {
		        try
		        {
		            this.statement.executeUpdate(requete);
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		    }
		    
		    
		    
		    // pour se connecter avec cette classe:  
		    //Class.forName("org.sqlite.JDBC");
            //System.out.println("DRIVER OK ! ");
            
            /*String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "postgres";
             //rs pour le résulset
            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection effective !");   */
		    
		    
		    
		    
		    
	
	
}
