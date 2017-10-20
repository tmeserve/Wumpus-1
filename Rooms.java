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
	
	public void play()
	{
		getSpiders();
		getWumpusr();
		getPits();
		
		Scanner in = new Scanner(System.in);
		String inn;
		int mo;
		
		int a = adrooms[room - 1];
		int b = adrooms[room];
		int c = adrooms[room + 1];
		
		boolean move = false;
		
		while (!move)
		{
			System.out.println("You are in room " + room + ".");
			System.out.println("You have " + arrows + " arrows left.");
			System.out.println(getDesc());
			System.out.println("There are tunnels to rooms " + getAdjRooms() + ".");
			System.out.println("Move or Shoot?");
			inn = in.nextLine();
			if (inn.equalsIgnoreCase("m") || inn.equalsIgnoreCase("move"))
			{
				System.out.println("Which room?");
				
				inn = in.nextLine();
				if (Integer.parseInt(inn) == a)
				{
					room = a;
					if (room == spiders || room == spiders2)
					{
						System.out.println("You were killed by the spiders!");
						move = true;
					}
					
					else if (room == wumpus)
					{
						System.out.println("You were eaten by the Wumpus.");
						move = true;
					}
					else if (room == pit || room == pit2)
					{
						System.out.println("You fell into a pit.");
						move = true;
					}
					else if ((wumpus == adrooms[room - 1]) || (wumpus == adrooms[room]) || (wumpus == adrooms[room + 1]))
					{
						System.out.println("You smell a nasty wumpus.");
					}
				}
				else if (Integer.parseInt(inn) == b)
				{
					room = b;
					if (room == spiders || room == spiders2)
					{
						System.out.println("You were killed by the spiders!");
						move = true;
					}
					
					else if (room == wumpus)
					{
						System.out.println("You were eaten by the Wumpus.");
						move = true;
					}
					else if (room == pit || room == pit2)
					{
						System.out.println("You fell into a pit.");
						move = true;
					}
					else if ((wumpus == adrooms[room - 1]) || (wumpus == adrooms[room]) || (wumpus == adrooms[room + 1]))
					{
						System.out.println("You smell a nasty wumpus.");
					}
				}
				else if (Integer.parseInt(inn) == c)
				{
					room = c;
					if (room == spiders || room == spiders2)
					{
						System.out.println("You were killed by the spiders!");
						move = true;
					}
					
					else if (room == wumpus)
					{
						System.out.println("You were eaten by the Wumpus.");
						move = true;
					}
					else if (room == pit || room == pit2)
					{
						System.out.println("You fell into a pit.");
						move = true;
					}
					else if ((wumpus == adrooms[room - 1]) || (wumpus == adrooms[room]) || (wumpus == adrooms[room + 1]))
					{
						System.out.println("You smell a nasty wumpus.");
					}
				}
				else
				{
					System.out.println("Moron! You can't get to there from here!");
				}
			}
			else if (inn.equalsIgnoreCase("s") || inn.equalsIgnoreCase("shoot"))
			{
				System.out.println("Which room?");
				
				inn = in.nextLine();
				if (Integer.parseInt(inn) == a)
				{
					arrows = arrows - 1;
					if (Integer.parseInt(inn) == wumpus)
					{
						System.out.println("Your arrow goes down the tunnel and hits its mark.");
						System.out.println("You shot the wumpus!");
						System.out.println("You win!. Enjoy your fame.");
						move = true;
					}
				}
				else if (Integer.parseInt(inn) == b)
				{
					arrows = arrows - 1;
					if (Integer.parseInt(inn) == wumpus)
					{
						System.out.println("Your arrow goes down the tunnel and hits its mark.");
						System.out.println("You shot the wumpus!");
						System.out.println("You win!. Enjoy your fame.");
						move = true;
					}
				}
				else if (Integer.parseInt(inn) == c)
				{
					arrows = arrows - 1;
					if (Integer.parseInt(inn) == wumpus)
					{
						System.out.println("Your arrow goes down the tunnel and hits its mark.");
						System.out.println("You shot the wumpus!");
						System.out.println("You win!. Enjoy your fame.");
						move = true;
					}
				}
				else
				{
					System.out.println("Moron! You can't shoot in that room from there!");
				}
			}
		}
	}
	
	public String getAdjRooms()
	{
		return adrooms[room - 1] + ", " + adrooms[room] + ", and " + adrooms[room + 1];
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
	
	public void getWumpusr()
	{
		wumpus = (int) (1 + n*Math.random());
		
		if (wumpus == 1)
		{
			getWumpusr();
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
}
