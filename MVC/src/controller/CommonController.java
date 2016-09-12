package controller;

import model.Model;
import view.View;

/**
 * The Common Controller is an abstract class that implements Controller.
 * the class will hold the Controller variables 
 * @author Nati Sadeh & Eli Salem
 */

public abstract class CommonController implements Controller {
	/**
	 *  variables	
	 */
	protected View view;
	protected Model model;
	
	public CommonController (View view, Model model){
		super();
		this.view = view;
		this.model = model;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	/**
	 * This method is used by "displayStringArray" from view.
	 * @param string []
	 */
	@Override
	public void displayStringArray(String[] strings){
		this.view.displayStringArray(strings);
	}
	
	/**
	 * This method is used by "printMassage" from view.
	 * @param string
	 */
	@Override
	public void display(String massage){
		this.view.printMsg(massage);
	}
	
	/**
	 * This method is used by "displayByteArray" from view.
	 * @param byteArray
	 */
	@Override
	public void displayByteArr(byte[] byteArray){
		this.view.displayByteArray(byteArray);
	}
	
	/**
	 * Controller methods
	 */
	public abstract void displayMaze(String name);
	public abstract void generate3dMaze(String name, int z, int y, int x);
	public abstract void displayCrossSectionBy(String ZYX, String name, int index);
	public abstract void saveMaze(String name, String fileName);
	public abstract void loadMaze(String name, String fileName);
	public abstract void solveMaze(String name, String algorithm);
	public abstract void displaySolution(String name);
	public abstract void exit();
}
