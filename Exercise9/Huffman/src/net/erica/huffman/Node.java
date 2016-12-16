/**
 * 
 */
package net.erica.huffman;

import java.util.ArrayList;

/**
 * @author erica
 *
 */
public class Node {
	private ArrayList<Node> nodeList;		//nodes below each node
	private char character;
	private int nodeFreq;
	private String code;
	
	public Node(char character, int nodeFreq) {
		nodeList = new ArrayList<Node>();
		this.character = character;
		this.nodeFreq = nodeFreq;
		this.code = "";
	}
	
	public Node() {
		nodeList = new ArrayList<Node>();
		code = "";		
	}
	
	public void addNode(Node n){
		nodeList.add(n);
		n.addToCode(Integer.toString(nodeList.indexOf(n)));
		nodeFreq += n.getFreq();
	}
	
	public ArrayList<Node> getNodes(){
		return nodeList;
	}
	
	public final int getFreq() {
		return nodeFreq;
	}
	
	public final char getChar(){
		return character;
	}
	
	public String getCode() {
		return code;
	}
	
	public String addToCode(String s) {
		code += s;
		return code;
	}

}
