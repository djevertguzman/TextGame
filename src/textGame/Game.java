package textGame;

import java.util.ArrayList;
import textGame.commonLib.*;
import java.util.Arrays;
import java.util.Iterator;
//Main game logic will go here.

public class Game {
	static ArrayList<Room> Area = new ArrayList<Room>();
	static ArrayList<Puzzle> Puzzles = new ArrayList<Puzzle>();
	private static int usrLOC = 1;
	
	public static void addRoom(Room x) {
		Area.add(x);
		//System.out.println(x.getRoomName() + ": Has been loaded into the game");
	}
	public static void addPuzzle(Puzzle x) {
		Puzzles.add(x);
		//System.out.println(x.getRoomName() + ": Has been loaded into the game");
	}
	public static void newGame() {
		//System.out.println("You have been dropped off in front of your friends house, and you are unfamillar with this landscape.");
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
			gps();
			String usrCommand = UserCLI.navigationCLI(usrLOC,Area.get(usrLOC).getRoomName(), Area.get(usrLOC).hasVisited(),Area.get(usrLOC).description);
			//System.out.println("usrSel:" + direction);
			parseUSRInput(usrCommand);
			Area.get(usrLOC).visit();
			}
		}
	private static void gps() {
		usrLOC = Player.currPlayerLocation();
	}
	private static void parseUSRInput(String D) {
		gps();
		int nbrRoom[] = Area.get(usrLOC).getNeighbouringRooms();
		//System.out.println("nbrroom:" + Arrays.toString(nbrRoom));
			switch(D.toLowerCase()){
			case "n":
				if(nbrRoom[0] != 0) {
					Player.updatePlayerLocation(nbrRoom[0]);
					gps();
					//System.out.println("Branch 1");
				}
				else {
					System.out.println("There is nowhere to go, select another option.");
				}
				break;
				
			case "e":
				if(nbrRoom[1] != 0) {
					Player.updatePlayerLocation(nbrRoom[1]);
					gps();
					//System.out.println("Branch 2");
				}
				else {
					System.out.println("There is nowhere to go, select another option.");
				}
				break;
			case "s":
				if(nbrRoom[2] != 0) {
					Player.updatePlayerLocation(nbrRoom[2]);
					gps();
					//System.out.println("Branch 3");
				}else {
					System.out.println("There is nowhere to go, select another option.");
				}
				break;
			case "w":
				if(nbrRoom[3] != 0) {
					Player.updatePlayerLocation(nbrRoom[3]);
					gps();
					//System.out.println("Branch 3");
				}else {
					System.out.println("There is nowhere to go, select another option.");
				}
				break;
			case "explore":
				explore();
				break;
			case "pickup":
				pickup();
				break;
			case "inventory":
				playerInv();
				break;
			case "inspect":
				itemInspect();
				break;
			case "drop":
				dropItem();
				break;
			case "help":
				UserCLI.displayHelp();
				break;
			case "exit":
				//System.out.println("Branch 4");
				System.out.println("See you next time, Goodbye.");
				System.exit(0);
			case "":
				System.out.println("Make sure to select an option.");
				//System.out.println("Branch 5");
				break;
			default:
				System.out.println("There is nowhere to go, select another option.");
				//System.out.println("Branch 6");
				break;
			}
	}
	public static String[] getNbrRoomName() {
		int[] temp = Area.get(usrLOC).getNeighbouringRooms();
		String[] nbrName = {Area.get(temp[0]).getRoomName(),Area.get(temp[1]).getRoomName(),Area.get(temp[2]).getRoomName(),Area.get(temp[3]).getRoomName()};
		return nbrName;
	}
	public static void explore() {
		boolean isEmpty = Area.get(usrLOC).rmInv.isEmpty();
		UserCLI.exploreList(isEmpty, Area.get(usrLOC).rmInv.prntList());
	}
	public static void pickup() {
		String usrSelection = UserCLI.pickup();
		int count = 0;
		Iterator<Item> iter = Area.get(usrLOC).rmInv.getArrList().iterator();
		Boolean anything = false;
		while(iter.hasNext()) {
			Item X = iter.next();
			count += 1;
			if(X.getName().toLowerCase().contains(usrSelection.toLowerCase())) {
				Player.pInv().addToInv(X);
				//Area.get(usrLOC).rmInv.removeFromInv(count);
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
		UserCLI.playerInv();
		if(Player.playInv.getItemCount() != 0) {
		System.out.println(Player.playInv.prntList());
		}
		else {
			System.out.println("You haven't yet picked up any items.");
		}
	}
	public static void itemInspect(){
		String chosenItem = UserCLI.playerItemInspect();
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
	public static void dropItem() {
		String usrSelection = UserCLI.drop();
		int count = 0;
		Iterator<Item> iter = Player.playInv.getArrList().iterator();
		Boolean anything = false;
		while(iter.hasNext()) {
			Item X = iter.next();
			count += 1;
			if(X.getName().toLowerCase().contains(usrSelection.toLowerCase())) {
				//Player.pInv().addToInv(X);
				//Area.get(usrLOC).rmInv.removeFromInv(count);
				Area.get(usrLOC).rmInv.addToInv(X);
				iter.remove();
				System.out.println("Item " + X.getName() + " has been dropped,\nand successfully placed in the: " + Area.get(usrLOC).name);
				anything = true;
			}
		}
		if(anything == false) {
			System.out.println("There is no item named " + usrSelection + "in your Inventory.");
		}
	}
	public static void checkForPuzzle() {
		System.out.println("In the checking puzzle method.");
		Iterator<Puzzle> pIter = Puzzles.iterator();
		while(pIter.hasNext()) {
			Puzzle X = pIter.next();
			if(X.getroomNum() == usrLOC && X.getCompletion() == false) {
				playPuzzle(X);
			}
		}
	}
	public static void playPuzzle(Puzzle X) {
		System.out.println(X.getQuestion());
		Boolean corrAns = false;
		int attempts = X.getAttempts();
		while(corrAns == false && attempts != 0) {
		String Answer = UserCLI.puzzle();
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
		Player.updatePlayerLocation(usrLOC - 1);
		gps();
	}
}
