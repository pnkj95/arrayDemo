package com.java.arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TFNSimulator {

	static String line = null;
	static int batchSize = 5;// Define your batchsize here
	static String data[] = null;
	public static void main(String[] args) throws IOException {
			
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\g802940\\OneDrive - Syniverse\\Desktop\\portout_data.csv"));
			String line = null;
			long batchNumber = 1;
			    try {
			        List<String> mylist = null;
			        while ((line = br.readLine()) != null) {                  // Do it for your all line in your csv file
			            
			            System.out.println("Batch Number # " + batchNumber);
			           // System.out.println(line); // else you will miss every batchsize number line
			            // process your First Line here...
			            for (int i = 0; i < 1; i++) {
							//System.out.println("first line of batch : "+line);
							data = line.split(",");
							System.out.println("Brodcast [tid=" + data[0] + ", i=" + i + "]");
				        	System.out.println("Brodcast [pn=" + data[1] + ", i=" + i + "]");
						}
			            mylist = readBatch(br, batchSize); // get/catch your (List) result here as returned from readBatch() method

			            for (int i = 0; i < mylist.size(); i++) {   
			                System.out.println(mylist.get(i));
			                // process your lines here...
			                data = mylist.get(i).split(",");
//			                System.out.println("Brodcast [tid=" + data[0] + ", i=" + i + "]");
//				        	System.out.println("Brodcast [pn=" + data[1] + ", i=" + i + "]");
			            }
			            batchNumber++;
			        }

			        System.out.println("Lines are Successfully processed!");

			        br.close();  // one you are done .. dont forget to close/flush
			        br = null;   // all 
			        
			    } catch (Exception e) {
			        System.out.println("Exception caught: " + e.getMessage());   // Catch any exception here
			    }
		
	}
	
	
	private static List<String> readBatch(BufferedReader br, int batchSize) throws IOException {
	    // Create a List object which will contain your Batch Sized lines
	    List<String> result = new ArrayList<>();
	    for (int i = 1; i < batchSize; i++) {  // loop thru all your lines
	        String line = br.readLine();
	        if (line != null) {
	            result.add(line);   // add your lines to your (List) result
	        } else {
	            return result;  // Return your (List) result
	        }
	    }
	    return result;   // Return your (List) result
	}
}
