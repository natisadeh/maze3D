package controller;

public class DisplayCommand extends CommonCommand {

	public DisplayCommand(Controller controller) {
		super(controller);
	}

	/**
	 * Override "doCommand" and implements this method.
	 * This method will display the command 
	 * or crossSection
	 * or solution
	 * or maze 
	 */
	@Override
	public void doCommand(String string) {
		String[] tempArray = string.split(" ");
		String mazeName;
		
		// if we want to display the crossSection
		if(tempArray.length > 4){
			if(tempArray[0].equals("cross")){
				int i = 0;
				try{
				i = Integer.parseInt(tempArray[4]);
				}
				catch (NumberFormatException e){
					controller.display("Invalid input");
				}
				
				String name = tempArray[2];
				mazeName = tempArray[3];
				controller.displayCrossSectionBy(name, mazeName, i);
			}
		}
		
		// if we want to display the solution
		else if (tempArray.length > 1){
			if(tempArray[0].equals("solution")){
				mazeName = tempArray[1];
				controller.displaySolution(mazeName);
			}
		}
		
		// if we want to display the maze
		else {
			mazeName = tempArray[0];
			this.controller.displayMaze(mazeName);
		}

	}

}
