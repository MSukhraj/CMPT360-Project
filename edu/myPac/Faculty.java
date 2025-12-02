package edu.myPac;

import java.io.*;
import java.util.*;

public class Faculty extends CollegeMembers
{
	private int facultyID = -1;
	private String department = "X";
	private ArrayList<String> courses = new ArrayList<String>();
	public String getDepartment()
	{
        return department;
    }
    public ArrayList<String> getCourses()
    {
        return courses;
    }
    public int getFacultyID()
    {
        return facultyID;
    }
    public void setDepartment(String department)
    {
        this.department = department;
    }
    public void addCourse(String course)
    {
        courses.add(course);
    }
    public void removeCourse(String course)
    {
        if(courses.contains(course))
        {
            courses.remove(course);
        }
        else
        {
            System.out.println("Error: Course not found!");
        }
    }
    public void setFacultyID(int facultyID)
    {
        this.facultyID = facultyID;
    }
	// question 4
	public void writeToFile() throws IOException
	{
		FileWriter file = new FileWriter("Faculty.txt", true);
		PrintWriter outputFile = new PrintWriter(file);
		outputFile.println("First Name: " + firstName);
		outputFile.println("Last Name: " + lastName);
		outputFile.println("SSN: " + SSN);
		outputFile.println("Address: " + address);
		outputFile.println("Phone Number: " + phoneNum);
		outputFile.println("Email: " + email);
		outputFile.println("Faculty ID: " + facultyID);
		outputFile.println("Department: " + department);
		outputFile.println("Courses: " + courses);
		outputFile.println();
		outputFile.close();
	}
}
