/**
 * 
 */
package net.erica.huffman;

import java.util.HashMap;

/**
 * @author erica
 * This is Exercise 8 for JavaOOP Independent Study
 *
 */
public class Histogram {
	/**
	 * A Histogram represents a set of counters that counts the frequency
	 * of each element of the set. A natural implementation is a HashMap
	 * that maps from String elements to Integer counters
	 */
	HashMap<String, Integer> hist;	
	public Histogram() {
		hist = new HashMap<String,Integer>();
	}
	
	public String toString(){
		return hist.toString();
	}
	public void count(Character c){
		int counter = 0;
		if (hist.containsKey(c.toString())){
			counter = hist.get(c.toString())+1;
			hist.put(c.toString(), counter);
		} else {
			hist.put(c.toString(), 1);
		}
	}
	
	public void count (String s){
		char[] charArray = s.toCharArray();
		for(Character a : charArray){
			count(a);
		}		
	}
	
	public int freq(Character c){
		if (hist.containsKey(c.toString())){
			return hist.get(c.toString());
		} else {
			return 0;
		}
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
