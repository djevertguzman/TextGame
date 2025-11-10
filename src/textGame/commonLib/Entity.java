package textGame.commonLib;

public class Entity {
	int ID;
	String Type;
	String Name; 
	String Description;
	public Entity(int ID, String Type, String Name, String Description) {
		this.ID = ID;
		this.Type = Type;
		this.Name = Name;
		this.Description = Description;
	}
	public int getID() {
		return ID;
	}
	public String getType() {
		return Type;
	}
	public String getName() {
		return Name;
	}
	public String getDescription() {
		return Description;
	}
	
}
