package com.locked.me;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
public class VKR {

	public static void main(String[] args) throws IOException {
		int ch=0, choice=0;
		Scanner sc =new Scanner(System.in);
		

		System.out.println("     ***************************");
		System.out.println("\t*********************\n");

		System.out.println("\t Welcome to LOCK IT! ");
		System.out.println("\t By, Locker Pvt Ltd. \n");
		System.out.println("\t*********************");
		System.out.println("     ***************************\n");
		System.out.println("Application\t:"+"LockedMe.com"+"\n");
		System.out.println("Developer\t:"+"Y Shankar Reddy\n");
		
		while(true)
		{
			System.out.println("Please choose one of the following options :");
			System.out.println("1. List Current Files");
			System.out.println("2. Business Operations");
			System.out.println("3. Close Application");
			try{    
				System.out.println("Enter Option:");
				ch = sc.nextInt();
			}
			catch(Exception e)  
             {  
              System.out.println("Null Exception occurred");  
             }         
			
			switch(ch)
			{
			case 1: //List function feature to list all files in ascending order.
				Business_Operations.listofFiles();
				break;
			case 2:
				
					System.out.println("Please choose one of the following options :");
					System.out.println("1. Add a File to directory");
					System.out.println("2. Delete a File from directory!");
					System.out.println("3. Search for a File?");
					try{    
						System.out.println("Enter Option:");
						 choice = sc.nextInt();
					}
					catch(Exception e)  
	                  {  
	                   System.out.println("Null Exception occurred");  
	                  }          
					switch(choice)
					{
					case 1:
						//Creation of a file takes place
						System.out.println("Enter the name of a file to be created: ");
						String fileCreate = sc.next();
						
						// Calling the function to create the file
						Business_Operations.creatingFile(fileCreate);
						break;
						
					case 2:
						//deletion of a file takes place
						System.out.print("Enter the name of a file to be deleted: ");
						String fileDelete = sc.next();
						
						// Calling the function to delete the file
						Business_Operations.deleteFile(fileDelete);
						break;
					case 3:
						//Search for a file takes place
						System.out.println("Enter the name of a file to be searched: ");
						String fileSearch = sc.next();
						
						// Calling the function to search the file
						Business_Operations.searchFile(fileSearch);
						break;
						
				default:
						//In the case of unprecedented input execute this
						System.out.println("\n Opps! Invalid Input,Please Try Agian!\n");
						break;
				}
			
					break;
			case 3:
				
				//Voluntarily exiting the application
				sc.close();
				System.out.println("\n Thank You....\n Visit Again..,:)\n Have a Nice Day;)");
				System.exit(1);
				break;
			
			default:
				//In the case of unprecedented input execute this
				System.out.println("\n\n Opps! Invalid Input, Select within the range of 1-3\n");
				break;
			
			}
		}
		
	}

}
 class Business_Operations {

	//Bubble sort to sort file in ascending order
	protected static String[] sort_sub(String a[], int size){
		String temp = "";
		for(int i=0; i<size; i++){
			for(int j=1; j<(size-i); j++){
				if(a[j-1].compareToIgnoreCase(a[j])>0){
					temp = a[j-1];
					a[j-1]=a[j];
					a[j]=temp;
				}
			}
		}
		return a;
	}
	

	
	//File listing function
	protected static void listofFiles() {
		
		int fileCount = 0;
	    ArrayList<String> filenames = new ArrayList<String>();
	
		File directoryPath = new File(System.getProperty("user.dir"));
		File[] listOfFiles = directoryPath.listFiles();
		fileCount = listOfFiles.length;
		
		
		System.out.println("Files in ascending fashion: ");
		for (int i = 0; i < fileCount; i++) {
		  if (listOfFiles[i].isFile()) {
		    filenames.add(listOfFiles[i].getName());
		  } 
		}
		
		String[] str = new String[filenames.size()];
		 
	    for (int i = 0; i < filenames.size(); i++) {
	        str[i] = filenames.get(i);
	    }
		
	    String[] sorted_filenames = sort_sub(str, str.length);
		
		for(String currentFile: sorted_filenames) {
			System.out.println(currentFile);
		}

	}
	
	//File delete function
	protected static void deleteFile(String fileToBeDeleted) {
		
		File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeDeleted );
		
		if(file.exists()) {
			if ( file.delete() ) {
				System.out.println("Hoorah! File deleted successfully!");
			}
		} else {
			System.out.println("Sorry, File wasn't deleted (File Not Found)");
		}
	}
	
	//File search function
	protected static void searchFile(String fileToBeSearched) {
	        
		File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeSearched );
		
		//Check whether file whether file exists or not.
		//If yes then display associated message
		if(file.exists()) {
			System.out.println("Yes! File found!");
		} else {
			System.out.println("Sorry, File is not here (File Not Found)");
		}	PrintWriter pw;  
        try {  
            pw = new PrintWriter(fileToBeSearched); //may throw exception   
            pw.println("saved");  
        }  
        // providing the checked exception handler  
        catch (FileNotFoundException e) {  
              
            System.out.println(e);  
        } 
	}

	//File creation function
	protected static void creatingFile (String fileToBeCreated) {
		File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeCreated );
		
		try {
			if (file.createNewFile() ) {
				System.out.println("File Created!");
			} else {
				System.out.println("File already exists :(");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}