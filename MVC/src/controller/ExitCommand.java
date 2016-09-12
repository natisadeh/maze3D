package controller;

public class ExitCommand extends CommonCommand {

	public ExitCommand(Controller controller) {
		super(controller);
	}

	/**
	 * Override "doCommand" and implements this method.
	 * This method will tell the controller to exit
	 */
	@Override
	public void doCommand(String string) {
		this.controller.exit();
	}

}
