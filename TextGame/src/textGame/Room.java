package textGame;
//import java.util.HashMap;
import java.util.Map;

//import com.sun.tools.javac.code.Attribute.Array;

public class Room {
	int roomNumber;
	String name;
	String description;
	boolean visited = false;
	int N,E,S,W = 0;
	Map<String, Integer> exits;
	public Room(int roomNumber, String name, String description, int N, int E, int S, int W) {
		this.roomNumber = roomNumber;
		this.name = name;
		this.description = description;
		this.visited = false;
		//this.exits = new HashMap<>();
		this.N = N;
		this.E = E;
		this.S = S;
		this.W = W;
	}
	public void addExit(String Direction, int roomNumber) {
		exits.put(Direction, roomNumber);
	}
	public String getRoomName() {
		return name;
	}
	public int[] getNeighbouringRooms() {
		int NeighbouringRoom[] = {N,E,S,W};
		return NeighbouringRoom;
	}
	public void visit() {
		visited = true;
	}
	public boolean hasVisited() {
		return visited;
	}
	
}
