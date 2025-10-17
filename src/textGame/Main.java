package textGame;

import textGame.commonLib.Inventory;
import textGame.commonLib.Item;

public class Main {
	public static void main(String[] args) {
		//Going to use main to sanity check the games config before bringing up the user CLI.
		System.out.println("Game Start!");
		Inventory iA = new Inventory("AAAA");
		Inventory iB = new Inventory("BBBB");
		Item oA = new Item("ch1","chicken");
		Item oB = new Item("ch2","chicken2");
		System.out.println(iA.printInv() + "first");
		iA.addToInv(oA);
		System.out.println(iA.printInv() + "second");
		Inventory Pinv = Player.pInv();
		Pinv.addToInv(oB);
		System.out.println("Player's Inventory: " + Pinv.printInv());
		//FileIO.readMap();
		//Room chicken = new Room(1,"Chicken Coop","Welcome to the chicken coop.", 0, 0, 0, 0);
		//Game.addRoom(chicken);
		//System.out.println("builtRooms:" + chicken);
		//UserCLI.mainmenu();
	}
}
