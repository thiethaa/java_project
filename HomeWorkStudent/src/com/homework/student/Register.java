package com.homework.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Register {

	private List<Student> students = new ArrayList<Student>();
	private Student student;
	
	private Scanner in = new Scanner(System.in);
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void registerStudent() {

		student = new Student();

		System.out.print("\nEnter your First Name: ");
		student.setFirstName(in.nextLine());

		System.out.print("Enter your last Name: ");
		student.setLastName(in.nextLine());

		selectProgram();
		selectGrade();
	
		showCourses();
		calcualteTution();
		
		student.setStudentId(student.getGrade() + student.getId());
		students.add(student);
		
		displayProfile();
	}
	
	private void selectProgram() {
		
		String program = "";
		do {
			System.out.print("STUDENT PROGRAM: \n1 Medical \n2 engineer \n3 Bussiness \nEnter Your Program: ");
			program = in.nextLine();
			if (program.equals("1") || program.equals("2") || program.equals("3")) {
				if (student != null) {
					student.setProgram(Integer.parseInt(program));
				}
				break;
			}
		}while(program.equals("") || !program.equals("1") || !program.equals("2") || !program.equals("3"));
	}
	
	private void selectGrade() {
		String grade = "";
		do {
			System.out.print("STUDENT GRADE: \n1 Freshmen \n2 Junior \n3 Senior \nEnter your Grade: ");
			grade = in.nextLine();
			if (grade.equals("1") || grade.equals("2") || grade.equals("3")) {
				student.setGrade(Integer.parseInt(grade));
				break;
			}
		} while (grade.equals("") || !grade.equals("1") || !grade.equals("2") || !grade.equals("3"));

	}

	private void showCourses() {
		
		do {
			System.out.print("Enter your course (Q for quit): ");
			String course_input = in.nextLine();

			if (!course_input.equalsIgnoreCase("q")) {
				Course course = new Course();
				if (course_input != null && course_input.trim().length() > 0) {
					course.setCourseName(course_input);
					if (this.student != null) {
						this.student.getCourses().add(course);
					}
				}
			} else {
				break;
			}
		} while (true);
		
	}


	private void calcualteTution() {

		logMessage("Your total Tution fee shown below", 5);

		if (this.student != null) {
			if (!this.student.getCourses().isEmpty()) {
				int numberOfTotalCoues = this.student.getCourses().size();
				int totalBalanceDue = numberOfTotalCoues * TutionFee.TUTIONBALANCE;
				this.student.setTotalBalanceDue(totalBalanceDue);
			}

			logMessage("\n--------------------------------------------------", 3);
			logMessage("For " + this.student.getCourses().size() + " course(s) you've registered: $ "
					+ this.student.getTotalBalanceDue(), 4);
			logMessage("--------------------------------------------------", 3);
		}
	}

	
	private void displayProfile() {
		
		System.out.print("do you wanna go to Profile page (Y for Yes N for Logout)?");
		String answer = in.nextLine();
		if(answer.equalsIgnoreCase("y")) {
		System.out.println("-------STUDENT PROFILE-------\nDISPLAY NAME: " + student.getFirstName() + " "
				+ student.getLastName() +"\nSTUDENT ID: "+ student.getStudentId() + "\nGRADE: " + student.getGrade() + "\nPROGRAM: " + student.getProgram()
				+ "\nTOTAL BALANCE: $" + student.getTotalBalanceDue());
		// display courses:
				System.out.println("LIST OF COURSE(S):");
				if (this.student != null && !this.student.getCourses().isEmpty()) {
					int i = 1;
					for (Course course : this.student.getCourses()) {
						System.out.println(i + ". " + course.getCourseName());
						i++;
					}
				}
		}else if(answer.equalsIgnoreCase("n")) {
			System.out.print("You have been Logged out,see you next time!");
		}
		
	}

	private void logMessage(String msg, int lvl) {
		if (lvl < 5) {
			System.out.println(msg);
		}
	}

}
