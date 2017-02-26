public class Word
{
	static String showLetters(String word, String guesses)
	{
		String output = "";
		for(int i = 0; i < word.length(); i++)
		{
			int j = 0;
			while(j < guesses.length()&&!word.substring(i, i+1).equals(guesses.substring(j,j+1)))
				j++;
			if(j == guesses.length())
				output += "_";
			else 
				output += word.substring(i, i+1);
		}
		return output;
	}
}
