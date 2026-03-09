package com.tss.service;

import com.tss.entity.Address;
import com.tss.repository.AddressRepository;
import com.tss.repository.AddressRepositoryImpl;

public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository = new AddressRepositoryImpl();

    @Override
    public void addAddress(Address address) {
        addressRepository.addAddress(address);
    }
}
