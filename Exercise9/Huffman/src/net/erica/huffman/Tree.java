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

		while(leaves.size() > 2){
			Node a = leaves.poll();
			Node b = leaves.poll();
			Node c = leaves.peek();


			Node d = joinNode(a,b);


			hold.add(d);

			if (c.getFreq() > d.getFreq()){
				for (Node n : hold) {
					System.out.print(n.getNodes());
					leaves.offer(n);

//					System.out.println(n);
				}
			}
		}
		
		if (leaves.size() == 2) {
			Node a = leaves.poll();
			Node b = leaves.poll();


			tree = joinNode(a,b);

		} else {
			tree = leaves.poll();
		}

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
//			System.out.println(entry.getValue());
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
	
	public static void main(String[] args) {
		Tree tree = new Tree("abcccdd");
		tree.makeTree();
//		System.out.print(huff.encode("Erica"));
	}	
	
}

