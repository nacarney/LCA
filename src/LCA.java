import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


// Recursive Java program to print lca of two nodes 

class Node 
{ 
	int data; 
	Node left, right;

	Node(int item) 
	{ 
		if(item>=0)
		{
		data = item; 
		left = right = null; 
		}
	} 
	
	Node()
	{
		data = -1;
		left = right = null;
	}
} 

class BinaryTree 
{ 
	Node root; 
	
	/* Function to find LCA of n1 and n2. The function assumes that both 
	n1 and n2 are present in BST */
	Node lca(Node node, int n1, int n2) 
	{ 
		if (node == null) 
			return null; 

		// If both n1 and n2 are smaller than root, then LCA lies in left 
		if (node.data > n1 && node.data > n2) 
			return lca(node.left, n1, n2); 

		// If both n1 and n2 are greater than root, then LCA lies in right 
		if (node.data < n1 && node.data < n2) 
			return lca(node.right, n1, n2); 

		return node; 
	} 
	
	
	    public static String printNodesInOrder(Node node) {
    	
    	if(node != null) {
    	return printNode(node);
    	}
    	else{
    		return "";
    	}
    }
    
     public static String printNode(Node node)
     {
    	if(node == null)
    	{
    		return "";
    	}
    	else if(node.left == null && node.right == null)
    	{
    		return " "+ Integer.toString(node.data) + " ";
    	}
    	else
    	{
    		return "" + printNode(node.left) + Integer.toString(node.data) +
    				printNode(node.right) + "";
    	}
    }
}

class Dag
{
	private int Vertices; 
	private int Edges;
	private ArrayList<Integer>[] adjacencyList;
	private int [] inDegree;
	private int outDegree;
	private boolean marked [];
	private boolean hasCycle;
	private boolean stack [];
	
	public Dag(int vertices)
	{
		if(vertices<0)
		{
			throw new IllegalArgumentException("Number of vertices in graph must not be less than 0");
			
		}
		
		this.Vertices = vertices;
		this.Edges = 0;
		inDegree = new int[Vertices];
		marked = new boolean[Vertices];
		stack = new boolean[Vertices];
		adjacencyList = (ArrayList<Integer>[]) new ArrayList[Vertices];
		
		for(int v = 0; v<Vertices; v++)
		{
			adjacencyList[v] = new ArrayList<Integer>();
		}
	}
	
	public int Vertices()
	{
		return Vertices;
	}
	
	public int Edges()
	{
		return Edges;
	}
}



// This code has been contributed by Mayank Jaiswal 
