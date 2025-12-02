package edu.myPac;

import java.io.*;
import java.util.*;

public class Student extends CollegeMembers
{
	private int studentID = -1;
	private double GPA = -1.0;
	private String status = "X";
	// getters for info
    public int getStudentID()
    {
        return studentID;
    }
    public double getGPA()
    {
        return GPA;
    }
    public String getStatus()
    {
        return status;
    }
    // setters
    public void setStudentID(int studentID)
    {
        this.studentID = studentID;
    }
    public void setGPA(double GPA)
    {
        this.GPA = GPA;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
	// part 4
	public void writeToFile() throws IOException
	{
		FileWriter file = new FileWriter("Student.txt", true);
		PrintWriter outputFile = new PrintWriter(file);
		outputFile.println("First Name: " + firstName);
		outputFile.println("Last Name: " + lastName);
		outputFile.println("SSN: " + SSN);
		outputFile.println("Address: " + address);
		outputFile.println("Phone Number: " + phoneNum);
		outputFile.println("Email: " + email);
		outputFile.println("Student ID: " + studentID);
		outputFile.println("GPA: " + GPA);
		outputFile.println("Status: " + status);
		outputFile.println();
		outputFile.close();
	}
}
