package in.niyamo.springcurd.niyamocurdapi.service;

import java.util.List;

import in.niyamo.springcurd.niyamocurdapi.model.Employee;

public interface EmployeeService {
    List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}
