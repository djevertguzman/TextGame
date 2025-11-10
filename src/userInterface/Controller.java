package userInterface;

import java.util.Scanner;

import textGame.Combat;
import textGame.Game;
import textGame.Player;

public class Controller {
	static Scanner usrkey = new Scanner(System.in);
	public static void singleStepParse(int context) {
		String usrString = usrkey.nextLine();
		if(context == 0) {
			MainMenuParse(usrString);
		}
		else if(context == 1) {
			NavigationParse(usrString);
		}
		else if(context == 3) {
			CombatParse(usrString);
		}
	}
	public static void NavigationParse(String usrString) {
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
			Player.playerInv();
			break;
		case "inspect":
			if(commandSplit.length == 1) {
				System.out.println("Command argument required: Try Again");
			}else {
				Player.itemInspect(commandSplit[1]);
			}
			break;
		case "drop":
			if(commandSplit.length == 1) {
				System.out.println("Command argument required: Try Again");
			}else {
				Game.dropItem(commandSplit[1]);
			}
			break;
		case "equip":
			if(commandSplit.length == 1) {
				System.out.println("Command argument required: Try Again");
			}else {
				Player.equipItem(commandSplit[1]);
			}
			break;
		case "unequip":
			Player.unequipItem();
			break;
		case "checkequip":
			Player.checkequip();
			break;
		case "checkhp":
			Player.checkHP();
			break;
		case "heal":
			if(commandSplit.length == 1) {
				System.out.println("Command argument required: Try Again");
			}else {
				Player.itemHeal(commandSplit[1]);
			}
			break;
		case "checkattack":
			System.out.println("Player's Currrent Attack Power: " + Player.getCurrAttk());
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
	public static void MainMenuParse(String usrString) {
		//System.out.println("We've made it to where we parse the users input.");
		//System.out.println("The user selected: " + option);
		//String[] options = {"new","continue","config","stats"};
		switch(usrString) {
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
	public static void CombatParse(String usrString) {
		Combat currFight = Game.getCombatOBJ();
		usrString = usrString.toLowerCase();
		String commandSplit[] = usrString.split(" ");
		switch(commandSplit[0]){
		case "examine":
				System.out.println("In progress - Controller");
				newView.setCombatMessage(currFight.examine());
			break;
		case "attack":
			if(commandSplit.length == 1) {
				System.out.println("Command argument required: Try Again");
			}else {
				System.out.println("Not Implemented");
			}
			break;
		//case "skip":
			//Game.skipFight();
			//break;
		case "ignore":
			currFight.ignore();
			break;
		}
	}
}
