package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import controller.Command;

/**
 * The Class MyView that extends CommonView
 * @author Nati Sadeh & Eli Salem
 */
public class MyView extends CommonView {

	/** Variable. */
	private CLI myCli;
	
	/**
	 * Instantiates a new my view.
	 *
	 * @param buff the buff
	 * @param print the print
	 */
	public MyView(BufferedReader buff, PrintWriter print){
		in = buff;
		out = print;
	}
	
	/**
	 * The method will call the start method in the CLI class
	 */
	@Override
	public void start() {
		myCli.start();
	}

	/* (non-Javadoc)
	 * @see view.CommonView#printMsg(java.lang.String)
	 */
	@Override
	public void printMsg(String msg) {
		if (msg != null){
			out.println(msg);
			out.flush();
		}
		else
		{
			out.print("There is no message");
			out.flush();
		}
	}

	/* (non-Javadoc)
	 * @see view.CommonView#displayStringArray(java.lang.String[])
	 */
	@Override
	public void displayStringArray(String[] strings) {
		if(strings != null){
			for(int i=0; i < strings.length; i++){
				out.println(strings[i] + " ");
			}
			out.flush();
		}
		else
		{
			out.print("The array is empty");
			out.flush();
		}
	}

	/* (non-Javadoc)
	 * @see view.CommonView#displayByteArray(byte[])
	 */
	@Override
	public void displayByteArray(byte[] byteArray) {
		try {
			Maze3d maze = new Maze3d(byteArray);
			out.println(maze.getStartPosition());
			out.println(maze.getGoalPosition());
			maze.printMaze();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see view.CommonView#setCommand(java.util.HashMap)
	 */
	@Override
	public void setCommand(HashMap<String, Command> commandHash) {
		myCli = new CLI(in, out, commandHash);
	}

	/* (non-Javadoc)
	 * @see view.CommonView#exit()
	 */
	@Override
	public void exit() {
		out.println("View exit");
		out.flush();
	}
}
