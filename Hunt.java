package theWumpus;

import java.io.*;

public class Hunt
{
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Rooms hi = new Rooms();
		
		System.out.println(hi.getRoom());
		System.out.println(hi.getDesc());
		hi.getWumpus();
	}
}
