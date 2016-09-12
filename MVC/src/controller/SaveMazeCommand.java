package controller;

public class SaveMazeCommand extends CommonCommand {

	public SaveMazeCommand(Controller controller) {
		super(controller);
	}
	
	/**
	 * Override "doCommand" and implements this method.
	 * This method will tell the controller that the user want to save the maze
	 */
	@Override
	public void doCommand(String string) {
		String[] tempArray = string.split(" ");

		if (tempArray.length >= 2) {
			if (tempArray[0].equals("maze")) {
				String name = tempArray[1];
				String fileName = tempArray[2];
				this.controller.saveMaze(name, fileName);
			} else {
				this.controller.display("Invalid input");
			}
		}
	}
}
