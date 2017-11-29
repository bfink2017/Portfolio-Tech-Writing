# Name Sorter

This program was created collaboratively by myself and a fellow JSU student. The program sorts any number of names alphabetically using bubble sort, and outputs the results into text files seperated by first letter of last name. For example, all last names starting with the letter 'A' will be sorted alphabetically first by last name, and then by first name. After this is completed, the names will be output to a text file containing only sorted last names beginning with A. This process is then repeated for B-Z.

### Authors

Brendan Fink
Sarah Qureshi

### Prerequisites

The only requirements to run this program are:

	A computer that can run .java files
	A list of names to be sorted

### Motivation

This program was created for a class project. The purpose of the project was to explore different problem-solving techniques using Java specifically. It implements various techniques learned in earlier lectures such as sorting algorithms and file input/output.

### How It Works

First, a file containing names to be sorted is read into the program. 

```java
	ArrayList<String> names = new ArrayList();
	Scanner input = new Scanner (new File ("Names.txt"));
```
The program then uses a Scanner to gather the names from the file and place them into an ArrayList.

Next, the last names are sorted using bubblesort.
```java
	int x = names.get(i).compareTo(names.get(i+2));

	if (x > 0) { //compares currentLastName and nextLastName
				
				String temp = currentLastName;
				currentLastName = nextLastName; 
				nextLastName = temp;
				
				temp = currentFirstName;
				currentFirstName = nextFirstName;
				nextFirstName = temp;
```
After that is completed, the first names are also sorted using bubble sort.

Lastly, the sorted names are output into various text files based on the first letter of the last name using a FileWriter.
```java
		//Creates separate text files of sorted names by alphabetical order
		File file = new File("SortedNames" + c+".txt"); 
		file.createNewFile();
		FileWriter writer = new FileWriter(file); //sets a path to the new sorted file
```

### Features

A list of current and possible future features includes:

	- [x] Name sorting
	- [x] Unsorted names input from file
	- [x] Sorted names output to files
	- [ ] Error checking
	- [ ] GUI

### Versions

Currently there is only one version - The version that was submitted to the professor.