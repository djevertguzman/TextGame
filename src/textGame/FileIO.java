package textGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileIO {
	//This is going to be fun.
	//The idea here is that we're going to create a Hashmap of Room Objects.
Map<String,Room> locations;
	public static void readMap() {
		try {
		      File roomFile = new File("Rooms.txt");
		      Scanner lineReader = new Scanner(roomFile);
		      //Splitting file by line.
		      while (lineReader.hasNextLine()) {
		        String data = lineReader.nextLine();
		        //System.out.println(data);
		      //Splitting file by delimiter, also adding those tokens to an arraylist.
		        Scanner roomParser = new Scanner(data);
		        roomParser.useDelimiter(",");
		        ArrayList<String> roomAttributes = new ArrayList<String>(); 
		        while(roomParser.hasNext()) {
		        	//System.out.println(roomParser.next());
		        	roomAttributes.add(roomParser.next());
		        	//System.out.println("Delim Division");
		        }
		        roomParser.close();
		        //System.out.println(roomAttributes);
		        //Room newROOM = new Room();
		        Room temp = new Room(
		        		Integer.parseInt(roomAttributes.get(0)),
		        		roomAttributes.get(1),
		        		roomAttributes.get(2),
		        		Integer.parseInt(roomAttributes.get(3)),
		        		Integer.parseInt(roomAttributes.get(4)),
		        		Integer.parseInt(roomAttributes.get(5)),
		        		Integer.parseInt(roomAttributes.get(6))
		        		);
		        Game.addRoom(temp);
		        //System.out.println("Line Division");
		        //Aright We can read the file, but we have not parsed it yet.
		      }
		      lineReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
