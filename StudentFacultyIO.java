import java.io.IOException;

import edu.myPac.*;
import java.io.*;
import java.util.*;

public class StudentFacultyIO
{
	// 5.1
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
	// 5.3
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
	//5.4
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
		// part 5.1
		Student stu1 = createStudent("John", "Smith", "New York City", 123456789, 1234567890, "John.Smith@email.com", 1, 3.7, "Freshman");
		
		Student stu2 = createStudent("James", "Brown", "San Francisco", 111111111, 1231111111, "James.Brown@email.com", 2, 2.9, "Sophomore");
		
		Faculty fac1 = createFaculty("Mary", "Garcia", "Miami", 222222222, 1232222222, "Mary.Garcia@email.com", 1, "Math");
		fac1.addCourse("MATH 100");
		fac1.addCourse("MATH 200");
		fac1.addCourse("MATH 201");
		
		Faculty fac2 = createFaculty("Jennifer", "Green", "Austin", 333333333, 1233333333, "Jennifer.Green@email.com", 2, "English");
		fac2.addCourse("ENGL 100");
		fac2.addCourse("ENGL 150");
		fac2.addCourse("ENGL 200");

		try
		{
			// part 5.2
			stu1.writeToFile();
			stu2.writeToFile();
			fac1.writeToFile();
			fac2.writeToFile();
			
			// part 5.3
			File studentFile = new File("Student.txt");
			File facultyFile = new File("Faculty.txt");
			// read from file and store into array
			Student stu[] = studentReadFromFile(studentFile);
			Faculty fac[] = facultyReadFromFile(facultyFile);

			// part 5.4
			int studentSize = arraySize(studentFile);
			int facultySize = arraySize(facultyFile);
			// search for student/faculty with a particular ID inside the array
			System.out.println("The Student with ID 1 " + ((searchStudent(stu, studentSize, 1) ? "was " : "wasn't ") + "found in the array."));
			System.out.println("The Student with ID 3 " + ((searchStudent(stu, studentSize, 3) ? "was " : "wasn't ") + "found in the array."));
			System.out.println("The Faculty with ID 2 " + ((searchFaculty(fac, facultySize, 2) ? "was " : "wasn't ") + "found in the array."));
			System.out.println("The Faculty with ID 5 " + ((searchFaculty(fac, facultySize, 5) ? "was " : "wasn't ") + "found in the array."));
		}
		catch (IOException exception)
		{
			System.out.println("IO exception occurred");
		}
	}
}
