package net.erica.huffman;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class HistogramTest {

	@Test
	public void testToString(){
		Histogram h = new Histogram();
		h.count("There is no English Breakfast tea. The day already looks bleak.");
		
		assertTrue(h.toString() instanceof String);
		
	}
	@Test
	public void testCountChar() {
		Histogram h = new Histogram();
		h.count('a');

		assertEquals("testCountChar", 1, h.freq('a'));
	}
	
	@Test
	public void testCountString(){
		Histogram h = new Histogram();
		h.count("There was no English Breakfast tea. The day was bleak.");
		
		assertEquals("testCountString", 7, h.freq('a'));
	}
	
	@Test
	public void testFreq(){
		Histogram h = new Histogram();
		h.count("aaabbc ddd");
		
		assertEquals("testFreq_a", 3, h.freq('a'));
		assertEquals("testFreq_b", 2, h.freq('b'));
		assertEquals("testFreq_c", 1, h.freq('c'));
		assertEquals("testFreqSpace", 1, h.freq(' '));
	}
	
	@Test
	public void testGetHist(){
		Histogram h = new Histogram();
		h.count("There is no English Breakfast tea. The day already looks bleak.");
		
		assertTrue(h.getHist() instanceof HashMap);
	}
}
