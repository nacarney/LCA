import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {
	
	@Test  // test empty node constructor
	public void testEmptyNode() {
		new Node();
		 
	}
	
	@Test //test data-filled constructor
	public void testPopulatedNode() {
		new Node(5);
	}
	
	@Test
	public void testNodeInsertion() {
		
		BinaryTree testTree = new BinaryTree(); 
		testTree.root = new Node(20); 
		testTree.root.left = new Node(8); 
		testTree.root.right = new Node(22); 
		testTree.root.left.left = new Node(4); 
		testTree.root.left.right = new Node(12); 
		testTree.root.left.right.left = new Node(10); 
		testTree.root.left.right.right = new Node(14);
		
		assertEquals(" 4 8 10 12 14 20 22 ", 
				BinaryTree.printNodesInOrder(testTree.root));
	}
	
	@Test
	public void testLCA() {
		
		BinaryTree testTree1 = new BinaryTree(); 
		testTree1.root = new Node(12); 
		testTree1.root.left = new Node(11); 
		testTree1.root.right = new Node(13); 
		
		int n1 = 11, n2 = 13; 
		Node t = testTree1.lca(testTree1.root, n1, n2); 
		
		assertEquals(12, t.data);
		
		BinaryTree testTree2 = new BinaryTree(); 
		testTree2.root = new Node(15); 
		testTree2.root.left = new Node(12); 
		testTree2.root.right = new Node(18); 
		
		n1 = 14; 
		n2 = 8; 
		t = testTree2.lca(testTree2.root, n1, n2); 
		
		assertEquals(12, t.data);
	}
	
	@Test 
	public void testIncorrectNodeData() {
		
	}

}
