/**
 * 
 */
package net.erica.huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author erica
 *
 */
public class Huffman {
	private String inputString;
	private String outputString;
	private ArrayList<Integer> inputCode;
	private ArrayList<Integer> outputCode;
	private String s;
	private Node tree;


	public Huffman(String s) {
		this.s = s;
	}
	
	public void setTree() {
		Tree newTree = new Tree(s);
		newTree.makeTree();
		tree = newTree.getTree();
	}
	
	public Node getTree() {
		return tree;
	}
	
	public static void main(String[] args) {
		Huffman huff = new Huffman("Earl grey green black chamomile");
		huff.setTree();
		System.out.println(huff);
	}
	

			
		

		
		
}

