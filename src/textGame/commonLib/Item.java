package textGame.commonLib;

//This the item class, this allows items to exist. Instantiate an item and it exists.
public class Item {
	private String itemID;
	private String Name;
	private String itemDescription;
	public Item(String id,String Name,String description) {
		this.itemID = id;
		this.Name = Name;
		this.itemDescription = description;
	}
	
	@Override
	public String toString() {
		return Name;
	}
	public String printNameDescription() {
		return Name + " , " + itemDescription;
	}
	public String getID() {
		return itemID;
	}
	public String getName() {
		return Name;
	}
}
