import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AL_07_02_Rejs {

	public static void main(String[] args) throws IOException {
		//Scanner input = new Scanner(System.in);
		//wczytywanie liczby okreslajacej ilosc linii danych
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		int number_of_lines = readInt(bufferRead);
		for(int i=0; i < number_of_lines ; i++)
		{
			int startX = readInt(bufferRead);
			int startY = readInt(bufferRead);
			int metaX = readInt(bufferRead);
			int metaY = readInt(bufferRead);
			int number_of_days = readInt(bufferRead);
			String list_of_winds_directions="";
			while(list_of_winds_directions.equals(""))
			{
				list_of_winds_directions = bufferRead.readLine();
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
			while((distanceX != 0 || distanceY!=0 ) && actualDay < number_of_days)
			{
				switch(list_of_winds_directions.charAt(actualDay))
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
