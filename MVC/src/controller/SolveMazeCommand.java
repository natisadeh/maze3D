package controller;

public class SolveMazeCommand extends CommonCommand {

	public SolveMazeCommand(Controller controller) {
		super(controller);
	}

	/**
	 * Override "doCommand" and implements this method.
	 * This method will tell the controller that the user want to solve the maze
	 */
	@Override
	public void doCommand(String string) {
		String[] tempArray = string.split(" ");
		if (tempArray.length != 2) {
			controller.display("Invalid parameters");
		} else {
			String nameMaze = tempArray[0];
			String algorithm = tempArray[1];
			controller.solveMaze(nameMaze, algorithm);
		}
	}

}
