import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ProcessHandle.Info;
import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

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
	 * 2. The admin able to view 
	 */
	public static void main(String[] args) {
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
				System.out.println("2. View Student");
				System.out.println("3. Search Student");
				System.out.println("4. Update Student");

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
					System.out.println("2. View Student");

					Scanner sc = null;

					try {
						sc = new Scanner(new File("data/Reg.csv"));
					} catch (FileNotFoundException e) {

						e.printStackTrace();
					}
					sc.useDelimiter(",");
					while (sc.hasNext()) {

						System.out.print(sc.next() + " ");

					}
					sc.close();
				}

				// Search for student with id
				else if (menuNum == 3) {
					
					System.out.println("3. Search Student");
					System.out.println("Enter Student ID: ");
					
					String Id = new Scanner(System.in).nextLine();
					
					for (String key : Studentinfo.keySet()) {
						
							System.out.println(Arrays.toString(Studentinfo.get(key)));
					}
					for ( java.util.Map.Entry<String, String[]> entry : Studentinfo.entrySet()) {
						if (entry.getKey() == Id) {
							System.out.println("true");
							System.out.println(entry.getKey() + " => " + Arrays.toString(entry.getValue()));
						}
					}

				}

				else {
					System.out.println("4. Update Student");
				}
			 }
			}

			else {
				System.out.println("Exit");
			}
			

		}
	
	
	
	
	}
	


