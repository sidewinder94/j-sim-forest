/**
 * 
 */
package Settings;

/**
 * @author Antoine-Ali
 *
 */
public enum CellSizes {
	NORMALE(10),
	GRANDE(18),
	TRES_GRANDE(25),
	PETITE(5),
	MINUSCULE(3);
	
	public final int cellSize;
	
	CellSizes(int size) {
		this.cellSize = size;
	}

	public int getCellSize()
	{
		return this.cellSize;
	}
}
