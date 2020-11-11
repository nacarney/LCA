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

	// This code has been contributed by Mayank Jaiswal 
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

	private int validateVertex(int v)
	{
		if(v < 0 || v >= Vertices)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}

	public void addEdge(int v, int w)
	{
		if((validateVertex(v) > 0) && (validateVertex(w) >0))
		{
			adjacencyList[v].add(w);
			inDegree[w]++;
			Edges++;
		}
		else
		{
			System.out.println("Please only enter numbers greater than 0 and less than "
					+ (Vertices - 1));
		}
	}

	public int inDegree(int v)
	{
		if(validateVertex(v) >0)
		{
			return inDegree[v];
		}
		else
		{
			return -1;
		}
	}

	public int outDegree(int v)
	{
		if(validateVertex(v) > 0)
		{
			return adjacencyList[v].size();

		}
		else
		{
			return -1;

		}
	}

	public Iterable<Integer> adjacencyList(int v)
	{
		return adjacencyList[v];
	}

	public boolean hasCycle()
	{
		return hasCycle;
	}

	public void findCycle(int v)
	{
		marked[v] = true;
		stack[v] = true;

		for(int w : adjacencyList(v))
		{
			if(!marked[w])
			{
				findCycle(w);
			}
			else if(stack[w])
			{
				hasCycle = true;
				return;
			}
		}
		stack[v] = false;
	}

	public int findLCA(int v, int w)
	{
		findCycle(0);

		if(hasCycle)
		{
			return -1;
		}
		else if(validateVertex(v) < 0 || validateVertex(w) < 0)
		{
			return -1;
		}
		else if(Edges == 0)
		{
			return -1;
		}

		Dag reverse = reverse();

		ArrayList<Integer> firstArray = reverse.BFS(v);
		ArrayList<Integer> secondArray = reverse.BFS(w);
		ArrayList<Integer> commonAncestors = new ArrayList<Integer>();

		boolean foundLCA = false;

		for(int i = 0; i< firstArray.size(); i++)
		{
			for(int j=0; j<secondArray.size(); j++)
			{
				if(firstArray.get(i) == secondArray.get(j))
				{
					commonAncestors.add(firstArray.get(i));
					foundLCA = true;
				}
			}
		}

		if(foundLCA)
		{

			return commonAncestors.get(0);
		}
		else {
			return -1;
		}
	}

	public ArrayList<Integer> BFS(int s){
		ArrayList<Integer> order = new ArrayList<Integer>();
		boolean visited[] = new boolean[Vertices];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while(queue.size() != 0)
		{
			s = queue.poll();
			order.add(s);

			Iterator<Integer> i = adjacencyList[s].listIterator();

			while(i.hasNext())
			{
				int n = i.next();
				if(!visited[n])
				{
					visited[n] = true;
					queue.add(n);
				}
			}


		}
		return order;

	}

	public Dag reverse()
	{
		Dag reverse = new Dag(Vertices);
		for(int v = 0; v < Vertices; v++)
		{
			for(int w : adjacencyList(v))
			{
				reverse.addEdge(w, v);
			}
		}
		return reverse;
	}
}




