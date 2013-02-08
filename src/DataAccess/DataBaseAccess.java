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
		        	dbName = "F:\\GExia\\Prosits A2\\Projets\\UML_Java\\j-sim-forest\\JSimBDD.sqlite";
		        	
		        }
		        catch (ClassNotFoundException e)
		        {
		            System.err.println(e.getMessage());
		        }
		 
		        this.dbName     = dbName;
		        this.connection = null;
		    }
	
		    //m�thode qui permet la connection � la BBD
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
		     //m�thode qui permet la d�connexion
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
	        //m�thode qui permet de r�cup�rer le r�sultat d'un s�lect
	
		    public ResultSet getName ()
		    {
		        try
		        {
		            return this.statement.executeQuery("SELECT DISTINCT * FROM PARAMETRES");
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		         
		        return null;
		    }
		    // m�thode qui permet de mettre � jour la BDD
		    public String Sauvegarde (String index,String nb_pas, String vitesse, String taille, String name)
		    {
		        try
		        {
		          this.statement.executeUpdate("INSERT INTO PARAMETRES (id_configuration,nb_pas,vitesse,taille_grille_x,taille_grille_y,name)"+
		                          " VALUES ('"+index+"','"+nb_pas+"','"+vitesse+"','"+taille+"','"+taille+"','"+name+"')");
		          return "Sauvegarde r�ussie";
		        
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		        return "Sauvegarde �chou�e";
		    }
		    
		    
		    public ResultSet GetParametre(String name)
		    {
		        try
		        {
		            return this.statement.executeQuery("SELECT * FROM PARAMETRES WHERE name = '"+ name +"' ");
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		         
		        return null;
		    }
		    
		    public ResultSet getID ()
		    {
		        try
		        {
		            return this.statement.executeQuery("SELECT id_configuration FROM PARAMETRES");
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		         
		        return null;
		    }
		    
		    
		    
		    
		    
		    // pour se connecter avec cette classe:  
		    //Class.forName("org.sqlite.JDBC");
            //System.out.println("DRIVER OK ! ");
            
            /*String url = "jdbc:postgresql://localhost:5432/Ecole";
            String user = "postgres";
            String passwd = "postgres";
             //rs pour le r�sulset
            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection effective !");   */
		    
		    
		    
		    
		    
	
	
}
