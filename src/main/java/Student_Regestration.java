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
 * @author LAP-10
 *
 */
public class Student_Regestration {

	/**
	 * @param args
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
				
				//while (actionNum != 5) {

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

				HashMap<String, String[]> map = new HashMap<String, String[]>();
				if (menuNum == 1) {

					int newID = 1;
					try {
						BufferedReader reader = new BufferedReader(new FileReader("data/Reg.csv"));
						String line;

						while ((line = reader.readLine()) != null) {

							String[] box = line.split(",");

							map.put(box[0], box);

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
					String StudentName = input.nextLine();

					// student[i]= StudentName;

					System.out.println("Enter Student Email: ");
					System.out.println("-------------------");
					String StudentEmail = input.nextLine();
					// studentE[i]= StudentEmail;

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
					String[] person = null;

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

				// Search for stufent with id
				else if (menuNum == 3) {
					
					System.out.println("3. Search Student");
					System.out.println("Enter Student ID: ");
					
					String Id = new Scanner(System.in).nextLine();
					
					for (String key : map.keySet()) {
//						
							System.out.println(Arrays.toString(map.get(key)));
					}
					for ( java.util.Map.Entry<String, String[]> entry : map.entrySet()) {
						if (entry.getKey() == Id) {
							System.out.println("true");
							//System.out.println(entry.getKey() + " => " + Arrays.toString(entry.getValue()));
//					String mystring;
//					try {
//						BufferedReader br = new BufferedReader(new FileReader("data/Reg.csv"));
//						while ((mystring = br.readLine()) != null) {
							// System.out.println("there is a student");
//							for (String key : map.keySet()) {
//								if (map.containsKey(Id)) {
//									System.out.println("true");
//									System.out.println(Arrays.toString(map.get(key)));
//								}
//
//							}
		
						}
					}

				}

				else {
					System.out.println("4. Update Student");
				}
			//}
			}

			else {
				System.out.println("Exit");
			}
			

		}
	
	
	
	}
	


