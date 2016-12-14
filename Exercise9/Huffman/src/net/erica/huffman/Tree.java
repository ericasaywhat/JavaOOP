package net.erica.huffman;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

/**
 * @author erica
 *
 */
public class Tree {
	private Histogram h;
	private Node tree;
	private String s;
	
	public Tree(String s) {
		h = new Histogram();
		tree = new Node();
		this.s = s;
	}
	
	public void makeTree() {
		h.count(s);
		PriorityQueue<Node> leaves = makeLeafNodes(h.getHist());

		ArrayList<Node> hold = new ArrayList<Node>();

		while(leaves != null && (leaves.size() > 1)){
			Node a = leaves.poll();
			Node b = leaves.poll();
			Node c = leaves.peek();
			
			Node d = joinNode(a,b);

			hold.add(d);
			System.out.println(leaves.peek().getFreq());
			System.out.println(c.getFreq() + " " + d.getFreq());
			if (c.getFreq() > d.getFreq()){
				for (Node n : hold) {
					leaves.offer(n);
					System.out.println(n);
				}
			}
		}
		
		System.out.println(leaves);


//		tree = leaves;

	}

	
	private Node joinNode(Node a, Node b) {
		Node joined = new Node();
		joined.addNode(a);
		joined.addNode(b);
		
		return joined;
	}
	
	private PriorityQueue<Node> makeLeafNodes(HashMap<Character,Integer> hist) {
		Comparator<Node> comparator = new freqComparator();
		PriorityQueue<Node> leafSet = new PriorityQueue<Node>(hist.size(), comparator);

		for(Entry<Character, Integer> entry: hist.entrySet()) {
			Node leaf = new Node(entry.getKey(),entry.getValue());
			leafSet.add(leaf);
		}
		
		return leafSet;
	}
	
	private class freqComparator implements Comparator<Node>{
		@Override
		public int compare(Node o1, Node o2) {
			return Integer.compare(o1.getFreq(), o2.getFreq());
		}
	}
	
	public Node getTree() {
		return tree;
	}
}

class Node {
	private ArrayList<Node> nodeList;		//nodes below each node
	private char character;
	private int nodeFreq;
	
	Node(char character, int nodeFreq) {
		nodeList = new ArrayList<Node>();
		character = this.character;
		nodeFreq = this.nodeFreq;
	}
	
	Node() {
		nodeList = new ArrayList<Node>();
		nodeFreq = 0;
		
	}
	
	void addNode(Node n){
		nodeList.add(n);
		nodeFreq += n.getFreq();
	}
	
	ArrayList<Node> getNodes(){
		return nodeList;
	}
	
	final int getFreq() {
		return nodeFreq;
	}
	
	final char getChar(){
		return character;
	}
}


