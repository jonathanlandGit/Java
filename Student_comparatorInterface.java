package Comparator;

import java.util.*;

import java.lang.*;
import java.io.*;

/*
 * @author Jonathan
 * 
 * 5/2017
 * 
 * This is a program that demonstrate the comparator interface
 * A class/blueprint is created to structure user data, particularly
 * for a student, which includes roll number, name, and address
 * 
 * the comparator interface does different sorts on this data by name
 * and roll
 */

class Student
{
	//ivars
	String name;
	String address;
	int rollNumber;

	//Constructor - three params
	public Student(int rollno, String name, String address) 
	{
		this.rollNumber = rollno;
		this.name = name;
		this.address = address;
	}

	//method to print student details
	public String toString() 
	{
		return this.rollNumber + " " + this.name + " " + this.address;
	}
}

//comparable interface to sort by roll number, passing in Student
class Sortbyroll implements Comparator<Student> 
{
	//sort in ascending order by rollNumber
	public int compare(Student a, Student b) 
	{
		return a.rollNumber - b.rollNumber;
	}
}

//comparable interface to sort by name passing in Student
class Sortbyname implements Comparator<Student> 
{
	// Used for sorting in ascending order of
	// roll name
	public int compare(Student a, Student b) 
	{
		return a.name.compareTo(b.name);
	}
}

class Main 
{
	public static void main(String[] args) 
	{
		ArrayList<Student> ar = new ArrayList<Student>();
		ar.add(new Student(4, "Jerry", "NYC"));
		ar.add(new Student(12, "Elaine", "California"));
		ar.add(new Student(1, "George", "NYC"));
		ar.add(new Student(1, "Kramer", "California"));

		System.out.println("Unsorted List:");
		for (int i = 0; i < ar.size(); i++)
		{
			System.out.println(ar.get(i));
		}

		Collections.sort(ar, new Sortbyroll());
		
		System.out.println();

		System.out.println("Sorted by rollno:");
		for (int i = 0; i < ar.size(); i++)
		{
			System.out.println(ar.get(i));
		}

		Collections.sort(ar, new Sortbyname());
		
		System.out.println();

		System.out.println("Sorted by name:");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
	}
}