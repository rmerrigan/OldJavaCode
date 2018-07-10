package fileSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class ListPractice 
{
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Scanner originalMapFileScanner = new Scanner(new File("E:/CorsairDrive+UbuntuISO/textFiles/parsedMap.txt"));
		Scanner dummyMapFileScanner = new Scanner(new File("E:/CorsairDrive+UbuntuISO/textFiles/parsedMapDummy.txt"));
		
		
		Set<String> a = new TreeSet<String>();
		Set<String> b = new TreeSet<String>();
		
		Set<String> originalFileAdded = fileContentsToSet(originalMapFileScanner);
		Set<String> dummyFileAdded = fileContentsToSet(dummyMapFileScanner);
//		System.out.println(originalFileAdded.toString());
//		System.out.println(dummyFileAdded.toString());
		Set<String> testSet = new TreeSet<String>(dummyFileAdded);
		testSet.removeAll(originalFileAdded);
		System.out.println(testSet.toString());
		
		
	}
	
	public static Set<String> fileContentsToSet(Scanner mapFileScanner)
	{
		Set<String> a = new TreeSet<String>();
		while(mapFileScanner.hasNext())
		{
			a.add(mapFileScanner.nextLine());
		}
		return a;
	}
	
	
}
