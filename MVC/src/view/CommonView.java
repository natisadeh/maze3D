package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;


/**
 * An abstract class that implements View interface
 * @author Nati Sadeh & Eli Salem
 */
public abstract class CommonView implements View {

	/**
	 * Variables
	 */
	protected Controller controller;
	protected BufferedReader in;
	protected PrintWriter out;
	
	/* (non-Javadoc)
	 * @see view.View#start()
	 */
	public abstract void start();
	
	/* (non-Javadoc)
	 * @see view.View#printMsg(java.lang.String)
	 */
	public abstract void printMsg(String msg);
	
	/* (non-Javadoc)
	 * @see view.View#displayStringArray(java.lang.String[])
	 */
	public abstract void displayStringArray(String[] strings);
	
	/* (non-Javadoc)
	 * @see view.View#displayByteArray(byte[])
	 */
	public abstract void displayByteArray(byte[] byteArray);
	
	/* (non-Javadoc)
	 * @see view.View#setCommand(java.util.HashMap)
	 */
	public abstract void setCommand(HashMap<String, Command> commandHash);
	
	/* (non-Javadoc)
	 * @see view.View#exit()
	 */
	public abstract void exit();
	
	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	public Controller getController() {
		return controller;
	}
	
	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * Gets the in.
	 *
	 * @return the in
	 */
	public BufferedReader getIn() {
		return in;
	}
	
	/**
	 * Sets the in.
	 *
	 * @param in the new in
	 */
	public void setIn(BufferedReader in) {
		this.in = in;
	}
	
	/**
	 * Gets the out.
	 *
	 * @return the out
	 */
	public PrintWriter getOut() {
		return out;
	}
	
	/**
	 * Sets the out.
	 *
	 * @param out the new out
	 */
	public void setOut(PrintWriter out) {
		this.out = out;
	}
}
