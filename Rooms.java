package theWumpus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.lang.NumberFormatException;

public class Rooms
{
	private int arrows = 3;
	private int room;
	private String description;
	private int r;
	private int[] rooms;
	private String[] desc;
	private String[] adjrooms;
	
	private String output;
	private String[] strarr;
	private int[] adrooms;
	
	private int wumpp;
	private int spid;
	private int spid2;
	private int pi;
	private int pi2;
	private int supp;
	private int a;
	private int b;
	private int c;
	
	public Rooms() throws FileNotFoundException
	{
		Scanner cave = new Scanner(new FileReader("Wumpus.txt"));
		
		r = cave.nextInt();
		
		//System.out.println(r);
		
		//System.out.println(r + " " + s + " " + p);
		
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
		getWumpp();
		getSpid();
		getPi();
		getSupp();
		
		int j;
		int l;
		
		System.out.println("Test");
		
		while ((spid == pi) || (spid == spid2) || (spid2 == pi2) || (spid == pi2)
				|| (spid2 == pi) || (spid == wumpp) ||(spid2 == wumpp) || (pi2 == wumpp)
				|| (pi == wumpp) || (spid == 1) || (spid2 == 1) || (pi == 1) ||(pi2 == 1)
				|| (wumpp == 1) || (pi == pi2) || (supp == spid2) || (supp == spid)
				|| (supp == pi2) || (supp == pi) || (supp == wumpp))
			{
				getSpid();
				getPi();
				getWumpp();
				getSupp();
			}
		
		//System.out.println(spid);
		//System.out.println(spid2);
		//System.out.println(pi);
		//System.out.println(pi2);
		System.out.println(wumpp + " wump");
		System.out.println(supp + " supp");
		
		
		Scanner in = new Scanner(System.in);
		String inn;
		
		a = adrooms[room - 1];
		b = adrooms[room];
		c = adrooms[room + 1];
		
		boolean move = false;
		
		while (move)
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
				}
				else if (Integer.parseInt(inn) == b)
				{
					room = b;
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
				}
				else if (Integer.parseInt(inn) == c)
				{
					room = c;
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
					if (Integer.parseInt(inn) == wumpp)
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
					if (Integer.parseInt(inn) == wumpp)
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
	
	public String getAdjRooms()
	{
		return adrooms[room - 1] + ", " + adrooms[room] + ", and " + adrooms[room + 1];
	}
	
	public String getDesc()
	{
		description = desc[room - 1];
		return description;
	}
	
	//int calc = (int) (1 + rooms.length*Math.random());
	
	public void getSpid()
	{
		spid = (int) (1 + r*Math.random());
		spid2 = (int) ( 1 + r*Math.random());
	}
	
	public void getPi()
	{
		pi = (int) (1 + r*Math.random());
		pi2 = (int) ( 1 + r*Math.random());
	}
	
	public void getWumpp()
	{
		wumpp = (int) (1 + rooms.length*Math.random());
	}
	
	public void getSupp()
	{
		supp = (int) (1 + rooms.length*Math.random());
	}
}
