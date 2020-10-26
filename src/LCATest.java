import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {
	
	@Test  // test constructor
	public void testConstructor() {
		new Node(5);
	}
	
	@Test
	public void testprintNodesInOrder() {
		
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
	public void testLCAOutput1() {
		
		BinaryTree testTree1 = new BinaryTree(); 
		testTree1.root = new Node(12); 
		testTree1.root.left = new Node(11); 
		testTree1.root.right = new Node(13); 
		
		int n1 = 11, n2 = 13; 
		Node t = testTree1.lca(testTree1.root, n1, n2); 
		
		assertEquals(12, t.data);
		
	}
	
	@Test
	public void testLCAOutput2() {
		
		BinaryTree testTree = new BinaryTree(); 
		testTree.root = new Node(15); 
		testTree.root.left = new Node(12);
		testTree.root.left.left = new Node(11);
		testTree.root.left.right = new Node(13);
		testTree.root.right = new Node(18); 
		testTree.root.right.left = new Node(17);
		
		 //      _15_
        //     /      \
        //   _12_      _18_
        //  /    \	  /
        // 11     13 17
      
		int n1 = 11, n2 = 13; 
		Node t = testTree.lca(testTree.root, n1, n2); 
		
		n1 = 17; 
		n2 = 13; 
		t = testTree.lca(testTree.root, n1, n2); 
		
		assertEquals(15, t.data);
		
	}

	@Test 
	public void testLCANullNode(){

		// test null node

		BinaryTree testTree = new BinaryTree();

		int n1 = 3;
		int n2 = 1;
		assertEquals(null, testTree.lca(null, n1, n2));
	}

	@Test
	public void testLCAEmptyTree() {

		//test empty tree

		BinaryTree testTree = new BinaryTree();

		int n1 = 1;
		int n2 = 2;

		assertEquals(null, testTree.lca(testTree.root, n1, n2));

	}

	@Test 
	public void testSingleNode() {

		// function assumes that n1 and n2 are present in the tree. If there is only a root in
		// the tree and the passed n1 or n2 is equal to this root, then no matter the value of the corresponding
		// n1/n2, the function will return 1
		
		
		BinaryTree testTree = new BinaryTree();
		Node testNode = new Node(1);
		int n1 = 1;
		int n2 =3;
		assertEquals(1,testTree.lca(testNode, n1, n2).data);
	}
	
	


	
}
