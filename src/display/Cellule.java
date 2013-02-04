package display;

import Settings.*;

import java.util.*;

public class Cellule implements Affichable
{
	int[] position;
	Etats state;
	Mode mode;
	Cellule[][] grid;
	
	public Cellule(int size_x, int size_y, Cellule[][] grid, Mode mode)
	{
		this.position = new int[2];
		this.position[0] = size_x;
		this.position[1] = size_y;
		this.state = Etats.VIDE;
		this.grid = grid;
	}

	@Override
	public void update() 
	{		
		if (this.mode == Mode.FORESTIER)
		{
			if (this.state == Etats.VIDE)
			{
				int trees;
			}
		}
	}
	
	public Etats getState()
	{
		return this.state;
	}
	
	@SuppressWarnings("unused")
	private Hashtable<Etats, Integer> getNeighboursCellState()
	{
		Hashtable<Etats, Integer> results = new Hashtable<Etats, Integer>();
		
		int max_x = this.grid.length;
		int max_y = this.grid[0].length;
		
		int startPos_x = this.position[0], 
			startPos_y = this.position[1];
		
		if (this.position[0] != 0){startPos_x -= 1;}
		if (this.position[1] != 0){startPos_y -= 1;}
		
		for (int i = startPos_x; i < max_x; i++)
		{
			for (int j = startPos_y; j < max_y; i++)
			{
				Etats state = this.grid[i][j].getState();
				try 
				{
					Integer temp = results.get(state);
					temp++;
					results.put(state, temp);
				} catch (NullPointerException e) 
				{
					results.put(state, new Integer(1));
				}
			}
		}
		return results;		
	}
}
