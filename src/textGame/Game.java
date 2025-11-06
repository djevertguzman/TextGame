package textGame;

import java.util.ArrayList;
import textGame.commonLib.*;
import userInterface.Controller;
import userInterface.View;

import java.util.Iterator;
//Main game logic will go here.

public class Game {
	static ArrayList<Room> Area = new ArrayList<Room>();
	static ArrayList<Puzzle> Puzzles = new ArrayList<Puzzle>();
	
	public static void addRoom(Room x) {
		Area.add(x);
		//System.out.println(x.getRoomName() + ": Has been loaded into the game");
	}
	public static void addPuzzle(Puzzle x) {
		Puzzles.add(x);
		//System.out.println(x.getRoomName() + ": Has been loaded into the game");
	}
	public static void newGame() {
		game();
	}
	public static void continueGame() {
		//Not implemented
		System.out.println("Not implemented: Returning to Main Menu.");
		return;
	}
	private static void game() {
		while(true) {
			checkForPuzzle();
			String usrCommand = View.navigationCLI(Player.currPlayerLocation(),Area.get(Player.currPlayerLocation()).getRoomName(), Area.get(Player.currPlayerLocation()).hasVisited(),Area.get(Player.currPlayerLocation()).description);
			//Controller.parseUSRInput(usrCommand);
			Controller.singleStepParse(usrCommand);
			Area.get(Player.currPlayerLocation()).visit();
			}
		}
	public static int[] getNeighbouringRooms() {
		return Area.get(Player.currPlayerLocation()).getNeighbouringRooms();
	}
	//See about reworking this later, to make room host and generate it's own Neighboring Array.
	public static String[] getNbrRoomName() {
		int[] temp = Area.get(Player.currPlayerLocation()).getNeighbouringRooms();
		String[] nbrName = {Area.get(temp[0]).getRoomName(),Area.get(temp[1]).getRoomName(),Area.get(temp[2]).getRoomName(),Area.get(temp[3]).getRoomName()};
		return nbrName;
	}
	public static void explore() {
		boolean isEmpty = Area.get(Player.currPlayerLocation()).rmInv.isEmpty();
		View.exploreList(isEmpty, Area.get(Player.currPlayerLocation()).rmInv.prntList());
	}
	public static void pickup(String usrSelection) {
		//String usrSelection = View.pickup();
		int count = 0;
		Iterator<Item> iter = Area.get(Player.currPlayerLocation()).rmInv.getArrList().iterator();
		Boolean anything = false;
		while(iter.hasNext()) {
			Item X = iter.next();
			count += 1;
			if(X.getName().toLowerCase().contains(usrSelection.toLowerCase())) {
				Player.pInv().addToInv(X);
				iter.remove();
				System.out.println("Item " + X.getName() + " has been picked up,\nand successfully added to the player inventory");
				anything = true;
			}
		}
		if(anything == false) {
			System.out.println("There is no item named " + usrSelection + "in this Room.");
		}
	}
	public static void playerInv() {
		View.playerInv();
		if(Player.playInv.getItemCount() != 0) {
		System.out.println(Player.playInv.prntList());
		}
		else {
			System.out.println("You haven't yet picked up any items.");
		}
	}
	public static void itemInspect(String chosenItem){
		chosenItem = chosenItem.toLowerCase();
		Iterator<Item> iter = Player.playInv.getArrList().iterator();
		Boolean anything = false;
		while(iter.hasNext()) {
			Item X = iter.next();
			if(X.getName().toLowerCase().contains(chosenItem.toLowerCase())) {
				System.out.println(X.printNameDescription());
				anything = true;
			}
		}
		if(anything == false) {
			System.out.println("This item was not found in your Inventory.\n are you sure you have picked it up?");
		}
	}
	public static void dropItem(String usrSelection) {
		usrSelection = usrSelection.toLowerCase();
		int count = 0;
		Iterator<Item> iter = Player.playInv.getArrList().iterator();
		Boolean anything = false;
		while(iter.hasNext()) {
			Item X = iter.next();
			count += 1;
			if(X.getName().toLowerCase().contains(usrSelection.toLowerCase())) {
				Area.get(Player.currPlayerLocation()).rmInv.addToInv(X);
				iter.remove();
				System.out.println("Item " + X.getName() + " has been dropped,\nand successfully placed in the: " + Area.get(Player.currPlayerLocation()).name);
				anything = true;
			}
		}
		if(anything == false) {
			System.out.println("There is no item named " + usrSelection + "in your Inventory.");
		}
	}
	public static void checkForPuzzle() {
		Iterator<Puzzle> pIter = Puzzles.iterator();
		while(pIter.hasNext()) {
			Puzzle X = pIter.next();
			if(X.getroomNum() == Player.currPlayerLocation() && X.getCompletion() == false) {
				playPuzzle(X);
			}
		}
	}
	public static void playPuzzle(Puzzle X) {
		System.out.println(X.getQuestion());
		Boolean corrAns = false;
		int attempts = X.getAttempts();
		while(corrAns == false && attempts != 0) {
		String Answer = View.puzzle();
		if(Answer.toLowerCase().contains(X.getAnswer().toLowerCase())) {
			X.markComplete();
			corrAns = true;
			System.out.println("You have correctly solved the puzzle. \n You may proceed.");
			return;
		}
		else {
			attempts -= 1;
			System.out.println("The answer you have provided is wrong, you still have " + attempts + " attempts. Try again.");
		}
		}
		System.out.println("You have failed to solve the puzzle,\ncome back later.");
		Player.updatePlayerLocation(Player.currPlayerLocation() - 1);
	}
}
