
public class BinarySearchTree
{
	
	int wordCount;     // The Number of total words is stored
	int length;        // The number of distinct words is stored 
	long compare;      // The number of comparisons made is kept track of
	int ref;           // The number of references made is stored
    Node root;         // The root of the tree is made
    int fellOffChecker;  // This is given a value to check where a word goes in the tree
 public void binarySearchTree() //constructor
 {
	root = null;              // the root is null
 }
public void addToTree(String word)
{
	//This method adds nodes to the binary search tree
	//When the root is null, a new node is a made for the root
	//A section of the tree is traversed to see where the new node should go
	//When the word is found somewhere in the tree, their count is incremented
	//If the node pointer falls of the tree, the lag pointer is used to place a node at the bottom of the tree
	if(root == null)          // The root is null
	{
		
		Node newRootNode = new Node(word);    // Make a new node for the root
		newRootNode.incrementCount();         // Increment the count of that word
		root = newRootNode;                   // root is equal to the new root node
		ref++;  // Reference is incremented due to a reference change
		return;
	}
	compare++;              // Compare is incremented due to a comparison being made
	if(word.equals("$$"))	// When the $$ is found equal to the input string there was a word made of symbols
	{
		return;
	}
	 Node nodePointer = root;     // Pointer is equal to the root
	 Node lagPointer = null;      // The lag pointer lags behind the node pointer
	 while(nodePointer != null)   // The Pointer is not null
	 {
		 lagPointer = nodePointer;  // Lag pointer is equal to the pointer
		 compare++;              // Compare is incremented due to a comparison being made
		 if(word.compareTo(nodePointer.getInfo()) < 0)   // The string is compared to the pointer and is less than it
		 {
			 nodePointer = nodePointer.left;             // The pointer is equal to the left child of the pointer
			 fellOffChecker = -1;                        // The checker is set to -1 to later check if a word should be placed to the left
			 continue;
		 }
		  compare++;              // Compare is incremented due to a comparison being made
		  if(word.compareTo(nodePointer.getInfo()) > 0)   // The string is compared to the pointer and is greater than it
		 {
			 nodePointer = nodePointer.right;            // The pointer is equal to the right child of the pointer
			 fellOffChecker = 1;                         // The checker is set to 1 to later check if a word should be placed to the right
			 continue;
		 }
		  compare++;              // Compare is incremented due to a comparison being made
		  if(word.compareTo(nodePointer.getInfo()) == 0)    // The string is compared to the pointer and is equal to it
		 {
			 nodePointer.incrementCount();            // Increment the count of the node pointer
			 return;
		 }
		 
	 }
	 Node newNode = new Node(word);                 // Create a new node to add to the tree
	 newNode.incrementCount();                      // Increment the count of that node
	 if(fellOffChecker < 0)                         // The checker is less than 0
	 {
		 lagPointer.left = newNode;                 // The new node is equal to the left child of the lag pointer
		 ref++;                                     // Reference is incremented due to a reference change
		 
	 }
	  if(fellOffChecker > 0)                       // The checker is greater than 0
	 {
		 lagPointer.right = newNode;               // The new node is equal to the right child of the lag pointer
		 ref++;                                    // Reference is incremented due to a reference change
	 }
	 
}
public void traverse()      
{
	//The length and word count and distinct words are set
	// The traverse with root being passed is called
	length = 0;                // Length is set zero 
	wordCount = 0;             // Word count is set to zero
	traverse(root);            // The root is traversed
}
private void traverse(Node node) 
{
	// The entire tree is traversed to the distinct words and number of total words
	if (node.left !=null) traverse(node.left);        // The left node is not null, traverse the left child
    length++;                                         // The length counter is incremented;
    wordCount+=node.getCount();                       // The word count is equal to the count of each node
	if (node.right !=null) traverse(node.right);      // The right node is not null, traverse the right child
}

public void printBST()
{
	// The Binary Search Tree is printed
	// Each word's count is also printed
	// These are done by traversing the tree
    traverse();
	printStats();    // The statistics length, compare,word count, and references are printed 
	System.out.println();  // Print a new line
	recursivePrint(root);   // The root is recursively printed
	
}
public void recursivePrint(Node node)
{
	// The tree is printed
	if (node.left !=null) recursivePrint(node.left);              // The left node is not null, recursively print the left child
	System.out.println( node.getInfo()+ "*"+ node.getCount());   // Root and number of times its value appeared are printed
	if (node.right !=null) recursivePrint(node.right);           // The right node is not null, recursively print the right child
}
public void printStats()
{
	//All of the statistics are printed for each list
	System.out.println("WordCount:" + wordCount);   // The total number of words are printed
	System.out.println("Distinct Words:" + length);        // The number of distinct words are printed
	System.out.println("Compare:" + compare);     // The total number of comparisons made are printed
	System.out.println("References:" + ref);    // The total number of references are printed
}
 private class Node     // The node is made
  {
	private int count;        // The word count is held
	private String info;      // The information string is made
	private Node left;        // The left child is made
	private Node right;       // The right child is made
	public Node(String info)
	{
		this.info = info;       // Info is set
		left =null;             // The left child is null
		right = null;           // The right child is null
	}
	
	public String getInfo()          // Method to return the info for the node
	{
		return info;                 // Return the information
	}
	public int incrementCount()    // The count is incremented for the specific word
	{
		return count++;              // return incremented count;
	}
	public int getCount()       // The count is returned
	{
		return count;            // return count;
	}
   }
 
}
