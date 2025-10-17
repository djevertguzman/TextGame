package textGame.commonLib;
import java.util.ArrayList;

public class Inventory {
	private String invID ;
	private ArrayList<Item> storedItems = new ArrayList<>();
	public Inventory(String id) {
		this.invID = id;
	}
	public void addToInv(Item I) {
		storedItems.add(I);
	}
	public void removeFromInv(int x) {
		storedItems.remove(x);
	}
	public void moveToInv(Item I,Inventory x) {
		x.addToInv(I);
		storedItems.remove(I);
	}
	public String printInv() {
		return invID + storedItems.toString();
		}
	public int getItemCount() {
		return storedItems.size();
	}
	public String printItemList() {
		return storedItems.toString();
	}
	public boolean isEmpty() {
		return storedItems.isEmpty();
	}
	public String prntList() {
		String sendList = "";
		for(Item I : storedItems) {
			sendList = sendList + I.toString() + "\n";
		}
		return sendList;
	}
	
}
