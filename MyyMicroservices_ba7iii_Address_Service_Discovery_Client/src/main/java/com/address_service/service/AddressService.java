package com.address_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.address_service.model.Address;
import com.address_service.repository.AddressRepository;
import com.address_service.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addRepo;

	@Autowired
	public ModelMapper modelMapper;
	
	private static List<Address> list = new ArrayList<>();
	
	static {
		list.add(new Address(1,"Mumbra","Maharashtra",1));
		list.add(new Address(2,"Thane","Maharashtra",2));
		list.add(new Address(3,"Kalwa","Maharashtra",3));
		list.add(new Address(4,"Vikhroli","Maharashtra",4));
		list.add(new Address(5,"Dombivli","Maharashtra",5));
	}
	
	public List<AddressResponse> getAllAddresses()
	{
		List<Address> addresses = list;
		List<AddressResponse> addRess = addresses.stream().map(address->AddToRes(address)).collect(Collectors.toList());
		return addRess;
	}
	
	public AddressResponse getAddressById(int id)
	{
		Address add = list.stream().filter(e -> e.getId()==id).findFirst().get();
			
		return AddToRes(add);
	}
	
	
	
	
	
	public AddressResponse getAddressByEmpId(int empid)
	{
		Address add = list.stream().filter(e -> e.getEmpid()==empid).findFirst().get();
		
		return AddToRes(add);
	}
	
	
	
	
	
//========================================================================
	
	public Address ResToAdd(AddressResponse addRes)
	{
		Address add = modelMapper.map(addRes, Address.class);
		return add;
	}
	
	public AddressResponse AddToRes(Address add)
	{
		AddressResponse addRes = modelMapper.map(add, AddressResponse.class);
		return addRes;
	}

}
