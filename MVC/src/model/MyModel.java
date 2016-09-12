package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import algorithms.demo.SearchableMaze;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.SimpleMaze3dGenerator;
import algorithms.search.BestFirstSearch;
import algorithms.search.DepthFirstSearch;
import algorithms.search.Searchable;
import algorithms.search.Searcher;
import algorithms.search.Solution;
import algorithms.search.State;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

// TODO: Auto-generated Javadoc
/**
 * The MyModel is a class that extends CommonModel.
 * the class will implement the methods from Model Interface 
 * @author Nati Sadeh & Eli Salem
 */
public class MyModel extends CommonModel {
     
     /** The string builder. */
     private StringBuilder stringBuilder;
     
	/**
	 * Instantiates a new my model.
	 */
	public MyModel() {
		super();
		this.stringBuilder = new StringBuilder();
	}
	
	
	/**
	 * This method generate a new maze 
	 * The method will run a new thread from the threadpool when creating a new maze
	 */
	@Override
	public void generate3dMaze(String name, int z, int y, int x) {
		threadPool.execute(new Runnable() {
			@Override
			public void run() {
				Maze3d maze3d = new SimpleMaze3dGenerator().generate(z, y, x);
				hashMaze.put(name, maze3d);
				controller.display("maze " + name + " is ready");
			}
		});

	}


	/**
	 * This method will display a maze
	 * The method will check in the hashmap if the maze exist and will display him
	 */
	@Override
	public void displayMaze(String name) {
		// get the maze from hashMap
		Maze3d maze3d = hashMaze.get(name);
		if (maze3d == null)
			this.controller.display("Maze " + name + " is not exist");
		else
			try {
				this.controller.displayByteArr(maze3d.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	/**
	 * This method will display a 2D maze
	 * The method will check in the hashmap if the  maze exist and will display as 2D maze 
	 * 
	 */
	@Override
	public void crossSectionBy(String ZYX, String name, int index) {
		// get the maze from hashMap
		Maze3d maze3d = hashMaze.get(name);
		int[][] maze2d;

		if (maze3d == null) {
			this.controller.display("this maze isn't exist");
			return;
		}

		try {
			switch (ZYX) {
			case "z":
			case "Z":
				maze2d = maze3d.getCrossSectionByZ(index);
				break;
			case "y":
			case "Y":
				maze2d = maze3d.getCrossSectionByY(index);
				break;
			case "x":
			case "X":
				maze2d = maze3d.getCrossSectionByX(index);
				break;
			default:
				this.controller.display("Invalid Input");
				return;
			}
		} catch (IndexOutOfBoundsException e) {
			this.controller.display("Invalid index");
			return;
		}

		// print the maze for printWriter variables, using string.
		String maze2dprint = "";
		for (int i = 0; i < maze2d.length; i++) {
			for (int j = 0; j < maze2d[i].length; j++) {
				maze2dprint += String.valueOf(maze2d[i][j] + " ");
			}
			maze2dprint += "\n";
		}
		this.controller.display(maze2dprint);
	}

	/**
	 * This method will save a maze
	 * The method will check in the hashmap if the maze exist and will save him as bytes in OUT file
	 */
	@Override
	public void saveMaze(String name, String fileName) {
		// get the maze from hashMap
		Maze3d maze3d = hashMaze.get(name);
		if (maze3d == null)
			this.controller.display("Maze" + name + "isn't exist");
		else {
			try {
				// writing the maze by byteArray into file.
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
				out.write(maze3d.toByteArray());
				out.close();
				this.controller.display("Maze " + name + " is saved successfully in the file " + fileName);
				// handle exceptions.
			} catch (FileNotFoundException e) {
				this.controller.display("The " + fileName + " isn't exist");
			} catch (IOException e) {
				this.controller.display("this maze isn't success to save");
			}
		}

	}

	/**
	 * This method will display a maze
	 * The method will check in the hashmap if the maze exist and will load him from OUT file 
	 */
	@Override
	public void loadMaze(String name, String fileName) {
		try {
			// creating inputStream to get the file name.
			InputStream in = new MyDecompressorInputStream(new FileInputStream(fileName));
			byte[] byteArray = new byte[35000]; // 34586

			// read from file
			int numerOfByte = in.read(byteArray);
			in.read(byteArray);
			in.close();
			byte[] newByteArray = new byte[numerOfByte];

			// copy arrays
			for (int i = 0; i < newByteArray.length; i++)
				newByteArray[i] = byteArray[i];

			// creating maze3d and get him from hashMap.
			Maze3d maze3d = new Maze3d(byteArray);
			// put the new maze in hashMap
			hashMaze.put(name, maze3d);
			this.controller.display("Maze " + name + " is loaded from " + fileName + " file");
			in.close();

			// handles exceptions.
		} catch (FileNotFoundException e) {
			this.controller.display("The file " + fileName + " isn't found");
		} catch (IOException e) {
			this.controller.display("isn't success new maze");
		}
	}

	/**
	 * This method will solve a maze
	 * The method will check in the hashmap if the maze exist and solve him by a given algorithm
	 * The method run a thread when solving the maze
	 */
	@Override
	public void solveMaze(String name, String algorithm) {
		// this is calculate process > different thread.
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				// get the maze from hashMap
				Maze3d maze3d = hashMaze.get(name);
				if (maze3d == null)
					controller.display("Maze " + name + " isn't exist");
				else {
					// local variables
					Searchable<Position> mazeSearch = new SearchableMaze(maze3d);
					Searcher<Position> myAlgorithm;

					// switch & case for solution maze.
					switch (algorithm) {
					case "bfs":
					case "BFS":
						myAlgorithm = new BestFirstSearch<Position>();
						break;
					case "dfs":
					case "DFS":
						myAlgorithm = new DepthFirstSearch<Position>();
						break;
					default:
						controller.display("Invalid algorithm");
						return;
					}

					// put solution in hashMap.
					hashSolution.put(name, myAlgorithm.search(mazeSearch));
					controller.display("Solution for " + name + " is ready");
				}
			}
		});
	}

	/**
	 * This method will display solution for the maze
	 * The method will check in the hashmap if the maze exist and will display the solution
	 */
	@Override
	public void displaySolution(String name) {
		// get solution from hashMap by key (name).
		Solution<Position> mySolution = hashSolution.get(name);
		if (mySolution == null)
			controller.display("Solution for " + name + " isn't exist");
		else {
			// temp arrayList to get the solution.
			Stack<State<Position>> arraySolution = mySolution.getSolution();
			// concat all solution steps.
			for (int i = 0; i < arraySolution.size(); i++)
				this.stringBuilder.append(arraySolution.get(i));
			// print solution
			controller.display("The solution for " + name + " is:\n" + stringBuilder.toString());
		}
	}

	/**
	 * This method will close the model work
	 * This method will inform the controller that the model has stop
	 * This method will close any thread that worked in the model
	 */
	@Override
	public void exit() {
		controller.display("The system is shutting down");
		threadPool.shutdown();
		try {
			while (!(threadPool.awaitTermination(10, TimeUnit.SECONDS)));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
