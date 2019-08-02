package in.niyamo.springcurd.niyamocurdapi.dao;

import java.util.List;

import in.niyamo.springcurd.niyamocurdapi.model.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
	
}
