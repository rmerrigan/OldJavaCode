import java.util.Scanner;

/**
 * @author rmerriga
 *
 */
public class CMDInputValidationTemplate {

	/**
	 *testing while loop conditionals, including comparing strings and 
	 *booleans, using in programs with user input
	 *got the intended logic to work, able to validate with while loop and run code 
	 *based on user input
	 */
	
	public static void main(String[] args) {
		mainPrompt();
		String input = userInputValidation();
		commandLogic(input);
	}
	
	//displays prompt for user
	private static void mainPrompt() {
		System.out.println(
				"Choose from a selection of commands below: \n" 
		);
	}
	//displays invalid input error message
	private static void invInputErr() {
		System.out.println("Invalid input for command selection, please renter a command.");
	}
	//gets user input with scanner.nextline and stores it in a string
	private static String getUserInput() {
		Scanner sysIn = new Scanner(System.in);
		return sysIn.nextLine();
	}
	//creates a systemin for user to input, validates, and returns it as a string
	public static String userInputValidation() {
		String input = getUserInput();
		//makes sure user input is correct, loops until it is, enter in string values with && to test 
		//multiple values
		while(!input.equalsIgnoreCase("")){
			invInputErr();
			mainPrompt();
			input = getUserInput();
		}
		return input;
	}
	
	public static void commandLogic(String input) {
		//loops until close or exit is chosen as a command
		while(!input.equalsIgnoreCase("")) {
			if(input.equalsIgnoreCase("")) {
				//methods
			}else if(input.equalsIgnoreCase("")) {
				//methods
			}else if(input.equalsIgnoreCase("")) {
				//methods
			}
			input = userInputValidation();
		}
	}
	
}
