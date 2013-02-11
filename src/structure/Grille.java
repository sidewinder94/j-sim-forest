package structure;
import java.util.*;

import Settings.*;

public class Grille
{
	private Cellule[][] grille;
	
	public Cellule[][] getGrille() {
		return grille;
	}

	//Crée la grille et instancie l'intégralité des cases
	public Grille(int size_x,int size_y,Mode mode)
	{
		this.grille = new Cellule[size_x][size_y];
		for (int i = 0; i < size_x; i++) 
		{
			for (int j = 0; j < size_y; j++)
			{
				this.grille[i][j] = new Cellule(i, j, 
						this.grille,mode);
			}
		}
	}
	
	//Lance la mise à jour de l'intégralité des cases
	public Grille update(int iteration, Mode mode) 
	{
		//Boucle de détection et de mise à jour de l'état suivant des cellules
		for (int i = 0; i < this.grille.length; i++) {
			for (int j = 0; j < this.grille[i].length; j++) {
				this.grille[i][j].setMode(mode);
				this.grille[i][j].update(iteration);
			}
		}
		
		//Boucle de mise à jour de l'état réel des cellules
		iteration++;
		for (int i = 0; i < this.grille.length; i++) {
			for (int j = 0; j < this.grille[i].length; j++) {
				this.grille[i][j].setMode(mode);
				this.grille[i][j].update(iteration);
			}
		}
		return this;
	}
	
	//Calcul des densités pour chaque état
	public Hashtable<Etats, Float> densityCalc()
	{
		Hashtable<Etats, Float> result = new Hashtable<Etats, Float>();
		Hashtable<Etats, Integer> table = new Hashtable<Etats, Integer>();
		
		//On compte le nombre total de cellules
		int size_x = this.grille.length,
			size_y = this.grille[0].length,
			cells = size_x * size_y;
		
		//On compte le nombre de cellules de chaque type
		for (int i = 0 ; i < size_x ; i++)
		{
			for (int j = 0 ; j < size_y ; j++)
			{
				Etats state = this.grille[i][j].getState();
				try
				{
					Integer temp = table.get(state);
					temp++;
					table.remove(state);
					table.put(state, temp);
				}
				catch (NullPointerException e) {
					table.put(state, 1);
				}
			}
		}
		for(Etats info : table.keySet())
		{
			float temp= (float)table.get(info)/cells;
			result.put(info, temp);
		}
		
		return result;
	}
	
}
