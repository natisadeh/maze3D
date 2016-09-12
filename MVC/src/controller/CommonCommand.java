package controller;


/**
 * The Common Command is an abstract class that implements Command.
 * the class will hold the Command variables 
 * @author Nati Sadeh & Eli Salem
 */

public abstract class CommonCommand implements Command {

	/** Variable. */
	protected Controller controller;
	
	/**
	 * Instantiates a new common command.
	 *
	 * @param controller the controller
	 */
	public CommonCommand(Controller controller) {
		super();
		this.controller = controller;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#doCommand(java.lang.String)
	 */
	public abstract void doCommand(String string);

}
