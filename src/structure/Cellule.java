package structure;

import Settings.*;
import java.util.*;

public class Cellule {
	int[] position;
	Etats state;
	Mode mode;
	Cellule[][] grid;
	Etats nextState;
	int nextStateApplicability;

	public Cellule(int size_x, int size_y, Cellule[][] grid, Mode mode) {
		this.mode = mode;
		this.position = new int[2];
		this.position[0] = size_x;
		this.position[1] = size_y;
		this.state = Etats.VIDE;
		this.grid = grid;
		this.nextStateApplicability = -1;
	}

	public void update(int iteration) {
		//System.out.println(iteration + this.nextStateApplicability);
		if (nextStateApplicability >= iteration) {
			if (nextStateApplicability == iteration) {
				this.state = this.nextState;
			}
		} else if (this.mode == Mode.FORESTIER) {

			int trees, shrub;
			Hashtable<Etats, Integer> stats = getNeighboursCellState();
			try {
				trees = stats.get(Etats.ARBRES).intValue();
			} catch (NullPointerException e) {
				trees = 0;
			}
			try
			{
				shrub = stats.get(Etats.ARBUSTE).intValue();
			}
			catch (NullPointerException e)
			{
				shrub = 0;
			}
			//System.out.println("Trees :" + trees+ "\nshrubs :" + shrub);
			if (this.state == Etats.VIDE) {
				if ((trees >= 2) || (shrub >= 3) || (trees == 1 && shrub == 2)) {
					this.nextState = Etats.JEUNE_POUSSE;
					this.nextStateApplicability = iteration + 1;
				}

			} else if (this.state == Etats.JEUNE_POUSSE) {
				if ((trees + shrub) <= 3) {
					this.nextState = Etats.ARBUSTE;
					this.nextStateApplicability = iteration + 1;
				}
			} else if (this.state == Etats.ARBUSTE) {
				this.nextState = Etats.ARBRES;
				this.nextStateApplicability = iteration + 2;
			}
		}
		// TODO : Finir les updates pour les modes incendies et infection
	}

	public void setState(Etats state) {
		this.state = state;
	}

	public Etats getState() {
		return this.state;
	}
	/*
	private Hashtable<Etats, Integer> getNeighboursCellState() {
		Hashtable<Etats, Integer> results = new Hashtable<Etats, Integer>();

		//Position de début de la recherche
		int startPos_x = this.position[0],
			startPos_y = this.position[1];
		
		//Coordonnées de fin de la recherche et taille max de la grille
		int max_x = this.grid.length,
			max_y = this.grid[0].length,
			endPos_x = this.position[0] + 1,
			endPos_y = this.position[1] + 1;
		
		//Limite la fin de la recherche aux bornes de la grille
		if (max_x < endPos_x){endPos_x = max_x;}
		if (max_y < endPos_y){endPos_y = max_y;}
		
		//Si la case de départ est en début de grille, on n'analyse pas les cases précédentes
		if (this.position[0] != 0){startPos_x--;}
		if (this.position[1] != 0){startPos_y--;}

		//On commence a boucler depuis le début de la recherche
		for (int i = startPos_x; i < endPos_x; i++) {
			for (int j = startPos_y; j < endPos_y; j++) {
				if ((i != this.position[0])&&(j != this.position[1])) {
					Etats state = this.grid[i][j].getState();
					try {
						Integer temp = results.get(state);
						temp++;
						results.remove(state);
						results.put(state, temp);
					} catch (NullPointerException e) {
						results.put(state, new Integer(1));
					}
				}
			}
		}
		return results;
	}*/
	private Hashtable<Etats, Integer> getNeighboursCellState() {
		Hashtable<Etats, Integer> results = new Hashtable<Etats, Integer>();
		List<Etats> states = new ArrayList<Etats>();
		states.add(getCellState(-1,-1));
		states.add(getCellState(-1,0));
		states.add(getCellState(-1,1));
		states.add(getCellState(0,-1));
		states.add(getCellState(0,1));
		states.add(getCellState(1,-1));
		states.add(getCellState(1,0));
		states.add(getCellState(1,1));
		
		for (Etats state : states)
		{
			try {
				Integer temp = results.get(state);
				temp++;
				results.remove(state);
				results.put(state, temp);
			} catch (NullPointerException e) {
				results.put(state, new Integer(1));
			}
		}
		return results;
	}
	
	private Etats getCellState(int delta_x, int delta_y)
	{
		try
		{
			return this.grid[this.position[0]+delta_x][this.position[1]+delta_y].getState();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return Etats.VIDE;
		}
	}
}
