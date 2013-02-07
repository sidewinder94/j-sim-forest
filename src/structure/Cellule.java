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
	public void setMode(Mode mode)
	{
		this.mode = mode;
	}
	
	public void update(int iteration) {
		// System.out.println(iteration + this.nextStateApplicability);
		if (nextStateApplicability >= iteration) {
			if (nextStateApplicability == iteration) {
				this.state = this.nextState;
			}
		} else if (this.mode == Mode.FORESTIER) {

			int trees, shrub;
			Hashtable<Etats, Integer> stats = getMooreNeighboursCellState();
			try {
				trees = stats.get(Etats.ARBRES).intValue();
			} catch (NullPointerException e) {
				trees = 0;
			}
			try {
				shrub = stats.get(Etats.ARBUSTE).intValue();
			} catch (NullPointerException e) {
				shrub = 0;
			}
			// System.out.println("Trees :" + trees+ "\nshrubs :" + shrub);
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
		} else if (this.mode == Mode.INCENDIE) {

			int fired = (int) (Math.random() * 100), inFire = 0;

			Hashtable<Etats, Integer> stats = getMooreNeighboursCellState();
			try {
				inFire = stats.get(Etats.FEU).intValue();
			} catch (NullPointerException e) {
			}

			if (this.state == Etats.JEUNE_POUSSE) {
				if ((fired > 75) && (inFire > 0)) {
					this.nextState = Etats.FEU;
					this.nextStateApplicability = iteration + 1;
				}
			} else if (this.state == Etats.ARBUSTE) {
				if ((fired > 50) && (inFire > 0)) {
					this.nextState = Etats.FEU;
					this.nextStateApplicability = iteration + 1;
				}
			} else if (this.state == Etats.ARBRES) {
				if ((fired > 25) && (inFire > 0)) {
					this.nextState = Etats.FEU;
					this.nextStateApplicability = iteration + 1;
				}
			} else if (this.state == Etats.FEU) {
				this.nextState = Etats.CENDRE;
				this.nextStateApplicability = iteration + 1;
			} else if (this.state == Etats.CENDRE) {
				this.nextState = Etats.VIDE;
				this.nextStateApplicability = iteration + 1;
			}

		} else if (this.mode == Mode.INSECTES) {
			int infection = (int) (Math.random() * 100), infected = 0;
			Hashtable<Etats, Integer> stats = getNeumannNeighboursCellState();
			try {
				infected = stats.get(Etats.INFECTE).intValue();
			} catch (Exception e) {
			}

			if (this.state == Etats.JEUNE_POUSSE) {
				if ((infection > 25) && (infected > 0)) {
					this.nextState = Etats.INFECTE;
					this.nextStateApplicability = iteration + 1;
				}
			} else if (this.state == Etats.ARBUSTE) {
				if ((infection > 50) && (infected > 0)) {
					this.nextState = Etats.INFECTE;
					this.nextStateApplicability = iteration + 1;
				}
			} else if (this.state == Etats.ARBRES) {
				if ((infection > 75) && (infected > 0)) {
					this.nextState = Etats.INFECTE;
					this.nextStateApplicability = iteration + 1;
				}
			} else if (this.state == Etats.INFECTE) {
				this.nextState = Etats.VIDE;
				this.nextStateApplicability = iteration + 1;
			}
		}
	}

	public void setState(Etats state) {
		this.state = state;
	}

	public Etats getState() {
		return this.state;
	}

	private Hashtable<Etats, Integer> getMooreNeighboursCellState() {
		Hashtable<Etats, Integer> results = new Hashtable<Etats, Integer>();
		List<Etats> states = new ArrayList<Etats>();
		states.add(getCellState(-1, -1));
		states.add(getCellState(-1, 0));
		states.add(getCellState(-1, 1));
		states.add(getCellState(0, -1));
		states.add(getCellState(0, 1));
		states.add(getCellState(1, -1));
		states.add(getCellState(1, 0));
		states.add(getCellState(1, 1));

		for (Etats state : states) {
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

	private Hashtable<Etats, Integer> getNeumannNeighboursCellState() {
		Hashtable<Etats, Integer> results = new Hashtable<Etats, Integer>();
		List<Etats> states = new ArrayList<Etats>();
		states.add(getCellState(-1, 0));
		states.add(getCellState(0, -1));
		states.add(getCellState(0, 1));
		states.add(getCellState(1, 0));

		for (Etats state : states) {
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

	private Etats getCellState(int delta_x, int delta_y) {
		try {
			return this.grid[this.position[0] + delta_x][this.position[1]
					+ delta_y].getState();
		} catch (ArrayIndexOutOfBoundsException e) {
			return Etats.VIDE;
		}
	}
}
