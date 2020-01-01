package com.homework.student;

import java.util.Scanner;

public class StudentApp {

	private static Register register = new Register();

	public static void main(String [] args) {
		
		registerStudent();
		
		//printAllStudents();
	}

	private static void registerStudent() {
		System.out.println("\t\t\tStudent Registration Portal");
		System.out.println("\t\t -------------------------------------------");

		Scanner in = new Scanner(System.in);

		do {
			register.registerStudent();
		} while (!in.next().equalsIgnoreCase("Q"));

		in.close();

		System.out.println("\nTotal # Enrolled Students: " + register.getStudents().size());
		printAllStudents();
	}

	private static void printAllStudents() {
		if (register.getStudents().size() > 0) {
			for (Student student : register.getStudents()) {
				System.out.println("ID   		  : " + student.getStudentId());
				System.out.println("First Name    : " + student.getFirstName());
				System.out.println("Last Name     : " + student.getLastName());
				System.out.println("Program       : " + student.getProgram());
				System.out.println("Grade         : " + student.getGrade());

				System.out.println("Courses taken : ");
				for (Course course : student.getCourses()) {
					System.out.println("\t\t" + "~ " + course.getCourseName());
				}

				System.out.println("Total balance due: $ " + student.getTotalBalanceDue());
				System.out.println("----------------------------------");
			}
		}
	}
}
