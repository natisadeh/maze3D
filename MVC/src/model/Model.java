package model;


/**
 * The Interface Model.
 * @author Nati Sadeh & Eli Salem
 */
public interface Model {
	
	/**
	 * Generate 3 d maze.
	 *
	 * @param name the name of the maze
	 * @param z the floors
	 * @param y the columns
	 * @param x the rows
	 */
	void generate3dMaze(String name, int z, int y, int x);
	
	/**
	 * Display maze.
	 *
	 * @param name the name
	 */
	void displayMaze(String name);
	
	/**
	 * Cross section by.
	 *
	 * @param ZYX the zyx
	 * @param name the name
	 * @param index the index
	 */
	void crossSectionBy(String ZYX, String name, int index);
	
	/**
	 * Save maze.
	 *
	 * @param name the name
	 * @param fileName the file name
	 */
	void saveMaze(String name, String fileName);
	
	/**
	 * Load maze.
	 *
	 * @param name the name
	 * @param fileName the file name
	 */
	void loadMaze(String name, String fileName);
	
	/**
	 * Solve maze.
	 *
	 * @param name the name
	 * @param algorithm the algorithm
	 */
	void solveMaze(String name, String algorithm);
	
	/**
	 * Display solution.
	 *
	 * @param name the name
	 */
	void displaySolution(String name);
	
	/**
	 * Exit.
	 */
	void exit();
}
