/**
 * 
 */
package net.erica.huffman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author erica
 * This is for Exercise 9 in JavaOOP Independent Study
 */
public class WordCount {
	
	private String fileName;
	private int count;

	/**
	 * @param args
	 */
	
	public WordCount(String fileName){
		fileName = this.fileName;
	}
	
	public int countWords(String fileName){
		try{
			File sonnet = new File(fileName);
			FileReader fileReader = new FileReader(sonnet);
			
			BufferedReader reader = new BufferedReader(fileReader);
			
			int wordCount = 0;
			String line = null;
			
			while ((line = reader.readLine())!= null){
				String[] splitLine = line.split(" ");
				wordCount += splitLine.length;
			}
			reader.close();
			System.out.println(wordCount);
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		return count;
	}

}
