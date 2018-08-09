import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AL_12_01_Winda {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		int numberOfLines = readInt(bufferRead);
		for(int i =0; i< numberOfLines ; i++)
		{
			int numberOfFloors = readInt(bufferRead);
			String listOfMoves="";
			while(listOfMoves.equals(""))
			{
				listOfMoves = bufferRead.readLine();
			}
			int startFloor = 1;
			while(startFloor <= numberOfFloors)
			{
				int actualFloor = startFloor;
				int counter =0;
				do
				{
					if(listOfMoves.charAt(counter) == 'U')
					{
						actualFloor++;
					}else
					{
						actualFloor--;
					}
					counter++;
				}while (actualFloor > 0 && actualFloor <= numberOfFloors && counter < listOfMoves.length() );
				if(counter == listOfMoves.length() && actualFloor > 0 && actualFloor <= numberOfFloors)
				{
					System.out.println("TAK");
					break;
				}
				startFloor++;
				if(startFloor==numberOfFloors)
				{
					System.out.println("NIE");
				}
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
