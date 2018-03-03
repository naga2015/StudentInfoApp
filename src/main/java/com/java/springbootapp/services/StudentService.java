package com.java.springbootapp.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.java.springbootapp.model.Student;

@Service
public class StudentService {
	
	List<Student> student = new ArrayList<>(Arrays.asList(			
			new Student("1", "Naga", "Somerset"),
			new Student("2", "Raju", "Jersey City"),
			new Student("3", "Ravi", "New York City"),
			new Student("4", "Ramu", "Atlantic City")
		));
	
	public List<Student> getAllStudents()
	{
		System.out.println("Geting all students..............");		
		return student;
	}

	public Student getStudentById(String id) {
		
		System.out.println("Geting single students based on ID......");		
		return student.stream().filter(s -> s.getId().equals(id)).findFirst().get();
		
	}

	public void addStudent(Student student2) {
		
		System.out.println("Adding student..............");		
		student.add(student2);
	}
	
	public void deleteStudent(String id) {
		
		System.out.println("Deleting student..............");		
		student.removeIf(s -> s.getId().equals(id));
	}
	
	public void updateStudent(String id, Student student2) {
		
		System.out.println("Updating student..............");
		
		for(int i=0; i<student.size(); i++)
		{
			Student s = student.get(i);
			if(s.getId().equals(id))
			{
				student.set(i, student2);
				return;
			}
		}
	}

}
