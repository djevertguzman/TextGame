package textGame;

import java.util.ArrayList;
import java.util.Iterator;

import textGame.commonLib.Item;
import textGame.commonLib.Monster;
import userInterface.newView;

public class Combat {
	ArrayList<Monster> currMobs;
	boolean stopFight = false;
	Monster currMobBeingFaught;
	public Combat(ArrayList<Monster> MobsPresent) {
		currMobs = MobsPresent;
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
	public void setMobBeingAttacked(String Y) {
		int count = 0;
		Iterator<Monster> iter = currMobs.iterator();
		Boolean anything = false;
		while(iter.hasNext()) {
			Monster X = iter.next();
			count += 1;
			if(X.getName().toLowerCase().contains(Y.toLowerCase())) {
				currMobBeingFaught = X;
				anything = true;
				break;
			}
		}
		if(anything == false) {
			System.out.println("There is no Monster named " + Y + "in this Room.");
		}
	}
	public void attack() {
		int playAtt = Player.getCurrAttk();
		currMobBeingFaught.reduceHP(playAtt);
		System.out.println("You have caused " + playAtt + " Damage.");
	}
	public void damage() {
		int mobattk = currMobBeingFaught.getMaxAttack();
		Player.damageHP(mobattk);
		System.out.println("You have recived " + mobattk + " Damage.");
	}
	public int getMobHP() {
		return currMobBeingFaught.getTotalHP();
	}
}
