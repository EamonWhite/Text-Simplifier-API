package ie.gmit.dip;

/**
 * A class containing the main method, used to launch the application
 * 
 * @author Eamon White
 * @version 1.0
 * @since 1.8
 *
 */
public class Runner {
	
	/**
	 * An <b>Input</b> object is instantiated and used to call the <i>start</i>
	 * method from the <b>Input</b> class which launches the application.
	 * 
	 * @param args
	 * @throws Throwable
	 */
	public static void main(String[] args) throws Throwable {

		Input input = new Input();
		input.start();
	}
}
