package textGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import textGame.commonLib.Item;

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
	public static void readItems() {
		try {
		      File roomFile = new File("Items.txt");
		      Scanner lineReader = new Scanner(roomFile);
		      //Splitting file by line.
		      while (lineReader.hasNextLine()) {
		        String data = lineReader.nextLine();
		        //System.out.println(data);
		      //Splitting file by delimiter, also adding those tokens to an arraylist.
		        Scanner itemParser = new Scanner(data);
		        itemParser.useDelimiter("~");
		        ArrayList<String> itemAttributes = new ArrayList<String>(); 
		        while(itemParser.hasNext()) {
		        	//System.out.println(roomParser.next());
		        	itemAttributes.add(itemParser.next());
		        	//System.out.println("Delim Division");
		        }
		        itemParser.close();
		        //System.out.println(roomAttributes);
		        //Room newROOM = new Room();
		        Item temp = new Item(
		        		itemAttributes.get(0),
		        		itemAttributes.get(1),
		        		itemAttributes.get(2)
		        		//Integer.parseInt(itemAttributes.get(3));
		        		
		        		);
		        Game.Area.get(Integer.parseInt(itemAttributes.get(3))).rmInv.addToInv(temp);
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
