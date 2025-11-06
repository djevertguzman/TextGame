package userInterface;

import textGame.Game;
import textGame.Player;

public class Controller {
	public static void parseUSRInput(String D) {
		int nbrRoom[] = Game.getNeighbouringRooms();
			switch(D.toLowerCase()){
			case "n":
				if(nbrRoom[0] != 0) {
					Player.updatePlayerLocation(nbrRoom[0]);
				}
				else {
					System.out.println("There is nowhere to go, select another option.");
				}
				break;
				
			case "e":
				if(nbrRoom[1] != 0) {
					Player.updatePlayerLocation(nbrRoom[1]);
					//System.out.println("Branch 2");
				}
				else {
					System.out.println("There is nowhere to go, select another option.");
				}
				break;
			case "s":
				if(nbrRoom[2] != 0) {
					Player.updatePlayerLocation(nbrRoom[2]);
					//System.out.println("Branch 3");
				}else {
					System.out.println("There is nowhere to go, select another option.");
				}
				break;
			case "w":
				if(nbrRoom[3] != 0) {
					Player.updatePlayerLocation(nbrRoom[3]);
					//System.out.println("Branch 3");
				}else {
					System.out.println("There is nowhere to go, select another option.");
				}
				break;
			case "explore":
				Game.explore();
				break;
			case "pickup":
				//Game.pickup();
				break;
			case "inventory":
				Game.playerInv();
				break;
			case "inspect":
				Game.itemInspect();
				break;
			case "drop":
				Game.dropItem();
				break;
			case "help":
				View.displayHelp();
				break;
			case "exit":
				System.out.println("See you next time, Goodbye.");
				System.exit(0);
			case "":
				System.out.println("Make sure to select an option.");
				break;
			default:
				System.out.println("There is nowhere to go, select another option.");
				break;
			}
			
	}
	public static void singleStepParse(String usrString) {
		int nbrRoom[] = Game.getNeighbouringRooms();
		usrString = usrString.toLowerCase();
		String commandSplit[] = usrString.split(" ");
		switch(commandSplit[0]){
		case "n":
			if(nbrRoom[0] != 0) {
				Player.updatePlayerLocation(nbrRoom[0]);
			}
			else {
				System.out.println("There is nowhere to go, select another option.");
			}
			break;
			
		case "e":
			if(nbrRoom[1] != 0) {
				Player.updatePlayerLocation(nbrRoom[1]);
				//System.out.println("Branch 2");
			}
			else {
				System.out.println("There is nowhere to go, select another option.");
			}
			break;
		case "s":
			if(nbrRoom[2] != 0) {
				Player.updatePlayerLocation(nbrRoom[2]);
				//System.out.println("Branch 3");
			}else {
				System.out.println("There is nowhere to go, select another option.");
			}
			break;
		case "w":
			if(nbrRoom[3] != 0) {
				Player.updatePlayerLocation(nbrRoom[3]);
				//System.out.println("Branch 3");
			}else {
				System.out.println("There is nowhere to go, select another option.");
			}
			break;
		case "explore":
			Game.explore();
			break;
		case "pickup":
			if(commandSplit.length == 1) {
				System.out.println("Command argument required: Try Again");
			}else {
				Game.pickup(commandSplit[1]);
			}
			break;
		case "inventory":
			Game.playerInv();
			break;
		case "inspect":
			if(commandSplit.length == 1) {
				System.out.println("Command argument required: Try Again");
			}else {
				Game.itemInspect(commandSplit[1]);
			}
			break;
		case "drop":
			if(commandSplit.length == 1) {
				System.out.println("Command argument required: Try Again");
			}else {
				Game.dropItem(commandSplit[1]);
			}
			break;
		case "help":
			View.displayHelp();
			break;
		case "exit":
			System.out.println("See you next time, Goodbye.");
			System.exit(0);
		case "":
			System.out.println("Make sure to select an option.");
			break;
		default:
			System.out.println("There is nowhere to go, select another option.");
			break;
		}
	}
}
