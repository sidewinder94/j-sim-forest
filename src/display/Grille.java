package display;

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
				this.grille[size_x][size_y] = new Cellule(size_x, size_y);
			}
		}
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
