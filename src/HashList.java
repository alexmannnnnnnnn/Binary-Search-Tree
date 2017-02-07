

public class HashList
{
	int wordCount;     // The Number of total words is stored
	int length;        // The number of distinct words is stored 
	long compare;      // The number of comparisons made is kept track of
	int ref;           // The number of references made is stored
    Node[] hashArray = new Node[256];
  public void addHashList(String word)
  {
	  //This method creates the hash list
	  // After the word is hashed, the location equal to its ASCII value is found
	  // The list in that location will make the word being checked the first word in the list if it is empty
	  // If that word is found in the list, the count for that word is incremented
	  // Words not matching any other word will be placed at the front of the list
	compare++;               // compare is incremented due to a comparison being made
	if(word.equals("$$"))	 // When the $$ is found equal to the input string there was a word made of symbols
	{
		return;
	}
	wordCount++;             // A word is found and added to the word count
	int location = hash(word);
	compare++;               // compare is incremented due to a comparison being made
	if(hashArray[location] == null)  // Location in the array is null
	{
			hashArray[location] = new Node(word, null); // Make a new node with the word and its link null and add to the null location
			ref++;                       // Reference is incremented due to a reference change
			return;
	}	
	compare++;               // compare is incremented due to a comparison being made
    if(hashArray[location] != null) // The location in the array is not null
	{
	  Node nodePointer;  // The pointer is made 
	  nodePointer = hashArray[location];  // The pointer is equal to the location in the array
	  compare++;               // compare is incremented due to a comparison being made
		while(nodePointer != null)  //The pointer is not null
		{
     	  compare++;               // compare is incremented due to a comparison being made
		  if(nodePointer.getVal().compareTo(word) == 0)  // The pointer and the string have the same value
		  {
	 		nodePointer.incrementCount();     // Increment the count for that word
			return;
		  }
		  nodePointer = nodePointer.getLink();   // The pointer is equal to the pointer's link to traverse the list
		}
	  Node beginNode = new Node(word, hashArray[location]); // The word was not found equal and is put in a new node at the beginning of the list with a link the the location in the array
	  ref++;                       // Reference is incremented due to a reference change
	  hashArray[location] = beginNode;
	  ref++;                       // Reference is incremented due to a reference change
	  return;
	}
  }
  public HashList(){}            // HashList 1 default constructor
  public int hash(String toHash)  
  {
	  // The hash function takes the total ASCII value of the word
	  // This value is then mod 256 to find the location in the array where it belongs
	  int word = 0;            // The word being hashed is initialized
	  int sumOfWord = 0;      // The sum of each letter is added here
	  for( int i =0; i<toHash.length(); i++) // Loop to go through each letter in the word
	  {
		   word = toHash.charAt(i);     // Get the character's value of each letter in the word
		   sumOfWord += word;           // Each value is added to the sum of the word
	  }
	  return (sumOfWord % 256);         // The word value is mod 256 and the value it will have in the array is found
  }

  public void printHashList()  
  { 
	// The hash list  is printed
	// Only the first hundred words are printed
    // Each word's count is also printed 
		int b = 0;     // b is initialized to make sure every all location's lists are used to get the length        
		int c = 0;     // c is initialized to make sure every all location's lists are printed and counts displayed     
		int d = 0;     // d is initialized to make sure that only the first hundred words are printed
		while(b<256)   // b is less than 256
	{
		Node pointer3 =hashArray[b];    // Pointer 3 is equal to the location in the list being incremented
		while(pointer3 != null)         // Pointer 3 is not null
		{
			length++;  // The length counter is incremented;
		    pointer3 = pointer3.getLink(); // Pointer 3 is equal the the link of itself in order to traverse the list
	           
		}	
		 b++;    // b is incremented to go through the array
	}
			printStats();   // The statistics length, compare,word count, and references are printed 
			System.out.println();  // Print a new line
			while(c<256 && d<100)  // c is less than 256 and d is less than 100
			{
			    Node pointer2 = hashArray[c];  // Pointer 2 is equal to the location in the list being incremented
				while(pointer2 != null)	   // Pointer 2 is not null
				{
					System.out.println( pointer2.getVal()+ "*"+ pointer2.getCount()); // Pointer 2's value and number of times its value appeared are printed
					pointer2 = pointer2.getLink();  // Pointer 2 is equal the the link of itself in order to traverse the list
					if(d == 99)            // Check when d is equal to 99. The first hundred words will be printed.
				    {
				    	return;
				    }
				 d++;  // Increment counter for the first hundred words
				}
		     c++;     // Increment through the array to get all words in each list
				
			}
				 
  }
  /*public void printIndex()        // This was used to get the number of words in each index
  {
	  Node nodePointer4;     
	  for( int l =0; l<hashArray.length; l++) 
	  {
		   nodePointer4 = hashArray[l];  
		   int sumOfWord = 0; 
		   while(nodePointer4 != null)
		   {
			   nodePointer4 = nodePointer4.getLink();
			   sumOfWord++;
		   }
		   //System.out.print(l+"\n");
		   System.out.print(sumOfWord+"\n");
		   //System.out.print(l+" : "+sumOfWord+"\n");
	  }
  } */
  public void printStats()
	{
		//All of the statistics are printed for each list
		System.out.println("WordCount:" + wordCount);    // The total number of words are printed
		System.out.println("Distinct Words:" + length);          // The number of distinct words are printed
		System.out.println("Compare:" + compare);        // The total number of comparisons made are printed
		System.out.println("References:" + ref);         // The total number of references are printed
	}
  
  private class Node      // The node is made
	{
	private int count;   // The word count is held
	private Node link;  // This is the Link for the node
	private String val; // This is the value which is an object

	public Node(String v, Node l) // Node is created
		{
			count=1;           // Start count at 1
			val=v;             // Value is initialized 
			link=l;	           // Link is initialized
		}
	public int getCount()     // The count is returned
	{
		return count;         // return count;
	}
	public int incrementCount()  // The count is incremented for the specific word
	{
		return count++;         // return incremented count;
	}
	public Node getLink()    // This method returns the link
		{
		   return link;           // return link
		}
	public String getVal()  // This method returns the value
		{
		   return val;          //return value
		}
	}
}
