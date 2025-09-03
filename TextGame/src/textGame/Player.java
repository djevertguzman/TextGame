package textGame;

public class Player {
	private static int currRoom = 1;
	public static void updatePlayerLocation(int rmID) {
		currRoom = rmID;
	}
	public static int currPlayerLocation() {
		return currRoom;
	}
}
