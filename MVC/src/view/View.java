package view;

import java.util.HashMap;

import controller.Command;

/**
 * The Interface View.
 * @auth Nati Sadeh & Eli Salem
 */
public interface View {

	/**
	 * Start method that running a thread, the method will be implement in the CLI
	 */
	void start();
	
	/**
	 * Prints the msg.
	 *
	 * @param msg the msg
	 */
	void printMsg(String msg);
	
	/**
	 * Display string array.
	 *
	 * @param strings the strings
	 */
	void displayStringArray(String[] strings);
	
	/**
	 * Display Byte array
	 *
	 * @param byteArray the byte array
	 */
	void displayByteArray(byte[] byteArray);
	
	/**
	 * Sets the command.
	 *
	 * @param commandHash the command hash
	 */
	void setCommand(HashMap<String, Command> commandHash);
	
	/**
	 * Exit.
	 */
	void exit();
	
}
