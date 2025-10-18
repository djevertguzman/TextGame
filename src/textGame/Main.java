package textGame;

import textGame.commonLib.Inventory;
import textGame.commonLib.Item;

public class Main {
	public static void main(String[] args) {
		/*
		 * Going to use main to sanity check the games configuration before bringing up the user CLI.
		 * These next lines are for a normal game start
		 * Comment them out to prevent the UI from loading.
		 */
		
		System.out.println("Game Start!");
		FileIO.readMap();
		FileIO.readItems();
		//Item oA = new Item("ch1","chicken","a wee little chicken1");
		//Item oB = new Item("ch2","chicken2","a wee little chicken2");
		//Item oC = new Item("ch3","chicken3","a wee little chicken3");
		//Game.Area.get(1).rmInv.addToInv(oA);
		//Game.Area.get(1).rmInv.addToInv(oB);
		//Game.Area.get(1).rmInv.addToInv(oC);
		UserCLI.mainmenu();
		
		/*
		 * After this line is where debug, or testing lines occur.
		 * This is to stop mixing them together.
		 */
		
		//Inventory iA = new Inventory("AAAA");
		//Inventory iB = new Inventory("BBBB");
		//Item oA = new Item("ch1","chicken");
		//Item oB = new Item("ch2","chicken2");
		//System.out.println(iA.printInv() + "first");
		//iA.addToInv(oA);
		//System.out.println(iA.printInv() + "second");
		//Inventory Pinv = Player.pInv();
		//Pinv.addToInv(oB);
		//System.out.println("Player's Inventory: " + Pinv.printInv());
		//Room chicken = new Room(1,"Chicken Coop","Welcome to the chicken coop.", 0, 0, 0, 0);
		//Game.addRoom(chicken);
		//System.out.println("builtRooms:" + chicken);
	}
}