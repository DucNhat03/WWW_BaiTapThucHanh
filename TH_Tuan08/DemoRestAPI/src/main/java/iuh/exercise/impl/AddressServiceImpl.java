package iuh.exercise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iuh.exercise.entities.Address;
import iuh.exercise.repositories.AddressRepository;
import iuh.exercise.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address save(Address address) {
		return this.addressRepository.save(address);
	}
}