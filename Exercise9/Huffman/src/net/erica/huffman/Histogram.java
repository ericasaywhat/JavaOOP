/**
 * 
 */
package net.erica.huffman;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author erica
 * This is Exercise 8 for JavaOOP Independent Study
 *
 */
public class Histogram {
	/**
	 * A Histogram represents a set of counters that counts the frequency
	 * of each element of the set. A natural implementation is a HashMap
	 * that maps from Character elements to Integer counters
	 */
	private HashMap<Character, Integer> hist;	
	
	public Histogram() {
		hist = new HashMap<Character,Integer>();
	}
	
	public String toString(){
		return hist.toString();
	}
	public void count(Character c){
		if (hist.containsKey(c)){
			int counter = hist.get(c)+1;
			hist.put(c, counter);
		} else {
			hist.put(c, 1);
		}
	}
	
	public void count (String s){
		char[] charArray = s.toCharArray();
		for(Character a : charArray){
			count(a);
		}		
	}
	
	public int freq(Character c){
		if (hist.containsKey(c)){
			return hist.get(c);
		} else {
			return 0;
		}
	}
	
	public HashMap<Character, Integer> getHist(){
		return hist;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Histogram h = new Histogram();
		h.count("There is no English Breakfast tea. The day already looks bleak.");
		System.out.println(h.toString());
		System.out.println(h.freq('a') + "");
	}

}
