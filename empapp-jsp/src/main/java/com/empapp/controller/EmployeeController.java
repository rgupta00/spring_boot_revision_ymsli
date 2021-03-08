package com.empapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empapp.dao.Employee;
import com.empapp.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	
	
	// they are all same
	//ModelAndView
	//ModelMap
	//Model
	
	//------------getting all emp------------------
	@GetMapping(value = "viewAll")
	public String viewAll(Model m) {
		m.addAttribute("emps", employeeService.getAll());// goes the req scope
		return "viewAll";
	}
	
	//------------get for post-----------------
	@GetMapping(value = "addEmp")
	public String getAddEmp(Model m) {
		m.addAttribute("emp", new Employee());// goes the req scope
		return "addemp";
	}
	//------------posst for post-----------------
	@PostMapping(value = "addEmp")
	public String postAddEmp(@ModelAttribute(name = "emp")Employee emp) {
		Integer id=emp.getId();
		if(id==null) {
		employeeService.save(emp);
		}else {
			employeeService.update(id, emp);
		}
		return "redirect:viewAll";
	}
	
	//------------deleting an emp------------------
	@GetMapping(value = "delEmp")
	public String deleteAnEmp(@RequestParam(name = "id")Integer id) {
		employeeService.delete(id);
		return "redirect:viewAll";
	}
	
	//------------get for update-----------------
	@GetMapping(value = "updateEmp")
	public String getUpdateEmp(@RequestParam(name = "id")Integer id, Model m) {
		m.addAttribute("emp",employeeService.getEmployeeById(id));// goes the req scope
		return "addemp";
	}
	
}




