package com.empapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.empapp.dao.Employee;
import com.empapp.service.EmployeeService;

@RestController
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(path = "employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getAll(){
		List<Employee> employees= employeeService.getAll();
		return ResponseEntity.ok(employees);
	}
	
	
	@GetMapping(path = "employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getAnEmployee(@PathVariable(name = "id") int id){
		Employee employee= employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	

	@PostMapping(path = "employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Employee> addAnEmployee(@Valid  @RequestBody Employee employee){
		Employee employeeAdded= employeeService.save(employee);
		return new ResponseEntity<Employee>(employeeAdded, HttpStatus.CREATED);
	}
	


	@PutMapping(path = "employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Employee> updateAnEmployee( @PathVariable(name = "id") int id, 
			@RequestBody Employee employee){
		Employee employeeUpdated= employeeService.update(id, employee);
		return new ResponseEntity<Employee>(employeeUpdated, HttpStatus.OK);
	}
	
	@DeleteMapping(path = "employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteAnEmployee(@PathVariable(name = "id") int id){
		Employee employeeDeleted=  employeeService.delete(id);
		return new ResponseEntity<Employee>(employeeDeleted,   HttpStatus.ACCEPTED);
		
	}
}









