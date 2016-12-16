/**
 * 
 */
package net.erica.huffman;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * @author erica
 *
 */
public class HuffmanTest {
	
	private Huffman huff;
	
	
	public HuffmanTest(){
		huff = new Huffman();
		huff.setTree("eerrricccca");
//		huff.genCodeMap();
	}
	
	@Test
	public void testTree(){
		assertTrue(huff.getTree() instanceof Node);
		assertTrue(huff.getTree().getNodes() instanceof ArrayList<?>);
	}
	
	@Test
	public void testEncode(){		
		assertEquals(huff.encode("erica"), "10 01 001 11 000");
	}
	
	@Test
	public void testDecode(){
		assertEquals(huff.decode("10 01 001 11 000"), "erica");
		
	}

	

}
