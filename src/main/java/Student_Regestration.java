import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessHandle.Info;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.naming.directory.SearchControls;

/**
 * 
 */

/**
 * This program is School Management System for Administration to Register new Student , 
 * See the existing student view and search for spicific student.
 *
 */
public class Student_Regestration {

	

	/**
	 * @param args
	 * the main will allow the admin to :
	 * 1. Register new student using their name and email and  the id will automaticlly generated
	 * 2. The admin able to view the regiestred student.
	 * 3. The admin can search for spicific student using their Id.
	 * 4. The admin can update the student information.
	 * 5. The admin can deleat student. 
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		BufferedWriter bw = null;

		System.out.println("Wellcome to School Management System ");
		System.out.println("Wellcome to Adminstration Page ");
		System.out.println("Menu: ");
		System.out.println("1. Register Student");
		System.out.println("2. Manage Student");
		System.out.println("3. Hire Teacher");
		System.out.println("4. Manage Teacher");
		System.out.println("5. Exit");

		System.out.println("Your option is: ");
		System.out.println("-------------------");
		int actionNum = input.nextInt();
		
			if (actionNum == 1) {
				
				while (actionNum != 5) {

					System.out.println();
				System.out.println("1. Register Student");
				System.out.println("Student Menue: ");
				System.out.println("1. Creat Student");
				System.out.println("2. View Students");
				System.out.println("3. Search for Student");
				System.out.println("4. Update/ Deleat Student");
				
			

				System.out.println("-------------------");
				System.out.println("Your option is: ");
				System.out.println("-------------------");
				int menuNum = input.nextInt();

				HashMap<String, String[]> Studentinfo = new HashMap<String, String[]>();
				if (menuNum == 1) {

					int newID = 1;
					try {
						BufferedReader reader = new BufferedReader(new FileReader("data/Reg.csv"));
						String line;

						while ((line = reader.readLine()) != null) {

							String[] box = line.split(",");

							Studentinfo.put(box[0], box);

							newID++;
						}
						   
						reader.close();
					} catch (FileNotFoundException e) {
						System.out.println("The file not found" + e);
					} catch (IOException e) {
						e.printStackTrace();
					}
					String studentidString = Integer.toString(newID);

					System.out.println("Enter Student Name: ");
					System.out.println("-------------------");
					String StudentName = new Scanner(System.in).nextLine();

					

					System.out.println("Enter Student Email: ");
					System.out.println("-------------------");
					String StudentEmail = new Scanner(System.in).nextLine();
					

					try {
						FileWriter newfile = new FileWriter("data/Reg.csv", true);
						bw = new BufferedWriter(newfile);

						bw.write(studentidString);
						bw.append(",");
						bw.write(StudentName);
						bw.append(",");
						bw.write(StudentEmail);
						bw.newLine();

						System.out.println("Successfully wrote to the file.");
						bw.close();

					} catch (IOException e) {
						System.out.println("An error occurred." + e);

					}

				}
				// View the student
				else if (menuNum == 2) {
					System.out.println("2. View Students");
					System.out.println();
					ViewStudent("data/Reg.csv");
					
				}

				// Search for student with id
				else if (menuNum == 3) {
					
					System.out.println("3. Search for Student");
					System.out.println("Enter Student ID: ");
					
					String Id = new Scanner(System.in).nextLine();
					SearchStudent(Id,"data/Reg.csv");


				}
				
				else if (menuNum == 4) {
					
					System.out.println("4. Update/ Deleat Student");
					UpdateFile("data/Reg.csv","data/Reg1.csv");

				}
				
			
			 }
			}

			else {
				System.out.println("Exit");
			}
			

		}
	
	/**
	 * This method is for converting the file to hashmap.
	 * @param filepath : the path of file to be converted.
	 * @return : return the hashmap.
	 * @throws IOException
	 */
	
	public static HashMap<String, String[]> fileTohashMap( String filepath) throws IOException {
		
		HashMap<String, String[]> Studentinfo1 = new HashMap<String, String[]>();

		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String line;

			while ((line = reader.readLine()) != null) {

				String[] box = line.split(",");

				Studentinfo1.put(box[0], box);

				
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file not found" + e);
		}
		return Studentinfo1;
		
	}
	/**
	 * method to view the student using scanner
	 * @param filepath  : the path of file to be viewed.
	 */
	
	 public static void ViewStudent (String filepath) {
		 Scanner sc = null;

			try {
				sc = new Scanner(new File(filepath));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			sc.useDelimiter(",");
			while (sc.hasNext()) {

				System.out.print(sc.next() + " ");

			}
			sc.close();
		
	}
	 
	 
	 /**
	  * 
	  * @param Id: the student id.
	  * @param filePath:: the path of file to search in it.
	  * @throws IOException
	  */
	 public static void SearchStudent(String Id , String filePath) throws IOException {
		
			
			
			for ( java.util.Map.Entry<String, String[]> entry : fileTohashMap(filePath).entrySet()) {
				if (Arrays.toString(entry.getValue()).contains(Id)) {
					System.out.println("true");
					
					System.out.println(entry.getKey() + " => " + Arrays.toString(entry.getValue()));

					
				}
				
			}
			
		
	}
	 

	 /**
	  * 
	  * @param filepath : the file to be updated.
	  * @param newfilepath : the new file "After the updation of the orginal file"
	  * @throws IOException
	  */
	 public static void UpdateFile(String filepath, String newfilepath ) throws IOException {
		 
		
		 List<List<String>> records = new ArrayList<>();
		 try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			 
			 FileWriter newfile = new FileWriter(newfilepath, true);
			 BufferedWriter bw = new BufferedWriter(newfile);
		     String line;
		     while ((line = br.readLine()) != null) {
		         String[] values = line.split(",");
		         records.add(Arrays.asList(values));
		     }
		     
		     for (List<String> entry : records) {            
		         System.out.println(entry);       
		    }
		     
		     System.out.println("Enter the index of student ");
				
			int Id = new Scanner(System.in).nextInt();
			
			String studentidString = Integer.toString(Id+1);
			String [] info={studentidString,"name", "name@gmail.com"};
			List<String> infoStrings = Arrays.asList(info);
			records.set(Id, infoStrings);
			
			 for (List<String> entry : records) {            
		         System.out.println(entry);    
			 }
			 
			 try {
				 for(List<String> str: records) {
					 bw.write(str + System.lineSeparator());
				 }
				 bw.close();	
				
			} 
			 catch (Exception e) {
				// TODO: handle exception
			}
			 	 
		 }
	 
		
	}
	 

    }

	
	


