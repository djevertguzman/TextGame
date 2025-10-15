package textGame;

public class Main {
	public static void main(String[] args) {
		//Going to use main to sanity check the games config before bringing up the user CLI.
		System.out.println("Game Start!");
		FileIO.readMap();
		//Room chicken = new Room(1,"Chicken Coop","Welcome to the chicken coop.", 0, 0, 0, 0);
		//Game.addRoom(chicken);
		//System.out.println("builtRooms:" + chicken);
		UserCLI.mainmenu();
	}
}
