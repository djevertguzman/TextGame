package textGame.commonLib;

public class Monster extends Entity{
	int totalHP;
	int maxAttack;
	public Monster(int ID, String Type, String Name, String Description, int totalHP,int maxAttack) {
		super(ID, Type, Name, Description);
		this.totalHP = totalHP;
		this.maxAttack =  maxAttack;
	}
	public int getTotalHP() {
		return totalHP;
	}
	public void setTotalHP(int totalHP) {
		this.totalHP = totalHP;
	}
	public int getMaxAttack() {
		return maxAttack;
	}
	public void setMaxAttack(int maxAttack) {
		this.maxAttack = maxAttack;
	}
	

}
