package com.payal.courserestws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Course")
public class Course {
	//fields
	private long courseId;
	private String courseName;
	private String instructorName;
	private String textbookTitle;
	private double numberOfCredits;
	
	//getters and setters
	public long getCourseId() {
		return courseId;
	}
	
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getInstructorName() {
		return instructorName;
	}
	
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	public String getTextbookTitle() {
		return textbookTitle;
	}
	
	public void setTextbookTitle(String textbookTitle) {
		this.textbookTitle = textbookTitle;
	}
	
	public double getNumberOfCredits() {
		return numberOfCredits;
	}
	
	public void setNumberOfCredits(double numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
}
