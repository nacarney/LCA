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
	public void testInsert() {
		Node testNode = new Node(1);
		testNode.left = null;
		testNode.right = null;
		Main.insert(testNode, 1);
		
		
		
		
	}
	
	@Test
	public void testSearch() {
		
	}

}
