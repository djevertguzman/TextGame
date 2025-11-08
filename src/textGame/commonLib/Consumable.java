package textGame.commonLib;

public class Consumable extends Item{
	int hpUP;

	public Consumable(String id, String Name, String description, int hp) {
		super(id, Name, description);
		hpUP = hp;
	}
	public int getHP() {
		return hpUP;
	}
}
