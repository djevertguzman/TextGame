package textGame;

import java.util.ArrayList;
import java.util.Arrays;
//Main game logic will go here.

public class Game {
	static ArrayList<Room> Area = new ArrayList<Room>();
	private static int usrLOC = 1;
	
	public static void addRoom(Room x) {
		Area.add(x);
		//System.out.println(x.getRoomName() + ": Has been loaded into the game");
	}
	public static void newGame() {
		//System.out.println("Printing the Room arraylist, until we have more to show.");
		//System.out.println(Area);
		System.out.println("You have been dropped off in front of your friends house, and you are unfamillar with this landscape.");
		game();
	}
	public static void continueGame() {
		//Not implemented
		System.out.println("Not implemented: Returning to Main Menu.");
		return;
	}
	private static void game() {
		while(true) {
			gps();
			String direction = UserCLI.exploreCLI(Area.get(usrLOC).getRoomName(), Area.get(usrLOC).hasVisited(),Area.get(usrLOC).description);
			Area.get(usrLOC).visit();
			//System.out.println("usrSel:" + direction);
			updatePlayerLocation(direction);
			}
		}
	private static void gps() {
		usrLOC = Player.currPlayerLocation();
	}
	private static void updatePlayerLocation(String D) {
		//Player.updatePlayerLocation(usrLOC);
		gps();
		int nbrRoom[] = Area.get(usrLOC).getNeighbouringRooms();
		//System.out.println("nbrroom:" + Arrays.toString(nbrRoom));
			switch(D.toLowerCase()){
			case "n":
				if(nbrRoom[0] != 0) {
					Player.updatePlayerLocation(nbrRoom[0]);
					//System.out.println("Branch 1");
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
}
