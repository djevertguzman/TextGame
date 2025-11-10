package userInterface;

import java.util.ArrayList;

import textGame.Game;
import textGame.Player;
import textGame.Room;

public class newView {
	static ArrayList<Room> rmList = Game.getRoomList();
	static int currView = 0;
	static String message;
	public static void draw() {
		if(currView == 0) {
			MainMenu();
		}
		else if(currView == 1) {
			Navigation();
		}
		else if(currView == 2) {
			Puzzle();
		}
		else if(currView == 3) {
			//Hard wired, until plumbing figured out.
			exploreList(false, null);
		}
		else if(currView == 4) {
			CombatIntro();
		}
		else if(currView == 5) {
			CombatMain();
		}
	}
	public static void setView(int X) {
		currView = X;
	}
	private static void MainMenu() {
		System.out.println("1. New Game [new]");
		System.out.println("2. Continue Game [continue]");
		System.out.println("3. Configuration [config]");
		System.out.println("4. Game Stats [stats]");
		System.out.println("5. Exit [exit]");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.print("Enter Selection []: ");
	}
	private static void Navigation() {
		int usrLoc = Player.currPlayerLocation(); 
		String currRm = rmList.get(usrLoc).getRoomName();
		Boolean Visit = rmList.get(usrLoc).hasVisited(); 
		String description = rmList.get(usrLoc).getDescription();
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
			drawMap();
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("Description: " + description);
			System.out.println("You are currently in the " + currRm + ". " + message );
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.print("Which way would you like to go? []: ");
	}
	private static void Puzzle() {
		
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
	public static void exploreList(boolean isEmpty,String itemList) {
		if(isEmpty != true) {
		System.out.println("You explored the room, You have found.");
		System.out.println(itemList);
		System.out.println("You can pick them up using the pickup command.");
		}
		else {
			System.out.println("This room is empty");
		}
	}
	public static void CombatIntro() {
		int usrLoc = Player.currPlayerLocation();
		String currRm = rmList.get(usrLoc).getRoomName();
		System.out.println("------------------------Monster----------------------------");
		System.out.println("There is " + rmList.get(usrLoc).getMobCount() + " Monsters Present in " + currRm + ".");
		System.out.println("Run the examine command to discover them.");
	}
	public static void CombatMain() {
		int usrLoc = Player.currPlayerLocation();
		String currRm = rmList.get(usrLoc).getRoomName();
		System.out.println("------------------------Monster----------------------------");
		System.out.println("There are " + rmList.get(usrLoc).getMobCount() + " Monsters left in " + currRm + ".");
		System.out.println(message);
		message = "";
	}
	public static void setCombatMessage(String currMessage) {
		message = currMessage;
	}
}
