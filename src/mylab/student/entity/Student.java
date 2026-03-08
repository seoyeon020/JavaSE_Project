package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	private String studentId; //학번
	private String name; //이름
	private String major; //전공
	private int grade; //학년 
	
	public Student(String studentId, String name, String major, int grade) throws InvalidGradeException{
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		setGrade(grade);
	}
	
	//Getter 
	public String getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMajor() {
		return major;
	}
	
	public int getGrade() {
		return grade;
	}
	
	//Setter 
	public void setGrade(int grade) throws InvalidGradeException {
		if (grade < 1 || grade > 4) {
			throw new InvalidGradeException("학년은 1~4 사이여야 합니다.");
		}
		this.grade = grade;
	}
	


}
