/*
 */
package diff;

/**
 * Created on 1/12/2018
 * Program takes two top level directories and finds unique folders in each one, 
 * output in separate text files. 
 * 
 * TODO: Create a small window with buttons and user entry for specified 
 * directories to use
 * 
 */
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author rmerriga
 */



public class Diff {
    
    public static ArrayList<String> list = new ArrayList<String>();
    
    public static int count;
    public static int dirCount = 0;
    
    
    public static void main(String[] args)throws FileNotFoundException{
        
        //the directories sent in need to have different paths, so one folder apart
        //because the logic distinguishes the directory names and utilizes the full
        //path when sorting and comparing, having the same path makes the directories
        //match and they don't show up with writing to the corresponding text file
 
        count = 7;
        listFolder(new File("C:\\Users\\rmerriga\\Desktop\\back-OPSClient"));
        list.clear();
        count+= 2;
        listFolder(new File("C:\\Users\\rmerriga\\Desktop\\CARG01CT004064\\OPSClient"));
        list.clear();
        File diff1 = new File("C:\\Users\\rmerriga\\Desktop\\Diff\\2_7Files");
        File diff2 = new File("C:\\Users\\rmerriga\\Desktop\\Diff\\2_9Files");
        
        compare(diff1, diff2); //pass in text documents, put into list, compare
        
    }
    
    public static void listFolder(File dir)throws FileNotFoundException{
        
        
        
        File[] subDirs = dir.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname){
                return pathname.isDirectory();//boolean for returning directory names
            }    
        });
        
        System.out.println("\nDirectory of " + dir.getAbsolutePath());
        listFile(dir);
        dirCount++;
        for(File folder: subDirs){
            listFolder(folder);
        }
    }
    
    public static void listFile(File dir)throws FileNotFoundException{
        
        PrintStream output = new PrintStream(new File("C:\\Users\\rmerriga\\Desktop\\Diff\\2_" + count + "Files"));
        
        File[] files = dir.listFiles();
        list.add(dir.getAbsolutePath());
        for (File file:files){
            
            list.add(file.getName());
        }
        
        for(int i = 0; i < list.size(); i++){ //outputs to specified file
            output.println(list.get(i));
        }		
    }

    private static void compare(File diff1, File diff2)throws FileNotFoundException {
       
        //Diff1 corresponds to 2.7, diff2 is 2.9
        
       PrintStream output2_7 = new PrintStream(new File("C:\\Users\\rmerriga\\Desktop\\Diff\\uniqueTo2_7"));
       PrintStream output2_9 = new PrintStream(new File("C:\\Users\\rmerriga\\Desktop\\Diff\\uniqueTo2_9"));
       PrintStream output2_7andDirs = new PrintStream(new File("C:\\Users\\rmerriga\\Desktop\\Diff\\uniqueTo2_7+Directories"));
        
       TreeSet<String> diffList1 = new TreeSet<String>();
       TreeSet<String> diffList2 = new TreeSet<String>();
       ArrayList<String> raw2_7list = new ArrayList<String>(); //will contain complete 2_7 files not in Alp order
       ArrayList<String> unique2_7list = new ArrayList<String>(); //contains ordered uniques
       ArrayList<String> unique2_7Fixed = new ArrayList<String>(); //contains ordered uniques
       
       Scanner diff1Scanner = new Scanner(diff1);
       Scanner diff2Scanner = new Scanner(diff2);
       
       while(diff1Scanner.hasNextLine()){
           String currentLine = diff1Scanner.nextLine();
           raw2_7list.add(currentLine);
           diffList1.add(currentLine);
       }
       
       while(diff2Scanner.hasNextLine()){
           String currentLine = diff2Scanner.nextLine();
           diffList2.add(currentLine);
       }
       
       TreeSet<String> tempSet1 = new TreeSet<String>();
       TreeSet<String> tempSet2 = new TreeSet<String>();
       tempSet1.addAll(diffList1);
       tempSet2.addAll(diffList2);

       tempSet1.addAll(tempSet2); //contains every unique channel in set1 and set2
       tempSet2.addAll(diffList1); //also containes every unique channel for comparing

       tempSet1.removeAll(diffList2);
       tempSet2.removeAll(diffList1);
       
       Iterator<String> itr1 = tempSet1.iterator();
       Iterator<String> itr2 = tempSet2.iterator();

       
       while(itr1.hasNext()){
           String itrNext = itr1.next();
           output2_7.println(itrNext);
           unique2_7list.add(itrNext);
       }
       
       while(itr2.hasNext()){
           output2_9.println(itr2.next());
       }       
       
       
       //raw2_7list contains correct ordering -> match to unique2_7list
       //write to new document
       
       raw2_7list.retainAll(unique2_7list);
       
       
        for(int i = 0; i<raw2_7list.size();i++){
            output2_7andDirs.println(raw2_7list.get(i));
        }
       
    }
    
}