import java.io.*;
import java.util.*;

/**
*
* Sort any number of names alphabetically and place them into corresponding text files
*
* @author Sarah Qureshi & Brendan Fink
* @date 2016-02-18
*
*
* (Finished)
*/

public class ProjectChanges{
	
public static void main(String args[]) throws FileNotFoundException, IOException{

	ArrayList<String> names = new ArrayList();
	Scanner input = new Scanner (new File ("Names.txt"));    /*grab each line (loop) .realine(), >split()
																	put lastnames into array list like this
																	bubblesort using compareTo()*/
	String line;
	while (input.hasNextLine()){
	
		line = input.nextLine();
		String[] name = line.split(" ");
		names.add (name[0]);
		names.add (name[1]);
	}
	input.close();
	//System.out.println(names.size());
	
	//Bubble sort
	boolean flag = true;  //Required to start bubble sort
	while (flag) {
		flag = false; //If no changes happen, this stays false through loop and recursion ends.
		
		for (int i = 1; i < names.size() - 2; i++) { //loops through all elements
			String currentFirstName = names.get(i-1);
			String currentLastName = names.get(i);
			String nextFirstName = names.get(i+1);
			String nextLastName = names.get(i+2);
			
			int x = names.get(i).compareTo(names.get(i+2));
			
			if (x > 0) { //compares currentLastName and nextLastName: if nextLastName is first alphabetically, swap the two and their first names.
				//sorting
				String temp = currentLastName;
				currentLastName = nextLastName; 
				nextLastName = temp;
				
				temp = currentFirstName;
				currentFirstName = nextFirstName;
				nextFirstName = temp;
				flag = true; //change has happened, so this is set to true and loop continues running
				
				//after sort has been done, make the changes in the arraylist itself
				names.set(i-1, currentFirstName);
				names.set(i, currentLastName);
				names.set(i+1, nextFirstName);
				names.set(i+2, nextLastName);
			}
			
			if (x == 0){ //checks to see if the last names are same, then swaps the first names if needed
				x = names.get(i-1).compareTo(names.get(i+1));
				if (x > 0) {
					
					String temp = currentLastName;
					currentLastName = nextLastName; 
					nextLastName = temp;
					
					temp = currentFirstName;
					currentFirstName = nextFirstName;
					nextFirstName = temp;
					flag = true; //change has happened, so this is set to true and loop continues running
					
					//after sort has been done, make the changes in the arraylist itself
					names.set(i-1, currentFirstName);
					names.set(i, currentLastName);
					names.set(i+1, nextFirstName);
					names.set(i+2, nextLastName);
					
				}
			
			}
			i++; //Sorting is being done by last name, so I is incremented twice.
		}
	}


	//Int counter for 24 files 
	char c = 'A';
	int x = 0; //counter
	
	while (x < 26) {
		
	
		//Creates separate text files of sorted names by alphabetical order
		File file = new File("SortedNames" + c+".txt"); 
		file.createNewFile();
		FileWriter writer = new FileWriter(file); //sets a path to the new sorted file
		
		//prints out the names in the file
		String name = "Sarah Qureshi"; //example of the name
		for (int i = 0; i < names.size(); i++) {
			if (c == names.get(i+1).charAt(0)){ 
			
				writer.write(names.get(i+1) + " , " + names.get(i) + " ");
				writer.write("\n");
			}
			i++; 
		}
		
		//writes to the file to print out the names
		writer.flush(); //pushes all the names out, making sure nothing is left
		writer.close();  //closes the file, so it doesn't mess up 
		x++;
		c++;
		
		}
	}
}
