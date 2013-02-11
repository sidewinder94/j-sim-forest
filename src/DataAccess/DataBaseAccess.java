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
		        	dbName = "C:\\Users\\arnaud\\git\\j-sim-forest";
		        	
		        }
		        catch (ClassNotFoundException e)
		        {
		            System.err.println(e.getMessage());
		        }
		 
		        this.dbName     = dbName;
		        this.connection = null;
		    }
	
		    //méthode qui permet la connection à la BBD
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
		     //méthode qui permet la déconnexion
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
	        //méthode qui permet de récupérer le résultat d'un sélect
	
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
		    // méthode qui permet de mettre à jour la BDD
		    public String Sauvegarde (String index,String nb_pas, String vitesse, String taille, String name)
		    {
		        try
		        {
		            this.statement.executeUpdate("INSERT INTO PARAMETRES (id_configuration,nb_pas,vitesse,taille_grille_x,taille_grille_y,name)"+
		                          " VALUES ('"+index+"','"+nb_pas+"','"+vitesse+"','"+taille+"','"+taille+"','"+name+"')");
		          return "Sauvegarde réussie";
		        
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		        return "Sauvegarde échouée";
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
		    
		    
		    public ResultSet getIDliaison ()
		    {
		        try
		        {
		            return this.statement.executeQuery("SELECT id_configuration FROM CONFIGURATION_PARAMETRES");
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		         
		        return null;
		    }
		    
		    
		    public ResultSet getIDcellule ()
		    {
		        try
		        {
		            return this.statement.executeQuery("SELECT cellule FROM CONFIGURATION");
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		         
		        return null;
		    }
		    
		    
		    public String Sauvegardeentiere(String id_liaison, String cellule, String id_configuration, String posx, String posy, String Etat)
		    {
		        try
		        {
		            this.statement.executeUpdate("INSERT INTO CONFIGURATION,CONFIGURATION_PARAMETRES (CONFIGURATION.cellule,CONFIGURATION.pos_x,CONFIGURATION.pos_y,CONFIGURATION.etat,CONFIGURATION_PARAMETRES.id_liaison,CONFIGURATION_PARAMETRES.cellule,CONFIGURATION_PARAMETRES.id_configuration)"+
		                          " VALUES ('"+cellule+"','"+posx+"','"+posy+"','"+Etat+"','"+id_liaison+"','"+cellule+"','"+id_configuration+"')");
		          return "Sauvegarde réussie";
		        
		        }
		        catch (SQLException e)
		        {
		            e.printStackTrace();
		        }
		        return "Sauvegarde échouée";
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
