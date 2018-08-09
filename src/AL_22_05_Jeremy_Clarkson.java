import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class AL_22_05_Jeremy_Clarkson {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		int numberOfClients = readInt(bufferRead);
		Vector <Point> tableOfAdresses = new Vector <Point>(numberOfClients);
		for(int i = 0; i < numberOfClients ; i++)
		{
			tableOfAdresses.add(new Point(readInt(bufferRead),readInt(bufferRead)));
		}
		for(int i = 0; i < numberOfClients ; i++)
		{
			int startPoint_index = i;
			do
			{
				double angle = calculateAngle3Points(tableOfAdresses.elementAt(i),tableOfAdresses.elementAt(i+1),tableOfAdresses.elementAt(i+2));
				if(angle < 180)
				{
					
				}
			}while(;);
		}
		

	}
	
	public static boolean calculateAngle3Points(Point a , Point b , Point c)
	{
		double angleAB = calculateAngle(a,b);
		double angleBC = calculateAngle(b,c);
		double angle = 360 - angleBC - (180 - angleAB);
		if(angle <180) 
		{
			calculateAngle3Points
			return true;
		}
		return false;
	}
	
	public static double calculateAngle(Point a, Point b)
	{
	    double angle = Math.toDegrees(Math.atan2(b.y - a.y, b.x - a.x));
	    // Keep angle between 0 and 360
	    angle = angle + Math.ceil( -angle / 360 ) * 360;
	    return angle;
	}
	
	
	
	public static int readInt(BufferedReader br) throws IOException
	{
		//Wczytywaj znaki (spacje, entery i takie tam) az bedzie jakas cyfra (minus zmienia na ujemna)
		int znak;
		int wynik = 0;
		int znakLiczby = 1;
		do 
		{
			znak = br.read();
			if (znak == '-')
			{
				znakLiczby = -1;
				continue;
			}
		} while (znak < '0' || znak > '9');
		wynik = 0;
		//Wczytywaj cyfry i tworz inta, az napotkasz inny znak
		while ( (znak >= '0' && znak <= '9'))
		{
			wynik = wynik * 10 + znak - '0';
			znak = br.read();
		}
		return wynik * znakLiczby;
	}
}

class Point {
	public int x;
	public int y;
	
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
