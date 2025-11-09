package textGame;
import java.util.ArrayList;

//import java.util.Map;
import textGame.commonLib.*;

public class Room {
	int roomNumber;
	String name;
	String description;
	boolean visited = false;
	int N,E,S,W = 0;
	Inventory rmInv;
	ArrayList<Entity> Mobs = new ArrayList<Entity>();
	//Map<String, Integer> exits;
	public Room(int roomNumber, String name, String description, int N, int E, int S, int W) {
		this.roomNumber = roomNumber;
		this.name = name;
		this.description = description;
		this.N = N;
		this.E = E;
		this.S = S;
		this.W = W;
		rmInv = new Inventory(Integer.toString(roomNumber));
	}
	public String getRoomName() {
		return name;
	}
	public int[] getNeighbouringRooms() {
		int NeighbouringRoom[] = {N,E,S,W};
		return NeighbouringRoom;
	}
	public String getDescription() {
		return description;
	}
	public void visit() {
		visited = true;
	}
	public boolean hasVisited() {
		return visited;
	}
	public void addMob(Monster X) {
		Mobs.add(X);
	}
	
}
