package textGame.commonLib;

//This the item class, this allows items to exist. Instantiate an item and it exists.
public class Item {
	private String itemID;
	private String itemDescription;
	public Item(String id,String description) {
		this.itemID = id;
		this.itemDescription = description;
	}
	
	@Override
	public String toString() {
		return itemID +" , "+ itemDescription;
	}
	public String getID() {
		return itemID;
	}
}
