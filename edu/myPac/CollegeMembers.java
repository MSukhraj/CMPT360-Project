package edu.myPac;

import java.io.*;

public class CollegeMembers
{
	protected String firstName = "X";
	protected String lastName = "X";
	protected int SSN = -1; // SSNs can't start with 0
	protected String address = "X";
	protected int phoneNum = -1; // phone numbers also can't start with 0
	protected String email = "X";
	public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getSSN()
    {
        return SSN;
    }
    public String getAddress()
    {
        return address;
    }
    public int getPhoneNum()
    {
        return phoneNum;
    }
    public String getEmail()
    {
        return email;
    }
    // setters
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setSSN(int SSN) // necessary with no constructor
    {
    	this.SSN = SSN;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setPhoneNum(int phoneNum)
    {
        this.phoneNum = phoneNum;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
}
