package com.java.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.springbootapp.model.Student;
import com.java.springbootapp.services.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET,  value="/hello")
	public String sayHello(){
		return "Hi Students!!!!!!!!!!";
	}
	
	@RequestMapping(method=RequestMethod.GET,  value="/students")
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@RequestMapping(method=RequestMethod.GET,  value="/students/{id}")
	public Student getStudentById(@PathVariable String id)
	{
		return studentService.getStudentById(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,  value="/students")
	public void addStudent(@RequestBody Student student)
	{
		studentService.addStudent(student);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,  value="/students/{id}")
	public void addStudent(@PathVariable String id)
	{
		studentService.deleteStudent(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,  value="/students/{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable String id)
	{
		studentService.updateStudent(id, student);
	}
}
