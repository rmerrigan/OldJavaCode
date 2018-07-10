import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ParseOrReadTextFile {
	
	//path to be entered and used by entire class
	public static final String INPUT_FILE_PATH = "";
	public static final String OUTPUT_FILE_PATH = "";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File txtFile = new File(INPUT_FILE_PATH);
		outputParsedData(processTxtFile(txtFile));
		
	}

	private static void outputParsedData(List<String> txtFileList) throws FileNotFoundException {
		PrintStream output = new PrintStream(OUTPUT_FILE_PATH);
		Iterator txtItr = txtFileList.iterator();
		while(txtItr.hasNext()) {
			output.println(txtItr.next());
		}
	}

	private static List<String> processTxtFile(File txtFile) throws FileNotFoundException {
		List<String> txtFileList = new ArrayList(); //
		Scanner txtFileSC = new Scanner(txtFile);
		while(txtFileSC.hasNextLine()) {
			//txtFileList.add(txtFileSC.nextLine());
		}
		return txtFileList;
	}

}
