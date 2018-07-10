package fileSearching;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class CompareFlagsTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		compareFlags();
		
	}
	
	public static void compareFlags() throws FileNotFoundException{
		
		String absFilePath1 = JOptionPane.showInputDialog("Enter first file path.");
		String absFilePath2 = JOptionPane.showInputDialog("Enter second file path.");
		
		/* absFilePath1 contains the file for map.txt1, absFilePath2 contains it for map.txt2
		 * parse files, isolate channel names, compare with sets, return to output file
		 * JOptionPane.showMessageDialog(null, "The file paths are, " + absFilePath1 + " " + absFilePath2, null, JOptionPane.PLAIN_MESSAGE);
		 */
		
		Scanner mapFileScanner1 = new Scanner(new File(absFilePath1));
		Scanner mapFileScanner2 = new Scanner(new File(absFilePath2));
		
		PrintStream output1 = new PrintStream(new File("R:/CorsairDrive+UbuntuISO/FileSearchingApp/MapSetData1.txt"));
		PrintStream output2 = new PrintStream(new File("R:/CorsairDrive+UbuntuISO/FileSearchingApp/MapSetData2.txt"));
		
		/* TODO convert these lists to sets and utilize set methods to compare and return 
		 * differing flag data between two computers
		 */
//		ArrayList<String> stringList1 = new ArrayList<String>();
//		ArrayList<String> stringList2 = new ArrayList<String>();
		TreeSet<String> setList1 = new TreeSet<String>();
		TreeSet<String> setList2 = new TreeSet<String>();
		
		while(mapFileScanner1.hasNextLine()) { //grabs each full url, stores it in list
			String currentLine = mapFileScanner1.nextLine();
			String[] tokens = currentLine.split("/|="); //delimits using / and = characters
			setList1.add(tokens[tokens.length - 2]);
		}
		
		while(mapFileScanner2.hasNextLine()) { //grabs each full url, stores it in list
			String currentLine = mapFileScanner2.nextLine();
			String[] tokens = currentLine.split("/|="); //delimits using / and = characters
			setList2.add(tokens[tokens.length - 2]);
		}
			
		TreeSet<String> tempSet1 = new TreeSet<String>();
		TreeSet<String> tempSet2 = new TreeSet<String>();
		tempSet1.addAll(setList1);
		tempSet2.addAll(setList2);
		
		tempSet1.addAll(tempSet2); //contains every unique channel in set1 and set2
		tempSet2.addAll(setList1); //also containes every unique channel for comparing
	
		
		
		
	}

}
