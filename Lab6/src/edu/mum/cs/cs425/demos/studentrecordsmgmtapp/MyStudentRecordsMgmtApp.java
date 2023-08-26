package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

public class MyStudentRecordsMgmtApp {
	public static void main(String[] args) {
		Student listOfStudent[] =  {
				new Student(110001,"Dave",new Date()),
				new Student(110002,"Anna",new Date()),
				new Student(110003,"Erica",new Date()),
				new Student(110004,"Carlos",new Date()),
				new Student(110005,"Bob",new Date()),
				
		};
		printListOfStudents(listOfStudent);
		System.out.println();
		System.out.println("Platinum Alumni are:");
		for(Student std : getListOfPlatinumAlumniStudents(listOfStudent)) {
		    System.out.println(std.toString());
		}
		
		//int[] nums = {35, 30 , 28};
		//printHelloWorld(nums);
		
		//int a[]={1,2,5,6,3,2};   
		//System.out.println("Second Largest: "+ findSecondBiggest(a));  
	}
	
	public static void printListOfStudents(Student[] stdList) {
		for(Student std : stdList) {
		    System.out.println(std.toString());
		}
	}
	
	public static List<Student> getListOfPlatinumAlumniStudents(Student[] stdList) {
		List<Student> PlatinumAlumni = new ArrayList<Student>();
		for(Student std : stdList) {
		    if(new Date().getYear()- std.getDateOfAdmission().getYear()>30)
		       PlatinumAlumni.add(std);
		}
		return PlatinumAlumni;
	}
	
	public static void printHelloWorld(int[] nums) {
		for(int num : nums) {
			if(num%5==0 && num%7==0) System.out.println("HelloWorld");
			else if(num%5==0) System.out.println("Hello");
			else if(num%7==0) System.out.println("World");
		}
	}
	
	public static int findSecondBiggest(int[] nums) {
		int temp;  
		for (int i = 0; i < nums.length; i++)   
		        {  
		            for (int j = i + 1; j < nums.length; j++)   
		            {  
		                if (nums[i] > nums[j])   
		                {  
		                    temp = nums[i];  
		                    nums[i] = nums[j];  
		                    nums[j] = temp;  
		                }  
		            }  
		        }  
		       return nums[nums.length-2];  
		} 
}
