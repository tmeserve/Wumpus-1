package theWumpus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class Rooms
{
	private int arrows = 3;
	//private boolean bats;
	private int room;
	private String description;
	private int spiders;
	private int spiders2;
	private int wumpus;
	private int pit;
	private int pit2;
	private int n;
	int[] rooms;
	String[] desc;
	String[] adjrooms;
	
	String output;
	String[] strarr;
	int[] adrooms;
	
	public Rooms() throws FileNotFoundException
	{
		Scanner cave = new Scanner(new FileReader("Wumpus.txt"));
		
		n = cave.nextInt();
		
		rooms = new int[n];
		desc = new String[n];
		adjrooms = new String[n];
		
		for (int i = 0; i < n; i++)
		{
			rooms[i] = cave.nextInt();
			//System.out.println(rooms[i]);
			adjrooms[i] = cave.nextLine();
			//System.out.println(adjrooms[i]);
			desc[i] = cave.nextLine();
			//System.out.println(desc[i]);
		}
		
		output = "";
		for(String str: adjrooms)
		{
			output = output + str;
		}
		
		output = output.replaceAll("\\s+",",");
		output = output.replaceFirst(",", "");
		
		strarr = output.split(",");
		
		adrooms = new int[strarr.length];
		
		try
		{
			for (int i = 0; i < strarr.length; i++)
			{
				String str = strarr[i];
				adrooms[i] = Integer.parseInt(str);
			}
		}
		catch (NumberFormatException e)
		{
			
		}
		
		room = rooms[0];
		
		//System.out.println(adrooms[room - 1] + " " + adrooms[room] + " " + adrooms[room + 1]);
	}
	
	public int getArrows()
	{
		arrows = arrows - 1;
		return arrows;
	}
	
	public void play()
	{
		Scanner in = new Scanner(System.in);
		String inn;
		System.out.println("You are in room " + room + ".");
		System.out.println("You have " + arrows + " arrows left.");
		System.out.println(getDesc());
		System.out.println("There are tunnels to rooms " + adrooms[room - 1] + ", " + adrooms[room] + ", and "
				+ adrooms[room + 1] + ".");
		System.out.println("You hear a faint clicking noise.");
		System.out.println("Move or Shoot?");
		inn = in.nextLine();
		if (inn.equalsIgnoreCase("m") || inn.equalsIgnoreCase("move"))
		{
			System.out.println("Which room?");
			inn = in.nextLine();
		}
		else if (inn.equalsIgnoreCase("s") || inn.equalsIgnoreCase("shoot"))
		{
			
		}
	}
	
	public String getAdjRooms()
	{
		return adrooms[room - 1] + " " + adrooms[room] + " " + adrooms[room + 1];
	}
	
	public int getRoom()
	{
		//if(rooms[0] == 1)
		{
			//System.out.println("You are in room 1");
			
		}
		return room;
	}
	
	public String getDesc()
	{
		description = desc[room - 1];
		return description;
	}
	
	public void getSpiders()
	{
		spiders = (int) (1 + n*Math.random());
		spiders2 = (int) ( 1 + n*Math.random());
		
		if (spiders == 1 || spiders2 == 1)
		{
			getSpiders();
		}
	}
	
	public void getSpider()
	{
		if (room == spiders)
		{
			System.out.println("You were killed by the spiders!");
		}
		else if ((spiders == adrooms[room - 1]) || (spiders == adrooms[room]) || (spiders == adrooms[room + 1]))
		{
			
		}
		
		if (room == spiders2)
		{
			System.out.println("You were eaten by the spiders!");
		}
		else if ((spiders2 == adrooms[room - 1]) || (spiders2 == adrooms[room]) || (spiders2 == adrooms[room + 1]))
		{
			
		}
	}
	
	public void getWumpusr()
	{
		wumpus = (int) (1 + n*Math.random());
		
		if (wumpus == 1)
		{
			getWumpusr();
		}
	}
	
	public void getWumpus()
	{
		
		if (room == wumpus)
		{
			System.out.println("You were eaten by the Wumpus.");
		}
		else if ((wumpus == adrooms[room - 1]) || (wumpus == adrooms[room]) || (wumpus == adrooms[room + 1]))
		{
			System.out.println("You smell a nasty wumpus.");
		}
	}
	
	public void getPits()
	{
		pit = (int) (1 + n*Math.random());
		pit2 = (int) ( 1 + n*Math.random());
		
		if (pit == 1 || pit2 == 1)
		{
			getPits();
		}
	}
	
	public void getPit()
	{
		if (room == pit)
		{
			System.out.println("You were killed by the spiders!");
		}
		else if ((pit == adrooms[room - 1]) || (pit == adrooms[room]) || (pit == adrooms[room + 1]))
		{
			
		}
		
		if (room == pit2)
		{
			System.out.println("You fell into a pit");
		}
		else if ((pit2 == adrooms[room - 1]) || (pit2 == adrooms[room]) || (pit2 == adrooms[room + 1]))
		{
			
		}
	}
}
