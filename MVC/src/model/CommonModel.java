package model;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Controller;

/**
 * The Common Model is an abstract class that implements Model.
 * the class will hold the model variables 
 * @author Nati Sadeh & Eli Salem
 */

public abstract class CommonModel implements Model {
	/**
	 * CommonModel variables
	 */
	protected Controller controller;
	protected HashMap<String, Maze3d> hashMaze;
	protected HashMap<String, Solution<Position>> hashSolution;
	protected ExecutorService threadPool;
	
	public CommonModel() {
		this.hashMaze = new HashMap<String, Maze3d>();
		this.hashSolution = new HashMap<String, Solution<Position>>();
		this.threadPool = Executors.newCachedThreadPool();
	}
	
	/**
	 * setters and getters for variable class.
	 */

	public Controller getController() {
		return controller;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}

	public HashMap<String, Maze3d> getHashMaze() {
		return hashMaze;
	}

	public void setHashMaze(HashMap<String, Maze3d> hashMaze) {
		this.hashMaze = hashMaze;
	}

	public HashMap<String, Solution<Position>> getHashSolution() {
		return hashSolution;
	}

	public void setHashSolution(HashMap<String, Solution<Position>> hashSolution) {
		this.hashSolution = hashSolution;
	}

/**
 * The methods what will be implemented in MyModel class
 */
	public abstract void generate3dMaze(String name, int x, int y, int z);
	public abstract void displayMaze(String name);
	public abstract void crossSectionBy(String XYZ, String name, int index);
	public abstract void saveMaze(String name, String fileName);
	public abstract void loadMaze(String name, String fileName);
	public abstract void solveMaze(String name, String algorithm);
	public abstract void displaySolution(String name);
	public abstract void exit();
}
