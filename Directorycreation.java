/* Author: Abhijit Palve
 * Statement: Sample code for dynamic folder creation 
 */

package palve.assign1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class RevCreateDirectory {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// public void revCreateDirectory() {
		// To create single directory/folder
		/*
		 * File file = new File("D:\\Project\\Directory1"); if (!file.exists()) { if
		 * (file.mkdir()) { System.out.println("Directory is created!"); } else {
		 * System.out.println("Failed to create directory!"); } } //To create multiple
		 * directories/folders File files = new
		 * File("D:\\Project\\Directory2\\Sub2\\Sub-Sub2"); if (!files.exists()) { if
		 * (files.mkdirs()) { System.out.println("Multiple directories are created!"); }
		 * else { System.out.println("Failed to create multiple directories!"); } }
		 * 
		 * FileReader file = new FileReader("D:\\flat.txt"); // Reading the file
		 * BufferedReader reader = new BufferedReader(file);
		 * 
		 * String text = " "; String line = reader.readLine(); //reading each line
		 * 
		 * 
		 * while(line!=null) { text+= line; while(line!="\n") { StringTokenizer stk =
		 * new StringTokenizer(line); String string1 = stk.nextToken();
		 * System.out.print(string1); File file1 = new File("D:\\Project\\"+string1\\);
		 * 
		 * if (!file1.exists()) { if (file1.mkdir()) {
		 * System.out.println("Directory is created!"); } else {
		 * System.out.println("Failed to create directory!"); } } } line =
		 * reader.readLine();
		 * 
		 * text+= "\n"; }
		 * 
		 * System.out.println(text);
		 * 
		 * }
		 */

		BufferedReader in = null; // Your reader

		ArrayList<String> al = new ArrayList<String>(); // Where you store the Strings
		try {

			in = new BufferedReader(new FileReader("D:\\flat.txt")); // Open the file and give it to the 
			                                                            //reader
			String line;

			while ((line = in.readLine()) != null) // As long as the file has more lines read a line at a time
			{

				String[] splitLine = line.split("SRC:"); // Split the line and store it in an array

				for (int i = 0; i < splitLine.length; i++) {

					String[] placing = splitLine[i].split("\\s+"); // Putting tokens in string array using 
																	// line split and regex

					/*
					 * System.out.println(Arrays.toString(placing)); System.out.println(placing[0]);
					 * 
					 * File file1 = new File("D:\\Project\\"+ placing[0]); File file2 = new
					 * File("D:\\Project\\"+ placing[0]+ "\\" + placing[1]); File file3 = new
					 * File("D:\\Project\\"+ placing[0]+ "\\" + placing[1] + "\\" +placing[2]);
					 * 
					 * Path [] path = {}; Path p1= Paths.get("D:\\Project\\"+ placing[0]); Path p2=
					 * Paths.get(p1+ "\\" + placing[1]); Path p3= Paths.get(p2+ "\\" + placing[2]);
					 * System.out.println(p1); System.out.println(p2); System.out.println(p3);
					 * 
					 * Files.createDirectories(p1); Files.createDirectories(p2);
					 * Files.createDirectories(p3);
					 */

					Path[] path = new Path[placing.length]; // Path array for storing various paths
					for (int j = 0; j < placing.length; j++) {
						if (j == 0)
							path[j] = Paths.get("D:\\Project\\" + placing[j]);

						else
							path[j] = Paths.get(path[j - 1] + "\\" + placing[j]);


						Files.createDirectories(path[j]); // Creating directory of the path
					}

					al.add(splitLine[i]); // Add each element of the split array into an ArrayList
				}
			}
		}

		// Catch your possible problems
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}

		catch (IOException ioe) {
			ioe.printStackTrace();
		}

		for (String s : al) // Print the arraylist
		{

			System.out.println(s);
		}
	}

}
