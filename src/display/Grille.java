
package display;



import Settings.*;

public class Grille implements Affichable
{
	Cellule[][] grille;
	public Grille(int size_x,int size_y)
	{
		this.grille = new Cellule[size_x][size_y];
		for (int i = 0; i < size_x; i++) 
		{
			for (int j = 0; j < size_y; i++)
			{
				//TODO compléter
				this.grille[size_x][size_y] = new Cellule(size_x, size_y, this.grille,Mode.FORESTIER);
			}
		}
	}
	
	@Override
	public void update(int iteration) {
		// TODO Auto-generated method stub
		
	}
	
}
