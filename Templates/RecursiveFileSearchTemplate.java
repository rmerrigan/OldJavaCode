import java.io.File;
import java.io.FileFilter;
/**
 * only contains methods to copy paste into current class
 * @author rmerriga
 */

    
    private static void listFolder(File dir){
        File[] subDirs = dir.listFiles(new FileFilter(){
            
            @Override
            public boolean accept(File pathname){
                return pathname.isDirectory();
            }
            
        });
        
        System.out.println("\nDirectory of " + dir.getAbsolutePath());
        listFile(dir);
        
        for (File folder: subDirs){
            listFolder(folder);
        }
    }
    
    private static void listFile(File dir){
        File[] files = dir.listFiles();
        for(File file: files){
            System.out.println(file.getName());
        }
    }
      
