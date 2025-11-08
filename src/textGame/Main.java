package textGame;

import textGame.commonLib.Consumable;
import textGame.commonLib.Inventory;
import textGame.commonLib.Item;
import textGame.commonLib.Weapon;
import userInterface.View;

public class Main {
	public static void main(String[] args) {
		/*
		 * Going to use main to sanity check the games configuration before bringing up the user CLI.
		 * These next lines are for a normal game start
		 * Comment them out to prevent the UI from loading.
		 */
		
		System.out.println("Game Start! Version - #0.0.2");
		FileIO.readMap();
		FileIO.readItems();
		FileIO.readPuzzle();
		Consumable x = new Consumable("testconsume", "Apple", "Small apple doesnt add much but better then nothing.",5);
		Player.playInv.addToInv(x);
		Weapon Y = new Weapon("testWeapon","Gun","Small Gun a bit powerful",100);
		Player.playInv.addToInv(Y);
		
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
		/*
		 * Finally Start the User Interface
		 */
		View.mainmenu();
	}
}