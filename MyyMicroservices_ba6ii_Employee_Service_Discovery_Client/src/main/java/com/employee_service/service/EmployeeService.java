package com.employee_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.employee_service.feignclient.AddressClient;
import com.employee_service.model.Employee;
import com.employee_service.repository.EmployeeRepository;
import com.employee_service.response.AddressResponse;
import com.employee_service.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AddressClient addressClient;
	
	private static List<Employee> list = new ArrayList<>();
	static {
		list.add(new Employee(1,"Swapnil Bamble","swapnil@gmail.com","AB+"));
		list.add(new Employee(2,"Yash More","yash@gmail.com","A+"));
		list.add(new Employee(3,"Pratik Shinde","pratik@gmail.com","B+"));
		list.add(new Employee(4,"Zurez Malik","zurez@gmail.com","O+"));
		list.add(new Employee(5,"Deepak Sawant","deepak@gmail.com","A-"));
	
	}
		
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
		
	//	addRes = addressClient.getAddressByEmployeeId(id);
		
//		ResponseEntity<AddressResponse> addResEntity =addressClient.getAddressByEmpId(id);
//		addRes = addResEntity.getBody();
		
		addRes = callToAddressServiceUsingDiscoveryClient(id);
		
		empRes.setAddressResponse(addRes);
		
		
		return empRes;
	}
	
	

	public List<EmployeeResponse> getAllEmployeesWithAddress()
	{
		List<Employee> employees = list;

		List<EmployeeResponse> empRess = employees.stream().map(employee->EmpToRes(employee)).collect(Collectors.toList());
	
		empRess.forEach(e -> e.setAddressResponse(
				
				callToAddressServiceUsingWebClient(e.getId())
				
				));
		
		return empRess;
	}

	
//===================================================================================================
	
	// restTemplate
	
	private RestTemplate restTemplate;
		public EmployeeService(RestTemplateBuilder builder,@Value("${address-service.base.url}")String addressBaseURL)
		{
			this.restTemplate = builder
					.rootUri(addressBaseURL)
					.build();
		}
	
		
		@Autowired
		private WebClient webClient;
	
	
//===================================================================================================	
	
	// calling Address Service using Feign Client(i.e our addressClient)
	private AddressResponse callToAddressServiceUsingDiscoveryClient(int id) {

		return addressClient.getAddressByEmpId(id).getBody();
		
	}
	
	
	// calling Address Service using WebClient (i.e our webClient)
	private AddressResponse callToAddressServiceUsingWebClient(int id) {

		return webClient
				.get()
				.uri("/emp/"+id)
				.retrieve()
				.bodyToMono(AddressResponse.class)
				.block();
		
	}
	
	// calling Address Service using restTemplate (i.e our restTemplate)
		private AddressResponse callToAddressServiceUsingRestTemplate(int id) {
	
		return	restTemplate.getForObject("/emp/{empid}", AddressResponse.class,id);
			
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
