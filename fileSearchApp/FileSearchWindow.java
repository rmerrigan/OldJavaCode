package fileSearching;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.*;

/*TODO window produces error message if filenotfoundexception occurs
 * <Added IP name for current machine and flag buttons (10/19/2017)>
 * <Added compare two stores flag button, working on full
 * functionality, still need to sort the two sets and output them 
 * correctly to a single file 10/23/2017>
 * <10/26/2017 Need to rewrite all UI code in JavaFX, much simpler and more powerful>
*/

public class FileSearchWindow extends JFrame {
	
	//swing UI components
	private JButton buttonURLFlagSearch, buttonNoURLFlagSearch, buttonFindWebConfig, buttonCompareMaps;
	private JLabel machineInfo;
	
	public FileSearchWindow() throws UnknownHostException {
		
		createWindow();
		
		setTitle("Search Directories");
		setSize(400, 200);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	//contains specific UI elements
	private void createWindow() throws UnknownHostException {
		
		
		//auto searches for file, add absolute path input capabilities later
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		String getLocalHost = InetAddress.getLocalHost().getHostAddress();
		
		//absolutePathText = new JLabel("Writes to new file in R:/CorsairDrive+UbuntuISO/FileSearchingApp/ directory");
		//panel.add(absolutePathText);
		
		machineInfo = new JLabel("Host Info: " + getLocalHost);
		panel.add(machineInfo);
		
		//Find Flags with url
		buttonURLFlagSearch = new JButton("List flags (with URL)");
		buttonURLFlagSearch.addActionListener(new FlagWithURLFinder());
		panel.add(buttonURLFlagSearch);
		
		
		//Find flags without url
		buttonNoURLFlagSearch = new JButton("List flags (no URL)");
		buttonNoURLFlagSearch.addActionListener(new FlagWithoutURLFinder());
		panel.add(buttonNoURLFlagSearch);
		
		//Find web.config.txt, absolute path is C:\OPSClient\wwwroot\EGateway\web.config.txt
		buttonFindWebConfig = new JButton("Get web.config.txt");
		buttonFindWebConfig.addActionListener(new WebConfigFinder());
		panel.add(buttonFindWebConfig);
		
		buttonCompareMaps = new JButton("Compare two stores flags.");
		buttonCompareMaps.addActionListener(new CompareFlags());
		panel.add(buttonCompareMaps);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> { try {
			new FileSearchWindow().setVisible(true);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}});
	}
	
	//class for buttonURLFlagSearch
	private class FlagWithURLFinder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				findFlags_URL();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.print("Something wrong with path name.");
				e1.printStackTrace();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			showConfirm();
		}
	}
	//class for buttonNoURLFlagSearch button
	private class FlagWithoutURLFinder implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				findFlags_NoURL();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			showConfirm();
		}
		
	}
	//private class for finding web.config.txt
	private class WebConfigFinder implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				findWebConfig();
				
			} catch (UnknownHostException | FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			showConfirm();
		}
	}
	//private class for CompareFlags
	private class CompareFlags implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				compareFlags();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			showConfirm();
		}
	}
	
	//button helper methods
	private void findFlags_URL() throws FileNotFoundException, UnknownHostException {
		
		//path on reg "C:\\Program Files\\BMC Software\\BCA-Clients\\Tuner\\.marimba\\POSReadyTuner\\map.txt"
		String getLocalHost = InetAddress.getLocalHost().getHostAddress();
		Scanner mapFileScanner = new Scanner(new File("C:\\Program Files\\BMC Software\\BCA-Clients\\Tuner\\.marimba\\POSReadyTuner\\map.txt"));
		PrintStream output = new PrintStream(new File("R:/CorsairDrive+UbuntuISO/FileSearchingApp/" + getLocalHost + "_FlagWithURL.txt"));
		ArrayList<String> stringList = new ArrayList<String>();
		
		while(mapFileScanner.hasNextLine()) { //grabs each full url, stores it in list
			String currentLine = mapFileScanner.nextLine();
			stringList.add(currentLine);
		}
		for(int i = 0; i < stringList.size(); i++){ //outputs to specified file
			output.println(stringList.get(i));
		}		
	}
	
	private void findFlags_NoURL() throws FileNotFoundException, UnknownHostException {
		
		//path on reg "C:\\Program Files\\BMC Software\\BCA-Clients\\Tuner\\.marimba\\POSReadyTuner\\map.txt"
		
		String getLocalHost = InetAddress.getLocalHost().getHostAddress();
		Scanner mapFileScanner = new Scanner(new File("C:\\Program Files\\BMC Software\\BCA-Clients\\Tuner\\.marimba\\POSReadyTuner\\map.txt"));
		PrintStream output = new PrintStream(new File("R:/CorsairDrive+UbuntuISO/FileSearchingApp/" + getLocalHost + "_FlagWithoutURL2.txt"));
		ArrayList<String> stringList = new ArrayList<String>();
		
		while(mapFileScanner.hasNextLine()) { //grabs each full url, stores it in list
			String currentLine = mapFileScanner.nextLine();
			String[] tokens = currentLine.split("/|="); //delimits using / and = characters
			stringList.add(tokens[tokens.length - 2]);
		}
		for(int i = 0; i < stringList.size(); i++){ //outputs to specified file
			output.println(stringList.get(i));
		}		
	}
	
	private void findWebConfig() throws UnknownHostException, FileNotFoundException {
		
		/* path on  reg is C:/OPSClient/wwwroot/EGateway/web.config.txt
		 * path on corsair is E:\CorsairDrive+UbuntuISO\FileSearchingApp\10.251.15.60_web.config.txt
		*/
		String getLocalHost = InetAddress.getLocalHost().getHostAddress();
		Scanner webConfigScanner = new Scanner(new File("C:/OPSClient/wwwroot/EGateway/web.config.txt"));
		PrintStream output = new PrintStream(new File("R:\\CorsairDrive+UbuntuISO\\FileSearchingApp\\" + getLocalHost + "_WebConfig.txt"));
		ArrayList<String> stringList = new ArrayList<String>();
		
		while(webConfigScanner.hasNextLine()) {
			String currentLine = webConfigScanner.nextLine();
			stringList.add(currentLine);
		}
		
		for(int i = 0; i < stringList.size(); i++) {
			output.println(stringList.get(i));
		}
		
	}
	
	private void compareFlags() throws FileNotFoundException, UnknownHostException {
		
		String getLocalHost = InetAddress.getLocalHost().getHostAddress();
		String absFilePath1 = JOptionPane.showInputDialog("Enter first file path.");
		String absFilePath2 = JOptionPane.showInputDialog("Enter second file path.");
		
		/* absFilePath1 contains the file for map.txt1, absFilePath2 contains it for map.txt2
		 * parse files, isolate channel names, compare with sets, return to output file
		 * JOptionPane.showMessageDialog(null, "The file paths are, " + absFilePath1 + " " + absFilePath2, null, JOptionPane.PLAIN_MESSAGE);
		 */
		
		Scanner mapFileScanner1 = new Scanner(new File(absFilePath1));
		Scanner mapFileScanner2 = new Scanner(new File(absFilePath2));
		
		PrintStream output = new PrintStream(new File("R:/CorsairDrive+UbuntuISO/FileSearchingApp/UniqueFlags.txt"));
		
		
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
	
		tempSet1.removeAll(setList2);
		tempSet2.removeAll(setList1);
		
		output.println("Unique to Machine 1: " + tempSet1);
		output.println("Unique to Machine 2: " + tempSet2);
				
		
	}
	
	private void showConfirm() {
		JOptionPane.showMessageDialog(null, "All done!");
	}
	
	
	
	
	
	
	
	
}
