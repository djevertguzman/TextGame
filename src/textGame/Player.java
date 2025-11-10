package textGame;

import java.util.ArrayList;
import java.util.Iterator;

import textGame.commonLib.*;
import userInterface.View;


public class Player {
	static Inventory playInv = new Inventory("playerInv");
	private static int currRoom = 1;
	private static int playHP = 100;
	private static int attDamage = 5;
	private static Weapon equip1;
	public static void updatePlayerLocation(int rmID) {
		currRoom = rmID;
	}
	public static int currPlayerLocation() {
		return currRoom;
	}
	public static void playerInv() {
		View.playerInv();
		if(playInv.getItemCount() != 0) {
		System.out.println(playInv.prntList());
		}
		else {
			System.out.println("You haven't yet picked up any items.");
		}
	}
	public static void itemInspect(String chosenItem){
		chosenItem = chosenItem.toLowerCase();
		Iterator<Item> iter = playInv.getArrList().iterator();
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
	public static int getMaxHP() {
		return 100;
	}
	public static int getCurrHP() {
		return playHP;
	}
	public static int getCurrAttk() {
		int calculateAttk = attDamage;
		if(equip1 != null) {
			calculateAttk += equip1.getAtt();
		}
		return calculateAttk;
	}
	public static void equipItem(String equpItem) {
		equpItem = equpItem.toLowerCase();
		Iterator<Item> iter = playInv.getArrList().iterator();
		Boolean anything = false;
		while(iter.hasNext()) {
			Item X = iter.next();
			if(X.getName().toLowerCase().contains(equpItem.toLowerCase())) {
				if(X instanceof Weapon) {
					Weapon W = (Weapon) X;
					System.out.println("Item Equipped ");
					System.out.println(X.getName());
					anything = true;
					equip1 = W;
				}
			}
		}
		if(anything == false) {
			System.out.println("This item was not found in your Inventory.\n are you sure you have picked it up?");
		}
	}
	public static void unequipItem() {
		System.out.println("Item Unequipped");
		equip1 = null;
	}
	public static void checkequip() {
		if(equip1 != null) {
			System.out.println("Item equiped " + equip1.getName());
		}
		else {
			System.out.println("There is no item currently equiped.");
		}
	}
	public static void itemHeal(String healItem) {
		healItem = healItem.toLowerCase();
		Iterator<Item> iter = playInv.getArrList().iterator();
		Boolean anything = false;
		while(iter.hasNext()) {
			Item X = iter.next();
			if(X.getName().toLowerCase().contains(healItem.toLowerCase())) {
				if(X instanceof Consumable) {
					Consumable C = (Consumable) X;
					System.out.println("Item Found: " + C.getName());
					System.out.println("You have healed: " + C.getHP());
					//Brainstorming quick way to consume item.
					//playInv.removeFromInv(X.getID());
					//Not going to work need position id.
					healHP(C.getHP());
					anything = true;
				}
				System.out.println("Item: " + X.getName() + " Has been consumed.");
				iter.remove();
			}
		}
		if(anything == false) {
			System.out.println("This item was not found in your Inventory.\n are you sure you have picked it up?");
		}
	}
	private static void healHP(int addHP) {
		System.out.println("HP Healed: " + addHP);
		playHP += addHP;
	}
	public static void checkHP() {
		System.out.println("Current HP: " + playHP);
	}
	public static void damageHP(int rmHP) {
		playHP -= rmHP;
	}
	
	public static Inventory pInv() {
		return playInv;
	}
}
