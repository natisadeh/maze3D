package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;


import controller.Command;

/**
 * The Class CLI managing commands from the user 
 * @author Nati Sadeh & Eli Salem
 */
public class CLI {

	/** Variables */
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String, Command> commandHash;

	/**
	 * Instantiates a new cli.
	 *
	 * @param in the in
	 * @param out the out
	 * @param HM the hm
	 */
	public CLI(BufferedReader in, PrintWriter out, HashMap<String, Command> HM) {  
		super();
		this.in = in;
		this.out = out;
		this.commandHash = HM;
	}

	/**
	 * getters and setters for variables class.
	 *
	 * @return the command hash
	 */
	public HashMap<String, Command> getCommandHash() {
		return commandHash;
	}

	/**
	 * Sets the command hash.
	 *
	 * @param commandHash the command hash
	 */
	public void setCommandHash(HashMap<String, Command> commandHash) {
		this.commandHash = commandHash;
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

	/**
	 * start method- creating new Thread and managing commands from user to controller. 
	 */
	public void start() {
		new Thread(new Runnable() {
			/**
			 * override "run" method and implements this method respectively to MVC.
			 */
			@Override
			public void run() {
				try {
					
					out.println("               ***********");
					out.println("               *MAIN MENU*");
					out.println("               ***********");
					out.println("(1). dir <path>");
					out.println("(2). generate 3d maze <maze name> <floors number> <columns number> <rows number>");
					out.println("(3). display <maze name>");
					out.println("(4). display cross section <dim> <maze name> <index>");
					out.println("(5). save maze <maze name> <file name>");
					out.println("(6). load maze <maze name> <file name>");
					out.println("(7). solve <maze name> <algorithm>");
					out.println("(8). display solution <maze name>");
					out.println("(9). exit");
					
					// ask user for command
					out.println("Please enter command");
					out.flush();

					// get the command
					String userCommand = in.readLine();
					Command commandInterface;

					while (!(userCommand.equals("exit"))) {
						// using "get" method to get the value that the hash map is mapping for specific key.
						commandInterface = commandHash.get(userCommand.split(" ")[0]);

						// if the value of the key "userCommand" in hash map is not empty
						if (commandInterface != null) {
							if (userCommand.split(" ").length > 1) {
								// check substring, the second part of the command from user.
								commandInterface.doCommand(userCommand.substring(userCommand.indexOf(' ') + 1));
							} else {
								out.println("Invalid input");
								out.flush();
							}
						} else {
							out.println("this command does not exist. Enter new command");
							out.flush();
						}
						// if the value of the key "userCommand" in hash map is null
						out.println("Please enter new command");
						out.flush();
						userCommand = in.readLine();
					}

					commandHash.get("exit").doCommand("");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// close the thread with start method.
		}).start();
	}
}
