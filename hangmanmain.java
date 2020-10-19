import java.io.Console;
import java.util.Scanner;
public class hangmanmain
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		//Console hide = System.console();
		//char [] word_array = hide.readPassword("Enter a word: "); //the word you're meant to guess
		String word = "dog"; 
		char[] word_array = word.toCharArray();
		int unique_letters = uniqueLetters(word_array);
		int guesses_amount_allowed = 5 + unique_letters; //6 wrong guesses are allowed
		char [] guesses_array = new char[guesses_amount_allowed]; //a string of all guesses
		int letter_count = 0;
		int correct_guesses = 0;
		int wrong_guesses = 0;
		String letters_discovered ;
		System.out.println("The word is");
		while(!(correct_guesses == unique_letters))
		{
			letters_discovered = showLetters(word,guesses_array);
			System.out.println(letters_discovered);
			System.out.println("Guess a letter:");
			guesses_array[letter_count] = in.next().charAt(0); //if you type in more than 1 letter, it will just accept the first, improve later?
			letter_count++;
			if (letters_discovered != showLetters(word,guesses_array)) // was the last guess correct?
				correct_guesses ++;
			else
				wrong_guesses ++;
		}
		System.out.println(word);
		System.out.println("Well Done, the word was "+ word + ".");
	}

	

	static String showLetters(String word, char [] guesses)
	{
		String output = "";
		for(int i = 0; i < word.length(); i++)
		{
			int j = 0;
			while(j < guesses.length&&!(word.charAt(i)==guesses[j]))
				j++;
			if(j == guesses.length)
				output += "_";
			else 
				output += word.charAt(i);
		}
		return output;
	}
	

	static int uniqueLetters(char [] word)
	{
		int uniqueLetters = 0;
		for(int i = 0;i<word.length;i++)
		{
			int j = i+1;
			while(j<word.length)
			{
				if(word[i] == word[j])
					{
					uniqueLetters --;
                                        break;
					}
				j++;
			}
		uniqueLetters++;
		}
		return uniqueLetters;
	}

}

   // ___________
   // |         |
  //  |         O
  //  |        /|\  
  //  |         |
//    |        / \
//____|____

