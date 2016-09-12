package controller;

/**
 * The Interface Controller.
 * @author Nati Sadeh & Eli Salem
 */

public interface Controller {

	void displayStringArray(String[] strings);
	void display(String massage);
	void displayByteArr(byte[] byteArray);
	void displayMaze(String name);
	void generate3dMaze(String name, int z, int y, int x);
	void displayCrossSectionBy(String ZYX, String name, int index);
	void saveMaze(String name, String fileName);
	void loadMaze(String name, String fileName);
	void solveMaze(String name, String algorithm);
	void displaySolution(String name);
	void exit();
}
