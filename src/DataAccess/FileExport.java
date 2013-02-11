package DataAccess;

import java.io.*;

public class FileExport {

	String filePath;
	File file;
	FileWriter fw;
	FileReader fr;
	
	//Constructeur, prends en argument le chemin du fichier a enregistrer
	public FileExport(String filePath)
	{
			this.filePath = filePath;
			this.file = new File(this.filePath);		
	}
	
	//Fonction permettant d'écrire dans un fichier en en effaçant le contenu
	public void write(String strToWrite)
	{
		try
		{
			if (this.fw != null)
			{
				this.fw.close();
				this.fw = null;
			}
			this.fw = new FileWriter(this.file);
			this.fw.write(strToWrite);
			this.fw.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				this.fw.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	//Fonction permettant d'ajouter du contenu à un fichier texte
	public void append(String strToAppend)
	{
		try
		{
			if (this.fr != null)
			{
				this.fr.close();
				this.fr = null;
			}
			
			this.fr = new FileReader(this.file);
			String str = "";
			int i = 0;
			while ((i = this.fr.read()) != -1)
			{
				str += (char)i;
			}
			write(str + strToAppend);
			this.fr.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				this.fr.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
