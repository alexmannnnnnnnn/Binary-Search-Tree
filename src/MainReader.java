//Date December: 9, 2016
//Author: Alex Banus - EECS 2500
// This program creates a hash list and a binary search tree for a file being read
// The hash list takes the word's total ASCII value, mods by 256, and makes that value the location in the array
// The array has 256 locations. Each will have a list of words with that location's value
// This list will not be alphabetized, but will have all the words starting with the first letter of the word in that list
// The binary search tree will be a tree of all the words alphabetized.
// The tree is traversed to print all of the words
// All punctuation is removed from the front and back of the input words.
// Statistics are printed out for each list
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainReader
{
	final static String FILE_NAME = "E:\\Hamlet.txt"; // The file for creating lists can be selected here
	public static void main(String[] args)
	{
		// Main has the variables for files input and end and start times of the runtime
		// Files can be read in main
		// All words are formatted to lower case and all punctuation is removed from the front and back of the words 
		// Both lists are printed out with their statistics:Distinct words, references, time, and comparisons
		
		Scanner fileIn0 = null; // The variable that holds in the scanned in file for the first pass
		Scanner fileIn6 = null; // The variable that holds in the scanned in file for the Hash list
		Scanner fileIn7 = null; // The variable that holds in the scanned in file for the Binary Search Tree
		String textIn = "";     // The empty string to hold the formatted input file
		long fileInStart;       // The time is taken for each of the while loops and held here
		long fileInEnd;         // The time is taken after each of the while loops  and held here
		long firstPassTotalTime;// The total time is kept for the first pass
		long fileIn6Total;      // The total time is kept for the Hash list 
		long fileIn7Total;      // The total time is kept for Binary Search Tree
		try
		{
		fileIn0 = new Scanner(new File(FILE_NAME));  // The file is scanned in for the first pass and given to a variable
		}
		catch(FileNotFoundException f)              // There was a file not found and was caught
		{
			System.out.print("File was not Found\n");  // The file was not found when there is no file specified
			System.exit(0);
		}
		try
		{
		fileIn6 = new Scanner(new File(FILE_NAME)); // The file is scanned in for the Hash list1 and given to a variable
		}
		catch(FileNotFoundException f)         // This shouldn't be needed because the first catch block should cover this
		{
			System.out.print("File was not Found\n");  // The file was not found when there is no file specified
		}
		try
		{
		fileIn7 = new Scanner(new File(FILE_NAME)); // The file is scanned in for the Hash list2 and given to a variable
		}
		catch(FileNotFoundException f)         // This shouldn't be needed because the first catch block should cover this
		{
			System.out.print("File was not Found\n");  // The file was not found when there is no file specified
		}
		
		
		HashList hL = new HashList();    // A new list is made to hold the Hash list 
		BinarySearchTree BST = new BinarySearchTree();    // A new list is made to hold the Binary Search Tree
		FormatWord fW = new FormatWord();       // A new list is made to hold the formatted word
		fileInStart = (System.currentTimeMillis());  // The time is taken for the while loop
		while(fileIn0.hasNext())                     // Check the file for the next item
		{
			textIn = fileIn0.next().toLowerCase();   // Change all of the file input to lower case
			textIn = fW.formatWord(textIn);          // Remove all punctuation from the file input
		}
		fileInEnd = (System.currentTimeMillis());    // The time is taken after the while loop
		firstPassTotalTime = (long) ((fileInEnd - fileInStart)); // The total time is found by subtracting the loop time from the end time
		System.out.println("First Pass Time Through:" + ((firstPassTotalTime) / (1000.0)) + " Seconds");	// The total time is divided by 1000.0 to get seconds
		
		fileInStart  = (System.currentTimeMillis());    // The time is taken for the while loop
	    while(fileIn6.hasNext())                        // Check the file for the next item
		{
			textIn = fileIn6.next().toLowerCase();      // Change all of the file input to lower case
			textIn = fW.formatWord(textIn);             // Remove all punctuation from the file input
			hL.addHashList(textIn);  // The text is stored in the Self Adjusting One Node List 
		}
	     fileInEnd = (System.currentTimeMillis());     // The time is taken after the while loop
		 fileIn6Total = ((fileInEnd - fileInStart));  // The total time is found by subtracting the loop time from the end time
		 System.out.println("\nHash List ");  // The Self Adjusting One Node List label is printed
		 System.out.println("\nHash List  Time Through:" + ((fileIn6Total) / (1000.0)) + " Seconds");  // The total time is divided by 1000.0 to get seconds
		 hL.printHashList();           // The Hash List is printed
		 
		 fileInStart  = (System.currentTimeMillis());    // The time is taken for the while loop
		 while(fileIn7.hasNext())                        // Check the file for the next item
		{
			textIn = fileIn7.next().toLowerCase();      // Change all of the file input to lower case
			textIn = fW.formatWord(textIn);             // Remove all punctuation from the file input
			BST.addToTree(textIn);  // The text is stored in the Binary Search Tree 
		}
	     fileInEnd = (System.currentTimeMillis());     // The time is taken after the while loop
		 fileIn7Total = ((fileInEnd - fileInStart));  // The total time is found by subtracting the loop time from the end time
		 System.out.println("\nBinary Search Tree");  // The Binary Search Tree label is printed
		 System.out.println("\nBinary Search Tree Time Through:" + ((fileIn7Total) / (1000.0)) + " Seconds");  // The total time is divided by 1000.0 to get seconds
		 BST.printBST();           // The Binary Search Tree is printed

	}
}
