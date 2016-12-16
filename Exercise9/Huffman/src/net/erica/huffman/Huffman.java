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
	private HashMap<Character, String> codeMap;
	private String inputString;
	private String outputString;
	private String inputCode;
	private String outputCode;
	private static Node tree;


	public Huffman() {
		inputString = "";
		inputCode = "" ;
		outputString = "";
		outputCode = "";
		
	}
	
	public void setTree(String inputString) {
		Tree newTree = new Tree(inputString);
		newTree.makeTree();
		tree = newTree.getTree();
	}
	
	public Node getTree() {
		return tree;
	}
	
	public void genCodeMap() {
		boolean running = true;
		codeMap = new HashMap<Character, String>();
		ArrayList<Node> traveller = new ArrayList<Node>();
		traveller = tree.getNodes();
		while (running) {
			for (Node n : traveller) {
				ArrayList<Node> holder = new ArrayList<Node>();
				if(n.getNodes().size() > 0){
					for (int i = 0; i < n.getNodes().size(); i++) {
						holder.add(n.getNodes().get(i)); 
					}
					traveller = holder;				
				} else {
					codeMap.put(n.getChar(), n.getCode());
					running = false;
				}
			}
			
		}

	}
	
	public String encode(String s) {
		char[] characterArray = s.toCharArray();
		for (char c : characterArray) {
			outputCode += codeMap.get(c) + " ";
		}
		return outputCode;
	}
	
	public String decode(String s) {
		String [] codeArray = s.split(" ");
		for (String code : codeArray) {
			for (Entry e : codeMap.entrySet()) {
				if (code == e.getValue()) {
					outputString += e.getKey();
				}
			}
		}
		return outputString;
		
	}
	
	public static void print(Node tree){
		if (tree == null) return;
		System.out.print(tree.getChar() + " ");
		
		for (int i = 0; i < tree.getNodes().size(); i++) {
			print (tree.getNodes().get(i));
		}
	}
	
	public static void main(String[] args) {
		Huffman huff = new Huffman();
		huff.setTree("abcccdd");
		Huffman.print(tree);

//		System.out.print(huff.encode("Erica"));
	}	
	
	

		
}

