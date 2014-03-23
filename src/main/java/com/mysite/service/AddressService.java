package com.mysite.service;

import com.mysite.dao.AddressDao;
import com.mysite.dao.PersonDao;
import com.mysite.entity.Address;
import com.mysite.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Алена on 16.03.14.
 */
@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao=new AddressDao();

    @Transactional
    public void createAddress(String city) {
        Address address = new Address();
        address.setCity(city);
        addressDao.saveAddress(address);
    }

    @Transactional
    public Address findAddress(String city) {
        return addressDao.findByAddress(city);
    }

    @Transactional
    public List<Address> findAll() {
        return addressDao.findAll();
    }
}
