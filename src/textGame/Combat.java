package textGame;

import java.util.ArrayList;
import java.util.Iterator;
import textGame.commonLib.Monster;

public class Combat {
	ArrayList<Monster> currMobs;
	boolean stopFight = false;
	public Combat(ArrayList<Monster> MobsPresent) {
		currMobs = MobsPresent;
	}
	public void attack() {
		//Not implemented Yet, but it's coming. 
	}
	public String examine() {
		String mobExamine = "";
		Iterator<Monster> mobIter = currMobs.iterator();
		//System.out.println("List of Mobs");
		while(mobIter.hasNext()) {
			Monster X = mobIter.next();
			mobExamine += ("Monster: " + X.getName() + " - " + X.getDescription() + ". Attk: " + X.getMaxAttack() + "\n");
			
		}
		return mobExamine;
	}
	public void skip() {
		Game.skipFight();
	}
	public Boolean requestStop() {
		return stopFight;
	}
	public void ignore() {
		//Being Lazy, I'm just clearing the Mob ArrayList.
		currMobs.clear();
		stopFight = true;
	}
}
