package com.mysite.dao;

import com.mysite.entity.Address;
import com.mysite.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Алена on 16.03.14.
 */
@Repository
public class AddressDao {
    @PersistenceContext
    private EntityManager em;

    public void saveAddress(Address address){
        em.persist(address);
    }

    public Address findByAddress(String address) {
        return (Address)em.createQuery("SELECT a from Address a WHERE a.city=:abc").setParameter("abc", address).getSingleResult();
    }

    public List<Address> findAll() {
        return (List<Address>)em.createQuery("SELECT a from Address a").getResultList();
    }
}
