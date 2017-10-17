package theWumpus;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Rooms
{
	private int arrows = 3;
	//private boolean bats;
	private int room;
	private String description;
	private boolean spiders;
	private boolean wumpus;
	private boolean pit;
	private int n;
	int[] rooms;
	String[] desc;
	String[] adjrooms;
	
	String[] ajrooms = adjrooms;
	
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
		
		//int[] adrooms = Arrays.stream(adjrooms).mapToInt(Integer::parseInt).toArray();
		
		//for (int i = 0; i < adjrooms.length; i++)
		//{
			
		//}
		
		room = rooms[0];
		//System.out.println("The adjacent rooms are" + adjrooms[0]);
	}
	
	public int getArrows()
	{
		return arrows;
	}
	
	public String getAdjRooms()
	{
		return adjrooms[room - 1];
	}
	
	public int getRoom()
	{
		
		return room;
	}
	
	public String getDesc()
	{
		description = desc[room - 1];
		return description;
	}
	
	public boolean getSpiders()
	{
		return spiders;
	}
	
	public void getWumpus()
	{
		//int ranro = (int) (1 + n*Math.random());
		int ranro = 2;
		String raro = Integer.toString(ranro);
		if (ranro == 1)
		{
			getWumpus();
		}
		for (int i = 0; i < n; i++)
		{
			if (room == ranro)
			{
				System.out.println("You were eaten by the Wumpus.");
				//return wumpus;
			}
			else if (raro == adjrooms[room - 1])
			{
				System.out.println("You smeel a nasty wumpus.");
			}
		}
	}
	
	public boolean getPit()
	{
		return pit;
	}
	
}
