package com.employee_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee_service.model.Employee;
import com.employee_service.repository.EmployeeRepository;
import com.employee_service.response.AddressResponse;
import com.employee_service.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	private static List<Employee> list = new ArrayList<>();
	static {
		list.add(new Employee(1,"Swapnil Bamble","swapnil@gmail.com","AB+"));
		list.add(new Employee(2,"Yash More","yash@gmail.com","A+"));
		list.add(new Employee(3,"Pratik Shinde","pratik@gmail.com","B+"));
		list.add(new Employee(4,"Zurez Malik","zurez@gmail.com","O+"));
		list.add(new Employee(5,"Deepak Sawant","deepak@gmail.com","A-"));
	
	}
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WebClient webClient;

	
	
	
	public List<EmployeeResponse> getAllEmployees()
	{
		List<Employee> employees = list;
		List<EmployeeResponse> empRess = employees.stream().map(employee->EmpToRes(employee)).collect(Collectors.toList());
		
		return empRess;
	}
	
	public EmployeeResponse getEmpById(int id)
	{
		Employee emp = list.stream().filter(e -> e.getId()==id).findFirst().get();
		
		EmployeeResponse empRes = EmpToRes(emp);

		AddressResponse addRes = new AddressResponse();
	
		addRes = webClient
				.get()
				.uri("/emp/"+id)
				.retrieve()
				.bodyToMono(AddressResponse.class)
				.block();
		
		empRes.setAddressResponse(addRes);
		
		
		return empRes;
	}
	
	public List<EmployeeResponse> getAllEmployeesWithAddress()
	{
		List<Employee> employees = list;

		List<EmployeeResponse> empRess = employees.stream().map(employee->EmpToRes(employee)).collect(Collectors.toList());
	
		empRess.forEach(e -> e.setAddressResponse(
				
				 webClient
					.get()
					.uri("/emp/"+e.getId())
					.retrieve()
					.bodyToMono(AddressResponse.class)
					.block()
				
				));
		
		return empRess;
	}
	
	
	
	
	
	
//======================================================================
	
	public Employee ResToEmp(EmployeeResponse empRes)
	{
		Employee emp = modelMapper.map(empRes, Employee.class);
		return emp;
	}
	
	public EmployeeResponse EmpToRes(Employee emp)
	{
		EmployeeResponse empRes = modelMapper.map(emp,EmployeeResponse.class );
		return empRes;
	
	}
	
	
	
}
