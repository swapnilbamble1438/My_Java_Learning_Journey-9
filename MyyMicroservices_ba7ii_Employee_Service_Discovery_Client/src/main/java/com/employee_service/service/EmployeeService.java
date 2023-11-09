package com.employee_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	private DiscoveryClient discoveryClient; // no need to create any bean
	
	@Autowired
	public LoadBalancerClient loadBalancerClient;
	
	
	
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
		
		addRes = callToAddressServiceUsingFeignClient(id);
		
		empRes.setAddressResponse(addRes);
		
		
		return empRes;
	}
	
	

	public List<EmployeeResponse> getAllEmployeesWithAddress()
	{
		List<Employee> employees = list;

		List<EmployeeResponse> empRess = employees.stream().map(employee->EmpToRes(employee)).collect(Collectors.toList());
	
//		empRess.forEach(e -> e.setAddressResponse(                   // by this way it will make call again and again
//				
//				callToAddressServiceUsingFeignClient(e.getId())				
//				));
		
		List<AddressResponse> addResList;
		ResponseEntity<List<AddressResponse>> addResListResEntity = callToAddressServiceUsingFeignClient();
		 addResList = addResListResEntity.getBody();
		
		empRess.forEach(e -> e.setAddressResponse(
				addResList.stream().filter(ar -> ar.getEmpid()==e.getId()).findFirst().get()
				));
		
		return empRess;
	}

	
//===================================================================================================
	
	// restTemplate
	@Autowired
	private RestTemplate restTemplate;
		
		@Autowired
		private WebClient webClient;
	
	
//===================================================================================================	
	
	// calling Address Service using Feign Client(i.e our addressClient)
	private AddressResponse callToAddressServiceUsingFeignClient(int id) {

		return addressClient.getAddressByEmpId(id).getBody();
		
	}
	
	// calling Address Service using Feign Client(i.e our addressClient)
		private ResponseEntity<List<AddressResponse>> callToAddressServiceUsingFeignClient() {

			return addressClient.getAllAddresses();
			
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
		
			/* 	 first we did this way
			// making call using discovery Client (i.e discoveryClient) // it will call only one port/instance again and again	
				List<ServiceInstance> instances = discoveryClient.getInstances("address-service");	 // it will give all the instances(port) of address-service
				ServiceInstance serviceInstance = instances.get(0);
				String uri = serviceInstance.getUri().toString();
			*/				
		
			/* second we did this way
			// making call using loadbalancer (i.e loadBalancerClient) // it will also call another port/instance
		    ServiceInstance serviceInstance =	loadBalancerClient.choose("address-service");
			String uri = serviceInstance.getUri().toString();
			
			String contextPath = serviceInstance.getMetadata().get("configPath");
			
			
			System.out.println("=============================================================================================================================");
			System.out.println("uri: " + uri + contextPath);
			System.out.println("=============================================================================================================================");
			*/
	
		return	restTemplate.getForObject("http://ADDRESS-SERVICE/address/emp/{empid}", AddressResponse.class,id);
			
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
