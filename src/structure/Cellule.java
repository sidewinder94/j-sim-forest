package structure;

import Settings.*;
import java.util.*;

//Définition d'une cellule
/**
 * @author Antoine-Ali
 *
 */
public class Cellule {
	
	int[] position;
	Etats state;
	Mode mode;
	Cellule[][] grid;
	Etats nextState;
	int nextStateApplicability;

	/**
	 * Constructeur
	 * @param size_x position x de la cellule
	 * @param size_y position y de la cellule
	 * @param grid grille contenant la cellule
	 * @param mode mode de la simulation
	 */
	public Cellule(int size_x, int size_y, Cellule[][] grid, Mode mode) {
		this.mode = mode;
		this.position = new int[2];
		this.position[0] = size_x;
		this.position[1] = size_y;
		this.state = Etats.VIDE;
		this.grid = grid;
		this.nextStateApplicability = -1;
	}
	
	//Getters & Setters
	public void setMode(Mode mode)
	{
		this.mode = mode;
	}
	
	
	/**
	 * Fonction permettant de mettre à jour la cellule
	 * @param iteration
	 */
	public void update(int iteration) {
		// System.out.println(iteration + this.nextStateApplicability);
		
		//Détecte si un état doit être appliqué, si oui, ne fait rien ou l'applique
		if (nextStateApplicability >= iteration) {
			if (nextStateApplicability == iteration) {
				this.state = this.nextState;
				this.nextStateApplicability = -1;
			}
		//Si non, en fonction du mode réalise un test pour définir l'état suivant
		} else if (this.mode == Mode.FORESTIER) {

			int trees, shrub;
			//On récupère l'état des cellules voisines
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
			/*En fonction de l'état de la cellule et de l'état des cellules voisines, on définit le prochain état de la cellule
			 * ainsi que le tour ou celui-ci sera appliqué
			 */
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
			//On génère un nombre aléatoire entier entre 1 et 100
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

	//récupère l'état des cellules voisines selon le voisinnage de moore
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

		//Pour chaque état on en stocke le nombre dans une table par association
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

	//On récupère les états des cellules dans le voisinage de Neumann
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

	//Récupère l'état d'une cellule par la différence d'abcsisses et d'ordonnées
	private Etats getCellState(int delta_x, int delta_y) {
		try {
			return this.grid[this.position[0] + delta_x][this.position[1]
					+ delta_y].getState();
		} catch (ArrayIndexOutOfBoundsException e) {
			return Etats.VIDE;
			
		}
	}
}
