import edu.myPac.*;
import java.io.*;
import java.util.*;

public class StudentFacultyIO
{
	// question 5.1
	public static Student createStudent(String first, String last, String address, int SSN, int phone, String email, int ID, double GPA, String status) // input student data
	{
		Student stu1 = new Student();
		stu1.setFirstName(first);
		stu1.setLastName(last);
		stu1.setAddress(address);
		stu1.setSSN(SSN);
		stu1.setPhoneNum(phone);
		stu1.setEmail(email);
		stu1.setStudentID(ID);
		stu1.setGPA(GPA);
		stu1.setStatus(status);
		return stu1;
	}
	public static Faculty createFaculty(String first, String last, String address, int SSN, int phone, String email, int ID, String department) // input faculty data
	{
		Faculty fac1 = new Faculty();
		fac1.setFirstName(first);
		fac1.setLastName(last);
		fac1.setAddress(address);
		fac1.setSSN(SSN);
		fac1.setPhoneNum(phone);
		fac1.setEmail(email);
		fac1.setFacultyID(ID);
		fac1.setDepartment(department);
		return fac1;
	}
	// question 5.3
	public static int arraySize(File file) throws IOException // initialize arrays to store data from file
	{
		// determining size for student array
		Scanner inputFile = new Scanner(file);
		int tally = 0; // for counting number of students in a file
		while (inputFile.hasNext())
		{
			if (inputFile.findInLine("First Name") != null) // there should be one of these for each student
			{
				tally++;
			}
			inputFile.nextLine();
		}
		// closing the file was causing problems for some reason
		// inputFileStudent.close();
		return tally;

	}
	public static Student[] studentReadFromFile(File studentFile) throws IOException // read student data and store into an array
	{
		int studentTally = arraySize(studentFile);
		// initialize array
		Student stu[] = new Student[studentTally];
		for (int i = 0; i < studentTally; i++)
		{
			stu[i] = new Student();
		}
		
		Scanner inputFileStudent = new Scanner(studentFile);
		int i = 0;
		while (inputFileStudent.hasNext() && (i < studentTally))
		{
			// First Name
			String firstName = inputFileStudent.nextLine();
			firstName = firstName.replace("First Name: ", "");
			stu[i].setFirstName(firstName);
			// System.out.println(firstName);
			
			// Last Name
			String lastName = inputFileStudent.nextLine();
			lastName = lastName.replace("Last Name: ", "");
			stu[i].setLastName(lastName);
			// System.out.println(lastName);
			
			// SSN
			String tmpSSN = inputFileStudent.nextLine();
			tmpSSN = tmpSSN.replace("SSN: ", "");
			int SSN = Integer.parseInt(tmpSSN);
			stu[i].setSSN(SSN);
			// System.out.println(SSN);
			
			// Address
			String address = inputFileStudent.nextLine();
			address = address.replace("Address: ", "");
			stu[i].setAddress(address);
			// System.out.println(address);
			
			// Phone Number
			String tmpPhone = inputFileStudent.nextLine();
			tmpPhone = tmpPhone.replace("Phone Number: ", "");
			int PhoneNumber = Integer.parseInt(tmpPhone);
			stu[i].setPhoneNum(PhoneNumber);
			// System.out.println(PhoneNumber);
			
			// Email
			String email = inputFileStudent.nextLine();
			email = email.replace("Email: ", "");
			stu[i].setEmail(email);
			// System.out.println(email);
			
			// Student ID
			String tmpID = inputFileStudent.nextLine();
			tmpID = tmpID.replace("Student ID: ", "");
			int studentID = Integer.parseInt(tmpID);
			stu[i].setStudentID(studentID);
			// System.out.println(studentID);
			
			// GPA
			String tmpGPA = inputFileStudent.nextLine();
			tmpGPA = tmpGPA.replace("GPA: ", "");
			double GPA = Double.parseDouble(tmpGPA);
			stu[i].setGPA(GPA);
			// System.out.println(GPA);
			
			// Status
			String status = inputFileStudent.nextLine();
			status = status.replace("Last Name: ", "");
			stu[i].setStatus(status);
			// System.out.println(status);
			
			inputFileStudent.nextLine(); // should be blank if there's another record
			i++;
		}
		return stu;
	}
	public static Faculty[] facultyReadFromFile(File facultyFile) throws IOException // read faculty data and store into an array
	{
		int facultyTally = arraySize(facultyFile);
		// initializing objects in array
		Faculty fac[] = new Faculty[facultyTally];
		for (int i = 0; i < facultyTally; i++)
		{
			fac[i] = new Faculty();
		}
		Scanner inputFileFaculty = new Scanner(facultyFile);
		int i = 0;
		while (inputFileFaculty.hasNext() && (i < facultyTally))
		{
			// First Name
			String firstName = inputFileFaculty.nextLine();
			firstName = firstName.replace("First Name: ", "");
			fac[i].setFirstName(firstName);
			// System.out.println(firstName);
			
			// Last Name
			String lastName = inputFileFaculty.nextLine();
			lastName = lastName.replace("Last Name: ", "");
			fac[i].setLastName(lastName);
			// System.out.println(lastName);
			
			// SSN
			String tmpSSN = inputFileFaculty.nextLine();
			tmpSSN = tmpSSN.replace("SSN: ", "");
			int SSN = Integer.parseInt(tmpSSN);
			fac[i].setSSN(SSN);
			// System.out.println(SSN);
			
			// Address
			String address = inputFileFaculty.nextLine();
			address = address.replace("Address: ", "");
			fac[i].setAddress(address);
			// System.out.println(address);
			
			// Phone Number
			String tmpPhone = inputFileFaculty.nextLine();
			tmpPhone = tmpPhone.replace("Phone Number: ", "");
			int PhoneNumber = Integer.parseInt(tmpPhone);
			fac[i].setPhoneNum(PhoneNumber);
			// System.out.println(PhoneNumber);
			
			// Email
			String email = inputFileFaculty.nextLine();
			email = email.replace("Email: ", "");
			fac[i].setEmail(email);
			// System.out.println(email);
			
			// Faculty ID
			String tmpID = inputFileFaculty.nextLine();
			tmpID = tmpID.replace("Faculty ID: ", "");
			int facultyID = Integer.parseInt(tmpID);
			fac[i].setFacultyID(facultyID);
			// System.out.println(facultyID);
			
			// Department
			String department = inputFileFaculty.nextLine();
			department = department.replace("Department: ", "");
			fac[i].setDepartment(department);
			// System.out.println(department);
			
			// Courses
			String course = inputFileFaculty.nextLine();
			course = course.replace("Courses: [", "");
			course = course.replace("]", "");
			ArrayList<String> courses = new ArrayList<String>(Arrays.asList(course.split(", "))); // create an arraylist of the courses with a delimiter of ", "
			while(!courses.isEmpty())
			{
				fac[i].addCourse(courses.removeLast());
			}
			// System.out.println(fac[i].getCourses());
			
			inputFileFaculty.nextLine(); // there should be a blank line at the end
			i++;
		}
		return fac;
	}
	// question 5.4
	public static boolean searchStudent(Student stu[], int size, int ID) // searching from a student array
	{
		boolean flag = false;
		for (int i = 0; i < size; i++)
		{
			if (stu[i].getStudentID() == ID)
			{
				flag = true;
			}
		}
		return flag;
	}
	public static boolean searchFaculty(Faculty fac[], int size, int ID) // searching from a faculty array
	{
		boolean flag = false;
		for (int i = 0; i < size; i++)
		{
			if (fac[i].getFacultyID() == ID)
			{
				flag = true;
			}
		}
		return flag;
	}
	public static void main (String args[]) throws IOException
	{
		// question 6
		try
		{
			Student students[] = null;
			Faculty faculty[] = null;
			File studentFile = new File("Student.txt");
			File facultyFile = new File("Faculty.txt");
			String option = "X";
			String option2 = "X";
			String option3 = "X";
			int searchID = -1;
			Scanner input = new Scanner(System.in);
			boolean readFlag = false;
			while (!option.equals("quit") || !option.equals("Quit"))
			{
				System.out.print("Please enter an option (Read/Write/Search/Quit): ");
				option = input.nextLine();
				if (option.equals("Write") || option.equals("write")) // data input - have user input data, store it into a student object, and write it to file
				{
					String firstName = "X";
					String lastName = "X";
					String address = "X";
					int SSN = -1;
					int phone = -1;
					String email = "X";
					System.out.print("Please select the the type of data to record (Student/Faculty): ");
					option2 = input.nextLine();
					if (option2.equals("Student") || option2.equals("student"))
					{
						int studentID = -1;
						double GPA = -1.0;
						String status = "X";
						System.out.println("Please enter the following: ");
						System.out.print("First Name: ");
						firstName = input.nextLine();
						System.out.print("Last Name: ");
						lastName = input.nextLine();
						System.out.print("Address: ");
						address = input.nextLine();
						System.out.print("SSN: ");
						SSN = Integer.parseInt(input.nextLine()); // nextInt() does not go to next line automatically
						System.out.print("Phone Number: ");
						phone = Integer.parseInt(input.nextLine());
						System.out.print("Email: ");
						email = input.nextLine();
						System.out.print("Student ID: ");
						studentID = Integer.parseInt(input.nextLine());
						System.out.print("GPA: ");
						GPA = Double.parseDouble(input.nextLine());
						System.out.print("Status: ");
						status = input.nextLine();
						Student tmpStudent = createStudent(firstName, lastName, address, SSN, phone, email, studentID, GPA, status);
						tmpStudent.writeToFile();
					}
					else if (option2.equals("Faculty") || option2.equals("faculty"))
					{
						int facultyID = -1;
						String department = "X";
						String status = "X";
						System.out.println("Please enter the following: ");
						System.out.print("First Name: ");
						firstName = input.nextLine();
						System.out.print("Last Name: ");
						lastName = input.nextLine();
						System.out.print("Address: ");
						address = input.nextLine();
						System.out.print("SSN: ");
						SSN = Integer.parseInt(input.nextLine());
						System.out.print("Phone Number: ");
						phone = Integer.parseInt(input.nextLine());
						System.out.print("Email: ");
						email = input.nextLine();
						System.out.print("Faculty ID: ");
						facultyID = Integer.parseInt(input.nextLine());
						System.out.print("Department: ");
						department = input.nextLine();
						String course = "X";
						Faculty tmpFaculty = createFaculty(firstName, lastName, address, SSN, phone, email, facultyID, department);
						int courseTally = 0;
						while (!option3.equals("Quit") || !option3.equals("quit"))
						{
							System.out.print("Please enter an option for courses (Add/Remove/Quit): ");
							option3 = input.nextLine();
							if (option3.equals("Add") || option3.equals("add"))
							{
								System.out.print("Please enter a course to add: ");
								course = input.nextLine();
								tmpFaculty.addCourse(course);
							}
							else if (option3.equals("Remove") || option3.equals("remove"))
							{
								System.out.print("Please enter the course to remove: ");
								course = input.nextLine();
								tmpFaculty.removeCourse(course);
							}
							else if (option3.equals("Quit") || option3.equals("quit"))
							{
								tmpFaculty.writeToFile();
								System.out.println("Done");
								break;
							}
							else
								System.out.println("Invalid option, please try again");
						}
					}
					else
						System.out.println("Invalid option, please try again");
				}
				else if (option.equals("Read") || option.equals("read")) // data reading - store data from file into an array to later use for searching
				{
					System.out.print("Please select the the type of data to read (Student/Faculty): ");
					option2 = input.nextLine();
					if (option2.equals("Student") || option2.equals("student"))
					{
						students = studentReadFromFile(studentFile);
						System.out.println("Data successfully read");
					}
					else if (option2.equals("Faculty") || option2.equals("faculty"))
					{
						faculty = facultyReadFromFile(facultyFile);
						System.out.println("Data successfully read");
					}
					else
						System.out.println("Invalid option, please try again");
					readFlag = true;
				}
				else if (option.equals("Search") || option.equals("search")) // data search - search inside array that was created from data reading
				{
					if (readFlag)
					{
						System.out.print("Please select the the type of data to search for (Student/Faculty): ");
						option2 = input.nextLine();
						int studentSize = arraySize(studentFile);
						int facultySize = arraySize(facultyFile);
						if (option2.equals("Student") || option2.equals("student"))
						{
							System.out.print("Please enter the ID of the student to search for: ");
							searchID = input.nextInt();
							System.out.println("The student with ID " + searchID + ((searchStudent(students, studentSize, searchID) ? " was " : " wasn't ") + "found in the array."));
						}
						else if (option2.equals("Faculty") || option2.equals("faculty"))
						{
							System.out.print("Please enter the ID of the faculty member to search for: ");
							searchID = input.nextInt();
							System.out.println("The faculty member with ID " + searchID + ((searchFaculty(faculty, facultySize, searchID) ? " was " : " wasn't ") + "found in the array."));
						}
						else
							System.out.println("Invalid option, please try again");
					}
					else
					{
						System.out.println("Invalid option, please store data using the 'Read' before searching");
					}
				}
				else if (option.equals("Quit") || option.equals("quit"))
				{
					System.out.println("Done");
					break;
				}
				else
					System.out.println("Invalid option, please try again");
			}
		}
		catch (IOException exception)
		{
			System.out.println("IO exception occurred");
		}
	}
}
