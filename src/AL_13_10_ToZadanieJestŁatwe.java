import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

public class AL_13_10_ToZadanieJest£atwe {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		int numberOfLines = readInt(bufferRead);
		for(int i =0 ; i < numberOfLines ; i++)
		{
			String firstWord = "";
			String secondWord = "";
			firstWord = readString(bufferRead);
			secondWord = readString(bufferRead);
			boolean isTheSecondWordMatch = false;
			if(secondWord.length() <= firstWord.length())
			{
				int actualIndexOfFirstWord = 0;
				int actualIndexOfSecondWord = 0;
				while(actualIndexOfFirstWord < firstWord.length() && isTheSecondWordMatch == false)
				{
					if(firstWord.charAt(actualIndexOfFirstWord) == secondWord.charAt(actualIndexOfSecondWord))
					{
						actualIndexOfSecondWord++;
						if(actualIndexOfSecondWord==secondWord.length())
						{
							isTheSecondWordMatch = true;
						}
					}
					actualIndexOfFirstWord++;
					if(firstWord.length()-actualIndexOfFirstWord < secondWord.length()-actualIndexOfSecondWord) 
					{
						//konczymy sprawdzanie 
						actualIndexOfFirstWord = firstWord.length();
					}
				}
			}
			if(isTheSecondWordMatch == true)
			{
				System.out.println("Tak");
			}else
			{
				System.out.println("Nie");
			}
		}

	}
	
	public static String readString(BufferedReader br) throws IOException
	{
		char znak;
		String word="";
		do 
		{
			znak = (char)br.read();
		} while (znak < 'A' || znak > 'Z');
		while((znak >= 'A' && znak <= 'Z'))
		{
			word+=znak;
			znak=(char)br.read();
		}
		return word;
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
