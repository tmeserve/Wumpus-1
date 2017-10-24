package theWumpus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.NumberFormatException;

public class Rooms
{
	private int arrows = 3;
	private int room;
	private String description;
	private int spid;
	private int spid2;
	private int wumpp;
	private int pi;
	private int pi2;
	private int r;
	int[] rooms;
	String[] desc;
	String[] adjrooms;
	int supp;
	
	String output;
	String[] strarr;
	int[] adrooms;
	
	public Rooms() throws FileNotFoundException
	{
		Scanner cave = new Scanner(new FileReader("Wumpus.txt"));
		
		r = cave.nextInt();
		
		rooms = new int[r];
		desc = new String[r];
		adjrooms = new String[r];
		
		for (int i = 0; i < r; i++)
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
		getSpid();
		getWumpr();
		getPi();
		getSupp();
		
		while ((spid == pi) || (spid == spid2) || (spid2 == pi2) || (spid == pi2)
				|| (spid2 == pi) || (spid == wumpp) ||(spid2 == wumpp) || (pi2 == wumpp)
				|| (pi == wumpp) || (spid == 1) || (spid2 == 1) || (pi == 1) ||(pi2 == 1)
				|| (wumpp == 1) || (pi == pi2) || (supp == spid2) || (supp == spid)
				|| (supp == pi2) || (supp == pi) || (supp == wumpp))
			{
				getSpid();
				getPi();
				getWumpr();
				getSupp();
			}
		
		System.out.println(wumpp + " wumpus");
		System.out.println(pi + " " + pi2 + " pits");
		System.out.println(spid + " " + spid2 + " spiders");
		
		Scanner in = new Scanner(System.in);
		String inn;
		
		boolean move = false;
		
		while (!move)
		{
			System.out.println("You are in room " + room + ".");
			System.out.println("You have " + arrows + " arrows left.");
			System.out.println(getDesc());
			System.out.println("There are tunnels to rooms " + adrooms[room - 1] + ", " + adrooms[room] + ", and "
					+ adrooms[room + 1] + ".");
			System.out.println("Move or Shoot?");
			inn = in.nextLine();
			if (inn.equalsIgnoreCase("m") || inn.equalsIgnoreCase("move"))
			{
				System.out.println("Which room?");
				
				inn = in.nextLine();
				if (Integer.parseInt(inn) == adrooms[room - 1])
				{
					room = adrooms[room - 1];
					if (room == spid || room == spid2)
					{
						System.out.println("You were killed by the spiders!");
						move = true;
					}
					
					else if (room == wumpp)
					{
						System.out.println("You were eaten by the Wumpus.");
						move = true;
					}
					else if (room == pi || room == pi2)
					{
						System.out.println("You fell into a pit.");
						move = true;
					}
					else if ((wumpp == adrooms[room - 1]) || (wumpp == adrooms[room]) || (wumpp == adrooms[room + 1]))
					{
						System.out.println("You smell a nasty wumpus.");
					}
					else if (room == supp)
					{
						arrows = 3;
						System.out.println("You have entered the supply room.");
						System.out.println("You have " + arrows + " arrows.");
					}
				}
				else if (Integer.parseInt(inn) == adrooms[room])
				{
					room = adrooms[room];
					if (room == spid || room == spid2)
					{
						System.out.println("You were killed by the spiders!");
						move = true;
					}
					
					else if (room == wumpp)
					{
						System.out.println("You were eaten by the Wumpus.");
						move = true;
					}
					else if (room == pi || room == pi2)
					{
						System.out.println("You fell into a pit.");
						move = true;
					}
					else if ((wumpp == adrooms[room - 1]) || (wumpp == adrooms[room]) || (wumpp == adrooms[room + 1]))
					{
						System.out.println("You smell a nasty wumpus.");
					}
					else if (room == supp)
					{
						arrows = 3;
						System.out.println("You have entered the supply room.");
						System.out.println("You have " + arrows + " arrows.");
					}
				}
				else if (Integer.parseInt(inn) == adrooms[room + 1])
				{
					room = adrooms[room + 1];
					if (room == spid || room == spid2)
					{
						System.out.println("You were killed by the spiders!");
						move = true;
					}
					
					else if (room == wumpp)
					{
						System.out.println("You were eaten by the Wumpus.");
						move = true;
					}
					else if (room == pi || room == pi2)
					{
						System.out.println("You fell into a pit.");
						move = true;
					}
					else if ((wumpp == adrooms[room - 1]) || (wumpp == adrooms[room]) || (wumpp == adrooms[room + 1]))
					{
						System.out.println("You smell a nasty wumpus.");
					}
					else if (room == supp)
					{
						arrows = 3;
						System.out.println("You have entered the supply room.");
						System.out.println("You have " + arrows + " arrows.");
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
				if (Integer.parseInt(inn) == adrooms[room - 1])
				{
					arrows = arrows - 1;
					if (Integer.parseInt(inn) == wumpp)
					{
						System.out.println("Your arrow goes down the tunnel and hits its mark.");
						System.out.println("You shot the wumpus!");
						System.out.println("You win!. Enjoy your fame.");
						move = true;
					}
				}
				else if (Integer.parseInt(inn) == adrooms[room])
				{
					arrows = arrows - 1;
					if (Integer.parseInt(inn) == wumpp)
					{
						System.out.println("Your arrow goes down the tunnel and hits its mark.");
						System.out.println("You shot the wumpus!");
						System.out.println("You win!. Enjoy your fame.");
						move = true;
					}
				}
				else if (Integer.parseInt(inn) == adrooms[room + 1])
				{
					arrows = arrows - 1;
					if (Integer.parseInt(inn) == wumpp)
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
	
	public String getDesc()
	{
		description = desc[room - 1];
		return description;
	}
	
	public void getSpid()
	{
		spid = (int) (1 + r*Math.random());
		spid2 = (int) ( 1 + r*Math.random());
	}
	
	public void getWumpr()
	{
		wumpp = (int) (1 + r*Math.random());
	}
	
	public void getPi()
	{
		pi = (int) (1 + r*Math.random());
		pi2 = (int) ( 1 + r*Math.random());
	}
	
	public void getSupp()
	{
		supp = (int) (1 + r*Math.random());
	}
}
