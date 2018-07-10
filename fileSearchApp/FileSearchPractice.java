package fileSearching;

import java.io.File;
import java.util.Scanner;

public class FileSearchPractice {
	
	public static void main(String[] args) {
		Scanner user_input = new Scanner(System.in);
		String user_1;
		System.out.print("Directory: ");
		user_1 = user_input.next();
		
		File dir = new File(user_1);
		for (File f : dir.listFiles()) {
				System.out.println(f.getAbsolutePath());
		}
		
	}

}
