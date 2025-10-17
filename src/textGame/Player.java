package textGame;

import java.util.ArrayList;
import textGame.commonLib.*;


public class Player {
	static Inventory playInv = new Inventory("playerInv");
	private static int currRoom = 1;
	public static void updatePlayerLocation(int rmID) {
		currRoom = rmID;
	}
	public static int currPlayerLocation() {
		return currRoom;
	}
	public static Inventory pInv() {
		return playInv;
	}
}
