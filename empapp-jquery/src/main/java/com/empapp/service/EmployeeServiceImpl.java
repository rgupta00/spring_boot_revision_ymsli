package com.empapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empapp.dao.Employee;
import com.empapp.dao.EmployeeRepo;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepo empRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo empRepo) {
		this.empRepo = empRepo;
	}
	
	@Override
	public List<Employee> getAll() {
		return (List<Employee>) empRepo.findAll();
	}

	//http://localhost:8080/empapp/employee/5
	@Cacheable(value="emps",key="#id" )
	@Override
	public Employee getEmployeeById(int id) {
		System.out.println("-------emp get method is called-----");
		return empRepo.findById(id).orElseThrow(EmployeeNotFoundException:: new);
	}

	@CachePut(value="emps", key="#result.id")
	@Override
	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}
	@CacheEvict(value="emps", key="#id")
	@Override
	public Employee delete(int id) {
		Employee employeeToDelete=getEmployeeById(id);
		empRepo.delete(employeeToDelete);
		return employeeToDelete;
	}

	@CachePut(value="emps", key="#result.id")
	@Override
	public Employee update(int empId, Employee emp) {
		Employee employeeToUpdate=getEmployeeById(empId);
		//employeeToUpdate.setName(emp.getName());
		employeeToUpdate.setSalary(emp.getSalary());
		return empRepo.save(employeeToUpdate);
	}

	@CacheEvict(value="emps", allEntries=true)
	@Override
	public void evictCache() {}
}
