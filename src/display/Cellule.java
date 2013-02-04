package display;

public class Cellule implements Affichable
{
	int[] position;
	
	public Cellule(int size_x, int size_y)
	{
		this.position = new int[2];
		this.position[0] = size_x;
		this.position[1] = size_y;
	}

	@Override
	public void update() {
		
		
	}
	
	
	
	private Cellule getNeiboursCellState()
	{
		//TODO : A compléter
	}
}
