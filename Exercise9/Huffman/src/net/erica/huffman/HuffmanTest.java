/**
 * 
 */
package net.erica.huffman;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author erica
 *
 */
public class HuffmanTest {

	@Test
	public void testTree(){
		Huffman huff = new Huffman("Earl grey green black chamomile");
		huff.setTree();
		System.out.println(huff.getTree().getNodes());
		
		assertTrue(huff.getTree() instanceof Node);
	}

}
