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
