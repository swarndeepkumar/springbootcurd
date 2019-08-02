package in.niyamo.springcurd.niyamocurdapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.niyamo.springcurd.niyamocurdapi.dao.EmployeeDAO;
import in.niyamo.springcurd.niyamocurdapi.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
	
	@Autowired
	private EmployeeDAO employeeDAO;
	@Transactional
	@Override
	public List<Employee> get() {
		
		return employeeDAO.get();
		
	}
	
	@Transactional
	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		//return null;
		
		return employeeDAO.get(id);
		
		
	}
	@Transactional
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		System.out.print("from service IMP >>" + employee);
		employeeDAO.save(employee);
		
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeDAO.delete(id);
	}

}
