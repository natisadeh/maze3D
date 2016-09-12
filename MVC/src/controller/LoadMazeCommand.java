package controller;

public class LoadMazeCommand extends CommonCommand {

	public LoadMazeCommand(Controller controller) {
		super(controller);
	}

	/**
	 * Override "doCommand" and implements this method.
	 * This method will tell the controller that the user want to load maze
	 */
	@Override
	public void doCommand(String string) {
		String[] tempArray = string.split(" ");

		if (tempArray.length >= 2) {
			if (tempArray[0].equals("maze")) {
				String name = tempArray[1];
				String fileName = tempArray[2];
				this.controller.loadMaze(name, fileName);
			} else {
				this.controller.display("Invalid input");
			}
		}
	}
}
