import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class FileChooser {
	
	public static void main(String[] args) {
		createFileChooser();
	}		
	
	public static void createFileChooser() {
		JButton open = new JButton();
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("C:/"));
		fc.setDialogTitle("Choose a file.");
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if(fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
		}
		System.out.println("Chosen File: " + fc.getSelectedFile().getAbsolutePath());
	}

}
