package com.tss.service.impl;

import com.tss.entity.Address;
import com.tss.repository.AddressRepository;
import com.tss.repository.impl.AddressRepositoryImpl;
import com.tss.service.AddressService;

public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository = new AddressRepositoryImpl();

    @Override
    public void addAddress(Address address) {
        addressRepository.addAddress(address);
    }
}
