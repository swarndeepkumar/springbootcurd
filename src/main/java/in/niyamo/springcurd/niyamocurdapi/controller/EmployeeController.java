package in.niyamo.springcurd.niyamocurdapi.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.niyamo.springcurd.niyamocurdapi.model.Employee;
import in.niyamo.springcurd.niyamocurdapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee")
	public List<Employee> get(){
		
		return employeeService.get();
	}
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee emplObj) {
		System.out.print("from controller >>" + emplObj);
		employeeService.save(emplObj);
		return emplObj;
	}
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {
		
		Employee employeeObj = employeeService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("Records not available");
		}
		return employeeObj;
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {
		try {
			employeeService.delete(id);
		}catch(Error e) {
			throw new RuntimeErrorException(e, "my dddd");
		}
		
		return "Data deleted successfully";
	}
	
	@PutMapping("/employee")
	public String update(@RequestBody Employee employeeObj) {
		try {
			employeeService.save(employeeObj);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Records updated successfully";
	}
}
