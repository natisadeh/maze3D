package controller;

import java.io.File;

public class DirCommand extends CommonCommand {

	/**
	 * C'tor
	 * @param controller
	 */
	public DirCommand(Controller controller) {
		super(controller);
	}

	/**
	 * Override "doCommand" and implements this method.
	 * This method will display a files in specific dir
	 */
	@Override
	public void doCommand(String string) {
		if (string == null){
			this.controller.display("Invalid input");
		}
		else {
			try {
				File file = new File(string);
				if (file.list().length == 0) {
					this.controller.display("File is empty");
				} else {
					this.controller.displayStringArray(file.list());
				}
			} catch (NullPointerException e) {
				this.controller.display("Invalid path");
			}
		}
	}
}