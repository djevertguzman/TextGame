package textGame.commonLib;

public class Weapon extends Item {
	int weaponHP = 100;
	int weaDamage;
	Boolean isBroken = false;
	public Weapon(String id, String Name, String description,int damage) {
		super(id, Name, description);
		weaDamage = damage;
	}
	public int getLife() {
		return weaponHP;
	}
	public int getAtt() {
		return weaDamage;
	}
	public void damageWeapon(int x) {
		weaponHP -= x;
		if(weaponHP <= 0) {
			isBroken = true;
		}
	}
	//Overloading
	public void damageWeapon() {
		weaponHP -= 5;
		if(weaponHP <= 0) {
			isBroken = true;
		}
	}
	public Boolean chkBroken() {
		return isBroken;
	}
}
