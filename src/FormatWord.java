
public class FormatWord
{
	public String formatWord(String format)
    {
	  // Words that either have a punctuation in the front of the word or behind the word have to be removed 
	  // The words should only contain letters and number at their front or back
	  // Words can have punctuation inside them is good as long as there are letters on both sides of them
	  // A special case is covered when a trim results in no letters or numbers
	  // That space is set to $$ and covered in its own case 
	
	String letters = "abcdefghijklmnopqrstuvwxyz9876543210"; // String contains a-z and 0-9 for comparisons
	while(format.length() !=0 && (!letters.contains(""+format.charAt(0)) || !letters.contains(""+format.charAt(format.length() - 1))))
		// The string length cannot be zero and either at the beginning of the string there are no letters 
		// or at the end of the string there are no letters
	{
		String holder =  ""; // a blank string is made as a holder
		if(!letters.contains(""+format.charAt(0))) // There are no letters at the beginning of the string
		{
			for(int f=1; f<format.length(); f++ ) // Increment at the beginning of the string to get rid of non numbers/letters
			{
				 holder += format.charAt(f);      // Add the string with the trim at the front to the holder
			}
			format = holder;                      // The string is equal to the holder
		}
		holder = "";                                // a blank string is made as a holder
		if( format.length() !=0 && !letters.contains(""+format.charAt(format.length() - 1)))
		{
			for(int b=0; b<format.length()-1; b++ )   // Increment at the end of the string to get rid of non numbers/letters
			{
				 holder += format.charAt(b);          // Add the string with the trim at the end to the holder
			}
			format = holder;                      // The string is equal to the holder
		}
	}
		if(format.length() == 0)                 // There was trimming done that did not result in a word
		{
			format = "$$";                       // The string equals $$ and is a special case
		}
	return format;
	}
}
