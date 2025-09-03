package textGame;
import java.util.Scanner;

public class UserCLI {
	static Scanner usrkey = new Scanner(System.in);
	public static void mainmenu() {
		//Scanner usrkey = new Scanner(System.in);
		while(true) {
		System.out.println("1. New Game [new]");
		System.out.println("2. Continue Game [continue]");
		System.out.println("3. Configuration [config]");
		System.out.println("4. Game Stats [stats]");
		System.out.println("5. Exit [exit]");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.print("Enter Selection []: ");
		String usesel = usrkey.nextLine();
		usrMainOption(usesel.toLowerCase());
		}
	}
	public static void usrMainOption(String option) {
		//System.out.println("We've made it to where we parse the users input.");
		//System.out.println("The user selected: " + option);
		//String[] options = {"new","continue","config","stats"};
		switch(option) {
		case "new":
		    //System.out.println("Input ACK: new");
		    Game.newGame();
		    return;
		case "continue":
			//System.out.println("Input ACK: continue");
			Game.continueGame();
			return;
		case "config":
			//System.out.println("Input ACK: config");
			System.out.println("Not implemented: Returning to Main Menu.");
		    return;
		case "stats":
			//System.out.println("Input ACK: stats");
			System.out.println("Not implemented: Returning to Main Menu.");
		    return;
		case "exit":
			//System.out.println("Input ACK: exit");
			System.out.println("See you next time, Goodbye.");
			System.exit(0);
		case "":
			System.out.println("No option selected: Try Again");
			return;
		default:
			System.out.println("Invalid Option: Try Again");
			return;
		}
		
	}
	public static String exploreCLI(String currRm, Boolean Visit, String description) {
		String message = "";
		if(Visit == true) {
			message = "You have visited this room before.";
		}
		else {
			message = "You do not reconize this place, You never been here before.";
		}
		while(true) {
			drawMap();
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("Description: " + description);
			System.out.println("You are currently in the " + currRm + ". " + message );
			//System.out.println("------------------------------------------------------------------------------------------");
			System.out.print("Which way would you like to go? []: ");
			String usesel = usrkey.nextLine();
			return usesel;
			//usrMainOption(usesel.toLowerCase());
			}
	}
	public static void drawMap() {
		System.out.println("      ----N----");
		System.out.println("     |         |");
		System.out.println("     |         |");
		System.out.println("     |         |");
		System.out.println("  -----------------");
		System.out.println(" |                 |");
		System.out.println("W|                 |E");
		System.out.println(" |                 |");
		System.out.println("  -----------------");
		System.out.println("     |         |");
		System.out.println("     |         |");
		System.out.println("     |         |");
		System.out.println("      ----S----");
		String[] rmName = Game.getNbrRoomName();
		System.out.println("N: "+rmName[0]+" - E: "+rmName[1]+" - S: "+rmName[2]+" - W: "+rmName[3]);
	}
}
