package controller;

public class Generate3dMazeCommand extends CommonCommand {

	public Generate3dMazeCommand(Controller controller) {
		super(controller);
	}
	/**
	 * Override "doCommand" and implements this method.
	 * This method will tell the controller that the user want to generate a maze
	 */
	@Override
	public void doCommand(String string) {
		String[] tempArray = string.split(" ");
		if (tempArray.length > 5) {
			// check if the command is equals.
			if (tempArray[0].equals("3d") || tempArray[0].equals("3D")) {
				if (tempArray[1].equals("Maze") || tempArray[1].equals("maze")) {
					// local variables
					int z, y, x;
					try {
						z = Integer.parseInt(tempArray[3]);
						y = Integer.parseInt(tempArray[4]);
						x = Integer.parseInt(tempArray[5]);
						this.controller.generate3dMaze(tempArray[2], z, y, x);
					} catch (NumberFormatException e) {
						this.controller.display("Invalid convert numbers");
					}
				}
			}
		} else {
			this.controller.display("Invalid length");
		}
	}
}
