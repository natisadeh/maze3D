package controller;

import java.util.HashMap;

import model.Model;
import view.View;

// TODO: Auto-generated Javadoc
/**
 * The Class MyController.
 */
public class MyController extends CommonController {

	/**
	 *  Variable
	 */
	private HashMap<String, Command> commandHash;

	/**
	 * Instantiates a new my controller.
	 *
	 * @param view the view
	 * @param model the model
	 */
	public MyController(View view, Model model) {
		super(view, model);
		this.commandHash = new HashMap<String, Command>();
		this.commandHash.put("dir", new DirCommand(this));
		this.commandHash.put("generate", new Generate3dMazeCommand(this));
		this.commandHash.put("display", new DisplayCommand(this));
		this.commandHash.put("save", new SaveMazeCommand(this));
		this.commandHash.put("load", new LoadMazeCommand(this));
		this.commandHash.put("solve", new SolveMazeCommand(this));
		this.commandHash.put("exit", new ExitCommand(this));
		view.setCommand(commandHash);
	}

	/**
	 * This method will send the model a request "display maze" from the user
	 */
	@Override
	public void displayMaze(String name) {
		model.displayMaze(name);
	}

	/**
	 * This method will send the model a request "generate" from the user
	 */
	@Override
	public void generate3dMaze(String name, int z, int y, int x) {
		model.generate3dMaze(name, z, y, x);
		
	}

	/**
	 * This method will send the model a request "display cross section by" from the user
	 */
	@Override
	public void displayCrossSectionBy(String ZYX, String name, int index) {
		model.crossSectionBy(ZYX, name, index);
		
	}

	/**
	 * This method will send the model a request "save maze" from the user
	 */
	@Override
	public void saveMaze(String name, String fileName) {
		model.saveMaze(name, fileName);		
	}

	/**
	 * This method will send the model a request "load maze" from the user
	 */
	@Override
	public void loadMaze(String name, String fileName) {
		model.loadMaze(name, fileName);
	}

	/**
	 * This method will send the model a request "solve maze" from the user
	 */
	@Override
	public void solveMaze(String name, String algorithm) {
		model.solveMaze(name, algorithm);
	}

	/**
	 * This method will send the model a request "display solution" from the user
	 */
	@Override
	public void displaySolution(String name) {
		model.displaySolution(name);
	}

	/**
	 * This method will send the model a request "exit" from the user
	 * The method will shutdown the model
	 * The method will shutdown the view
	 */
	@Override
	public void exit() {
		model.exit();
		view.exit();
	}
}
