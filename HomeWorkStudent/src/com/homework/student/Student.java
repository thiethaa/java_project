package com.homework.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String firstName;
	private String lastName;
	private int program;
	private int grade;
	private int studentId;
	private int id = 1000;
	private int totalBalanceDue;
	List<Course> courses = new ArrayList<Course>();
	
	public Student() {
		setId(id);
	}

	public int getTotalBalanceDue() {
		return totalBalanceDue;
	}

	public void setTotalBalanceDue(int totalBalanceDue) {
		this.totalBalanceDue = totalBalanceDue;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setProgram(int program) {
		this.program = program;
	}

	public String getProgram() {

		if (this.program == 1) {
			return "Medical";
		} else if (this.program == 2) {
			return "Engineer";
		} else if (this.program == 3) {
			return "Bussiness";
		}
		
		return "";
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id++;
		//this.id = this.grade + this.program; samething
		this.id += Math.addExact(this.grade, this.program);
	}

}
