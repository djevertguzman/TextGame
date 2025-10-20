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
	public static String navigationCLI(int usrLoc, String currRm, Boolean Visit, String description) {
		String message = "";
		if(Visit == true) {
			message = "You have visited this room before.";
		}
		else if(Visit == false && usrLoc == 1){
			message = "";
		}
		else {
			message = "You do not reconize this place, You never been here before.";
		}
		while(true) {
			drawMap();
			System.out.println("------------------------------------------------------------------------------------------");
			//TODO narrative parsing.
			//System.out.println("Narrative: " + narrative() + ".");
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
	public static void displayHelp() {
		//TODO write out a help screen.
		System.out.println("In the help menu we display a little informational menu, that gives the user basic commands that they can try.");
		System.out.println("Future goals, make this help menu context aware.");
	}
	public static String narrative() {
		//Future TODO not implemented
		return "Not Implemented";
	}
	public static void exploreList(boolean isEmpty,String itemList) {
		if(isEmpty != true) {
		System.out.println("You explored the room, You have found.");
		//TODO populate the list of items.
		System.out.println(itemList);
		System.out.println("You can pick them up using the pickup command.");
		}
		else {
			System.out.println("This room is empty");
		}
	}
	public static String pickup() {
		System.out.println("What do you want to pickup?: ");
		String usrSelection = usrkey.nextLine();
		usrSelection = usrSelection.toLowerCase();
		return usrSelection;
	}
	public static void playerInv() {
		return;
	}
	public static String playerItemInspect() {
		System.out.println("What item do you want to inspect?");
		String userItem = usrkey.nextLine();
		userItem = userItem.toLowerCase();
		return userItem;
	}
	public static String drop() {
		System.out.println("What item do you want to drop?: ");
		String usrSelection = usrkey.nextLine();
		usrSelection = usrSelection.toLowerCase();
		return usrSelection;
	}
	public static String puzzle() {
		String usrAnswer = usrkey.nextLine();
		usrAnswer = usrAnswer.toLowerCase();
		return usrAnswer;
	}
}
