package fileSearching;

import java.util.TreeSet;

public class CompareSimpleTest {
	
	public static void main(String[] args) {
		
		simpleCompare();
		
	}
	
	public static void simpleCompare() {
		
		TreeSet<String> set1 = new TreeSet<String>();
		TreeSet<String> set2 = new TreeSet<String>();
		
		TreeSet<String> tempSet1 = new TreeSet<String>();
		TreeSet<String> tempSet2 = new TreeSet<String>();
		
		set1.add("ch1");
		set1.add("ch2");
		set1.add("ch5");
		set1.add("ch8");
		set1.add("ch9");
		
		set2.add("ch1");
		set2.add("ch2");
		set2.add("ch4");
		set2.add("ch8");
		set2.add("ch10");
		
		tempSet1.addAll(set1);
		tempSet2.addAll(set2);
		
		tempSet1.addAll(tempSet2); //contains full set of both unique elements
		tempSet2.addAll(set1); //also contains all of both unique elements
		
		System.out.println("Set1: " +  set1);
		System.out.println("Set2: " + set2);
		
		tempSet1.removeAll(set2);
		tempSet2.removeAll(set1);
		
		System.out.println("After set logic passed: ");
		System.out.println("Unique to set 1: " + tempSet1);
		System.out.println("Unique to set 2: " + tempSet2);
		
		
	}
	

}
