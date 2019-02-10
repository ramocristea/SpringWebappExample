package org.sda.springwebappexample.service;

import java.util.Arrays;
import java.util.List;

import org.sda.springwebappexample.model.Address;
import org.sda.springwebappexample.model.User;

public class UserService {

	public User getUserById(int id) {
		User user = new User();
		user.setId(id);
		user.setFirstName("tudor");
		user.setLastName("alexandru");
		user.setPhoneNo("456789");
		
		Address address1 = new Address(1, "cluj", "romania", "memo");
		Address address2 = new Address(2, "tg mures", "romania", "dorobantilor");
		
		user.setAddresses(Arrays.asList(address1, address2));
		
		return user;
	}
	
	public Address getAdressById(List<Address> addresses, int id) {
		Address address1 = null;
		for (Address address: addresses){
	if( address.getId() == id)	{
		address1=address;
	}
		}
	return address1;
	}
}
