import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AL_07_02_Rejs {

	public static void main(String[] args) throws IOException {
		
		//loading a number specifying the number of data lines
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		int numberOfLines = readInt(bufferRead);
		for(int i=0; i < numberOfLines ; i++)
		{
			int startX = readInt(bufferRead);
			int startY = readInt(bufferRead);
			int metaX = readInt(bufferRead);
			int metaY = readInt(bufferRead);
			int numberOfDays = readInt(bufferRead);
			String listOfWindsDirections="";
			while(listOfWindsDirections.equals(""))
			{
				listOfWindsDirections = bufferRead.readLine();
			}
			int distanceX = startX - metaX;
			int distanceY = startY - metaY;
			char whichDirectionX = '0' ;
			char whichDirectionY = '0' ;
			if(distanceX > 0 ) 
			{
				whichDirectionX = 'W';
			}else if (distanceX < 0)
			{
				whichDirectionX = 'E';
			}
			if(distanceY > 0 ) 
			{
				whichDirectionY = 'S';
			}else if (distanceY < 0)
			{
				whichDirectionY = 'N';
			}
			int actualDay=0;
			while((distanceX != 0 || distanceY!=0 ) && actualDay < numberOfDays)
			{
				switch(listOfWindsDirections.charAt(actualDay))
				{
				case 'W' :
					if( whichDirectionX == 'W' && distanceX!=0 )
					{
						distanceX--;
					}
					break;
				case 'E' :
					if( whichDirectionX == 'E' && distanceX!=0 )
					{
						distanceX++;
					}
					break;
				case 'S' :
					if( whichDirectionY == 'S' && distanceY!=0 )
					{
						distanceY--;
					}
					break;
				case 'N':
					if( whichDirectionY == 'N' && distanceY!=0 )
					{
						distanceY++;
					}
					break;
				}
				actualDay++;
			}
			if(distanceX == 0 && distanceY==0)
			{
				System.out.println(actualDay);
			}else 
			{
				System.out.println("NIE");
			}
			
		}
		

	}
	
	public static int readInt(BufferedReader br) throws IOException
	{
		//Load characters until there's a number (minus changes to negative)
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
		//Load numbers and create int until you encounter a different character
		while ( (znak >= '0' && znak <= '9'))
		{
			wynik = wynik * 10 + znak - '0';
			znak = br.read();
		}
		return wynik * znakLiczby;
	}

}
